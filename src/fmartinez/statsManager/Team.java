package fmartinez.statsManager;

public class Team implements Comparable<Team> {

	private String name;
	private int won;
	private int drawn;
	private int lost;
	
	public Team(String name, int won, int drawn, int lost) {
		this.name = name;
		this.won = won;
		this.drawn = drawn;
		this.lost = lost;
	}
	
	public String getName() {
		return name;
	}

	public int getWon() {
		return won;
	}

	public void addWon() {
		this.won++;
	}

	public int getDrawn() {
		return drawn;
	}

	public void addDrawn() {
		this.drawn++;
	}

	public int getLost() {
		return lost;
	}

	public void addLost() {
		this.lost++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Team o) {
		int s1 = this.won*3 + this.drawn; //Football stats, was not prepared for this.
		int s2 = o.getWon()*3 + o.getDrawn();
		if(s1==s2){
			return o.getName().compareTo(this.name);
		}
		return s2-s1;
	}	
}
