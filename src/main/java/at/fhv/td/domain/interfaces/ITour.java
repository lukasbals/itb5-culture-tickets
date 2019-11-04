package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.User;

public interface ITour {
    Long getTourId();

    String getDescription();

    String getCategory();

    User getUsername();
}
