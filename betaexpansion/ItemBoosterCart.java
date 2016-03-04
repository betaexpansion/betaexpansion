package net.minecraft.src;

public class ItemBoosterCart extends ModItem {

	protected ItemBoosterCart(int i, int tex, int tey, String name) {
		super(i, tex, tey, name);
		maxStackSize = 1;
	}
	
	 public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
	    {
	        int i1 = world.getBlockId(i, j, k);
	        if(BlockRail.isRailBlock(i1))
	        {
	            if(!world.multiplayerWorld)
	            {
	                world.entityJoinedWorld(new EntityMinecart(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, 3));
	            }
	            itemstack.stackSize--;
	            return true;
	        } else
	        {
	            return false;
	        }
	    }

}
