package com.sekwah.narutomod.abilities.utility;

import com.sekwah.narutomod.abilities.Ability;
import com.sekwah.narutomod.capabilities.INinjaData;
import com.sekwah.narutomod.sounds.NarutoSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

public class DoubleJumpAbility extends Ability {
    @Override
    public ActivationType activationType() {
        return ActivationType.INSTANT;
    }

    @Override
    public boolean logInChat() {
        return false;
    }

    public SoundEvent castingSound() {
        return null;
    }

    @Override
    public boolean handleCost(Player player, INinjaData ninjaData, int chargeAmount) {
        return ninjaData.getDoubleJumpData().canDoubleJumpServer;
    }

    @Override
    public void performServer(Player player, INinjaData ninjaData, int ticksActive) {
        ninjaData.useChakra(2f, 30);
        ninjaData.useStamina(5f, 40);

        if(player.level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.CLOUD,
                    player.getX(),
                    player.getY() + 0.1f,
                    player.getZ(),
                    35,
                    0, 0, 0, 0.6F);
        }
        ninjaData.getDoubleJumpData().canDoubleJumpServer = false;
        player.fallDistance = 0;

        player.getLevel().playSound(null,
                player, NarutoSounds.DOUBLE_JUMP.get(), SoundSource.PLAYERS, 1f, 1.0f);
    }
}
