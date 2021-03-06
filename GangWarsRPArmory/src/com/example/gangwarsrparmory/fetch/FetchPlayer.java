package com.example.gangwarsrparmory.fetch;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;

import com.example.gangwarsrparmory.logic.Achievement;
import com.example.gangwarsrparmory.logic.Player;

import android.graphics.Color;

public class FetchPlayer extends Fetch{
	
	private String name, race, money, create_date,played_time,kills,c_epics,c_weps,c_armors,level, xp, prim_color, sec_color, g_name, g_c1, g_c2;
	
	private ArrayList<Achievement> achievements;
	
	private Player player;
	
	private final String baseUrl="http://gangwarsrp.com/api/player/";

	public FetchPlayer(String in) {
		super(in);
		urlS = baseUrl+in; 
		
	}
	

	@Override
	public Player parseJSON(String in) {
		try {
			 achievements = new ArrayList<Achievement>();
	         JSONObject read = new JSONObject(in);
	         
	         Iterator<String> key = read.keys(); // always returns 1 single result
	         
	         JSONObject play = read.getJSONObject(key.next());
	         
	         name = play.getString("name");
	         create_date = play.getString("created");
	         money = play.getString("money");
	         race = play.getString("race");
	         level = play.getString("level");
	         xp = play.getString("xp");
	         played_time = play.getString("time");
	         kills = play.getString("kills");
	         c_epics = play.getString("epic_crafts");
	         c_weps = play.getString("weapon_crafts");
	         c_armors = play.getString("armor_crafts");
	         	         
	         JSONObject skin = play.getJSONObject("skin");
	         prim_color = skin.getString("color1");
	         sec_color = skin.getString("color2");
	         
	         JSONObject gang = play.getJSONObject("gang");
	         g_name = gang.getString("name");
	         g_c1 = gang.getString("color1");
	         g_c2 = gang.getString("color2");
	         
	         JSONObject ach = play.getJSONObject("achievements");
	         JSONObject aux=null;
	         for(int i=1;i<=ach.length();i++){ // traverses all the achievements
	        	 aux = ach.getJSONObject(i+"");
		         
	        	 String ach_name, ach_progress, ach_max, ach_desc;
	        	 
	        	 ach_name = aux.getString("name");
	        	 ach_progress = aux.getString("progress");
	        	 ach_max = aux.getString("max");
	        	 ach_desc = aux.getString("desc");
	        	 
	        	 achievements.add(new Achievement(ach_name, ach_progress, ach_max, ach_desc));
	        	 
	         }

	        } catch (Exception e) {
	           // TODO Auto-generated catch block
	        	data_error=true;
	           e.printStackTrace();
	        }
			
		  player= new Player(name, race, money, create_date,played_time,kills,c_epics,c_weps,c_armors,level, xp, prim_color, sec_color, g_name, g_c1, g_c2, achievements);
		  return player;
	}
	
}