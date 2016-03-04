package net.minecraft.src;

import java.util.Random;

public class BlockLamp extends ModBlock {

	protected BlockLamp(int i, int j, String name) {
		super(i, j, Material.glass, name);
        float f = 0.25F;
        setBlockBounds(f, 0, f, 1-f, 5f/8f, 1-f);
        this.setLightValue(1f);
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
        return BERender.lampRenderID;
    }

    private boolean func_31032_h(World world, int i, int j, int k)
    {
        return world.isBlockNormalCube(i, j, k) || world.getBlockId(i, j, k) == Block.fence.blockID ||
        	   (Block.blocksList[world.getBlockId(i, j, k)] instanceof BlockTable);
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        if(world.isBlockNormalCube(i - 1, j, k))
        {
            return true;
        }
        if(world.isBlockNormalCube(i + 1, j, k))
        {
            return true;
        }
        if(world.isBlockNormalCube(i, j, k - 1))
        {
            return true;
        }
        if(world.isBlockNormalCube(i, j, k + 1))
        {
            return true;
        }
        if(world.isBlockNormalCube(i, j + 1, k))
        {
            return true;
        }
        return func_31032_h(world, i, j - 1, k);
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        if(l == 1 && func_31032_h(world, i, j - 1, k))
        {
            i1 = 5;
        }
        if(l == 0 && world.isBlockNormalCube(i, j - 1, k))
        {
            i1 = 6;
        }
        if(l == 2 && world.isBlockNormalCube(i, j, k + 1))
        {
            i1 = 4;
        }
        if(l == 3 && world.isBlockNormalCube(i, j, k - 1))
        {
            i1 = 3;
        }
        if(l == 4 && world.isBlockNormalCube(i + 1, j, k))
        {
            i1 = 2;
        }
        if(l == 5 && world.isBlockNormalCube(i - 1, j, k))
        {
            i1 = 1;
        }
        
        world.setBlockMetadataWithNotify(i, j, k, i1);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (random.nextInt(500) == 0 && world.difficultySetting == 3){
        	world.setBlockAndMetadata(i, j, k, 101, world.getBlockMetadata(i, j, k));
        }
    	super.updateTick(world, i, j, k, random);
        if(world.getBlockMetadata(i, j, k) == 0)
        {
            onBlockAdded(world, i, j, k);
        }
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        if(world.isBlockNormalCube(i - 1, j, k))
        {
            world.setBlockMetadataWithNotify(i, j, k, 1);
        } else
        if(world.isBlockNormalCube(i + 1, j, k))
        {
            world.setBlockMetadataWithNotify(i, j, k, 2);
        } else
        if(world.isBlockNormalCube(i, j, k - 1))
        {
            world.setBlockMetadataWithNotify(i, j, k, 3);
        } else
        if(world.isBlockNormalCube(i, j, k + 1))
        {
            world.setBlockMetadataWithNotify(i, j, k, 4);
        } else
        if(world.isBlockNormalCube(i, j - 1, k)){
            world.setBlockMetadataWithNotify(i, j, k, 5);
        }
        else
            if(world.isBlockNormalCube(i, j + 1, k)){
                world.setBlockMetadataWithNotify(i, j, k, 6);
            }
        dropTorchIfCantStay(world,  i,  j, k);
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(dropTorchIfCantStay(world, i, j, k))
        {
            int i1 = world.getBlockMetadata(i, j, k);
            boolean flag = false;
            if(!world.isBlockNormalCube(i - 1, j, k) && i1 == 1)
            {
                flag = true;
            }
            if(!world.isBlockNormalCube(i + 1, j, k) && i1 == 2)
            {
                flag = true;
            }
            if(!world.isBlockNormalCube(i, j, k - 1) && i1 == 3)
            {
                flag = true;
            }
            if(!world.isBlockNormalCube(i, j, k + 1) && i1 == 4)
            {
                flag = true;
            }
            if(!func_31032_h(world, i, j - 1, k) && i1 == 5)
            {
                flag = true;
            }
            if(flag)
            {
                dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
                world.setBlockWithNotify(i, j, k, 0);
            }
        }
    }

    private boolean dropTorchIfCantStay(World world, int i, int j, int k)
    {
        if(!canPlaceBlockAt(world, i, j, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
            return false;
        } else
        {
            return true;
        }
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k);
        double d = (float)i + 0.5F;
        double d1 = (float)j + 0.7F;
        double d2 = (float)k + 0.5F;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        world.spawnParticle("reddust", d, d1, d2, 255f / 255f, 193f / 255f, 66f / 255f);     
    }
    
    public void texInit(int top){
    	this.top = top;
    }
    
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 1)
        {
            return top;
        }
        if(i == 0)
        {
            return top;
        }
        return blockIndexInTexture;
    }
    
    public int top;
	

}