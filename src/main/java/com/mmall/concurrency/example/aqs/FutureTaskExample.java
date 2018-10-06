package com.mmall.concurrency.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import javax.validation.constraints.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FutureTaskExample {
	private  final static Logger log = LoggerFactory.getLogger(FutureTaskExample.class);
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				log.info("do something in callable");
				Thread.sleep(5000);
				return "done";
			}
		});
		new Thread(futureTask).start();
		log.info("start main Thread");
		Thread.sleep(1000);
		String result = futureTask.get();
		log.info("result {}",result);
	}

}
