package com.lex.flow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lex.flow.models.Question;
import com.lex.flow.models.Tag;
import com.lex.flow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository qRepo;
	public QuestionService(QuestionRepository repo) {
		this.qRepo = repo;
	}
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	// get one question
	public Question getSingleQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	// Create a question
	public Question createQuestion(Question newQuestion) {
		return this.qRepo.save(newQuestion);
	}
	// update a question
	public Question updateQuestion (Question question) {
		return this.qRepo.save(question);
	}
	// delete a question
	public void deleteQuestion(Long id) {
		this.qRepo.deleteById(id);
	}
	public List<Question> findQuestionsNotInTag(Tag tag) {
		return qRepo.findByTagsNotContains(tag);
	}
	// add a tag to question
	public void addTagToQuestion(Tag tag, Question question) {
		///get the list of tags
		List<Tag> tags = question.getTags();
		//add question to the list
		tags.add(tag);
		//update list in DB
		this.qRepo.save(question);
		
	}
	
	

}
