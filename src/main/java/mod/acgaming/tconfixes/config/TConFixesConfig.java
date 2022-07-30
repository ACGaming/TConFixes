package mod.acgaming.tconfixes.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import mod.acgaming.tconfixes.TConFixes;

@Config(modid = TConFixes.MODID, name = "TConFixes")
public class TConFixesConfig
{
    @Config.Name("Projectile Lifetime")
    @Config.Comment("How many ticks projectiles are allowed on the ground until they despawn.")
    @Config.RangeInt(max = 1199)
    public static int despawnProjectile = 40;

    @Mod.EventBusSubscriber(modid = TConFixes.MODID)
    public static class EventHandler
    {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if (event.getModID().equals(TConFixes.MODID))
            {
                ConfigManager.sync(TConFixes.MODID, Config.Type.INSTANCE);
            }
        }
    }
}