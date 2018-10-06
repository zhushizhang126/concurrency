package com.mmall.concurrency.example.ThreadPoolExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.example.aqs.FutureTaskExample;

public class ThreadPoolExample3 {
	private  final static Logger log = LoggerFactory.getLogger(ThreadPoolExample3.class);
	public static void main(String[] args) {
		ExecutorService  executorService  = Executors.newSingleThreadExecutor();
		
		for(int i= 0 ;i<10 ;i++){
			final int  index= i ;
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					log.info("执行{}",index);
				}
			});
		}
		executorService.shutdown();
	}
}
