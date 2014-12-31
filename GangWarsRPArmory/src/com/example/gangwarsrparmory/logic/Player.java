package com.example.gangwarsrparmory.logic;

import java.util.ArrayList;

import android.graphics.Color;

public class Player {
		
	private String name, race, money, create_date,played_time,kills,c_epics,c_weps,c_armors,level, xp, prim_color, sec_color, g_name, g_c1, g_c2;
		
	private ArrayList<Achievement> achievements;
		
	public Player(String name, String race, String money, String create_date,
			String played_time, String kills, String c_epics, String c_weps,
			String c_armors, String level, String xp, String prim_color,
			String sec_color, String g_name, String g_c1, String g_c2,
			ArrayList<Achievement> achievements) {
		super();
		this.name = name;
		this.race = race;
		this.money = money;
		this.create_date = create_date;
		this.played_time = played_time;
		this.kills = kills;
		this.c_epics = c_epics;
		this.c_weps = c_weps;
		this.c_armors = c_armors;
		this.level = level;
		this.xp = xp;
		this.prim_color = prim_color;
		this.sec_color = sec_color;
		this.g_name = g_name;
		this.g_c1 = g_c1;
		this.g_c2 = g_c2;
		this.achievements = achievements;
	}

	
	public String getName() {
		return name;
	}


	public String getRace() {
		return race;
	}


	public String getMoney() {
		return money;
	}


	public String getCreate_date() {
		return create_date;
	}


	public String getPlayed_time() {
		return played_time;
	}


	public String getKills() {
		return kills;
	}


	public String getC_epics() {
		return c_epics;
	}


	public String getC_weps() {
		return c_weps;
	}


	public String getC_armors() {
		return c_armors;
	}


	public String getLevel() {
		return level;
	}


	public String getXp() {
		return xp;
	}

	public int getSec_color() {
		String [] aux =sec_color.split(", ");
		int color = Color.rgb(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
		
		return color;
	}
	
	public int getPrim_color() {
		String [] aux =prim_color.split(", ");
		int color = Color.rgb(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
		
		return color;
	}


	public String getGangName() {
		return g_name;
	}


	public int getGangPrimColor() {
		String [] aux =g_c1.split(", ");
		int color = Color.rgb(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
		
		return color;
	}


	public int getGangSecColor() {
		String [] aux =g_c2.split(", ");
		int color = Color.rgb(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
		
		return color;
	}


	public ArrayList<Achievement> getAchievements() {
		return achievements;
	}

}
