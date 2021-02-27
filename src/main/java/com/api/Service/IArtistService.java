package com.api.Service;

import com.api.Model.ArtistDO;
import com.api.dto.ArtistDTO;

import java.util.List;

public interface IArtistService {
    public ArtistDO createArtist(ArtistDO artist);
    public ArtistDO getArtist(Long artist_id);
    public List<ArtistDTO> getAllArtist();
    public ArtistDTO updateArtist(ArtistDO artist);
    public void deleteArtist(Long artist_id);
}
