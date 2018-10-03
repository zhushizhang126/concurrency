package com.mmall.concurrency.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.example.atomic.AtomicExample1;


public class SynchronizedExample1 {
	private  final static Logger log = LoggerFactory.getLogger(SynchronizedExample1.class);
	
	//修饰一个代码块
	public void test1(int j){
		synchronized (this){
			for(int i = 0 ;i<10 ;i++){
				log.info("test1---{}---{}",j,i);
			}
		}
	}
	
	
	//修饰一个方法
	public synchronized void test2(int j){
		for(int i = 0 ;i<10 ;i++){
			log.info("test1---{}---{}",j,i);
		}
	}
	
	public static void main(String[] args) {
		SynchronizedExample1 example1 = new SynchronizedExample1();
		SynchronizedExample1 example2 = new SynchronizedExample1();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(() ->{
			example1.test2(1);
		});
		executorService.execute(() ->{
			example2.test2(2);
		});
	}
}
