package mod.acgaming.tconfixes.mixin;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

import mod.acgaming.tconfixes.config.TConFixesConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;

@Mixin(EntityProjectileBase.class)
public abstract class EntityProjectileBaseMixin extends EntityArrow implements IEntityAdditionalSpawnData
{
    private int ticksInGround;

    public EntityProjectileBaseMixin(World worldIn)
    {
        super(worldIn);
    }

    @Inject(method = "updateInGround", at = @At(value = "RETURN"), remap = false)
    public void tconFixProjectileLifetime(IBlockState state, CallbackInfo ci)
    {
        if (this.ticksInGround >= TConFixesConfig.despawnProjectile)
        {
            this.setDead();
        }
    }
}