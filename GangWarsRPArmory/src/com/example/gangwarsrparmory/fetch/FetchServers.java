package com.example.gangwarsrparmory.fetch;

import java.util.ArrayList;

import org.json.JSONObject;

import com.example.gangwarsrparmory.logic.Server;

public class FetchServers extends Fetch{
	
	private ArrayList<Server> servers;
	
	private String name, min_level, max_level, ip, current_players, server_fps, server_uptime;
	
	private final String baseUrl="http://gangwarsrp.com/api/servers";

	public FetchServers() {
		super(null);
		urlS = baseUrl; 
	}

	@Override
	public ArrayList<Server> parseJSON(String in) {
		try {
			 servers = new ArrayList<Server>();
	         JSONObject read = new JSONObject(in);

	         JSONObject aux = null;
	         for(int i=1;i<=read.length();i++){ // traverses all the servers
	        	 aux = read.getJSONObject(i+"");
	        	 
	        	 name = aux.getString("name");
	        	 min_level = aux.getString("min_level");
	        	 max_level = aux.getString("max_level");
	        	 ip = aux.getString("ip");
	        	 current_players = aux.getString("current_players");
	        	 server_fps = aux.getString("server_fps");
	        	 server_uptime = aux.getString("server_uptime");
	        	 
	        	 servers.add(new Server(name, min_level, max_level, ip, current_players, server_fps, server_uptime));
	        	 
	         }

	        } catch (Exception e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	        }
		return servers;
	}

}
