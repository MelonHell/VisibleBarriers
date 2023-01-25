package amymialee.visiblebarriers.mixin.entities;

import amymialee.visiblebarriers.VisibleBarriers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
//    @Inject(method = "isInvisibleTo", at = @At("HEAD"), cancellable = true)
//    public void isInvisibleTo(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
//        if (VisibleBarriers.isVisible()) cir.setReturnValue(false);
//    }

    @Inject(method = "isInvisible", at = @At("HEAD"), cancellable = true)
    public void isInvisible(CallbackInfoReturnable<Boolean> cir) {
        if (VisibleBarriers.isVisible()) cir.setReturnValue(false);
    }
}
