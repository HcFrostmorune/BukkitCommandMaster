package com.frostmourne.bukkitcommandmaster.commands.handlers;

import com.frostmourne.bukkitcommandmaster.commands.annotations.CommandRegister;
import com.frostmourne.bukkitcommandmaster.commands.interfaces.AbstractCommandHandler;
import com.frostmourne.bukkitcommandmaster.commands.wrappers.CommandExecuteInfo;

public class ExampleExtensionCommandHandler extends AbstractCommandHandler {


    // 注册主命令的子指令extension
    @CommandRegister(name = "extension",aliases = {"e"},permission = "server.admin",desc = "send extension!",usage = "/@parent-command @command")
    public void extension(CommandExecuteInfo info){
        info.getSender()
                .sendMessage("Extension!");
    }

    // 注册world的子指令3
    @CommandRegister(name = "apex",permission = "server.admin",desc = "send extension apex!",usage = "/@main-command @parent-command @command",level = 2,parentName = "extension")
    public void extensionApex(CommandExecuteInfo info){
        info.getSender()
                .sendMessage("extension Apex!");
    }
}
