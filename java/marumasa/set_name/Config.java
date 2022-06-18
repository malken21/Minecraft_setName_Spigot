package marumasa.set_name;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public final String name_NoItemText;
    public final String name_ResultText;
    public final String lore_NoItemText;
    public final String lore_ResultText;

    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        name_NoItemText = config.getString("setname.NoItemText");
        name_ResultText = config.getString("setname.ResultText");

        lore_NoItemText = config.getString("setlore.NoItemText");
        lore_ResultText = config.getString("setlore.ResultText");
    }
}