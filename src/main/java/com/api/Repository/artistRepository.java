package com.api.Repository;

import com.api.Model.ArtistDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface artistRepository extends JpaRepository <ArtistDO,Long>{

}
