package com.nearsoft.dev.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import fmartinez.statsManager.StatsManager;



public class StatsManagerTest {
	 private StatsManager _statsManager;

	@Before public void setUp(){
		 _statsManager = new StatsManager();
		 _statsManager.loadStatsFromFile("england_premier_league_2000.xml");
	 }
	 
     @Test public void getTeamWithMostWonMatches(){
       	 String  expectedTeamName = "Manchester Utd";
       	 assertEquals(expectedTeamName,	_statsManager.getTeamNameWithMostWon());
     }
     
     @Test public void getTeamWithMostLostMatches(){
       	 String  expectedTeamName = "Bradford";
       	 assertEquals(expectedTeamName,_statsManager.getTeamNameWithMostLost());
     }

    @Test public void statsToString(){
    	String expectedSumary = loadTextFile("summary_england_premier_league_2000.txt");
    	assertEquals(expectedSumary,_statsManager.toString());
    }

	private String loadTextFile(String string) {
		StringBuilder sb = new StringBuilder();
		try {
			FileReader fileReader = new FileReader(string);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while( (line = reader.readLine()) != null ){
				sb.append(line+"\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
     
     
}
