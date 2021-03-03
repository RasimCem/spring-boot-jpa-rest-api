package com.api.Service;

import com.api.Model.ArtworkDO;
import com.api.Model.ArtistDO;
import com.api.Repository.ArtistRepository;
import com.api.Repository.ArtworkRepository;
import com.api.dto.ArtworkDTO;
import com.api.dto.ArtistDTO;
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

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public ArtworkDTO createArtwork(ArtworkDO artwork) {

        ArtistDO artist = artwork.getArtist();
        String name = artist.getName();
        Optional<ArtistDO> isExist = artistRepository.findByName(name);
        if(isExist.isPresent()){
            artwork.setArtist(isExist.get());
            ArtworkDO artworkDO = artworkRepository.save(artwork);
            ArtworkDTO artworkDTO = new ModelMapper().map(artworkDO,ArtworkDTO.class);
            return artworkDTO;
        }
        return null;

    }

    @Override
    public ArtworkDTO updateArtwork(ArtworkDO artwork) {
        long artworkId = artwork.getId();
        Optional<ArtworkDO> existingArtwork = artworkRepository.findById(artworkId);
        if(existingArtwork.isPresent()){
            existingArtwork.get().setName(artwork.getName());
            existingArtwork.get().setDescription(artwork.getDescription());
            existingArtwork.get().setImagePath(artwork.getImagePath());

            ArtistDO artist = artwork.getArtist();
            String name = artist.getName();
            Optional<ArtistDO> isExist = artistRepository.findByName(name);
            if(isExist.isPresent()){
                artwork.setArtist(isExist.get());
                artworkRepository.save(artwork);
                ArtworkDTO artworkDTO = new ModelMapper().map(existingArtwork.get(),ArtworkDTO.class);
                return artworkDTO;
            }
        }
        return null;
    }

    @Override
    public void deleteArtwork(Long artwork_id) {
        Optional<ArtworkDO> artwork = artworkRepository.findById(artwork_id);
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


