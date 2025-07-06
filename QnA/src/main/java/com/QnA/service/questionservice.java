 package com.QnA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QnA.quiz_questions;
import com.QnA.questiondao.Dao;

@Service
public class questionservice {
	
	@Autowired
	Dao Questiondao;

	public List<quiz_questions> getallquestions(){
		
		return Questiondao.findAll();
		
	}

	public List<quiz_questions> getQuestionsByCategory(String category) {
		
		// TODO :It can be Improved 
		return Questiondao.findByCategory(category);
	}

	public String addQuestion(quiz_questions question) {
		Questiondao.save(question);
        return "Question added successfully";

		
	}

	public String deletequestionById(Integer id) {
		if (Questiondao.existsById(id)) {
			Questiondao.deleteById(id);
	        return "Question with id "+ id+" deleted successfully ";
		}
		else {
	        return "Question with id " + id + " not Avalable";

			}
		}
	
	public String updateQuestion(Integer id, quiz_questions updatedQuestion) {
	    if (Questiondao.existsById(id)) {
	        
	    	quiz_questions existing = Questiondao.findById(id).get();

	        existing.setCategory(updatedQuestion.getCategory());

	        existing.setDifficultylevel(updatedQuestion.getDifficultylevel());
	        existing.setQuestion_title(updatedQuestion.getQuestion_title());
	        existing.setOption1(updatedQuestion.getOption1());
	        existing.setOption2(updatedQuestion.getOption2());
	        existing.setOption3(updatedQuestion.getOption3());
	        existing.setOption4(updatedQuestion.getOption4());
	        existing.setRight_answer(updatedQuestion.getRight_answer());

	        Questiondao.save(existing);
	        return "Question with id " + id + " updated successfully";
	    } else {
	        return "Question id " + id + " not found";
	    }
	}

	}

	

