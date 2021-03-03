package com.api.Service;

import com.api.Model.ArtworkDO;
import com.api.dto.ArtworkDTO;

public interface IArtworkService {
    public ArtworkDTO createArtwork(ArtworkDO artwork);
    public ArtworkDTO updateArtwork(ArtworkDO artwork);
    public void deleteArtwork(Long artworkId);
    public ArtworkDTO getArtwork(long artworkId);
}
