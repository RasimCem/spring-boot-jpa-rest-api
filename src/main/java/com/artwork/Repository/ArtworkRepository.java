package com.artwork.Repository;

import com.artwork.Model.ArtworkDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends JpaRepository<ArtworkDO,Long> {
}
