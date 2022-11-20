package addjump.addjump;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public final class AddJump extends JavaPlugin {
    public static JavaPlugin plugin;
    private AddJump listeners;

    public static Scoreboard board;
    ScoreboardManager sbManager;

    public static Objective mainObject;
    public static Score ascore;
    public static Score bscore;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new EventListner(),this);

        sbManager = Bukkit.getScoreboardManager();
        board = sbManager.getMainScoreboard();

        mainObject = board.registerNewObjective("mainBoard","dummy", "ジャンプ力");
        ascore = mainObject.getScore(ChatColor.AQUA + "あか：");
        ascore.setScore(EventListner.ajump);
        bscore = mainObject.getScore(ChatColor.AQUA + "あお：");
        bscore.setScore(EventListner.bjump);
        mainObject.setDisplaySlot(DisplaySlot.SIDEBAR);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        mainObject.getScoreboard().resetScores(ChatColor.AQUA + "あか：");
        mainObject.unregister();
    }

    public static JavaPlugin getPlugin(){return plugin;}
}
