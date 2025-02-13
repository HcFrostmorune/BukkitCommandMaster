package com.frostmourne.bukkitcommandmaster;

import com.frostmourne.bukkitcommandmaster.commands.handlers.ExampleCommandHandler;
import com.frostmourne.bukkitcommandmaster.commands.handlers.ExampleExtensionCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitCommandMaster extends JavaPlugin {

    @Override
    public void onEnable() {
        // 实例化主指令集
        new ExampleCommandHandler()
                // 添加拓展子指令集
                .addSubCommand(new ExampleExtensionCommandHandler())
                // 注册
                .register(this);
    }
}
