package com.harris.challenge.secret_agent_tools;

import java.util.ArrayList;

public class SafeCombination {

	ArrayList<Integer> combo = new ArrayList<Integer>();
	
	public SafeCombination(int a, int b, int c){
		combo.add(a);
		combo.add(b);
		combo.add(c);
	}
	
	public ArrayList<Integer> getCombo(){
		return combo;
	}
	
}
