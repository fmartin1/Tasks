package fmartinez.playerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fmartinez.playerTest.Player;
import fmartinez.playerTest.PlayerFactory;

public class PlayerRepository {
	
	private Connection conn;
	private PlayerFactory playerFactory;
	
	public PlayerRepository (Connection c) {
		conn = c;
		playerFactory = new PlayerFactory();
	}

	public List<Player> getPlayers() {
		String select = "SELECT * FROM Players LEFT JOIN Teams ON players.teamId = teams.teamId";
		List<Player> playerList = new ArrayList<Player>();
		try {
			Statement allPlayers = conn.createStatement();
			ResultSet rs = allPlayers.executeQuery(select);
			while(rs.next()){
				playerList.add(playerFactory.newPlayerFromResultSet(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}

	public List<Player> getPlayersByTeamId(int i) {
		String select = "SELECT * FROM Players NATURAL JOIN Teams WHERE teamId = ?";
		List<Player> playerList = new ArrayList<Player>();
		try {
			PreparedStatement playersByTeam = conn.prepareStatement(select);
			playersByTeam.setInt(1, i);
			ResultSet rs = playersByTeam.executeQuery();
			while(rs.next()){
				playerList.add(playerFactory.newPlayerFromResultSet(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}
}
