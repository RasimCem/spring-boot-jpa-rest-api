package com.artwork.Service;

import com.artwork.Model.ArtworkDO;
import com.artwork.Model.ArtistDO;
import com.artwork.Repository.ArtworkRepository;
import com.artwork.dto.ArtworkDTO;
import com.artwork.dto.ArtistDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ArtworkService implements IArtworkService {

    @Autowired
    private ArtworkRepository artworkRepository;

    @Override
    public ArtworkDO createArtwork(ArtworkDO artwork) {
        return artworkRepository.save(artwork);
    }

    @Override
    public ArtworkDTO updateArtwork(ArtworkDO artwork) {
        long artworkId = artwork.getId();
        Optional<ArtworkDO> existingArtwork = artworkRepository.findById(artworkId);
        if(existingArtwork.isPresent()){
            existingArtwork.get().setName(artwork.getName());
            existingArtwork.get().setDescription(artwork.getDescription());
            existingArtwork.get().setImagePath(artwork.getImagePath());
            ArtistDO user = existingArtwork.get().getUser();
            if(user==null){
                return null;
            }
            artworkRepository.save(existingArtwork.get());

            ArtworkDTO artworkDTO = new ModelMapper().map(existingArtwork.get(),ArtworkDTO.class);
            ArtistDTO artistDTO = new ModelMapper().map(existingArtwork.get().getUser(), ArtistDTO.class);
            artworkDTO.setUser(artistDTO);
            return artworkDTO;
        }
        return null;
    }

    @Override
    public void deleteArtwork(long artworkId) {
        Optional<ArtworkDO> artwork = artworkRepository.findById(artworkId);
        if(artwork.isPresent()){
            artworkRepository.delete(artwork.get());
        }
    }

    @Override
    public ArtworkDTO getArtwork(long artworkId) {
        Optional<ArtworkDO> artwork = artworkRepository.findById(artworkId);
        if(artwork.isPresent()){
            ArtworkDTO artworkDTO = new ModelMapper().map(artwork.get(),ArtworkDTO.class);
            return artworkDTO;
        }
        return null;
    }

    public List<ArtworkDTO> getAllArtwork(){
        List<ArtworkDO> artwork = artworkRepository.findAll();
        Type listType = new TypeToken<List<ArtworkDTO>>(){}.getType();
        List<ArtworkDTO> artworkDTO = new ModelMapper().map(artwork,listType);
        return artworkDTO;
    }
}


