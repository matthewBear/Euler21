package com.matt.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.matt.AlreadyReceivedException;
import com.matt.Answer;
import com.matt.Message;
import com.matt.utils.Euler21Utils;

@RestController
public class MessagesController {
	
	private static Set<Integer> receivedIds = new HashSet<Integer>();

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public @ResponseBody Answer processMessage(@RequestBody Message message) throws Exception{
    	
    	if(alreadyReceived(message.getMissionId())){
    		throw new AlreadyReceivedException("Already recieved missionId="+message.getMissionId());
    	}else{
    		receivedIds.add(message.getMissionId());
    	}
    	
    	int sum = 0;
    	
        for (int i = 1; i < message.getSeed(); i++) {
        	if(Euler21Utils.isAmicibleNumber(i)){
        		sum += i;
        	}
        }

        return new Answer(sum);
    }

    /**
     * Return true iff MessagesController has received the missionId before
     * 
     * @param missionId
     * @return
     */
    private boolean alreadyReceived(Integer missionId) {
		return receivedIds.contains(missionId);
	}

    /**
     * This method handles returning HTTP 409 when a missionId was already received
     * 
     * @param e
     * @param response
     * @throws IOException
     */
	@ExceptionHandler
    void handleException(AlreadyReceivedException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value());
    }
	
	@ExceptionHandler
    void handleException(Exception e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}

