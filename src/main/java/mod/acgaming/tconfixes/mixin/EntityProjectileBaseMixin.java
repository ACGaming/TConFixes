package mod.acgaming.tconfixes.mixin;

import javax.annotation.Nonnull;

import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import mod.acgaming.tconfixes.config.TConFixesConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import slimeknights.tconstruct.library.capability.projectile.TinkerProjectileHandler;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.tools.modifiers.ModReinforced;

@Mixin(EntityProjectileBase.class)
public abstract class EntityProjectileBaseMixin extends EntityArrow
{
    @Shadow
    public TinkerProjectileHandler tinkerProjectile;

    public EntityProjectileBaseMixin(World worldIn)
    {
        super(worldIn);
    }

    @Inject(method = "onUpdate", at = @At(value = "HEAD"))
    public void tconFixProjectileLifetime(CallbackInfo ci)
    {
        if (!this.getEntityWorld().isRemote
            && this.inGround
            && this.arrowShake <= 0
            && TagUtil.getTagSafe(this.tinkerProjectile.getItemStack()).getBoolean(ModReinforced.TAG_UNBREAKABLE)
            && this.ticksExisted >= TConFixesConfig.despawnProjectile)
        {
            this.setDead();
        }
    }

    @Shadow
    @Nonnull
    protected abstract ItemStack getArrowStack();
}