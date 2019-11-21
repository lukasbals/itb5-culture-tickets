package at.fhv.td.ldap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchResult;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Utils.class})
public class LDAPTest {

    @Test
    public void callLDAPWithoutPassword() {
        assertFalse(LDAP.callLDAP("lukasbals", ""));
    }

    @Test
    public void callLDAPBackdoor() {
        assertTrue(LDAP.callLDAP("user", "PssWrd"));
    }

    @Test
    public void callLDAPException() throws NamingException {
        mockStatic(Utils.class);
        DirContext dirContext1 = mock(DirContext.class);
        SearchResult searchResult = mock(SearchResult.class);
        when(searchResult.getName()).thenReturn("name");
        when(Utils.login(LDAP.SEARCH_USER_DN, LDAP.SEARCH_USER_PASSWORD)).thenReturn(dirContext1);
        when(Utils.login("name" + "," + LDAP.LDAP_BASE, "password")).thenThrow(NamingException.class);
        when(Utils.findAccountByAccountName(dirContext1, "lukasbals")).thenReturn(searchResult);
        assertFalse(LDAP.callLDAP("lukasbals", "password"));
    }

    @Test
    public void callLDAPSearchException() throws NamingException {
        mockStatic(Utils.class);
        SearchResult searchResult = mock(SearchResult.class);
        when(searchResult.getName()).thenReturn("name");
        when(Utils.login(LDAP.SEARCH_USER_DN, LDAP.SEARCH_USER_PASSWORD)).thenThrow(NamingException.class);
        assertFalse(LDAP.callLDAP("lukasbals", "password"));
    }

    @Test
    public void callLDAPFindAccountByAccountNameReturnsNull() throws NamingException {
        mockStatic(Utils.class);
        DirContext dirContext1 = mock(DirContext.class);
        DirContext dirContext2 = mock(DirContext.class);
        when(Utils.login(LDAP.SEARCH_USER_DN, LDAP.SEARCH_USER_PASSWORD)).thenReturn(dirContext1);
        when(Utils.login("name" + "," + LDAP.LDAP_BASE, "password")).thenReturn(dirContext2);
        when(Utils.findAccountByAccountName(dirContext1, "lukasbals")).thenReturn(null);
        assertFalse(LDAP.callLDAP("lukasbals", "password"));
    }

    @Test
    public void callLDAPSuccess() throws NamingException {
        mockStatic(Utils.class);
        DirContext dirContext1 = mock(DirContext.class);
        DirContext dirContext2 = mock(DirContext.class);
        SearchResult searchResult = mock(SearchResult.class);
        when(searchResult.getName()).thenReturn("name");
        when(Utils.login(LDAP.SEARCH_USER_DN, LDAP.SEARCH_USER_PASSWORD)).thenReturn(dirContext1);
        when(Utils.login("name" + "," + LDAP.LDAP_BASE, "password")).thenReturn(dirContext2);
        when(Utils.findAccountByAccountName(dirContext1, "lukasbals")).thenReturn(searchResult);
        assertTrue(LDAP.callLDAP("lukasbals", "password"));
    }
}