package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Tour;

import java.util.Set;

public interface IArtist {
    String getArtistname();

    String getGenre();

    Set<Tour> getTours();

    Long getArtistId();
}
