package com.artwork.Service;

import com.artwork.Model.ArtworkDO;
import com.artwork.dto.ArtworkDTO;

public interface IArtworkService {
    public ArtworkDO createArtwork(ArtworkDO artwork);
    public ArtworkDTO updateArtwork(ArtworkDO artwork);
    public void deleteArtwork(long artworkId);
    public ArtworkDTO getArtwork(long artworkId);
}
