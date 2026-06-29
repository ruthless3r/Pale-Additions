package net.ruthless3r.pale_additions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.ruthless3r.pale_additions.entity.ModEntities;
import net.ruthless3r.pale_additions.entity.custom.PaleCowEntity;
import net.ruthless3r.pale_additions.itemlike.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CowEntity.class)
public abstract class CowEntityMixin extends AnimalEntity {

    protected CowEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow
    protected abstract void playStepSound(BlockPos pos, BlockState state);

    @Inject(method="interactMob",at=@At("HEAD"),cancellable = true)
    public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        CowEntity cow = (CowEntity)(Object)this;
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.isOf(ModItems.PALE_APPLE)) {
            ItemStack remaining = itemStack.copy();
            remaining.decrement(1);

            player.setStackInHand(hand, remaining);

            cow.playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0f, 1.0f);

            if (!cow.getWorld().isClient) {
                PaleCowEntity paleCowEntity = ModEntities.PALE_COW.create(cow.getWorld());
                if (paleCowEntity != null) {
                    ((ServerWorld)cow.getWorld()).spawnParticles(ParticleTypes.ASH,cow.getX(),cow.getBodyY(0.5),cow.getZ(),15,0.0f,0.0f,0.0f,0.3);
                    cow.discard();
                    paleCowEntity.refreshPositionAndAngles(cow.getX(), cow.getY(), cow.getZ(), cow.getYaw(), cow.getPitch());
                    paleCowEntity.setHealth(cow.getHealth());
                    paleCowEntity.bodyYaw = cow.getYaw();
                    if (cow.hasCustomName()) {
                        paleCowEntity.setCustomName(cow.getCustomName());
                        paleCowEntity.setCustomNameVisible(cow.isCustomNameVisible());
                    }

                    if (cow.isPersistent()) {
                        paleCowEntity.setPersistent();
                    }

                    paleCowEntity.setInvulnerable(cow.isInvulnerable());
                    cow.getWorld().spawnEntity(paleCowEntity);

                }
            cir.setReturnValue(ActionResult.SUCCESS);
            }
        }
    }
}
