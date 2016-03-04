// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Item

public class BlockClay extends Block
{
	
	private int groundTex;

    public BlockClay(int i, int j)
    {
        super(i, j, Material.clay);
    }

    public int idDropped(int i, Random random)
    {
        return Item.clay.shiftedIndex;
    }

    public void texInit(int ground){
    	groundTex = ground;
    }
    
    public int quantityDropped(Random random)
    {
        return 4;
    }
    
    @Override
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if (j == 1){
        	return groundTex;
        }
        return blockIndexInTexture;
    }
}
