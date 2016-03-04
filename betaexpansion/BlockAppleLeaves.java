package net.minecraft.src;

import java.util.Random;

public class BlockAppleLeaves extends BlockLeavesBase {

	protected BlockAppleLeaves(int i, int j) {
		super(i, j, Material.leaves, true);
		this.setBlockName("Apple Leaves");
		ModLoader.AddName(this, "Apple Leaves");
		this.blockIndexInTexture = j;
		ModLoader.RegisterBlock(this);
		this.setStepSound(Block.soundGrassFootstep);
		setHardness(0.2F);
	}

	public boolean blockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer) {
		world.setBlockWithNotify(i, j, k, Block.leaves.blockID);
		world.entityJoinedWorld(new EntityItem(world, i, j, k, new ItemStack(
				Item.appleRed, 1)));
		return true;
	}

	public int quantityDropped(Random random) {
		return -1;
	}

	public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k) {
		iblockaccess.getWorldChunkManager().func_4069_a(i, k, 1, 1);
		double d = iblockaccess.getWorldChunkManager().temperature[0];
		double d1 = iblockaccess.getWorldChunkManager().humidity[0];
		return ColorizerFoliage.getFoliageColor(d, d1);
	}

}