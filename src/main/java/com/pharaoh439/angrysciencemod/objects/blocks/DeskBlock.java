package com.pharaoh439.angrysciencemod.objects.blocks;

import com.pharaoh439.angrysciencemod.init.TileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import java.util.Properties;

public class DeskBlock extends Block {
    public DeskBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypes.DESK.get().create();
    }
}
