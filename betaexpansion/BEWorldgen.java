package net.minecraft.src;

public class BEWorldgen {

	private static final int COLORED_STONE_HEIGHT = 40;
	
	public static void init(){
		System.out.println("Loading betaexpansion world generation...");
		System.out.println("Done.");
	}
	
	public static byte[] processOverworldChunk(byte[] data, World world, BiomeGenBase biomes[]){
		return data;
	}
	
	public static void populate(World world, int i, int j){
		for (int x = 0; x < 16; x++){
			for (int y = 1; y < 128; y++){
				for (int z = 0; z < 16; z++){
					if (y > 63){
						if (world.rand.nextInt(40000) == 0){
							if (world.getWorldChunkManager().getBiomeGenAt(x + (i * 16), z + (j * 16)).biomeName.equals(BiomeGenBase.desert.biomeName)){
								new WorldGenRedSand().generate(world, world.rand, x + (i * 16), y, z + (j * 16));
							}
						}
					}
				}
			}
		}
		
		i *= 16;
		j *= 16;
		
		int y;
		for (y = 127; y > 60; y--){
			if (world.getBlockId(i, y, j) == Block.grass.blockID){
				break;
			}
		}

		if (world.rand.nextInt(40) == 0){
			new WorldGenFlowers(BEBlocks.berryBush.blockID).generate(world, world.rand, i, y, j);
		}
		
		for (int tempx = i; tempx < i + 16; tempx++){
			for (int tempz = j; tempz < j + 16; tempz++){
				if (world.rand.nextInt(12) != 0){
					
				}
				else{
					for (int tempy = 126; tempy > 10; tempy--){
						if (world.getBlockId(tempx, tempy, tempz) == Block.waterStill.blockID
							&& world.getBlockId(tempx, tempy + 1, tempz) == 0
							&& (world.getBlockId(tempx, tempy - 1, tempz) == Block.sand.blockID
							   || world.getBlockId(tempx, tempy - 1, tempz) == Block.dirt.blockID)
							   && (world.getBlockId(tempx, tempy, tempz + 1) == Block.grass.blockID
							   ||  world.getBlockId(tempx, tempy, tempz - 1) == Block.grass.blockID
							   ||  world.getBlockId(tempx + 1, tempy, tempz) == Block.grass.blockID
							   ||  world.getBlockId(tempx - 1, tempy, tempz) == Block.grass.blockID)){
							world.setBlock(tempx, tempy + 1, tempz, BEBlocks.rushes.blockID);
						}
					}
				}
			}
		}
		
		for (int tempx = i; tempx < i + 16; tempx++){
			for (int tempz = j; tempz < j + 16; tempz++){
				if (world.rand.nextInt(20) != 0){
					
				}
				else{
					for (int tempy = 126; tempy > 10; tempy--){
						if (world.getBlockId(tempx, tempy, tempz) == 0
							&&( world.getBlockId(tempx, tempy + 1, tempz) == Block.dirt.blockID
							   || world.getBlockId(tempx, tempy + 1, tempz) == Block.grass.blockID)){
							world.setBlock(tempx, tempy, tempz, BEBlocks.roots.blockID);
						}
					}
				}
			}
		}
		
		new WorldGenMinable(Block.blockClay.blockID, 32, 1).generate(world, world.rand, 
																	 i + world.rand.nextInt(16),
																	 world.rand.nextInt(128), 
																	 j + world.rand.nextInt(16));
		
	}
	 
	public static Chunk addOverworldMetadata(int i, int j, Chunk chunk, World world){
		for (int x = 0; x < 16; x++){
			for (int z = 0; z < 16; z++){
				int stoneMeta = getStoneMetadataForBiome(world.getWorldChunkManager()
						.getBiomeGenAt(x + (i * 16), z + (j * 16)));
				int dirtMeta = getDirtMetadataForBiome(world.getWorldChunkManager()
						.getBiomeGenAt(x + (i * 16), z + (j * 16)));
				for (int y = 0; y < 128; y++){
					if (chunk.getBlockID(x, y, z) == Block.stone.blockID){
						if (y < COLORED_STONE_HEIGHT + world.rand.nextInt(3)){
							chunk.setBlockMetadata(x, y, z, stoneMeta);
						} else{
							chunk.setBlockMetadata(x, y, z, (byte) (8 * world.rand.nextInt(2)));
						}
					} else if (chunk.getBlockID(x, y, z) == Block.dirt.blockID || 
							   chunk.getBlockID(x, y, z) == Block.grass.blockID){
						chunk.setBlockMetadata(x, y, z, (byte) dirtMeta);
					}
				}
			}
		}
		
		return chunk;
	}
	
	private static int getStoneMetadataForBiome(BiomeGenBase biome){
		if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.desert.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.forest.biomeName)){
			return 6;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.hell.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.iceDesert.biomeName)){
			return 7;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.plains.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.rainforest.biomeName)){
			return 5;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.savanna.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.seasonalForest.biomeName)){
			return 6;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.shrubland.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.sky.biomeName)){
			return 3;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.swampland.biomeName)){
			return 5;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.taiga.biomeName)){
			return 7;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.tundra.biomeName)){
			return 7;
		}
		
		return -1;
	}
	
	private static int getDirtMetadataForBiome(BiomeGenBase biome){
		if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.desert.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.forest.biomeName)){
			return 3;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.hell.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.iceDesert.biomeName)){
			return 1;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.plains.biomeName)){
			return 0;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.rainforest.biomeName)){
			return 3;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.savanna.biomeName)){
			return 0;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.seasonalForest.biomeName)){
			return 3;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.shrubland.biomeName)){
			return 0;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.sky.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.swampland.biomeName)){
			return 3;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.taiga.biomeName)){
			return 2;
		} else if (biome.biomeName.equalsIgnoreCase(BiomeGenBase.tundra.biomeName)){
			return 2;
		}
		
		return -1;
	}
	
}
