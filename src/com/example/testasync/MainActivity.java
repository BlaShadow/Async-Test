package com.example.testasync;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView label = (TextView)findViewById(R.id.txt_label);
		final Context context = this;
		
		AsyncReneric.getInstance().setCallback(new CallBackInterface<String>() {

			@Override
			public void run() {
				
				HttpClient client = new DefaultHttpClient();
				
				HttpGet request = new HttpGet("http://172.27.99.39");
				
				try {
					HttpResponse response = client.execute(request);
					
					if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
						//Toast.makeText(context, "Metio mano", Toast.LENGTH_SHORT).show();
						Log.i("TAG","Metio mano");
					}
					
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void postExecute(){
				label.setText("Request made");
			}
			
		}).execute();
		
	}
}
