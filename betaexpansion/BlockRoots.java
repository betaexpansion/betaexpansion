package net.minecraft.src;

import java.util.Random;

public class BlockRoots extends ModBlock {

	protected BlockRoots(int i, int j, String name) {
		super(i, j, Material.plants, name);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
        this.setStepSound(Block.soundGrassFootstep);
	}
	
	public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return super.canPlaceBlockAt(world, i, j, k) && canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == Block.grass.blockID || i == Block.dirt.blockID || i == Block.tilledField.blockID;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        func_268_h(world, i, j, k);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        func_268_h(world, i, j, k);
    }
    
    protected final void func_268_h(World world, int i, int j, int k)
    {
        if(!canBlockStay(world, i, j, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        }
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return (world.getBlockId(i, j + 1, k) == Block.dirt.blockID)
        		|| (world.getBlockId(i, j + 1, k) == Block.grass.blockID);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }
    
    @Override
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
    	if (world.rand.nextInt(20) == 0){
    		world.entityJoinedWorld(new EntityItem(world, i, j, k, new ItemStack(BEItems.radish, 1)));
    		return;
    	}
    	if (entityplayer.inventory.getCurrentItem() == null){
    		return;
    	}
    	else if ((entityplayer.inventory.getCurrentItem().getItem() instanceof ItemSpade && !Config.NEED_SPADE_FOR_FLOWERS) || 
    		entityplayer.inventory.getCurrentItem().getItem() instanceof ItemTrowel){
            	entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        		dropBlockAsItem(world, i, j, k, l);
    	}
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }
   

}