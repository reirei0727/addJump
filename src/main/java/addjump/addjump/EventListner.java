package addjump.addjump;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventListner implements Listener {

    public static int ajump = 0;
    public static int bjump = 0;

    @EventHandler
    public void onJump(PlayerJumpEvent e){
        Player p = e.getPlayer();
        if(p.getName().equals("az_aka")){
            ajump +=1;
            AddJump.ascore.setScore(ajump);
        }
        if (p.getName().equals("az__ao")){
            bjump +=1;
            AddJump.bscore.setScore(bjump);
        }


    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (p.getName().equals("az_aka")){
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,10000,ajump,false,false));
        }
        if(p.getName().equals("az__ao")){
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,10000,bjump,false,false));
        }

    }
}
