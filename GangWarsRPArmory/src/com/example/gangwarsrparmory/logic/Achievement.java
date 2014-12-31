package com.example.gangwarsrparmory.logic;

public class Achievement {

	private String name, progress, max, desc;
	
	public Achievement(String name, String progress, String max, String desc) {
		this.name=name;
		this.progress=progress;
		this.max=max;
		this.desc=desc;
	}

	public String getName() {
		return name;
	}

	public String getProgress() {
		return progress;
	}

	public String getMax() {
		return max;
	}

	public String getDesc() {
		return desc;
	}

}
