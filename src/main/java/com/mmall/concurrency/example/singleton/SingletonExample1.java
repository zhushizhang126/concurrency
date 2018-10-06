package com.mmall.concurrency.example.singleton;

public class SingletonExample1 {

	//私有变量外界无法访问
	private static  SingletonExample1 instance = null;
	//私有构造器保证外界无法创建
	private SingletonExample1(){
		
	}
	//懒汉模式，只有用到了才创建
	public static SingletonExample1 getTnstance(){
		if(instance == null ){
			synchronized (instance) {
				if(instance == null){
					new SingletonExample1();
				}
			}
		}
		return instance;
	}
}
