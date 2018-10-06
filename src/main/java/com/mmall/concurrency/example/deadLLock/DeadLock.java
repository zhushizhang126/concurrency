package com.mmall.concurrency.example.deadLLock;

import javax.validation.constraints.Pattern.Flag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.example.ThreadPoolExample.ThreadPoolExample4;

public class DeadLock implements Runnable{
	private  final static Logger log = LoggerFactory.getLogger(DeadLock.class);
	public  int flag = 1;
	private static Object obj1 = new Object();
	private static Object obj2 = new Object();
	
	public static void main(String[] args)  {
		DeadLock thread1 = new DeadLock();
		DeadLock thread2 = new DeadLock();
		thread1.flag = 1;
		thread1.flag = 0;
		new Thread(thread1).start();
		new Thread(thread2).start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if(flag == 1 ){
			synchronized(obj1){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.info("执行了Obj11");
				synchronized(obj2){
					log.info("执行了Obj12");
				}
			}
			
		}else
		if(flag == 0){
			synchronized(obj2){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.info("执行了Obj21");
				synchronized(obj1){
					log.info("执行了Obj22");
				}
			}
			
		}
	}
}
