package net.minecraft.src;

public class ItemPlantableFood extends ItemModFood {

	public ItemPlantableFood(int i, int tex, int tey, String name, int heal,
			boolean flag, int stacksize, int plant) {
		super(i, tex, tey, name, heal, flag, stacksize);
		this.plant = plant;
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if (plant != BEBlocks.radishCrop.blockID){
			if(l != 1)
	        {
	            return false;
	        }
	        int i1 = world.getBlockId(i, j, k);
	        if(i1 == Block.tilledField.blockID && world.isAirBlock(i, j + 1, k))
	        {
	            world.setBlockWithNotify(i, j + 1, k, plant);
	            itemstack.stackSize--;
	            return true;
	        } else
	        {
	            return false;
	        }
        } else{
			if(l != 0)
	        {
	            return false;
	        }
	        int i1 = world.getBlockId(i, j, k);
	        if((i1 == Block.dirt.blockID || i1 == Block.grass.blockID) && world.isAirBlock(i, j - 1, k))
	        {
	            world.setBlockWithNotify(i, j - 1, k, plant);
	            itemstack.stackSize--;
	            return true;
	        } else
	        {
	            return false;
	        }
        }
    }
	
	private int plant;
	
}
