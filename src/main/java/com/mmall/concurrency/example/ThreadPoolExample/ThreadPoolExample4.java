package com.mmall.concurrency.example.ThreadPoolExample;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.example.aqs.FutureTaskExample;

public class ThreadPoolExample4 {
	private  final static Logger log = LoggerFactory.getLogger(ThreadPoolExample4.class);
	public static void main(String[] args) {
		ScheduledExecutorService  executorService  = Executors.newScheduledThreadPool(3);
		
		executorService.schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				log.warn("schedule task ");
			}
		},3, TimeUnit.SECONDS);
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				log.warn("schedule task ");
			}
		},1,3, TimeUnit.SECONDS);
		//executorService.shutdown();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				log.warn("执行");
			}
		}, new Date(),5*1000);
	}
}
