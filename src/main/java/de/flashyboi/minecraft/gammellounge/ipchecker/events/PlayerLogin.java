package de.flashyboi.minecraft.gammellounge.ipchecker.events;

import de.flashyboi.minecraft.gammellounge.ipchecker.IPChecker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.logging.Logger;

public class PlayerLogin implements Listener {

    private static final String[] PLAYERS = new String[]
            {"flash_btw", "Dark_Templars", "isa81"};

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent ple) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        Player player = ple.getPlayer();
        LocalDateTime now = LocalDateTime.now();
        InetAddress address = ple.getRealAddress();
        Collection<? extends Player> playerList = Bukkit.getOnlinePlayers();
        int playerCount = playerList.size();
        String time = dtf.format(now);
        Logger log = IPChecker.getLog();

        if(!(player.hasPermission("IPChecker.exclude"))) {
            log.info("Checking player " + player.getName());
            for(int i = 0; i < playerCount; i++) {
                Player p = playerList.iterator().next();
                String mail = player.getName() + " wollte mit der selben IP wie " + p.getName() + " joinen. (" + time + ")";
                InetAddress address1 = p.getAddress().getAddress();
                if (address.toString().equalsIgnoreCase(address1.toString())) {
                    for (String s : PLAYERS) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mail send " + s + " " + mail);
                    }
                }
            }
        }
    }
}
