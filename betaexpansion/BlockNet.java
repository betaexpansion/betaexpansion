package net.minecraft.src;

import java.util.Random;

public class BlockNet extends ModBlock
{

	public BlockNet(int i, int j, String name){
		super(i, j, Material.cloth, name);
        setBlockBounds(0.0f, 14.0f / 16.0f, 0.0f, 
                       1.0f, 15.0f / 16.0f, 1.0f);
        setTickOnLoad(true);
		setHardness(0.5F).setStepSound(soundGrassFootstep);
	}

    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return validPos(world, i, j, k); 
    }
    
    @Override
    public void onNeighborBlockChange(World world,
                                      int i, int j, int k, int l)
    {
        if (!validPos(world, i, j, k)){
            dropBlockAsItem(world, i, j, k, 
                            world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        }
    }
    
    @Override
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (!validPos(world, i, j, k)){
            dropBlockAsItem(world, i, j, k, 
                            world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        }
    }

    public boolean validPos(World world, int i, int j, int k)
    {
        int count = 0;
        if (world.getBlockId(i + 1, j, k) != 0){ count++; }
        if (world.getBlockId(i - 1, j, k) != 0){ count++; }
        if (world.getBlockId(i, j, k + 1) != 0){ count++; }
        if (world.getBlockId(i, j, k - 1) != 0){ count++; }
        if (world.getBlockId(i, j - 1, k) != 0){ count += 10; }
        return count >= 2;
    }

}
