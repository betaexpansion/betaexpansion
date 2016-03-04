package net.minecraft.src;

import java.util.Random;

public class BlockBerryBush extends ModBlock {

	public int red;
	public int blue;

	protected BlockBerryBush(int i, int j, String name) {
		super(i, j, Material.plants, name);
		setTickOnLoad(true);
		float f = 0.2F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3F, 0.5F + f);
		this.setStepSound(Block.soundGrassFootstep);
	}

	public void texinit(int blue, int red) {
		this.blue = blue;
		this.red = red;
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		func_268_h(world, i, j, k);
		int meta = world.getBlockMetadata(i, j, k);
		if (meta == 0) {
			world.setBlockAndMetadataWithNotify(i, j, k, blockID,
					world.rand.nextInt(2) + 3);
		}
		if (meta == 1 || meta == 2) {
			if (random.nextInt(100) == 0) {
				world.setBlockAndMetadataWithNotify(i, j, k, blockID, meta + 2);
			}
		}
	}

	public boolean blockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer) {
		int meta = world.getBlockMetadata(i, j, k);
		;
		if (meta == 3) {
			world.setBlockAndMetadataWithNotify(i, j, k, blockID, meta - 2);
			if (!entityplayer.inventory.addItemStackToInventory(new ItemStack(
					BEItems.redBerry, world.rand.nextInt(2) + 1))) {
				world.entityJoinedWorld(new EntityItem(world, (double) i,
						(double) j, (double) k, new ItemStack(BEItems.redBerry,
								world.rand.nextInt(2) + 1)));
			}
			return true;
		}
		if (meta == 4) {
			world.setBlockAndMetadataWithNotify(i, j, k, blockID, meta - 2);
			if (!entityplayer.inventory.addItemStackToInventory(new ItemStack(
					BEItems.blueBerry, world.rand.nextInt(2) + 1))) {
				world.entityJoinedWorld(new EntityItem(world, (double) i,
						(double) j, (double) k, new ItemStack(
								BEItems.blueBerry, world.rand.nextInt(2) + 1)));
			}
			return true;
		}
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getRenderType() {
		return 1;
	}

	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		if (j == 4) {
			return blue;
		}
		if (j == 3) {
			return red;
		}
		return blockIndexInTexture;
	}

	public boolean canPlaceBlockAt(World world, int i, int j, int k) {
		return super.canPlaceBlockAt(world, i, j, k)
				&& canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
	}

	@Override
	public void harvestBlock(World world, EntityPlayer entityplayer, int i,
			int j, int k, int l) {
		if (entityplayer.inventory.getCurrentItem() == null) {
			return;
		} else if ((entityplayer.inventory.getCurrentItem().getItem() instanceof ItemSpade && !Config.NEED_SPADE_FOR_FLOWERS)
				|| entityplayer.inventory.getCurrentItem().getItem() instanceof ItemTrowel) {
			entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
			dropBlockAsItem(world, i, j, k, l);
		}
	}

	protected boolean canThisPlantGrowOnThisBlockID(int i) {
		return i == Block.grass.blockID || i == Block.dirt.blockID
				|| i == Block.tilledField.blockID;
	}

	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
		super.onNeighborBlockChange(world, i, j, k, l);
		func_268_h(world, i, j, k);
	}

	protected final void func_268_h(World world, int i, int j, int k) {
		if (!canBlockStay(world, i, j, k)) {
			dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
			world.setBlockWithNotify(i, j, k, 0);
		}
	}

	public boolean canBlockStay(World world, int i, int j, int k) {
		return (world.getFullBlockLightValue(i, j, k) >= 8 || world
				.canBlockSeeTheSky(i, j, k))
				&& canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i,
			int j, int k) {
		return null;
	}

}
