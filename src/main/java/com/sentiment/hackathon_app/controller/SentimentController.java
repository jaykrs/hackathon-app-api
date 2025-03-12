package com.sentiment.hackathon_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sentiment.hackathon_app.model.SentimentResponse;
import com.vader.sentiment.analyzer.SentimentAnalyzer;
import com.vader.sentiment.analyzer.SentimentPolarities;


@RestController
@RequestMapping(value = "/api")
public class SentimentController {

@GetMapping(value = "/hallo")
	public ResponseEntity<?> fetchAllResponse() throws JsonProcessingException {
	
	ArrayList<String> sentencess = new ArrayList<String>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		 add("This product is a complete disaster. It broke within the first 10 minutes of use, and the customer service is non-existent. Worst purchase I’ve ever made!");
		 add("I regret buying this. The product doesn’t do what it promises, and it’s almost as if they used cheaper materials to trick you. Terrible quality. Zero stars if I could rate it that way.");
		 add("Absolute garbage! This thing barely even works, and when it does, it performs terribly. I feel scammed. If you're thinking about buying this, do yourself a favor and don’t.");
		 add("The worst product I’ve ever encountered. It’s dangerous, broke on the first use, and the company didn’t even offer a refund or replacement. I’m furious.");
		 add("this is one of the best speaker i purchased till now , it works ossome and so melodious");
		}
	};
    String s = "";
    List<SentimentResponse> lsr= new ArrayList<SentimentResponse>();
		for (String sentence : sentencess) {
			System.out.println(sentence);
			final SentimentPolarities sentimentPolarities = SentimentAnalyzer.getScoresFor(sentence);
			SentimentResponse sr = new SentimentResponse(sentence, sentimentPolarities.getNegativePolarity(),
					sentimentPolarities.getPositivePolarity(), sentimentPolarities.getCompoundPolarity(),
					sentimentPolarities.getNeutralPolarity());
			s = s + sentimentPolarities;
			lsr.add(sr);
		}
		ObjectMapper mapper = new ObjectMapper();
		String newJsonData = mapper.writeValueAsString(lsr);
		return ResponseEntity.ok().body(newJsonData);
	}
}
