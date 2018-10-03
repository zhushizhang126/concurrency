package com.mmall.concurrency.example.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.annoations.ThreadSafe;
import com.mmall.concurrency.example.atomic.AtomicExample3;

@ThreadSafe
public class AtomicExample6 {
	private  final static Logger logger = LoggerFactory.getLogger(AtomicExample6.class);
	
	private static AtomicBoolean isHappen = new AtomicBoolean(false);
	
	//请求总数
	public static int clientTotal = 5000;
	//同时并发的执行线程
	public static int threadTotal = 200 ;
	
	public static void main(String[] args) throws Exception {
		ExecutorService executorService  = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for(int i = 0 ; i<clientTotal ; i++){
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					test();
					semaphore.release();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error("Exception",e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		logger.info("isHappen{}",isHappen);
	}
	
	public static void test(){
		if(isHappen.compareAndSet(false, true)){
			logger.info("execute");
		}
	}
}
