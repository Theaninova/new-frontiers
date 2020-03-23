package de.wulkanat.www.new_frontiers.abstract_helpers

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.server.MinecraftServer
import net.minecraft.util.text.ITextComponent
import java.awt.Color

abstract class NFCommand(
    name: String,
    usage: String,
    val action: (ExecuteParams) -> Unit,
    val hasPermission: (HasPermissionParams) -> Boolean = { true },
    requiredPermissionLevel: Int = 0
) : CommandBase() {
    private val commandName = name
    private val commandUsage = "/$name $usage"
    private val permissionLevel = requiredPermissionLevel

    override fun getName(): String {
        return commandName
    }

    override fun getRequiredPermissionLevel(): Int {
        return permissionLevel
    }

    override fun execute(server: MinecraftServer, sender: ICommandSender, command: Array<String>) {
        action(ExecuteParams(server, sender, command))
    }

    override fun getUsage(p0: ICommandSender): String {
        return commandUsage
    }

    override fun checkPermission(server: MinecraftServer, sender: ICommandSender): Boolean {
        return hasPermission(HasPermissionParams(server, sender))
    }

    class ExecuteParams(
        val server: MinecraftServer,
        val sender: ICommandSender,
        val command: Array<String>
    )

    class HasPermissionParams(
        val server: MinecraftServer,
        val sender: ICommandSender
    )

    companion object {
        fun textLine(text: String, color: String = "white"): ITextComponent {
            return ITextComponent.Serializer.jsonToComponent("[{\"text\": \"$text\",\"color\":\"$color\"}]") as ITextComponent
        }
    }
}
