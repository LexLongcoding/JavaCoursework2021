package com.lex.exam.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name= "ideas")
public class Idea {
	public String getIdeaName() {
		return ideaName;
	}

	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String ideaName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User creator;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns = @JoinColumn(name="idea_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> likers;
	
	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}
	
	
	
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Idea() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}