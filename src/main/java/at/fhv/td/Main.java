package at.fhv.td;

import at.fhv.td.jms.Publisher;
import at.fhv.td.persistence.DBConnection;
import at.fhv.td.rmi.Setup;
import at.fhv.td.rss.FeedMessage;
import at.fhv.td.rss.FeedReader;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * @author Lukas Bals
 */
public class Main implements ServletContextListener {
    @EJB
    Publisher _publisher;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DBConnection.setupDBConnection();
        Setup.setupRmiRegistry();

//        List<FeedMessage> feedMessages = FeedReader.readFeed("https://www.festivalticker.de/rss-festivalfeed/festivalkalender.xml");
//
//        // This publishes the messages to the broker
//        for (FeedMessage feedMessage : feedMessages) {
//            _publisher.publishMessage(feedMessage);
//            System.out.println("PUBLISH: " + feedMessage.getTitle());
//        }
    }
}
