package at.fhv.td.dto.dtoInterfaces;

import at.fhv.td.dto.ArtistDTO;
import at.fhv.td.dto.TourDTO;

import java.util.List;

public interface IGoingOn {
    Long getGoingOnId();

    List<TourDTO> getTours();

    List<ArtistDTO> getArtists();
}
