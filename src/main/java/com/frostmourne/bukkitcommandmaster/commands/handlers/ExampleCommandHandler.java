package com.frostmourne.bukkitcommandmaster.commands.handlers;

import com.frostmourne.bukkitcommandmaster.commands.wrappers.CommandExecuteInfo;
import com.frostmourne.bukkitcommandmaster.commands.annotations.CommandRegister;
import com.frostmourne.bukkitcommandmaster.commands.interfaces.AbstractCommandHandler;

import java.util.Collections;
import java.util.List;

// 注册主命令
@CommandRegister(name = "examplecommand",aliases = {"ecommand"},permission = "server.admin",desc = "main command",usage = "/@command",level = 0)
public class ExampleCommandHandler extends AbstractCommandHandler {

    // 注册主命令的子指令hello
    @CommandRegister(name = "hello",aliases = {"h"},permission = "server.admin",desc = "send hello world!",usage = "/@parent-command @command")
    public void hello(CommandExecuteInfo info){
        info.getSender()
                .sendMessage("Hello World!");
    }

    // 注册Hello的子指令2
    @CommandRegister(name = "2",permission = "server.admin",desc = "send hello 2!",usage = "/@main-command @parent-command @command",level = 2,parentName = "hello")
    public void hello2(CommandExecuteInfo info){
        info.getSender()
                .sendMessage("Hello 2!");
    }
    // 注册Hello的子指令3
    @CommandRegister(name = "3",permission = "server.admin",desc = "send hello 3!",usage = "/@main-command @parent-command @command",level = 2,parentName = "hello")
    public void hello3(CommandExecuteInfo info){
        info.getSender()
                .sendMessage("Hello 3!");
    }

    // 注册主命令的子指令world
    @CommandRegister(name = "world",aliases = {"w"},permission = "server.admin",desc = "send world!",usage = "/@parent-command @command")
    public void world(CommandExecuteInfo info){
        info.getSender()
                .sendMessage("World!");
    }

    // 注册world的子指令2
    @CommandRegister(name = "4",permission = "server.admin",desc = "send world 2!",usage = "/@main-command @parent-command @command",level = 2,parentName = "world")
    public void world2(CommandExecuteInfo info){
        info.getSender()
                .sendMessage("world 4!");
    }
    // 注册world的子指令3
    @CommandRegister(name = "5",permission = "server.admin",desc = "send world 3!",usage = "/@main-command @parent-command @command",level = 2,parentName = "world",tabExecuteMethod = "world5Tab")
    public void world5(CommandExecuteInfo info){
        info.getSender()
                .sendMessage("world 5!");
    }
    // world 5 的 Tab 表
    public List<String> world5Tab(CommandExecuteInfo info){
        return Collections.singletonList("你冲Qb马？");
    }

}
