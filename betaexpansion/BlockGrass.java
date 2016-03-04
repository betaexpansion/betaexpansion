// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class BlockGrass extends Block
{

    protected BlockGrass(int i)
    {
        super(i, Material.grassMaterial);
        blockIndexInTexture = Util.normalizeTexture(3);
        setTickOnLoad(true);
    }

    @Override
    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
    	int meta = iblockaccess.getBlockMetadata(i, j, k);
    	
    	if(l == 0)
        {
    		switch (meta){
        	case 1:
        		return sandTexBottom;
        	case 2:
        		return coolTexBottom;
        	case 3:
        		return warmTexBottom;
        	default:
        		return 2;
        	}
        }
        if(l == 1)
        {
            return 0;
        }
        
        Material material = iblockaccess.getBlockMaterial(i, j + 1, k);
        if (material.equals(Material.snow)){
        	switch (meta){
        	case 1:
        		return sandTexSnow;
        	case 2:
        		return coolTexSnow;
        	case 3:
        		return warmTexSnow;
        	default:
        		return Util.normalizeTexture(68);
        	}
        }

        switch (meta){
        case 1:
    		return sandTex;
    	case 2:
    		return coolTex;
    	case 3:
    		return warmTex;
    	default:
    		return this.blockIndexInTexture;
    	}
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        iblockaccess.getWorldChunkManager().func_4069_a(i, k, 1, 1);
        double d = iblockaccess.getWorldChunkManager().temperature[0];
        double d1 = iblockaccess.getWorldChunkManager().humidity[0];
        return ColorizerGrass.getGrassColor(d, d1);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
        if(world.getBlockLightValue(i, j + 1, k) < 4 && Block.lightOpacity[world.getBlockId(i, j + 1, k)] > 2)
        {
            if(random.nextInt(4) != 0)
            {
                return;
            }
            world.setBlockAndMetadataWithNotify(i, j, k, Block.dirt.blockID, world.getBlockMetadata(i, j, k));
        } else
        if(world.getBlockLightValue(i, j + 1, k) >= 9)
        {
            int l = (i + random.nextInt(3)) - 1;
            int i1 = (j + random.nextInt(5)) - 3;
            int j1 = (k + random.nextInt(3)) - 1;
            int k1 = world.getBlockId(l, i1 + 1, j1);
            if(world.getBlockId(l, i1, j1) == Block.dirt.blockID && world.getBlockLightValue(l, i1 + 1, j1) >= 4 && Block.lightOpacity[k1] <= 2)
            {
                world.setBlockAndMetadataWithNotify(l, i1, j1, Block.grass.blockID, world.getBlockMetadata(l, i1, j1));
            }
        }
        
        if (SeasonManager.season == 0){
        	if (world.getBlockId(i, j + 1, k) == 0){
	        	if (random.nextInt(2000) == 0){
	        		world.setBlockAndMetadataWithNotify(i, j + 1, k, BEBlocks.wildGrass.blockID, random.nextInt(4));
	        	}
	        	if (random.nextInt(8000) == 0){
	        		world.setBlockAndMetadataWithNotify(i, j + 1, k, Block.plantRed.blockID, 0);
	        	}
	        	if (random.nextInt(8000) == 0){
	        		world.setBlockAndMetadataWithNotify(i, j + 1, k, Block.plantYellow.blockID, 0);
	        	}
	        	if (random.nextInt(1000) == 0){
		        	if (world.getBlockId(i + 1, j, k) == Block.waterStill.blockID){
		        		if (world.isBlockNormalCube(i + 1, j - 1, k)){
		        			if (world.getBlockId(i + 1, j + 1, k) == 0){
		        				world.setBlockWithNotify(i + 1, j + 1, k, BEBlocks.rushes.blockID);
		        			}
		        		}
		        	}
		        	if (world.getBlockId(i - 1, j, k) == Block.waterStill.blockID){
		        		if (world.isBlockNormalCube(i - 1, j - 1, k)){
		        			if (world.getBlockId(i - 1, j + 1, k) == 0){
		        				world.setBlockWithNotify(i - 1, j + 1, k, BEBlocks.rushes.blockID);
		        			}
		        		}
		        	}
		        	if (world.getBlockId(i, j, k + 1) == Block.waterStill.blockID){
		        		if (world.isBlockNormalCube(i, j - 1, k + 1)){
		        			if (world.getBlockId(i, j + 1, k + 1) == 0){
		        				world.setBlockWithNotify(i, j + 1, k + 1, BEBlocks.rushes.blockID);
		        			}
		        		}
		        	}
		        	if (world.getBlockId(i, j, k - 1) == Block.waterStill.blockID){
		        		if (world.isBlockNormalCube(i, j - 1, k - 1)){
		        			if (world.getBlockId(i, j + 1, k - 1) == 0){
		        				world.setBlockWithNotify(i, j + 1, k - 1, BEBlocks.rushes.blockID);
		        			}
		        		}
		        	}
	        	}
	        	if (random.nextInt(2000) == 0){
		        	if (world.getBlockId(i + 1, j, k) == Block.waterStill.blockID){
		        		if (world.isBlockNormalCube(i + 1, j - 1, k)){
		        			if (world.getBlockId(i + 1, j + 1, k) == 0){
		        				world.setBlockWithNotify(i + 1, j + 1, k, Block.reed.blockID);
		        			}
		        		}
		        	}
		        	if (world.getBlockId(i - 1, j, k) == Block.waterStill.blockID){
		        		if (world.isBlockNormalCube(i - 1, j - 1, k)){
		        			if (world.getBlockId(i - 1, j + 1, k) == 0){
		        				world.setBlockWithNotify(i - 1, j + 1, k, Block.reed.blockID);
		        			}
		        		}
		        	}
		        	if (world.getBlockId(i, j, k + 1) == Block.waterStill.blockID){
		        		if (world.isBlockNormalCube(i, j - 1, k + 1)){
		        			if (world.getBlockId(i, j + 1, k + 1) == 0){
		        				world.setBlockWithNotify(i, j + 1, k + 1, Block.reed.blockID);
		        			}
		        		}
		        	}
		        	if (world.getBlockId(i, j, k - 1) == Block.waterStill.blockID){
		        		if (world.isBlockNormalCube(i, j - 1, k - 1)){
		        			if (world.getBlockId(i, j + 1, k - 1) == 0){
		        				world.setBlockWithNotify(i, j + 1, k - 1, Block.reed.blockID);
		        			}
		        		}
		        	}
	        	}
        	}
        }
    }

    public int idDropped(int i, Random random)
    {
        return Block.dirt.idDropped(0, random);
    }
    
    @Override
    public int damageDropped(int i){
    	return i;
    }
    
    public static void texInit(int base, int base2, int base3, int base4){
    	sandTex = base;
    	coolTex = sandTex + 1;
    	warmTex = sandTex + 2;
    	
    	sandTexOverlay = base2;
    	coolTexOverlay = sandTexOverlay + 1;
    	warmTexOverlay = sandTexOverlay + 2;
    	
    	sandTexSnow = base3;
    	coolTexSnow = sandTexSnow + 1;
    	warmTexSnow = sandTexSnow + 2;
    	
    	sandTexBottom = base4;
    	coolTexBottom = sandTexBottom + 1;
    	warmTexBottom = sandTexBottom + 2;
    }
    
    public static int getOverlay(IBlockAccess ba, int i, int j, int k){
    	int meta = ba.getBlockMetadata(i, j, k);
    	
        switch (meta){
    	case 1:
    		return sandTexOverlay;
    	case 2:
    		return coolTexOverlay;
    	case 3:
    		return warmTexOverlay;
    	default:
    		return Util.normalizeTexture(38);
    	}
    }
    
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
    	if (world.rand.nextInt(40) == 0){
    		world.entityJoinedWorld(new EntityItem(world, i, j, k, new ItemStack(BEItems.peanuts, 1)));
    	}
    	super.harvestBlock(world, entityplayer, i, j, k, l);
    }
    
    private static int sandTex;
    private static int coolTex;
    private static int warmTex;
    
    private static int sandTexOverlay;
    private static int coolTexOverlay;
    private static int warmTexOverlay;
    
    private static int sandTexSnow;
    private static int coolTexSnow;
    private static int warmTexSnow;
    
    private static int sandTexBottom;
    private static int coolTexBottom;
    private static int warmTexBottom;
}
