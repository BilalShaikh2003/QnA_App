package com.QnA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.QnA.model.questionWrapper;
import com.QnA.service.quizService;

@RestController
@RequestMapping("quiz")
public class quizController {
	
	@Autowired
	quizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> reateQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
		return quizService.createQuiz(category , numQ ,title);
}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<questionWrapper>> getQuizQuestion(@PathVariable Integer id){
		return 	quizService.getQuizQuestion(id);
		
		/* Before getting quiz run: " http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz" in Postman 
		 * to actually create quiz and then run : http://localhost:8080/quiz/get/1
		 * to get the Quiz
		 */
		
	}
}
