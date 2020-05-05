package com.pharaoh439.angrysciencemod.entities;

import com.pharaoh439.angrysciencemod.init.TileEntityTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class DeskTileEntity extends TileEntity {

    public int x, y, z, tick;
    boolean initialized = false;

    public DeskTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public DeskTileEntity() {
        this(TileEntityTypes.DESK.get());
    }
}
