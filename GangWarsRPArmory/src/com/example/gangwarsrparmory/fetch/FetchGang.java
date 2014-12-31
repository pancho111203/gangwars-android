package com.example.gangwarsrparmory.fetch;

import org.json.JSONObject;

import com.example.gangwarsrparmory.logic.Gang;

import android.graphics.Color;

public class FetchGang extends Fetch{
	
	private String name, money, creator,points,w_lost,w_won,s_won,level, xp, prim_color, sec_color;
	private String[] recruits, soldiers, captains, viceleaders, leaders;
	private String[] upgs;
	
	private int recruit, soldier,captain,viceleader,leader;
	
	private Gang gang;
	
	public static final String[] upgNames={"hp_boost","regen","xp_boost","speed_boost","print_boost","drug_boost","drop_boost","armor_boost","member_boost","shop_boost","pickpocket_boost","bank_boost","mission_boost","gang_xp_boost"};
	
	private final String baseUrl="http://gangwarsrp.com/api/gang/";

	public FetchGang(String in) {
		super(in);
		urlS = baseUrl+in; 
		init();
	}
	
	public void init(){
		recruits = new String[35];
		soldiers = new String[35];
		captains = new String[35];
		viceleaders = new String[35];
		leaders = new String[35];
		
		upgs = new String[upgNames.length];
		
		recruit=0;
		soldier=0;
		captain=0;
		viceleader=0;
		leader=0;
		
	}

	@Override
	public Gang parseJSON(String in) {
		try {
			// ATTENTION: if this method is going to be used more than once per instance,
			// then init() method needs to be called here, not in the constructor
	         JSONObject read = new JSONObject(in);
	         
	         name = read.getString("name");
	         creator = read.getString("creator");
	         money = read.getString("money");
	         
	         level = read.getString("level");
	         xp = read.getString("xp");
	         points = read.getString("points");
	         w_won = read.getString("wars_won");
	         w_lost = read.getString("wars_lost");
	         s_won = read.getString("seasons_won");
	         
	         prim_color = read.getString("color1");
	         sec_color = read.getString("color2");
	         
	         JSONObject mem = read.getJSONObject("members"); // get arrays of members
	         JSONObject aux = null;
	         String name,rank;
	        
	         for(int i=1;i<=mem.length();i++){ // traverses all the members
	        	 aux = mem.getJSONObject(i+"");
	        	 
	        	
	        	 name=aux.getString("name");
	        	 
	        	
	        	 rank=aux.getString("rank");
	        
	        	 
	        	 switch(rank){ // one array per rank
	        	 case "Recruit": recruits[recruit]=name; recruit++; break;
	        	 case "Soldier": soldiers[soldier]=name; soldier++; break;
	        	 case "Captain": captains[captain]=name; captain++; break;
	        	 case "Vice-Leader": viceleaders[viceleader]=name; viceleader++; break;
	        	 case "Leader": leaders[leader]=name; leader++; break;
	        	 }
	         }
	         
	         JSONObject upg = read.getJSONObject("upgrades"); // get upgrade levels
	         for(int i=0;i<upgNames.length;i++){
	        	 upgs[i]=upg.getString(upgNames[i]);
	         } 
	         // upgs is an array of ints, to associate each int to a upgrade name we need to compare it with upgNames array
	        

	        } catch (Exception e) {
	           // TODO Auto-generated catch block
	        	data_error=true;
	           e.printStackTrace();
	        }
			
			gang=new Gang(name, money, creator,points,w_lost,w_won,s_won,level, xp, prim_color, sec_color,recruits, soldiers, captains, viceleaders, leaders,upgs);
		    init();
		    return gang;

	}
	
}