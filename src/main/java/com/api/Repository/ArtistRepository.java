package com.api.Repository;

import com.api.Model.ArtistDO;
import com.api.dto.ArtistDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository <ArtistDO,Long>{
    //Optional<ArtistDO> findByArtist(ArtistDTO artistDTO);
    Optional<ArtistDO> findByName(String name);
}
