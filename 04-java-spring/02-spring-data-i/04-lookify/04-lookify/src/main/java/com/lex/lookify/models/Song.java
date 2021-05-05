package com.lex.lookify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="songs")
public class Song {
	
	public Song() {
		
	}
	
	public Song(@Size(min = 5, max = 45) String name, @Size(min = 5, max = 45) String artist,
			@Min(1) @Max(10) int rating) {
		this.name = name;
		this.artist = artist;
		this.rating = rating;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=5,max=45)
	private String name;
	@Size(min=5,max=45)
	private String artist;
	@Min(1)
	@Max(10)
	private int rating;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
