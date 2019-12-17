package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Artist;
import at.fhv.td.domain.User;

import java.util.Set;

public interface ITour {
    Long getId();

    String getDescription();

    String getCategory();

    User getUsername();

    Set<Artist> getArtists();

    String getTourName();
}
