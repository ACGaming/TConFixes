package mod.acgaming.tconfixes.mixin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slimeknights.tconstruct.tools.melee.item.LongSword;
import slimeknights.tconstruct.tools.ranged.TinkerRangedWeapons;

@Mixin(LongSword.class)
public class LongSwordMixin
{
    @Inject(method = "onItemRightClick", at = @At(value = "HEAD"), cancellable = true)
    public void tconFixLongSwordOffhand(World worldIn, EntityPlayer playerIn, EnumHand hand, CallbackInfoReturnable<ActionResult<ItemStack>> cir)
    {
        if (!playerIn.getHeldItemOffhand().isEmpty() && (playerIn.getHeldItemOffhand().getItem() == TinkerRangedWeapons.shuriken))
        {
            cir.setReturnValue(ActionResult.newResult(EnumActionResult.PASS, playerIn.getHeldItem(hand)));
        }
    }
}