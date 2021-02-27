package com.api.Controller;

import com.api.Model.ArtistDO;
import com.api.Service.ArtistService;
import com.api.dto.ArtistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping(value = "",consumes = "application/json", produces = "application/json")
    public ResponseEntity<ArtistDO> createArtist(@RequestBody ArtistDO userDO){
        ArtistDO createdArtist = artistService.createArtist(userDO);
        return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);
    }

    @GetMapping(value="/{artist_id}")
    public ResponseEntity<ArtistDO> getArtist(@PathVariable(value="artist_id") Long user_id){
        ArtistDO user = artistService.getArtist(user_id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<ArtistDTO>> getAllArtist(){
        List<ArtistDTO> user = artistService.getAllArtist();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping(value="",consumes="application/json",produces="application/json")
    public ResponseEntity<ArtistDTO> updateArtist(@RequestBody ArtistDO artistDO){
        ArtistDTO updatedArtist = artistService.updateArtist(artistDO);
        return new ResponseEntity<>(updatedArtist,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{artist_id}")
    public ResponseEntity<String> deleteArtwork(@PathVariable(value="artist_id") Long artist_id){
        artistService.deleteArtist(artist_id);
        return new ResponseEntity<>(artist_id+" id number is deleted!!!",HttpStatus.OK);
    }

}
