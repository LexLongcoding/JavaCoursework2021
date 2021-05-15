package com.lex.flow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lex.flow.models.Question;
import com.lex.flow.models.Tag;
import com.lex.flow.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tRepo;
	public TagService(TagRepository repo) {
		this.tRepo = repo;
	}
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	// get one tag
	public Tag getSingleTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	// Create a tag
	public Tag createTag(Tag newTag) {
		return this.tRepo.save(newTag);
	}
	// update a tag
	public Tag updateTag (Tag tag) {
		return this.tRepo.save(tag);
	}
	// delete a tag
	public void deleteTag(Long id) {
		this.tRepo.deleteById(id);
	}
	/*public List<Tag> findTagsNotInQuestion(Question question) {
		return tRepo.findByQuestionsNotContains(question);
	}*/
	// add a question to a tag
	public void addTagToQuestion(Question question, Tag tag) {
		///get the list of questions
		List<Question> questions = tag.getQuestions();
		//add question to the list
		questions.add(question);
		//update list in DB
		this.tRepo.save(tag);
		
	}
	
	

}

