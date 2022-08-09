package mod.acgaming.tconfixes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = TConFixes.MODID,
    name = TConFixes.NAME,
    version = TConFixes.VERSION,
    acceptedMinecraftVersions = "[1.12.2]",
    dependencies = "required-after:mixinbooter;required-after:tconstruct")
public class TConFixes
{
    public static final String MODID = "tconfixes";
    public static final String NAME = "TConFixes";
    public static final String VERSION = "1.12.2-1.0.2";
    public static final Logger LOGGER = LogManager.getLogger();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LOGGER.info("TConFixes initialized");
    }
}