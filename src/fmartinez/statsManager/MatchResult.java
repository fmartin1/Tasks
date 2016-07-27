package fmartinez.statsManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="matchResult")
public class MatchResult {
	private String date;
	private String local;
	private String visitor;
	private String score;
	
	@XmlElement(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@XmlElement(name="local")
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	@XmlElement(name="visitor")
	public String getVisitor() {
		return visitor;
	}
	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}
	
	@XmlElement(name="score")
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getMatchWinner() {
		String[] scoreStr = this.score.split("\\-");
		int sc1 = Integer.parseInt(scoreStr[0]);
		int sc2 = Integer.parseInt(scoreStr[1]);
		if ( sc1 > sc2 ) {
			return this.local;
		}
		if ( sc2 > sc1 ) {
			return this.visitor;
		}
		else {
			return "Draw";
		}
	}
	
	public String getMatchLoser() {
		String winner = this.getMatchWinner();
		if ( winner.equals(local) ){
			return this.visitor;
		}
		if ( winner.equals(visitor)) {
			return local;
		}
		return "Draw";
	}
}
