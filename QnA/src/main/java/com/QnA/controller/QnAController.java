package com.QnA.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QnA.quiz_questions;
import com.QnA.service.questionservice;

@RestController
@RequestMapping("/question")
public class QnAController {

    @Autowired
    private questionservice questionService;

    @GetMapping("/allquestion")
    public List<quiz_questions> getAllQuestions() {
        return questionService.getallquestions();
    }


	@GetMapping("/category/{category}")
	public List<quiz_questions> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}

	@PostMapping("add")
	public String addQuestions(@RequestBody quiz_questions question){
		return 	questionService.addQuestion(question);	
	}
	@DeleteMapping("/delete/{id}")
	public String deletequestion(@PathVariable Integer id) {
		return questionService.deletequestionById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateQuestion(@PathVariable Integer id, @RequestBody quiz_questions updatedQuestion) {
	    return questionService.updateQuestion(id, updatedQuestion);
	}

}






/*
package com.QnA.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.QnA.quiz_questions;
import com.QnA.service.questionservice;

@RestController
@RequestMapping("question")
public class QnAController {
	
	
	@Autowired
	static
	public	questionservice Questionservice;
	
	
	@GetMapping("allquestion")
	
	public static List<quiz_questions>  getallquestion(){
		return Questionservice.getallquestions();
		
		
	}
}

*/