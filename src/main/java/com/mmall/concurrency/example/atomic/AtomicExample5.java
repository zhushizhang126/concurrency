package com.mmall.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.annoations.ThreadSafe;
import com.mmall.concurrency.example.atomic.AtomicExample3;

@ThreadSafe
public class AtomicExample5 {
	private  final static Logger logger = LoggerFactory.getLogger(AtomicExample5.class);
	
	private static AtomicExample5 example5 = new AtomicExample5();
	private static AtomicIntegerFieldUpdater<AtomicExample5> update = 
			AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");
	private volatile int count = 100;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static void main(String[] args) {
		if(update.compareAndSet(example5, 100, 120)){
			logger.info("update success 1 ,{}",example5.getCount());
		}
		if(update.compareAndSet(example5, 100, 120)){
			logger.info("update success 2 ,{}",example5.getCount());
		}else{
			logger.info("update falied 1 ,{}",example5.getCount());
		}
	}
}
