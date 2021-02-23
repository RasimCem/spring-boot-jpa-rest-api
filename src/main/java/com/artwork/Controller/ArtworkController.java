package com.artwork.Controller;

import com.artwork.Model.ArtworkDO;
import com.artwork.Service.ArtworkService;
import com.artwork.dto.ArtworkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/artwork")
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    @GetMapping(value = "/{artwork_id}")
    public ResponseEntity<ArtworkDTO> getArtwork(@PathVariable(value="artwork_id") long artwork_id){
        ArtworkDTO artwork = artworkService.getArtwork(artwork_id);
        return new ResponseEntity<>(artwork,HttpStatus.OK);
    }

    @PostMapping(value = "/",consumes = "application/json",produces="application/json")
    public ResponseEntity<ArtworkDO> createArtwork(@RequestBody ArtworkDO artworkDO){
        ArtworkDO createdArtwork = artworkService.createArtwork(artworkDO);
        return new ResponseEntity<>(createdArtwork, HttpStatus.CREATED);
    }
    
    @PutMapping(value="/",consumes="application/json",produces="application/json")
    public ResponseEntity<ArtworkDTO> updateArtwork(@RequestBody ArtworkDO artworkDO){
        ArtworkDTO updatedArtwork = artworkService.updateArtwork(artworkDO);
        return new ResponseEntity<>(updatedArtwork,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{artwork_id}")
    public ResponseEntity<String> deleteArtwork(@PathVariable(value="artwork_id") Long artworkID){
        artworkService.deleteArtwork(artworkID);
        return new ResponseEntity<>(artworkID+" id number is deleted!!!",HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArtworkDTO>> getAllArtwork(){
        List<ArtworkDTO> artworkList = artworkService.getAllArtwork();
        return new ResponseEntity<>(artworkList, HttpStatus.OK);
    }
}
