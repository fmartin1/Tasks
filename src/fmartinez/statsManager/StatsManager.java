package fmartinez.statsManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class StatsManager {

	private Results results;
	private HashMap<String, Team> season;
	
	public StatsManager() {
		results = new Results();
	}
	
	public void loadStatsFromFile(String string) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Results.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Results res = (Results) jaxbUnmarshaller.unmarshal(new File(string));
			setResults(res);
			computeSeason();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private void computeSeason() {		
		season = new HashMap<String, Team>();
		for( MatchResult mr : results.getResults() ){
			String local = mr.getLocal();
			if( !season.containsKey(local) ){
				season.put(local, new Team(local,0,0,0));
			}
			String visitor = mr.getVisitor();
			if( !season.containsKey(visitor) ){
				season.put(visitor, new Team(visitor,0,0,0));
			}
			String winner = mr.getMatchWinner();
			if( winner.equals("Draw") ) {
				season.get(local).addDrawn();
				season.get(visitor).addDrawn();
			}
			else {
				season.get(winner).addWon();
				season.get(mr.getMatchLoser()).addLost();
			}
		}
	}

	public String getTeamNameWithMostWon() {
		if( season == null ){
			computeSeason();
		}
		String mostWon = "";
		int highestScore = 0;
		for(Team team : season.values()) {
			if ( team.getWon() > highestScore ){
				mostWon = team.getName();
				highestScore = team.getWon();
			}
		}
		return mostWon;
	}

	public Object getTeamNameWithMostLost() {
		if( season == null ){
			computeSeason();
		}
		String mostLost = "";
		int highestScore = 0;
		for(Team team : season.values()) {
			if ( team.getLost() > highestScore ){
				mostLost = team.getName();
				highestScore = team.getLost();
			}
		}
		return mostLost;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	@Override
	public String toString() {
		if( season == null ){
			computeSeason();
		}
		List<Team> teams = new ArrayList<Team>(season.values());
		StringBuilder output = new StringBuilder();
		output.append("#\tTeam\tWon\tDrawn\tLost\n");
		int index = 1;
		
		Collections.sort(teams);
		for(Team team : teams){
			output.append(String.format("%d\t%s\t%d\t%d\t%d\n", index,team.getName(),
					team.getWon(),team.getDrawn(),team.getLost()));
			index++;
		}
		return output.toString();
	}
	

}
