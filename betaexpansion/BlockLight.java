package net.minecraft.src;

import java.util.Random;

public class BlockLight extends ModBlock {

	protected BlockLight(int i) {
		super(i, 0, Material.air, "");
		setBlockBounds(0f, 0f, 0f, 0f, 0f, 0f);
		this.setTickOnLoad(true);
		this.setLightValue(1f);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i,
			int j, int k) {
		return null;
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		if (world.rand.nextInt(40) == 0) {
			world.setBlockWithNotify(i, j, k, 0);
		}
	}

	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
		if (world.rand.nextInt(40) == 0) {
			world.setBlockWithNotify(i, j, k, 0);
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int tickRate(){
		return 5;
	}

}