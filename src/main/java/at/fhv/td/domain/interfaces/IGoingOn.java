package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Artist;
import at.fhv.td.domain.Tour;

import java.util.List;

public interface IGoingOn {
    Long getGoingOnId();

    List<Tour> getTours();

    List<Artist> getArtists();
}
