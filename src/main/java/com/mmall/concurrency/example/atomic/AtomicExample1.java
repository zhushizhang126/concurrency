package com.mmall.concurrency.example.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;


@ThreadSafe
public class AtomicExample1 {
	private  final static Logger logger = LoggerFactory.getLogger(AtomicExample1.class);
	//请求总数
	public static int clientTotal = 5000;
	//同时并发的执行线程
	public static int threadTotal = 200 ;
	
	public static AtomicInteger count = new AtomicInteger(0);
	
	
	public static void main(String[] args) throws Exception {
		ExecutorService executorService  = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for(int i = 0 ; i<clientTotal ; i++){
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					add();
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
		logger.info("count{}",count.get());
	}
	
	public static void add(){
		count.incrementAndGet();
	}
}
