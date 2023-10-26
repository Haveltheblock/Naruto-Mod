package com.sekwah.narutomod.abilities.jutsus;

import com.sekwah.narutomod.abilities.Ability;
import com.sekwah.narutomod.capabilities.INinjaData;
import com.sekwah.narutomod.entity.jutsuprojectile.FireballJutsuEntity;
import com.sekwah.narutomod.entity.jutsuprojectile.WaterSharkBombEntity;
import com.sekwah.narutomod.sounds.NarutoSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

/**
 * More of a slight speed boost than an actual dash
 */
public class WaterSharkBomb extends Ability implements Ability.Cooldown {

    @Override
    public ActivationType activationType() {
        return ActivationType.INSTANT;
    }

    @Override
    public long defaultCombo() {
        return 2223;
    }

    @Override
    public boolean handleCost(Player player, INinjaData ninjaData, int chargeAmount) {
        if(ninjaData.getChakra() < 30) {
            player.displayClientMessage(Component.translatable("jutsu.fail.notenoughchakra", Component.translatable(this.getTranslationKey(ninjaData)).withStyle(ChatFormatting.YELLOW)), true);
            return false;
        }
        ninjaData.useChakra(30, 30);
        return true;
    }

    @Override
    public void performServer(Player player, INinjaData ninjaData, int ticksActive) {
        ninjaData.scheduleDelayedTickEvent((delayedPlayer) -> {
            Vec3 shootSpeed = player.getLookAngle();
            var fireball = new WaterSharkBombEntity(player, shootSpeed.x, shootSpeed.y, shootSpeed.z);
            player.level().addFreshEntity(fireball);
            player.level().playSound(null, player, NarutoSounds.FIREBALL_SHOOT.get(), SoundSource.PLAYERS, 1f, 1.0f);

             shootSpeed = player.getLookAngle();
             shootSpeed=shootSpeed.yRot((float) Math.toRadians(45));
             fireball = new WaterSharkBombEntity(player, shootSpeed.x, shootSpeed.y, shootSpeed.z);
            player.level().addFreshEntity(fireball);
            player.level().playSound(null, player, NarutoSounds.FIREBALL_SHOOT.get(), SoundSource.PLAYERS, 1f, 1.0f);

             shootSpeed = player.getLookAngle();
            shootSpeed=shootSpeed.yRot((float) Math.toRadians(-45));
             fireball = new WaterSharkBombEntity(player, shootSpeed.x, shootSpeed.y, shootSpeed.z);
            player.level().addFreshEntity(fireball);
            player.level().playSound(null, player, NarutoSounds.FIREBALL_SHOOT.get(), SoundSource.PLAYERS, 1f, 1.0f);
        }, 10);
    }

    @Override
    public int getCooldown() {
        return 3 * 20;
    }
}
