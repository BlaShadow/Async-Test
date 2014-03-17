package com.example.testasync;

public abstract class CallBackInterface<T> {
	
	public abstract void run();
	
	public void postExecute(){
		// do nothing
	}

}
