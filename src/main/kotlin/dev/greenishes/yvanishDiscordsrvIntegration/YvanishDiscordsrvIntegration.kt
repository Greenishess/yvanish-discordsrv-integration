package dev.greenishes.yvanishDiscordsrvIntegration

import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.plugin.java.JavaPlugin
import pl.ynfuien.yvanish.api.YVanishAPI

class YvanishDiscordsrvIntegration : JavaPlugin() {

    override fun onEnable() {
        logger.info("Enabling YvanishDiscordsrvIntegration plugin")
        server.pluginManager.registerEvents(VanishListener(this), this)
        server.pluginManager.registerEvents(LeaveListener(this), this)
    }

    override fun onDisable() {
        logger.info("Disabling YvanishDiscordsrvIntegration plugin")
    }
}
