/*package com.mv.creatures.server;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TranslationTextComponent;

public class MVCommand {
    public static final SimpleCommandExceptionType NOT_IN_MV = new SimpleCommandExceptionType(new TranslationTextComponent("commands.mvfeatures.not_in_mv_world"));

    public static void register(CommandDispatcher<CommandSource> dispatcher){
        LiteralArgumentBuilder<CommandSource> builder = Commands.literal("mvcreatures")
                .then(CenterCommand.register())
                .then(ConquerCommand.register())
                .then(InfoCommand.register())
                .then(ShieldCommand.register());
        LiteralCommandNode<CommandSource> node = dispatcher.register(builder);
        dispatcher.register(Commands.literal("mv").redirect(node));
        dispatcher.register(Commands.literal("mvfeature").redirect(node));

        dispatcher.register(MapBiomesCommand.register());
    }
}
*/