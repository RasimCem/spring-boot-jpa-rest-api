package com.api.Service;

import com.api.Model.ArtistDO;
import com.api.Model.NationalityDO;
import com.api.dto.ArtistDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService implements IArtistService {

    @Autowired
    private com.api.Repository.artistRepository artistRepository;

    @Override
    public ArtistDO createArtist(ArtistDO user) {
        return artistRepository.save(user);
    }

    @Override
    public ArtistDO getArtist(Long user_id) {
        Optional<ArtistDO> currentUser = artistRepository.findById(user_id);
        if(currentUser.isPresent()){
            return currentUser.get();
        }
        return null;
    }

    @Override
    public List<ArtistDTO> getAllArtist() {
        List<ArtistDO> allArtists = artistRepository.findAll();
        Type listType = new TypeToken<List<ArtistDTO>>(){}.getType();
        List<ArtistDTO> artistDTO = new ModelMapper().map(allArtists,listType);
        return artistDTO;
    }

    @Override
    public ArtistDTO updateArtist(ArtistDO artist) {
        Optional<ArtistDO> artistDO = artistRepository.findById(artist.getId());
        if(artistDO.isPresent()){
            artistDO.get().setName(artist.getName());
            artistDO.get().setSurname(artist.getSurname());
            artistDO.get().setBirth_year(artist.getBirth_year());
            artistDO.get().setDeath_year(artist.getDeath_year());
            artistDO.get().setBiography(artist.getBiography());
            artistDO.get().setImage_url(artist.getImage_url());

            NationalityDO nation = artist.getNation();
            if (nation != null) {
                nation.setCity(artist.getNation().getCity());
                nation.setCountry(artist.getNation().getCountry());
                artistDO.get().setNation(nation);
            }

            artistRepository.save(artistDO.get());

            ArtistDTO artistDTO = new ModelMapper().map(artistDO.get(),ArtistDTO.class);
            return artistDTO;

        }
        return null;
    }

    @Override
    public void deleteArtist(Long artist_id) {
        Optional<ArtistDO> artist = artistRepository.findById(artist_id);
        if(artist.isPresent()){
            artistRepository.delete(artist.get());
        }
    }


}
