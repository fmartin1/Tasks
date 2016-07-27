package fmartinez.playerTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerFactory {
	
	// Could also implement static factory method in Player.class
	public Player newPlayerFromResultSet(ResultSet rs) throws SQLException {
		Player player = new Player();
		player.setUserName(rs.getString("username"));
		player.setFirstName(rs.getString("firstname"));
		player.setLastName(rs.getString("lastname"));
		int teamId = rs.getInt("teamId");
		if ( teamId > 0 ){
			Team t = new Team();
			t.setId(teamId);
			t.setName(rs.getString("teamname"));
			player.setTeam(t);
		}
		return player;
	}

}
