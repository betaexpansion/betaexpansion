package net.minecraft.src;


public abstract class BlockFurniture extends ModBlock {

	protected BlockFurniture(int i, Block b, String name) {
		super(i, b.blockIndexInTexture, b.blockMaterial, name);
		block = b;
		this.setHardness(b.blockHardness);
		this.setResistance(b.blockResistance);
		this.setStepSound(b.stepSound);
	}
	
	public Block block;
	
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public abstract int getRenderType();
    
    
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
    	if (!world.isBlockNormalCube(i, j - 1, k)){
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
    	}
    }
    
    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return world.isBlockNormalCube(i, j - 1, k);
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = func_31039_c(world, i, j, k, (EntityPlayer)entityliving);
        world.setBlockMetadataWithNotify(i, j, k, l);
    }
    
    private static int func_31039_c(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        int l = MathHelper.floor_double((double)((entityplayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            return 2;
        }
        if(l == 1)
        {
            return 5;
        }
        if(l == 2)
        {
            return 3;
        }
        return 4;
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	return block.getBlockTextureFromSideAndMetadata(i, 0);
    }
    
    public int getRenderBlockPass()
    {
        return block.getRenderBlockPass();
    }
}