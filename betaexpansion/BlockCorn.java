package net.minecraft.src;

import java.util.Random;

public class BlockCorn extends ModBlock {

	protected BlockCorn(int i, int j, String name) {
		super(i, j, Material.plants, name);
		this.stepSound = Block.soundGrassFootstep;
		setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
		this.setTickOnLoad(true);
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		func_268_h(world, i, j, k);
		int l = world.getBlockMetadata(i, j, k);
		if (l < 1) {
			float f = getGrowthRate(world, i, j, k);
			if (random.nextInt((int) (300f / f)) == 0) {
				l++;
				world.setBlockMetadataWithNotify(i, j, k, l);
				int blockAbove = world.getBlockId(i, j + 1, k);
				if (blockAbove == 0) {
					world.setBlockAndMetadataWithNotify(i, j + 1, k, blockID, 2);
				}
			}
		}
	}

	public boolean canBlockStay(World world, int i, int j, int k) {
		return (world.getFullBlockLightValue(i, j, k) >= 8 || world
				.canBlockSeeTheSky(i, j, k))
				&& canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
	}

	protected final void func_268_h(World world, int i, int j, int k) {
		if (!canBlockStay(world, i, j, k)) {
			dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
			world.setBlockWithNotify(i, j, k, 0);
		}
	}

	protected boolean canThisPlantGrowOnThisBlockID(int i) {
		return i == Block.tilledField.blockID || i == blockID;
	}

	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
		super.onNeighborBlockChange(world, i, j, k, l);
		if (world.getBlockId(i, j + 1, k) == 0
				&& world.getBlockMetadata(i, j, k) == 1) {
			world.setBlockMetadataWithNotify(i, j, k, 0);
		}
	}

	public void fertilize(World world, int i, int j, int k) {
		world.setBlockMetadataWithNotify(i, j, k, 1);
		int blockAbove = world.getBlockId(i, j + 1, k);
		if (blockAbove == 0) {
			world.setBlockAndMetadataWithNotify(i, j + 1, k, blockID, 2);
		}
	}

	private float getGrowthRate(World world, int i, int j, int k) {
		float f = 1.0F;
		int l = world.getBlockId(i, j, k - 1);
		int i1 = world.getBlockId(i, j, k + 1);
		int j1 = world.getBlockId(i - 1, j, k);
		int k1 = world.getBlockId(i + 1, j, k);
		int l1 = world.getBlockId(i - 1, j, k - 1);
		int i2 = world.getBlockId(i + 1, j, k - 1);
		int j2 = world.getBlockId(i + 1, j, k + 1);
		int k2 = world.getBlockId(i - 1, j, k + 1);
		boolean flag = j1 == blockID || k1 == blockID;
		boolean flag1 = l == blockID || i1 == blockID;
		boolean flag2 = l1 == blockID || i2 == blockID || j2 == blockID
				|| k2 == blockID;
		for (int l2 = i - 1; l2 <= i + 1; l2++) {
			for (int i3 = k - 1; i3 <= k + 1; i3++) {
				int j3 = world.getBlockId(l2, j - 1, i3);
				float f1 = 0.0F;
				if (j3 == Block.tilledField.blockID) {
					f1 = 1.0F;
					if (world.getBlockMetadata(l2, j - 1, i3) > 0) {
						f1 = 3F;
					}
				}
				if (j3 == BEBlocks.peanutCrop.blockID) {
					f1 += 1.0f * (world.getBlockMetadata(l2, j - 1, i3) / 2f);
				}
				if (l2 != i || i3 != k) {
					f1 /= 4F;
				}
				f += f1;
			}

		}

		if (flag2 || flag && flag1) {
			f /= 2.0F;
		}
		if (world.canBlockSeeTheSky(i, j, k) && !world.worldInfo.getRaining()) {
			f *= 2f;
		} else {
			f *= 0.75f;
		}
		if (SeasonManager.season != 1) {
			f /= 4f;
		}
		return f;
	}

	@Override
	public int getRenderType() {
		return 6;
	}

	public void dropBlockAsItemWithChance(World world, int i, int j, int k,
			int l, float f) {
		super.dropBlockAsItemWithChance(world, i, j, k, l, f);
		if (world.multiplayerWorld) {
			return;
		}
		for (int i1 = 0; i1 < 3; i1++) {
			if (world.rand.nextInt(15) <= l) {
				float f1 = 0.7F;
				float f2 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
				float f3 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
				float f4 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
				EntityItem entityitem = new EntityItem(world, (float) i + f2,
						(float) j + f3, (float) k + f4, new ItemStack(
								BEItems.corn));
				entityitem.delayBeforeCanPickup = 10;
				world.entityJoinedWorld(entityitem);
			}
		}

	}

	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		if (j < 0) {
			j = 0;
		}
		return blockIndexInTexture + j;
	}

	public int idDropped(int i, Random random) {
		if (i == 2) {
			return BEItems.corn.shiftedIndex;
		} else {
			return -1;
		}
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i,
			int j, int k) {
		return null;
	}

	public int quantityDropped(Random random) {
		return 1 + random.nextInt(3);
	}

	public void harvestBlock(World world, EntityPlayer entityplayer, int i,
			int j, int k, int l) {
		if (!world.multiplayerWorld) {
			dropBlockAsItem(world, i, j, k, l);
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

}