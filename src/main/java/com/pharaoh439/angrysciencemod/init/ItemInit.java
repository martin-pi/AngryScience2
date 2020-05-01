package com.pharaoh439.angrysciencemod.init;

import com.pharaoh439.angrysciencemod.AngryScienceMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= AngryScienceMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(AngryScienceMod.MOD_ID)
public class ItemInit {

    public static Item example_item;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        // Register a new item called Example Item to the MISC creative mode tab.
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("example_item"));
    }
}
