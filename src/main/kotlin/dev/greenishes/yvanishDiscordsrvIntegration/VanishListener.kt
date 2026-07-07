package dev.greenishes.yvanishDiscordsrvIntegration

import github.scarsz.discordsrv.DiscordSRV
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.plugin.java.JavaPlugin
import pl.ynfuien.yvanish.api.event.VanishToggleEvent


class VanishListener(private val plugin: JavaPlugin) : Listener {
    @EventHandler
    fun onToggle(event: VanishToggleEvent) {
        val player = event.player
        val vanishing = event.vanish
        player.setMetadata("vanished", FixedMetadataValue(plugin, vanishing))
        println("[Yvanish-Discordsrv-Integration] Settubg $player's vanish metadata to $vanishing")
        if (vanishing == false) {
            DiscordSRV.getPlugin().sendJoinMessage(player, "${player.name} joined the server")
        }
        if (vanishing == true) {
            DiscordSRV.getPlugin().sendLeaveMessage(player, "${player.name} left the server")
        }
    }
}