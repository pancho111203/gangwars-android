package com.example.gangwarsrparmory.logic;

public class Server {
	
	

	private String name, min_level, max_level, ip, current_players, server_fps, server_uptime;
	
	public Server(String name, String min_level, String max_level, String ip,
			String current_players, String server_fps, String server_uptime) {
		
		this.name = name;
		this.min_level = min_level;
		this.max_level = max_level;
		this.ip = ip;
		this.current_players = current_players;
		this.server_fps = server_fps;
		this.server_uptime = server_uptime;
	}

	public String getName() {
		return name;
	}

	public String getMin_level() {
		return min_level;
	}

	public String getMax_level() {
		return max_level;
	}

	public String getIp() {
		return ip;
	}

	public String getCurrent_players() {
		return current_players;
	}

	public String getServer_fps() {
		return server_fps;
	}

	public String getServer_uptime() {
		return server_uptime;
	}
	

}
