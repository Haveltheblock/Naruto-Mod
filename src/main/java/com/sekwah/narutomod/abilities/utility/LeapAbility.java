package com.sekwah.narutomod.abilities.utility;

import com.sekwah.narutomod.abilities.Ability;
import com.sekwah.narutomod.capabilities.INinjaData;
import com.sekwah.narutomod.sounds.NarutoSounds;
import com.sekwah.sekclib.player.PlayerUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class LeapAbility extends Ability {
    @Override
    public ActivationType activationType() {
        return ActivationType.INSTANT;
    }

    @Override
    public boolean handleCost(Player player, INinjaData ninjaData, int chargeAmount) {
        if(!player.isOnGround()) {
            player.displayClientMessage(new TranslatableComponent("jutsu.fail.notonground", new TranslatableComponent("jutsu.leap").withStyle(ChatFormatting.YELLOW)), true);
            return false;
        }
        if(ninjaData.getStamina() < 10) {
            player.displayClientMessage(new TranslatableComponent("jutsu.fail.notenoughstamina", new TranslatableComponent("jutsu.leap").withStyle(ChatFormatting.YELLOW)), true);
            return false;
        }
        ninjaData.useStamina(10, 40);
        return true;
    }

    @Override
    public void perform(Player player, INinjaData ninjaData, int chargeAmount) {
        Vec3 lookVector = player.getLookAngle();
        float horScale = 2.0f;
        PlayerUtil.setVelocity(player, lookVector.x * horScale, (lookVector.y + 0.8F)
                , lookVector.z * horScale, true);
        player.getCommandSenderWorld().playSound(null,
                player.getX(), player.getY(), player.getZ(),
                NarutoSounds.LEAP.get(), SoundSource.PLAYERS, 0.5f, 1.0f);
    }
}
