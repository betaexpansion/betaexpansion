package net.minecraft.src;

import java.util.Random;

public class BlockWildgrass extends ModBlock {

	public BlockWildgrass(int i, int j, Material material, String name) {
		super(i, j, material, name);
		setTickOnLoad(true);
        float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
	}
	
    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta){
    	return blockIndexInTexture + meta;
    }
	
	public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        boolean flag = super.canPlaceBlockAt(world, i, j, k) && canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k), false);
		if (world.getBlockId(i, j - 1, k) == blockID && world.getBlockMetadata(i, j - 1, k) != 4){
			return false;
		}
        return flag;
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i, boolean flag)
    {
        return i == Block.grass.blockID || i == Block.dirt.blockID || i == Block.tilledField.blockID || (i == blockID && flag);
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        func_268_h(world, i, j, k);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        func_268_h(world, i, j, k);
        growGrass(world, i, j, k, random);
    }

    protected final void func_268_h(World world, int i, int j, int k)
    {
        if(!canBlockStay(world, i, j, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        }
    }
    
    private void growGrass(World world, int i, int j, int k, Random random){
    	if (SeasonManager.season != 2 && random.nextInt(1000) == 0){
    		int meta = world.getBlockMetadata(i, j, k);
    		if (meta >= 4){
    			if (world.getBlockMetadata(i, j, k) == 5){
    				world.setBlockAndMetadataWithNotify(i, j, k, blockID, 6);
    			}
    			if (world.getBlockId(i, j + 1, k) == 0){
    				int bottom;
    				for (bottom = j; bottom >= 0; bottom--){
    					if (world.getBlockId(i, bottom, k) != blockID){
    						bottom++;
    						break;
    					}
    				}
    				int height = getHeightForBiome(world.getWorldChunkManager().getBiomeGenAt(i, k));
    				if (j - bottom < height){
    					world.setBlock(i, j + 1, k, blockID);
    				}
    			}
    			spreadGrass(world, i, j, k, random);
    		} else{
    			world.setBlockAndMetadataWithNotify(i, j, k, blockID, ++meta);
    		}
    	} else if (SeasonManager.season == 2){
    		if (random.nextInt(500) == 0){
    			if (world.getBlockId(i, j + 1, k) == blockID){
    				return;
    			} else{
    				int meta = world.getBlockMetadata(i, j, k);
    				--meta;
    				if (meta < 0){
    					meta = 0;
    				}
    				world.setBlockAndMetadataWithNotify(i, j, k, blockID, meta);
    			}
    		}
    	}
    }
    
    private void spreadGrass(World world, int i, int j, int k, Random random){
    	for (int x = -2; x < 3; x++){
    		for (int y = -2; y < 3; y++){
    			for (int z = -2; z < 3; z++){
    				if (canThisPlantGrowOnThisBlockID(world.getBlockId(x + i, y + j, z + k), false)){
    					if (world.getBlockId(x + i, y + j + 1, z + k) == 0){
    						if (random.nextInt(8) != 0){
    							continue;
    						}
    						world.setBlockAndMetadataWithNotify(x + i, y + j + 1, z + k, blockID, world.rand.nextInt(3));
    						break;
    					}
    				}
    			}
    		}
    	}
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return (world.getFullBlockLightValue(i, j, k) >= 8 || world.canBlockSeeTheSky(i, j, k)) && canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k), true);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        long l1 = i * 0x2fc20f + k * 0x5d8875 + j;
        l1 = l1 * l1 * 0x285b825L + l1 * 11L;
        i = (int)((long)i + (l1 >> 14 & 31L));
        j = (int)((long)j + (l1 >> 19 & 31L));
        k = (int)((long)k + (l1 >> 24 & 31L));
        iblockaccess.getWorldChunkManager().func_4069_a(i, k, 1, 1);
        double d = iblockaccess.getWorldChunkManager().temperature[0];
        double d1 = iblockaccess.getWorldChunkManager().humidity[0];
        return ColorizerGrass.getGrassColor(d, d1);
    }    

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }
    
    public int idDropped(int i, Random random)
    {
        if(random.nextInt(8) == 0)
        {
            return Item.seeds.shiftedIndex;
        } else if(random.nextInt(24) == 0)
        {
            return BEItems.corn.shiftedIndex;
        } else
        {
            return -1;
        }
    }
    
    private static int getHeightForBiome(BiomeGenBase biome){
    	if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.desert.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.forest.biomeName)){
			return 3;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.hell.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.iceDesert.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.plains.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.rainforest.biomeName)){
			return 5;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.savanna.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.seasonalForest.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.shrubland.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.sky.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.swampland.biomeName)){
			return 3;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.taiga.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.tundra.biomeName)){
			return 1;
		}
		
		return -1;
    }

}
