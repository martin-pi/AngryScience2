package com.pharaoh439.angrysciencemod.init;

import com.google.common.eventbus.Subscribe;
import com.pharaoh439.angrysciencemod.AngryScienceMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AngryScienceMod.MOD_ID)
@Mod.EventBusSubscriber(modid= AngryScienceMod.MOD_ID, bus = Bus.MOD)
public class BlockInit {

    public static final Block example_block = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0f).sound(SoundType.STONE)).setRegistryName("example_block"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(example_block, new Item.Properties().group(ItemGroup.MISC).maxStackSize(32)).setRegistryName("example_block"));
    }
}
