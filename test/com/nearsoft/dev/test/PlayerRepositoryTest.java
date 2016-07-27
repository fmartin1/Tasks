package com.nearsoft.dev.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import fmartinez.playerRepository.PlayerRepository;
import fmartinez.playerTest.Player;
import fmartinez.playerTest.Team;

public class PlayerRepositoryTest {

    private Connection _connection;

    @Before public void setUp() throws Exception {
        _connection = getConnection();
    }
 
    private Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Properties props = new Properties();
    	props.put("user", "root");
    	props.put("password", "jaina");
    	props.put("autoReconnect", "true");
    	props.put("serverTimezone", "UTC");
    	props.put("useSSL", "false");
		String connURL = "jdbc:mysql://localhost:3306/nstest";
		return DriverManager.getConnection(connURL, props);
	}
    @Test
	public void testGetPlayers() throws Exception {
        PlayerRepository PlayerRepository = new PlayerRepository(_connection);
        List<Player> Players = PlayerRepository.getPlayers();
        assertEquals(3, Players.size());

        Player john = Players.get(0);
        assertEquals("john@nearsoft.com", john.getUserName());
        assertEquals("John", john.getFirstName());
        assertEquals("Doe", john.getLastName());
        assertEquals(100, john.getTeamId());

        Player jane = Players.get(1);
        assertEquals("jane@nearsoft.com", jane.getUserName());
        assertEquals("Jane", jane.getFirstName());
        assertEquals("Doe", jane.getLastName());
        assertEquals(100, jane.getTeamId());

        Player bob = Players.get(2);
        assertEquals("bob@nearsoft.com", bob.getUserName());
        assertEquals("Bob", bob.getFirstName());
        assertEquals("Ross", bob.getLastName());
    }

    @Test
    public void testGetPlayersByTeamId() throws Exception {
        PlayerRepository PlayerRepository = new PlayerRepository(_connection);
        List<Player> Players = PlayerRepository.getPlayersByTeamId(100);
        assertEquals(2, Players.size());

        Player john = Players.get(0);
        assertEquals("john@nearsoft.com", john.getUserName());
        assertEquals("John", john.getFirstName());
        assertEquals("Doe", john.getLastName());
        assertEquals(100, john.getTeamId());

        Team softball = john.getTeam();
        assertEquals(100, softball.getId());
        assertEquals("Softball", softball.getName());

        Player jane = Players.get(1);
        assertEquals("jane@nearsoft.com", jane.getUserName());
        assertEquals("Jane", jane.getFirstName());
        assertEquals("Doe", jane.getLastName());
        assertEquals(100, jane.getTeamId());

        assertEquals(softball, jane.getTeam());
    }

}