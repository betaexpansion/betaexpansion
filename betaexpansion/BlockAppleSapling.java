package net.minecraft.src;

import java.util.Random;

public class BlockAppleSapling extends BlockSapling {

	protected BlockAppleSapling(int i, int j) {
		super(i, j);
		this.setBlockName("Apple Sapling");
		ModLoader.AddName(this, "Apple Sapling");
		this.blockIndexInTexture = j;
		ModLoader.RegisterBlock(this);
		this.setStepSound(Block.soundGrassFootstep);
	}

	public void growTree(World world, int i, int j, int k, Random random) {
		int l = world.getBlockMetadata(i, j, k);
		world.setBlock(i, j, k, 0);
		Object obj = null;
		obj = new WorldGenApple(random.nextInt(10) == 0);
		if (!((WorldGenerator) (obj)).generate(world, random, i, j, k)) {
			world.setBlockAndMetadata(i, j, k, blockID, l);
		}
	}


	@Override
	 public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer){
		growTree(world, i, j, k, world.rand);
		return true;
	}
	
	public void harvestBlock(World world, EntityPlayer entityplayer, int i,
			int j, int k, int l) {
		return;
	}

	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		return blockIndexInTexture;
	}
}