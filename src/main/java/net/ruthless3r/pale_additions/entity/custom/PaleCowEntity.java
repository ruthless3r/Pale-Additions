package net.ruthless3r.pale_additions.entity.custom;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.ruthless3r.pale_additions.entity.ModEntities;
import net.ruthless3r.pale_additions.itemlike.ModItems;
import net.ruthless3r.pale_additions.itemlike.PaleBackPort;
import org.jetbrains.annotations.Nullable;

public class PaleCowEntity extends CowEntity {
    private int ticksUntilNectClump;
    private static final int[] maxClumpsGiven = {4, 7, 10};
    private static final TrackedData<Integer> clumpStage =
            DataTracker.registerData(PaleCowEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private boolean clumping;

    public PaleCowEntity(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    public int getClumpStage() {
        return this.dataTracker.get(clumpStage);
    }

    public ItemStack pluckClumps() {
        if (getClumpStage()==0) {return ItemStack.EMPTY;}

        ItemStack clumps = new ItemStack(ModItems.RESIN_NUGGET);
        clumps.setCount(Random.create().nextBetween(2, maxClumpsGiven[getClumpStage()-1]));
        this.dataTracker.set(clumpStage, 0);
        return clumps;
    }

    public void progressClumpStage() {
        int stage = getClumpStage();

        if (stage >= 3) {return;}
        this.dataTracker.set(clumpStage, stage + 1);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(clumpStage, 0);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient() && this.isAlive() && clumping) {
            if (this.dataTracker.get(clumpStage) != 3) {

                if (ticksUntilNectClump <= 0) {
                    progressClumpStage();
                    ticksUntilNectClump = Random.create().nextBetween(2400, 4800);
                }

                ticksUntilNectClump -= 1;

            }
        }
    }

    public static DefaultAttributeContainer.Builder createPaleCowAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        clumping = true;
        ticksUntilNectClump = 2400;
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isOf(PaleBackPort.PALE_MOSS) ? 10.0f : world.getPhototaxisFavor(pos);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isEmpty()) {
            if (this.dataTracker.get(clumpStage) == 0) {return ActionResult.FAIL;}

            ItemStack clumps = pluckClumps();

            player.giveItemStack(clumps);
            this.playSound(SoundEvents.ENTITY_ITEM_PICKUP,1.0f,1.0f);

            return ActionResult.success(this.getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    @Override
    public @Nullable CowEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return ModEntities.PALE_COW.create(serverWorld);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("clumpStage", this.dataTracker.get(clumpStage));
        nbt.putInt("ticksUntilNectClump", this.ticksUntilNectClump);
        nbt.putBoolean("clumping", this.clumping);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(clumpStage, nbt.getInt("clumpStage"));
        ticksUntilNectClump = nbt.getInt("ticksUntilNectClump");
        clumping = nbt.getBoolean("clumping");
    }
}
