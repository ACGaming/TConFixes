package mod.acgaming.tconfixes.mixin;

import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

import mod.acgaming.tconfixes.config.TConFixesConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;

@Mixin(EntityProjectileBase.class)
public abstract class EntityProjectileBaseMixin extends EntityArrow
{
    public EntityProjectileBaseMixin(World worldIn)
    {
        super(worldIn);
    }

    @Inject(method = "onUpdate", at = @At(value = "HEAD"))
    public void tconFixProjectileLifetime(CallbackInfo ci)
    {
        if (this.inGround && this.ticksExisted >= TConFixesConfig.despawnProjectile)
        {
            this.setDead();
        }
    }
}