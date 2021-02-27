package com.api.Service;

import com.api.Model.ArtworkDO;
import com.api.Model.ArtistDO;
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

    @Override
    public ArtworkDTO createArtwork(ArtworkDO artwork) {
        ArtworkDO artworkDO = artworkRepository.save(artwork);
        ArtworkDTO artworkDTO = new ModelMapper().map(artworkDO,ArtworkDTO.class);
        return artworkDTO;
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
            if(artist!=null){
                artist.setName(artwork.getArtist().getName());
                artist.setSurname(artwork.getArtist().getSurname());
                artist.setBirth_year(artwork.getArtist().getBirth_year());
                artist.setDeath_year(artwork.getArtist().getDeath_year());
                artist.setBiography(artwork.getArtist().getBiography());
                artist.setImage_url(artwork.getArtist().getImage_url());
                existingArtwork.get().setArtist(artist);
            }
            artworkRepository.save(existingArtwork.get());

            ArtworkDTO artworkDTO = new ModelMapper().map(existingArtwork.get(),ArtworkDTO.class);
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


