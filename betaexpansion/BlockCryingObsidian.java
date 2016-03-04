package net.minecraft.src;

import java.util.Random;

public class BlockCryingObsidian extends ModBlock {

	public BlockCryingObsidian(int i, int j, Material material, String name) {
		super(i, j, material, name);
		setLightValue(5f / 15f);
	}

	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer){
	  if (world.getBlockId(i, j - 1, k) == blockID && world.getBlockId(i, j - 2, k) == blockID){
	        if(world.worldProvider.canRespawnHere())
	        {
	        	entityplayer.setPlayerSpawnCoordinate(new ChunkCoordinates(i, j - 1, k));
	        	lightUp(world, i, j - 1, k);
	        	return true;
	        }
	  }
	  if (world.getBlockId(i, j - 1, k) == blockID && world.getBlockId(i, j + 1, k) == blockID){
	        if(world.worldProvider.canRespawnHere())
	        {
	        	entityplayer.setPlayerSpawnCoordinate(new ChunkCoordinates(i, j, k));
	        	lightUp(world, i, j, k);
	        	entityplayer.addChatMessage("Your spawn obelisk has been set");
	        	return true;
	        }
	  }
	  if (world.getBlockId(i, j + 1, k) == blockID && world.getBlockId(i, j + 2, k) == blockID){
	        if(world.worldProvider.canRespawnHere())
	        {
	        	entityplayer.setPlayerSpawnCoordinate(new ChunkCoordinates(i, j + 1, k));
	        	entityplayer.addChatMessage("Your spawn obelisk has been set");
	        	lightUp(world, i, j + 1, k);
	        	return true;
	        }
	  }
	  
	  return false;
  }
  
  public void lightUp(World world, int x, int y, int z){
	  for (int i = -1; i < 2; i++){
		  for (int j = -1; j < 2; j++){
			  for (int k = -1; k < 3; k++){
				  if (world.getBlockId(i + x, j + y, k + z) == 0){
					  world.setBlock(i + x, j + y, k + z, BEBlocks.light.blockID);
				  }
			  }
		  }
	  }
  }
  
    public static ChunkCoordinates getNearestEmptyChunkCoordinates(World world, int i, int j, int k, int l)
    {
    	if (world.isAirBlock(i + 1, j, k)){
    		return new ChunkCoordinates(i + 1, j, k);
    	}
    	if (world.isAirBlock(i - 1, j, k)){
    		return new ChunkCoordinates(i - 1, j, k);
    	}
    	if (world.isAirBlock(i, j, k + 1)){
    		return new ChunkCoordinates(i, j, k + 1);
    	}
    	if (world.isAirBlock(i, j, k - 1)){
    		return new ChunkCoordinates(i, j, k - 1);
    	}

        return null;
    }
    
	public void updateTick(World world, int i, int j, int k, Random random)
    {
		this.setLightValue(5f / 15f);
    }
	
    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k);
        double d = (float)i + Util.randFloat(random) + 0.5;
        double d1 = (float)j + Util.randFloat(random) + 0.5;
        double d2 = (float)k + Util.randFloat(random) + 0.5;
        if (random.nextInt(5) != 0){
        	world.spawnParticle("reddust", d, d1, d2, 32f / 255f, 26f / 255f, 51f / 255f);
        } else{
        	world.spawnParticle("reddust", d, d1, d2, 12f / 26f, 53f / 255f, 136f / 255f);
        }
    }
}
