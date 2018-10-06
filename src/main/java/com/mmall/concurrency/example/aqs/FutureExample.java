package com.mmall.concurrency.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.example.publish.Escape;

public class FutureExample {
	private  final static Logger log = LoggerFactory.getLogger(FutureExample.class);
	
	static class MyCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			log.info("do something in callable");
			Thread.sleep(5000);
			return "done";
		}
	
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> future = executorService.submit(new MyCallable());
		String result = future.get();
		Thread.sleep(1000);
		log.info("result {}",result);
	}
}
