package com.example.gangwarsrparmory.fetch;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import android.provider.Telephony.Sms.Conversations;

public abstract class Fetch {

	protected String input = null;
	protected String urlS = null;
	
	public volatile boolean conn_error = false; // "Unable to fetch the data. Check your internet connection."
	
	public volatile boolean data_error = false; // "Wrong input. Please, enter a valid {gang name}{character name}{steam id}."
	
	public volatile boolean stillParsing = true;
	
	public Fetch(String in){
		input=in;
	}
	
	public abstract Object parseJSON(String i);
	
	public void fetchJSON(){
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					
					URL url = new URL(urlS);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setReadTimeout(10000);
					conn.setConnectTimeout(15000);
					conn.setRequestMethod("GET");
					conn.setDoInput(true);
					
					conn.connect(); // query
					
					InputStream stream = conn.getInputStream();
					
					Scanner s = new Scanner(stream).useDelimiter("\\A");
					
					String data = s.hasNext() ? s.next() : "";
					
					parseJSON(data);
					
					stream.close();
					stillParsing=false;
					
					
				} catch (Exception e) {
					conn_error = true;
					e.printStackTrace();
					
				}
			}
			
		});
		t.start();
	}
}
