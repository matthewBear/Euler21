package com.matt.jobs;

import java.util.Random;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.matt.Answer;
import com.matt.Message;

@Component
public class AppJob {
	
	private final String uri = "http://localhost:8080/messages";

	private static int MISSION_ID = 0;
	private final int seedFloor = 1000;
	private final int seedCeiling = 20000;
	
	private Random rand = new Random();
	
	@Scheduled(fixedDelay = 3000)
	public void sendMessage() {
		System.out.println("--SENDING MESSAGE--");
		
		int randomSeed = rand.nextInt((seedCeiling - seedFloor) + 1) + seedFloor;
		
		Message message = new Message();
		message.setMissionId(MISSION_ID++);
		message.setSeed(randomSeed);
		
		System.out.println("Mission ID:"+MISSION_ID+"     seed:"+randomSeed);
		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Answer> response = restTemplate.postForEntity(uri, message, Answer.class);
		
		HttpStatus status = response.getStatusCode();
		Answer restCall = response.getBody();
		
		System.out.println("HTTP Code: "+status+"  Answer:"+restCall.getAnswer());
	}

}
