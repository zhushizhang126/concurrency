package com.mmall.concurrency.example.publish;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.NotThreadSafe;

@NotThreadSafe
@NotRecommend
public class Escape {

	private  final static Logger log = LoggerFactory.getLogger(Escape.class);
	
	private int thisCanBeEscape = 0;
	
	public Escape (){
		new InnerClass();
	}
	
	private class InnerClass {
		public InnerClass(){
			log.info("{}",Escape.this.thisCanBeEscape);
		}
		
	}
	
	public static void main(String[] args) {
		new Escape();
	}
}
	
