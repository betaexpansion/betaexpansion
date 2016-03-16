package net.minecraft.src;

import java.util.Random;

public class BlockQuicksand extends ModBlock
{
	public BlockQuicksand(int i, int j, String name){
		super(i, j, Material.sand, name);
	}

    public void onEntityCollidedWithBlock(World world, int i, int j, int k,
                                          Entity entity)
    {
        entity.isInWeb = true;
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, 
                                                         int i, int j, 
                                                         int k)
    {
        return null;
    }

/*
    public int getRenderType()
    {
        return 1;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
*/
}
