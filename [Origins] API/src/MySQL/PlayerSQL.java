package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import Utils.Rank;

public class PlayerSQL {

	public Rank rank;
	
	public PlayerSQL(Rank rank) {
		this.rank = rank;
	}
	
	public Rank getRank(Player player) {
		MySQL.connection();
		PreparedStatement sts;
		try {
			sts = MySQL.getConnection().prepareStatement("SELECT Rank FROM Players WHERE UUID = ?");
			sts.setString(1, player.getUniqueId().toString());
			int power = 0;
			ResultSet result = sts.executeQuery();
			while(result.next()) {
				power = result.getInt("Rank");
				return rank.powerToRank(power);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MySQL.deconnection();
		return Rank.JOUEUR;
	}
	
}
