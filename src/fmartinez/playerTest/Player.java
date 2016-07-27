package fmartinez.playerTest;

import java.util.Collections;
import java.util.List;

import fmartinez.playerTest.ByUserNamePlayerComparator.SortOrder;

public class Player {

	private String userName;
	private String firstName;
	private String lastName;
	private Team team;
	
	public Player() {
		team = new Team();
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getTeamId() {
		return team.getId();
	}
	public void setTeamId(int id) {
		team.setId(id);
	}
	
	public static List<Player> sortByUserNameAsc(List<Player> players) {
		Collections.sort(players, 
				new ByUserNamePlayerComparator(SortOrder.ASCENDING));
		return players;
	}
	
	public static List<Player> sortByUserNameDesc(List<Player> players) {
		Collections.sort(players, 
				new ByUserNamePlayerComparator(SortOrder.DESCENDING));
		return players;
	}
	
}
