package com.music.streaming.platform.controller;

import com.music.streaming.platform.dto.ArtistRequest;
import com.music.streaming.platform.model.Artist;
import com.music.streaming.platform.service.ArtistService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music/platform/v1/artists")
public class ArtistController {
	
	
	private ArtistService as;
	
	public ArtistController(ArtistService as) {
		this.as=as;
	}
	@GetMapping
	public ResponseEntity<List<Artist>> getAllArtists(){
		
		return ResponseEntity.ok(as.getAllArtists());
		
	}
	
	@GetMapping("/{artistId}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long artistId) {
        return ResponseEntity.ok(as.getArtistById(artistId));
    }

 
    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody ArtistRequest request) {
        return ResponseEntity.ok(as.createArtist(request));
    }
    
    @PutMapping("/{artistId}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long artistId, @RequestBody ArtistRequest request) {
        return ResponseEntity.ok(as.updateArtist(artistId, request));
    }

 
    @DeleteMapping("/{artistId}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable Long artistId) {
        as.deleteArtist(artistId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
	
}
}
