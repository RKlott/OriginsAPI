package Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Utils.Rank;

public class JoinQuitListener implements Listener {

	private Rank rank;
	
	public JoinQuitListener(Rank rank) {
		this.rank = rank;
	}
	
	@EventHandler
	public void onJoinServer(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		// OBLIGATOIRE
		rank.update(player);
		// END OBLIGATOIRE
	}
	
}

