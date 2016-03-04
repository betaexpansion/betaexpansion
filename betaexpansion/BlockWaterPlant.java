package net.minecraft.src;

import java.util.Random;

public class BlockWaterPlant extends ModBlock {

	public int texBottom;
	
	protected BlockWaterPlant(int i, int j, int bottom, String name) {
		super(i, j, Material.plants, name);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
        
        texBottom = bottom;
	    setGrassLike(); 
    }
	
	public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return super.canPlaceBlockAt(world, i, j, k) && canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == Block.waterStill.blockID;
    }
    
    @Override
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
    	if (entityplayer.inventory.getCurrentItem() == null){
    		return;
    	}
    	else if ((entityplayer.inventory.getCurrentItem().getItem() instanceof ItemSpade && !Config.NEED_SPADE_FOR_FLOWERS) || 
    		entityplayer.inventory.getCurrentItem().getItem() instanceof ItemTrowel){
            	entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        		dropBlockAsItem(world, i, j, k, l);
    	}
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
        return (world.getBlockId(i, j - 1, k) == Block.waterStill.blockID);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
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
        return BERender.rushesRenderID;
    }
    
	 public int getRenderBlockPass(){
		 return 0;
	 }
	 
	 public void swapTextures(){
		 int temp = blockIndexInTexture;
		 blockIndexInTexture = texBottom;
		 texBottom = temp;
	 }
	
}
