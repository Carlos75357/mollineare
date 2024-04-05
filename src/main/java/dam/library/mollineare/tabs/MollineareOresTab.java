package dam.library.mollineare.tabs;

import dam.library.mollineare.MollineareLibrary;
import dam.library.mollineare.blocks.MaterialBlocks;
import dam.library.mollineare.blocks.OreBlocks;
import dam.library.mollineare.items.IngotItems;
import dam.library.mollineare.items.RawItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MollineareOresTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MollineareLibrary.MODID);

    public static final RegistryObject<CreativeModeTab> MOLLINEARE_ORES_TAB = CREATIVE_MODE_TABS.register("mollineare_ores_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(RawItems.RAW_TIN.get()))
                    .title(Component.translatable("creativetab.mollineare_ores_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        for(RegistryObject<Item> item : RawItems.ITEMS.getEntries()) {
                            pOutput.accept(item.get());
                        }
                        for (RegistryObject<Item> item : IngotItems.ITEMS.getEntries()) {
                            pOutput.accept(item.get());
                        }
                        for (RegistryObject<Block> block : MaterialBlocks.BLOCKS.getEntries()) {
                            pOutput.accept(block.get());
                        }
                        for (RegistryObject<Block> block : OreBlocks.ORES.getEntries()) {
                            pOutput.accept(block.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
