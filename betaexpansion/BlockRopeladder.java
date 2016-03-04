package net.minecraft.src;

import java.util.Random;

public class BlockRopeladder extends ModBlock {

	protected BlockRopeladder(int i, int j, String name) {
		super(i, j, Material.circuits, name);
		setHardness(0.4F);
	}
	
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if (entityplayer.isSneaking()){
        	if (world.getBlockId(i, j + 1, k) == blockID){
        		return false;
        	}
        	int ammount = 0;
        	int start = j;
        	for (int y = j; y > 0; y--){
        		if (world.getBlockId(i, y, k) == blockID){
        			ammount++;
        			start = y;
        		} else{
        			break;
        		}
        	}
        	if (entityplayer.inventory.addItemStackToInventory(new ItemStack(BEBlocks.ropeLadder, ammount))){
            	for (int y = start - 1; y <= j; y++){
            		if (world.getBlockId(i, y, k) == blockID){
            			world.setBlockWithNotify(i, y, k, 0);
            		}
            	}
            	return true;
        	} else{
        		return false;
        	}
        } else {
	        	if (entityplayer.inventory.getCurrentItem() != null && entityplayer.inventory.getCurrentItem().getItem().shiftedIndex == this.blockID){
	        	int ammount = entityplayer.inventory.getCurrentItem().stackSize;
	        	for (int y = j - 1; y > 0; y--){
	        		if (world.getBlockId(i, y, k) == 0 && ammount > 0){
	        			world.setBlockAndMetadataWithNotify(i, y, k, blockID, world.getBlockMetadata(i, j, k));
	        			ammount--;
	        		} else{
	        			break;
	        		}
	        	}
	        	
	        	if (ammount == 0){
	        		entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
	        	} else{
	        		entityplayer.inventory.getCurrentItem().stackSize = ammount;
	        	}
	        	
	        }
        }
    	return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.125F;
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.125F;
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getSelectedBoundingBoxFromPool(world, i, j, k);
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
        return 8;
    }
    
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
    	
    	for (int y = j; y < 128; y++){
    		if (world.getBlockId(i, y, k) == blockID){
    	        int i1 = world.getBlockMetadata(i, j, k);
    			boolean flag = false;
    	        if(i1 == 2 && world.isBlockNormalCube(i, y, k + 1))
    	        {
    	            flag = true;
    	        }
    	        if(i1 == 3 && world.isBlockNormalCube(i, y, k - 1))
    	        {
    	            flag = true;
    	        }
    	        if(i1 == 4 && world.isBlockNormalCube(i + 1, y, k))
    	        {
    	            flag = true;
    	        }
    	        if(i1 == 5 && world.isBlockNormalCube(i - 1, y, k))
    	        {
    	            flag = true;
    	        }
    	        if(flag)
    	        {
    	            return;
    	        }
    		} else{
    			break;
    		}
    	}
    	
        int i1 = world.getBlockMetadata(i, j, k);
        boolean flag = false;
        if(i1 == 2 && world.isBlockNormalCube(i, j, k + 1))
        {
            flag = true;
        }
        if(i1 == 3 && world.isBlockNormalCube(i, j, k - 1))
        {
            flag = true;
        }
        if(i1 == 4 && world.isBlockNormalCube(i + 1, j, k))
        {
            flag = true;
        }
        if(i1 == 5 && world.isBlockNormalCube(i - 1, j, k))
        {
            flag = true;
        }
        if(!flag)
        {
            dropBlockAsItem(world, i, j, k, i1);
            world.setBlockWithNotify(i, j, k, 0);
        }
    }
    
    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        if((i1 == 0 || l == 2) && world.isBlockNormalCube(i, j, k + 1))
        {
            i1 = 2;
        }
        if((i1 == 0 || l == 3) && world.isBlockNormalCube(i, j, k - 1))
        {
            i1 = 3;
        }
        if((i1 == 0 || l == 4) && world.isBlockNormalCube(i + 1, j, k))
        {
            i1 = 4;
        }
        if((i1 == 0 || l == 5) && world.isBlockNormalCube(i - 1, j, k))
        {
            i1 = 5;
        }
        world.setBlockMetadataWithNotify(i, j, k, i1);
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }

}