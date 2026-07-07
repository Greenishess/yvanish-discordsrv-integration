package dev.greenishes.yvanishDiscordsrvIntegration

import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class LeaveListener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onLeave(event: PlayerQuitEvent) {
        //reset the vanish state or else they'll join unvanished with the join message not being sent
        val player = event.player
        player.setMetadata("vanished", FixedMetadataValue(plugin, false))
    }
}