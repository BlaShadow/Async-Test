package com.example.testasync;

import android.os.AsyncTask;

public class AsyncReneric extends AsyncTask<Void, Void, Void>{

	private CallBackInterface<?> callback;
	private static AsyncReneric instance;
	
	private AsyncReneric(){
		super();
	}
	
	public static AsyncReneric getInstance(){
		
		instance = new AsyncReneric();
		
		return instance;
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		callback.run();
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		callback.postExecute();
	}

	public CallBackInterface<?> getCallback() {
		return callback;
	}

	public AsyncReneric setCallback(CallBackInterface<?> callback) {
		this.callback = callback;
		
		return instance;
	}

}
