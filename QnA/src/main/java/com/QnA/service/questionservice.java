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
		
	}

	
}
