package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DoAsyncStuffService {
	
	
	//Use below to not use SimpleAsyncExecutor
	@Async("threadPoolTaskExecutor")
	//if below uncommented and above commented will use default SimpleAsync Executor
	//@Async
	public CompletableFuture<String> doLongAsyncStuff() throws InterruptedException {
		log.info("Started doing async time taking stuff: " + Thread.currentThread());
		
		// Artificial delay of 30s for demonstration purposes
		Thread.sleep(30000L);
		
		//Otherwise you will be for example calling the API that takes loooong time for example like
		//String url = "API-GATEWAY-Endpoint-URL";
		//ResponseType results = webClient.getForObject(url, ResponseType.class);
		
		
		log.info("Done doing async time taking stuff");
		
		String response = "Done Async process found user";
		
		return CompletableFuture.completedFuture(response);
	}

}
