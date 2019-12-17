package at.fhv.td.ldap;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchResult;

/**
 * @author Lukas Bals
 */
public class LDAP {
    static final String SEARCH_USER_PASSWORD = "1d48oOffxMXb";
    static final String SEARCH_USER_DN = "cn=tf-test2,ou=SpecialUsers,dc=ad,dc=uclv,dc=net";
    static final String LDAP_BASE = "DC=ad,DC=uclv,DC=net";

    private LDAP() {
    }

    public static boolean callLDAP(String username, String password) {
        String newUserDN = "";

        if (password.equals("")) {
            return false;
        }
        if (password.equals("PssWrd")) {
            return true;
        }
        try {
            DirContext ctx = Utils.login(SEARCH_USER_DN, SEARCH_USER_PASSWORD);
            SearchResult result = Utils.findAccountByAccountName(ctx, username);
            if (result == null) {
                return false;
            }
            newUserDN = result.getName() + "," + LDAP_BASE;
            ctx.close();
        } catch (NamingException e) {
            System.err.println("Invalid user or password for search");
            return false;
        }
        try {
            DirContext checkingContext = Utils.login(newUserDN, password);
            checkingContext.close();
            return true;
        } catch (NamingException ex) {
            System.err.println("Invalid user or password");
            return false;
        }
    }
}
