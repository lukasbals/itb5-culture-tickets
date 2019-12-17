package at.fhv.td.communication.dto;

import java.io.Serializable;

/**
 * @author Lukas Bals
 */
public class TopicDTO implements Serializable {
    private String _name;

    public TopicDTO() {
        super();
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
