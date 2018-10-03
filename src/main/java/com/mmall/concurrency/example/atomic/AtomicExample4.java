package com.mmall.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.annoations.ThreadSafe;
import com.mmall.concurrency.example.atomic.AtomicExample3;

@ThreadSafe
public class AtomicExample4 {
	private  final static Logger logger = LoggerFactory.getLogger(AtomicExample4.class);
	
	private static AtomicReference<Integer> count = new AtomicReference<Integer>(0);
	public static void main(String[] args) {
		count.compareAndSet(0, 2);
		count.compareAndSet(0, 1);
		count.compareAndSet(1, 3);
		count.compareAndSet(2, 4);
		count.compareAndSet(3, 5);
		logger.info("count{}",count.get());
	}
}
