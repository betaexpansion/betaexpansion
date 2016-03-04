package net.minecraft.src;

import java.util.Random;

public class Util {

	public static int normalizeTexture(int tex){
		int x = tex % 16;
		int y = tex - x;
		return (y * 4) + x;
	}
	
	public static int tex(int x, int y){
		return x + (y * 64);
	}
	
	public static float randFloat(Random random){
		return random.nextFloat() * randNeg(random);
	}
	
	public static int randNeg(Random random){
		return random.nextInt(2) == 1 ? 1 : -1;
	}
	
	public static int distance(int x, int y, int z, int x1, int y1, int z1){
		return (int) Math.sqrt(distanceSquared(x, y, z, x1, y1, z1));
	}
	
	public static int distanceSquared(int x, int y, int z, int x1, int y1, int z1){
		return ((x - x1) * (x - x1)) + (( y - y1) * (y - y1)) + ((z - z1) * (z - z1)); 
	}
	
	public static int getDirtMetadataForBiome(BiomeGenBase biome){
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
