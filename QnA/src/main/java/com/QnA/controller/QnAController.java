package com.QnA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}



//package com.QnA.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.QnA.quiz_questions;
//import com.QnA.service.questionservice;
//
//@RestController
//@RequestMapping("question")
//public class QnAController {
//	
//	
//	@Autowired
//	static
//	questionservice Questionservice;
//	
//	
//	@GetMapping("allquestion")
//	
//	public static List<quiz_questions>  getallquestion(){
//		return Questionservice.getallquestions();
//		
//		
//	}
//}
