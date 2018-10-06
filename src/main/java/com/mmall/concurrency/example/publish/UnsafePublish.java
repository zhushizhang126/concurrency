package com.mmall.concurrency.example.publish;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.example.count.CountExample1;
 @NotThreadSafe
public class UnsafePublish {
	private  final static Logger log = LoggerFactory.getLogger(UnsafePublish.class);
	private String[] states = {"a","b","c"};

	public String[] getStates() {
		return states;
	}

	public static void main(String[] args) {
		UnsafePublish unsafePublish =  new UnsafePublish();
		log.info("{}",Arrays.toString(unsafePublish.getStates()));
		unsafePublish.getStates()[0] = "d";
		log.info("{}",Arrays.toString(unsafePublish.getStates()));
	}
	
}
