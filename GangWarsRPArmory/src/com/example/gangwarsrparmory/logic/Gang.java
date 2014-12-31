package com.example.gangwarsrparmory.logic;

import android.graphics.Color;

public class Gang {
	
	private String name, money, creator,points,w_lost,w_won,s_won,level, xp, prim_color, sec_color;
	private String[] recruits, soldiers, captains, viceleaders, leaders;
	private String[] upgs;
	
	public Gang(String name, String money, String creator, String points,
			String w_lost, String w_won, String s_won, String level, String xp,
			String prim_color, String sec_color, String[] recruits,
			String[] soldiers, String[] captains, String[] viceleaders,
			String[] leaders, String[] upgs) {
		this.money=money;
		this.name=name;
		this.creator=creator;
		this.points=points;
		this.w_lost=w_lost;
		this.w_won=w_won;
		this.level=level;
		this.xp=xp;
		this.prim_color=prim_color;
		this.sec_color=sec_color;
		this.recruits=recruits;
		this.soldiers=soldiers;
		this.captains=captains;
		this.viceleaders=viceleaders;
		this.leaders=leaders;
		this.upgs=upgs;
		
	}
	
	public String getName() {
		return name;
	}

	public String getMoney() {
		return money;
	}

	public String getCreator() {
		return creator;
	}

	public String getLevel() {
		return level;
	}

	public String getXp() {
		return xp;
	}

	public String getPoints() {
		return points;
	}

	public String getW_won() {
		return w_won;
	}

	public String getW_lost() {
		return w_lost;
	}

	public String getS_won() {
		return s_won;
	}

	public int getPrim_color() {
		String [] aux =prim_color.split(", ");
		int color = Color.rgb(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
		
		return color;
	}

	public int getSec_color() {
		String [] aux =sec_color.split(", ");
		int color = Color.rgb(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
		
		return color;
	}

	public String[] getRecruits() {
		return recruits;
	}

	public String[] getSoldiers() {
		return soldiers;
	}

	public String[] getCaptains() {
		return captains;
	}

	public String[] getViceleaders() {
		return viceleaders;
	}

	public String[] getLeaders() {
		return leaders;
	}

	public String[] getUpgs() {
		return upgs;
	}

}
