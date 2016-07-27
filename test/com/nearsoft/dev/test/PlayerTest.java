package com.nearsoft.dev.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fmartinez.playerTest.Player;
import fmartinez.playerTest.Team;

public class PlayerTest {

	@Test
	public void testPlayerAttributes() {
		Player Player = new Player();
		assertNull(Player.getUserName());
		assertNull(Player.getFirstName());
		assertNull(Player.getLastName());
		assertEquals(0, Player.getTeamId());

		Player.setUserName("doo@nearsoft.com");
		Player.setFirstName("John");
		Player.setLastName("Doe");
		Team team = new Team();
		team.setId(100);
		team.setName("Baseball");
		Player.setTeam(team);
		Player.setTeamId(100);

		assertEquals("doo@nearsoft.com", Player.getUserName());
		assertEquals("John", Player.getFirstName());
		assertEquals("Doe", Player.getLastName());
		assertEquals(100, Player.getTeamId());
		assertEquals(team, Player.getTeam());
	}
	@Test
	public void testSortByUserNameAsc() {
		Player playerFoo = new Player();
		playerFoo.setUserName("doo@nearsoft.com");

		Player playerBar = new Player();
		playerBar.setUserName("bar@nearsoft.com");

		List<Player> Players = new ArrayList<Player>();
		Players.add(playerFoo);
		Players.add(playerBar);

		List<Player> sorted = Player.sortByUserNameAsc(Players);
		assertEquals(2, sorted.size());
		assertEquals("bar@nearsoft.com", sorted.get(0).getUserName());
		assertEquals("doo@nearsoft.com", sorted.get(1).getUserName());
	}
	@Test
	public void testSortByUserNameDesc() {
		Player playerFoo = new Player();
		playerFoo.setUserName("doo@nearsoft.com");

		Player PlayerBar = new Player();
		PlayerBar.setUserName("bar@nearsoft.com");

		List<Player> Players = new ArrayList<Player>();
		Players.add(playerFoo);
		Players.add(PlayerBar);

		List<Player> sorted = Player.sortByUserNameDesc(Players);
		assertEquals(2, sorted.size());
		assertEquals("doo@nearsoft.com", sorted.get(0).getUserName());
		assertEquals("bar@nearsoft.com", sorted.get(1).getUserName());
	}

}