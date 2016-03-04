package net.minecraft.src;

import java.util.Random;

public class BlockRadishes extends BlockRoots {

	protected BlockRadishes(int i, int j, String name) {
		super(i, j, name);
		this.stepSound = Block.soundGrassFootstep;
		this.setTickOnLoad(true);
	}
	
	 public void updateTick(World world, int i, int j, int k, Random random)
	    {
	        super.updateTick(world, i, j, k, random);
	            int l = world.getBlockMetadata(i, j, k);
	            if(l < 2)
	            {
	                float f = getGrowthRate(world, i, j, k);
	                if(random.nextInt((int)(300f / f)) == 0)
	                {
	                    l++;
	                    world.setBlockMetadataWithNotify(i, j, k, l);
	                }
	            }
	    }

	    public void fertilize(World world, int i, int j, int k)
	    {
	        world.setBlockMetadataWithNotify(i, j, k, 2);
	    }

	    private float getGrowthRate(World world, int i, int j, int k)
	    {
	    	float f = 1.0f;
	    	if (SeasonManager.season == 1){
	    		f = 3.0f;
	    	}
	    	return f;
	    }

	public int getRenderType()
    {
        return 6;
    }

    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f);
        if(world.multiplayerWorld)
        {
            return;
        }
        for(int i1 = 0; i1 < 3; i1++)
        {
            if(world.rand.nextInt(15) <= l)
            {
                float f1 = 0.7F;
                float f2 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f3 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f4 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                EntityItem entityitem = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(BEItems.radish));
                entityitem.delayBeforeCanPickup = 10;
                world.entityJoinedWorld(entityitem);
            }
        }

    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j < 0)
        {
            j = 0;
        }
        return blockIndexInTexture + j;
    }
    
    public int idDropped(int i, Random random)
    {
        if(i == 2)
        {
            return BEItems.radish.shiftedIndex;
        } else
        {
            return -1;
        }
    }

    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(3);
    }
    
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
    	if (!world.multiplayerWorld){
    		dropBlockAsItem(world, i, j, k, l);
    	}
    }
	
}