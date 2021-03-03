package com.api.Controller;

import com.api.Service.ArtworkService;
import com.api.Model.ArtworkDO;
import com.api.dto.ArtworkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "",consumes = "application/json",produces="application/json")
    public ResponseEntity<ArtworkDTO> createArtwork(@RequestBody ArtworkDO artworkDO){
        ArtworkDTO createdArtwork = artworkService.createArtwork(artworkDO);
        return new ResponseEntity<>(createdArtwork, HttpStatus.CREATED);
    }
    
    @PutMapping(value="",consumes="application/json",produces="application/json")
    public ResponseEntity<ArtworkDTO> updateArtwork(@RequestBody ArtworkDO artworkDO){
        ArtworkDTO updatedArtwork = artworkService.updateArtwork(artworkDO);
        return new ResponseEntity<>(updatedArtwork,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{artwork_id}")
    public ResponseEntity<String> deleteArtwork(@PathVariable(value="artwork_id") Long artwork_id){
        artworkService.deleteArtwork(artwork_id);
        return new ResponseEntity<>(artwork_id+" id number is deleted!!!",HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArtworkDTO>> getAllArtwork(){
        List<ArtworkDTO> artworkList = artworkService.getAllArtwork();
        return new ResponseEntity<>(artworkList, HttpStatus.OK);
    }
}
