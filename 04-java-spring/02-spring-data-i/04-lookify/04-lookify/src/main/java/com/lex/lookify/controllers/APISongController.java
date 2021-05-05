package com.lex.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lex.lookify.models.Song;
import com.lex.lookify.services.SongService;

@RestController
@RequestMapping("/api")
public class APISongController {
	@Autowired
	private SongService sService;
	
	@GetMapping("")
	public List<Song> index(){
		return this.sService.allSongs();
		
	}
	
	@GetMapping("/{id}")
	public Song getLanguage(@PathVariable("id") Long id){
		return this.sService.findSong(id);
	}
	
	@PostMapping("/create")
	public Song create(Song song) {
		return this.sService.createSong(song);
	}
	
	//@RequestMapping ("/value="/delete/{id}", method = RequestMethod.Delete)
	@DeleteMapping (value="/delete/{id}")
	public void deleteSong(@PathVariable("id")Long id) {
		this.sService.deleteSong(id);
	}

}
