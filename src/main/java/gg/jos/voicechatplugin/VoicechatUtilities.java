package gg.jos.voicechatplugin;

import de.maxhenkel.voicechat.api.BukkitVoicechatService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;

public final class VoicechatUtilities extends JavaPlugin {

    public static final String PLUGIN_ID = "VoicechatUtilities";
    public static final Logger LOGGER = LogManager.getLogger(PLUGIN_ID);

    @Nullable
    private VoicechatUtilitiesPlugin voicechatPlugin;

    @Override
    public void onEnable() {
        BukkitVoicechatService service = getServer().getServicesManager().load(BukkitVoicechatService.class);
        if (service != null) {
            voicechatPlugin = new VoicechatUtilitiesPlugin();
            service.registerPlugin(voicechatPlugin);
            LOGGER.info("Successfully registered 4Year SMP Voice Chat Utilities");
        } else {
            LOGGER.info("Failed to register 4Year SMP Voice Chat Utilities");
        }
    }

    @Override
    public void onDisable() {
        if (voicechatPlugin != null) {
            getServer().getServicesManager().unregister(voicechatPlugin);
            LOGGER.info("Successfully unregistered 4Year SMP Voice Chat Utilities");
        }
    }
}
