package dam.library.mollineare;

import com.mojang.logging.LogUtils;
import dam.library.mollineare.blocks.MaterialBlocks;
import dam.library.mollineare.blocks.OreBlocks;
import dam.library.mollineare.items.IngotItems;
import dam.library.mollineare.items.RawItems;
import dam.library.mollineare.tabs.MollineareOresTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MollineareLibrary.MODID)
public class MollineareLibrary
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "mollinearelibrary";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public MollineareLibrary()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MollineareOresTab.register(modEventBus);
        RawItems.register(modEventBus);
        IngotItems.register(modEventBus);
        MaterialBlocks.register(modEventBus);
        OreBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(RawItems.RAW_TIN);
            event.accept(RawItems.RAW_ZINC);
            event.accept(RawItems.RAW_COBALT);
            event.accept(RawItems.RAW_ALUMINUM);
            event.accept(RawItems.RAW_TITANIUM);
            event.accept(RawItems.RAW_CHROMIUM);
            event.accept(IngotItems.TIN_INGOT);
            event.accept(IngotItems.ZINC_INGOT);
            event.accept(IngotItems.COBALT_INGOT);
            event.accept(IngotItems.ALUMINUM_INGOT);
            event.accept(IngotItems.TITANIUM_INGOT);
            event.accept(IngotItems.CHROMIUM_INGOT);
            event.accept(MaterialBlocks.TIN_BLOCK);
            event.accept(MaterialBlocks.ZINC_BLOCK);
            event.accept(MaterialBlocks.CHROMIUM_BLOCK);
            event.accept(MaterialBlocks.COBALT_BLOCK);
            event.accept(MaterialBlocks.ALUMINUM_BLOCK);
            event.accept(MaterialBlocks.TITANIUM_BLOCK);
            event.accept(OreBlocks.TIN_ORE);
            event.accept(OreBlocks.ZINC_ORE);
            event.accept(OreBlocks.CHROMIUM_ORE);
            event.accept(OreBlocks.COBALT_ORE);
            event.accept(OreBlocks.ALUMINUM_ORE);
            event.accept(OreBlocks.TITANIUM_ORE);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {

    }
}
