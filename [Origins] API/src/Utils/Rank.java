package Utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import MySQL.PlayerSQL;

public enum Rank {

	JOUEUR(0,"§7Joueur ", ChatColor.GRAY),
	VIP(10,"§eVip ", ChatColor.YELLOW),
	PARTENAIRE(70,"§dPartenaire ", ChatColor.LIGHT_PURPLE),
	HEROIQUE(90,"§bHeroique ", ChatColor.AQUA),
	MODO(700,"§6Modérateur ", ChatColor.GOLD),
	STAFF(900,"§9Staff ", ChatColor.BLUE),
	ADMIN(1000,"§cAdmin ", ChatColor.RED);

	private int power;
	private String displayName;
	private ChatColor colorTag;
	public static Map<Integer, Rank> grade = new HashMap<>();
	private PlayerSQL sql;

	private HashMap<Player, ChatColor> TAG = new HashMap<Player, ChatColor>();
	private HashMap<Player, String> NAME = new HashMap<Player, String>();
	private HashMap<Player, Integer> POWER = new HashMap<Player, Integer>();
	
	Rank(int power,String displayName, ChatColor tag){
		this.power = power;
		this.displayName = displayName;
		this.colorTag = tag;
	}

	static {
		for(Rank r : Rank.values()){
			grade.put(r.getPower(), r);
		}
	}

	public int getPower(){
		return power;
	}

	public String getName(){
		return displayName;
	}

	public ChatColor getTag(){
		return colorTag;
	}

	public Rank powerToRank(int power){
		return grade.get(power);
	}
	
	public void update(Player player) {
		Rank rank = sql.getRank(player);
		rank.POWER.put(player, rank.getPower());
		rank.NAME.put(player, rank.getName());
		rank.TAG.put(player, rank.getTag());
	}
	
}