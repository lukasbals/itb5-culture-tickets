package at.fhv.td.jms;

import javax.jms.JMSDestinationDefinition;

/**
 * @author Lukas Bals
 */
@JMSDestinationDefinition(
        name = "jms/stocks",
        interfaceName = "javax.jms.Topic",
        destinationName = "Stocks"
)
public class Config {
}
