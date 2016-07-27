package fmartinez.statsManager;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="results")
public class Results {
	
	private List<MatchResult> results;
	
	@XmlElement(name="matchResult")
	public List<MatchResult> getResults() {
		return results;
	}

	public void setResults(List<MatchResult> results) {
		this.results = results;
	}
}
