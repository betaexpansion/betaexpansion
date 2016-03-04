// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockStone extends Block
{

    public BlockStone(int i, int j)
    {
        super(i, j, Material.rock);
        maxID = 103;
    }

    public int idDropped(int i, Random random)
    {
        return Block.cobblestone.blockID;
    }
    
    public static void texInit(){
    	orangeTexture = 16;
    	redTexture = orangeTexture + 1;
    	purpleTexture = orangeTexture + 2;
    	blueTexture = orangeTexture + 3;
    	greenTexture = orangeTexture + 4;
    	whiteTexture = orangeTexture + 5;
    	blackTexture = orangeTexture + 6;
    	
    	variantTexture = 23 + 256;
    }
    
    public boolean chiselBlock(int x, int y, int z, World world, int meta){
		if (this.blockID != Block.stone.blockID){
			return false;
		}
    	int newID = BEBlocks.stoneBricks.blockID;
		if (newID > maxID){
			if (Config.HARD_CHISEL){
				world.setBlockAndMetadataWithNotify(x, y, z, 0, 0);
			}
			return false;
		}
		world.setBlockAndMetadataWithNotify(x, y, z, newID, meta);
		return true;
	}
    
    @Override
    protected int damageDropped(int i)
    {
        if (i == 8){
        	return 0;
        }
    	return i;
    }
    
    @Override
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        switch (j){
        case 1:
        	return orangeTexture;
        case 2:
        	return redTexture;
        case 3:
        	return purpleTexture;
        case 4:
        	return blueTexture;
        case 5:
        	return greenTexture;
        case 6:
        	return whiteTexture;
        case 7:
        	return blackTexture;
        case 8:
        	return variantTexture;
        default:
        	return this.blockIndexInTexture;
        }
    }
    
    private static int orangeTexture;
    private static int redTexture;
    private static int purpleTexture;
    private static int blueTexture;
    private static int greenTexture;
    private static int whiteTexture;
    private static int blackTexture;
    
    private static int variantTexture;
    
    private int maxID;
}
