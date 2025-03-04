package com.sekwah.narutomod.capabilities;

import com.sekwah.narutomod.capabilities.toggleabilitydata.ToggleAbilityData;
import com.sekwah.narutomod.config.NarutoConfig;
import com.sekwah.sekclib.capabilitysync.capabilitysync.annotation.Sync;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NinjaData implements INinjaData, ICapabilityProvider {

    @Sync(minTicks = 1)
    private float chakra;

    @Sync(minTicks = 1)
    private float stamina;

    @Sync
    private float maxChakra;

    @Sync
    private float maxStamina;

    /**
     * The current ability being charged/channeled
     */
    @Sync(minTicks = 1)
    private ResourceLocation currentlyChanneled;

    @Sync(minTicks = 1)
    private int ticksChanneled;

    @Sync
    private ToggleAbilityData toggleAbilityData;

    public NinjaData(boolean isServer) {
        if(isServer) {
            this.maxChakra = NarutoConfig.maxChakra;
            this.maxStamina = NarutoConfig.maxStamina;
        }
        this.toggleAbilityData = new ToggleAbilityData();
    }

    class RegenInfo {
        public float regenRate;
        public int cooldown;

        public RegenInfo(float regenRate) {
            this.regenRate = regenRate;
        }

        /**
         * Tick down when checked
         * @return if regen should take place
         */
        public boolean canRegen() {
            if(this.cooldown > 0) {
                this.cooldown--;
                return false;
            }
            return true;
        }
    }

    private RegenInfo chakraRegenInfo = new RegenInfo(0.05f);
    private RegenInfo staminaRegenInfo = new RegenInfo(0.6f);

    private static final String CHAKRA_TAG = "chakra";
    private static final String STAMINA_TAG = "stamina";

    private final LazyOptional<INinjaData> holder = LazyOptional.of(() -> this);

    @Override
    public float getChakra() {
        return this.chakra;
    }

    @Override
    public float getMaxChakra() {
        return this.maxChakra;
    }

    @Override
    public float getStamina() {
        return this.stamina;
    }

    @Override
    public float getMaxStamina() {
        return this.maxStamina;
    }

    @Override
    public void setChakra(float chakra) {
        this.chakra = chakra;
    }

    @Override
    public void setStamina(float stamina) {
        this.stamina = stamina;
    }

    @Override
    public void useChakra(float amount, int cooldown) {
        this.chakra -= amount;
        this.chakraRegenInfo.cooldown = Math.max(cooldown, this.chakraRegenInfo.cooldown);
    }

    @Override
    public void useStamina(float amount, int cooldown) {
        this.stamina -= amount;
        this.staminaRegenInfo.cooldown = Math.max(cooldown, this.staminaRegenInfo.cooldown);
    }

    @Override
    public ResourceLocation currentlyChanneledAbility() {
        return this.currentlyChanneled;
    }

    @Override
    public void setCurrentlyChanneledAbility(ResourceLocation ability) {
        this.currentlyChanneled = ability;
    }

    @Override
    public ToggleAbilityData getToogleAbilityData() {
        return this.toggleAbilityData;
    }

    @Override
    public void updateChakra() {
        if(this.staminaRegenInfo.canRegen()) {
            this.stamina += staminaRegenInfo.regenRate;
        }
        if(this.chakraRegenInfo.canRegen()) {
            this.chakra += chakraRegenInfo.regenRate;
        }
        this.stamina = Math.min(Math.max(this.stamina, 0), maxStamina);
        this.chakra = Math.min(Math.max(this.chakra, 0), maxChakra);
    }

    @Override
    public Tag serializeNBT() {
        final CompoundTag nbt = new CompoundTag();
        nbt.putFloat(CHAKRA_TAG, this.chakra);
        nbt.putFloat(STAMINA_TAG, this.stamina);
        return nbt;
    }

    @Override
    public void deserializeNBT(Tag tag) {
        if(tag instanceof CompoundTag compoundTag) {
            this.chakra = compoundTag.getFloat(CHAKRA_TAG);
            this.stamina = compoundTag.getFloat(STAMINA_TAG);
        }
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return NinjaCapabilityHandler.NINJA_DATA.orEmpty(cap, holder);
    }
}
