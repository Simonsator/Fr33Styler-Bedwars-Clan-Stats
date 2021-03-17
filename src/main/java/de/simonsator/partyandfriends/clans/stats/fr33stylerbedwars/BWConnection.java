package de.simonsator.partyandfriends.clans.stats.fr33stylerbedwars;


import de.simonsator.partyandfriends.communication.sql.SQLCommunication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;


public class BWConnection extends SQLCommunication {

	protected BWConnection(String pDatabase, String pURL, String pUserName, String pPassword, boolean pSSL) {
		super(pDatabase, pURL, pUserName, pPassword, pSSL);
	}


	public PlayerData getPlayerData(UUID pUUID) {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			rs = (stmt = con.createStatement()).executeQuery("select KILLS, WINS, LOSES,  BEDS_DESTROYED, DEATHS from `" + this.DATABASE + "`.BedWars WHERE uuid='" + pUUID.toString() + "' LIMIT 1");
			if (rs.next()) {
				return new PlayerData(rs.getInt("WINS"), rs.getInt("LOSES"), rs.getInt("BEDS_DESTROYED"), rs.getInt("DEATHS"), rs.getInt("KILLS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, stmt);
		}
		return null;
	}

}