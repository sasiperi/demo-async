package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DoStuffService {

	@Autowired
	DoAsyncStuffService asyncService;
	
	public String doStuff() {
		
		//Do your other stuff like may be storing to DB or any othet compute
		log.info(" done all sync stuff ... now start async stuff: " + Thread.currentThread());
		
		try 
		{
		
			CompletableFuture<String> aFuture = asyncService.doLongAsyncStuff();
			
			/*
			int i = 0;
			while(!aFuture.isDone()) 
			{
			  
			  log.info("still ... working: " + i++); 
			  
			 }
			 */
			 
			
			if(aFuture.isDone())
			{
				String finalresponse = aFuture.get();
				// Do what ever needs to be done with this response, received after 30 seconds
				// For example
				log.info("Async response: " + finalresponse);
				
			}
			
			
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info(" done all sync stuff ... now start async stuff---2: " + Thread.currentThread());
		return "stuff being done";
	}
	
	
}
