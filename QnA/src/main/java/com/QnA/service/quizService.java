package com.QnA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.QnA.quiz_questions;
import com.QnA.model.questionWrapper;
import com.QnA.model.quiz;
import com.QnA.questiondao.Dao;
import com.QnA.questiondao.quizDao;

@Service
public class quizService {

	@Autowired
	quizDao quizDao;
	@Autowired
	private Dao questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
	
	    List<quiz_questions> questions = questionDao.findRandomByCategory(category,numQ);

		
		quiz quiz = new quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);
 
        return ResponseEntity.ok("Quiz created successfully!");

		
	}

	public ResponseEntity<List<questionWrapper>> getQuizQuestion(Integer id) {
		
		Optional<quiz> quiz = quizDao.findById(id);
		if (quiz.isPresent()) {

		List<quiz_questions> questionFromDB = quiz.get().getQuestion();
		List<questionWrapper> questionForUser= new ArrayList<>();
		for(quiz_questions q: questionFromDB) {
			questionWrapper qw=new questionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
		}
		else {
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>()); 
		}
		
		
	}
	
}

