package me.spacekiller.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import me.spacekiller.main.Main;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TablistListener implements Listener {
	
	ScoreboardManager sco;
    Scoreboard sb;
    Team O = null;
    Team D = null;
    Team A = null;
    Team M = null;
    Team B = null;
    Team SU = null;
    Team TS = null;
    Team YT = null;
    Team VIPP = null;
    Team PVIP = null;
    Team VIP = null;
    Team S = null;
    
    Boolean initiated = false;
    
    Main plugin;
    
    public TablistListener(Main plugin) {
    	this.plugin = plugin;
    	setPrefix();
    }
	
	public void setPrefix() {
    	sco = Bukkit.getScoreboardManager();
        sb = sco.getMainScoreboard();
        sb.getTeam("O").unregister();
        sb.getTeam("D").unregister();
        sb.getTeam("A").unregister();
        sb.getTeam("M").unregister();
        sb.getTeam("B").unregister();
        sb.getTeam("SU").unregister();
        sb.getTeam("TS").unregister();
        sb.getTeam("YT").unregister();
        sb.getTeam("VIPP").unregister();
        sb.getTeam("PVIP").unregister();
        sb.getTeam("VIP").unregister();
        sb.getTeam("S").unregister();
        O = sb.registerNewTeam("O");
        D = sb.registerNewTeam("D");
        A = sb.registerNewTeam("A");
        M = sb.registerNewTeam("M");
        B = sb.registerNewTeam("B");
        SU = sb.registerNewTeam("SU");
        TS= sb.registerNewTeam("TS");
        YT = sb.registerNewTeam("YT");
        VIPP = sb.registerNewTeam("VIPP");
        PVIP = sb.registerNewTeam("PVIP");
        VIP = sb.registerNewTeam("VIP");
        S = sb.registerNewTeam("S");
		O.setPrefix("§9§lO §7");
		D.setPrefix("§b§lDev §7");
		A.setPrefix("§4§lA §7");
		M.setPrefix("§5§lMod §7");
		B.setPrefix("§d§lB §7");
		SU.setPrefix("§2§lSup §7");
		TS.setPrefix("§a§lT-Sup §7");
		YT.setPrefix("§4§lY§r§lY §7");
		VIPP.setPrefix("§6§lVIP+ §7");
		PVIP.setPrefix("§6§lPVIP §7");
		VIP.setPrefix("§6§lVIP §7");
		S.setPrefix("§7§lS §7");
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		PermissionManager pex = PermissionsEx.getPermissionManager();
		Player p = e.getPlayer();
		p.setScoreboard(sb);
		if (pex.getUser(p).inGroup("Owner")) {
			O.addPlayer(p);
		} else if (pex.getUser(p).inGroup("Developer")) {
			D.addPlayer(p);
		}else if (pex.getUser(p).inGroup("Administrator")) {
			A.addPlayer(p);
		}else if (pex.getUser(p).inGroup("Moderator")) {
			M.addPlayer(p);
		}else if (pex.getUser(p).inGroup("Builder")) {
			B.addPlayer(p);
		}else if (pex.getUser(p).inGroup("Supporter")) {
			SU.addPlayer(p);
		}else if (pex.getUser(p).inGroup("T-Supporter")) {
			TS.addPlayer(p);
		}else if (pex.getUser(p).inGroup("YT")) {
			YT.addPlayer(p);
		}else if (pex.getUser(p).inGroup("VIP+")) {
			VIPP.addPlayer(p);
		}else if (pex.getUser(p).inGroup("PremiumVIP")) {
			PVIP.addPlayer(p);
		}else if (pex.getUser(p).inGroup("VIP")) {
			VIP.addPlayer(p);
		}else {
			S.addPlayer(p);
		}
	}

}
