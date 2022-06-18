package marumasa.set_name;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class minecraft extends JavaPlugin {

    private final Config config;

    public minecraft() {
        config = new Config(this);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equals("setname")) {
            Player player = (Player) sender;
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            if (meta == null) {
                sender.sendMessage(config.lore_NoItemText);
                return false;
            }
            String name;
            if (args.length == 0) {
                name = "";
            } else {
                name = args[0].replace("&", "§");
            }
            meta.setDisplayName(name);
            item.setItemMeta(meta);
            sender.sendMessage(config.lore_ResultText);
            return true;
        }
        if (cmd.getName().equals("setlore")) {
            Player player = (Player) sender;
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            if (meta == null) {
                sender.sendMessage(config.lore_NoItemText);
                return false;
            }
            List<String> lore = new ArrayList<String>();
            for (String text : args) {
                lore.add(text.replace("&", "§"));
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            sender.sendMessage(config.lore_ResultText);
            return true;
        }
        return false;
    }
}