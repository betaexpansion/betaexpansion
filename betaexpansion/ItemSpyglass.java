package net.minecraft.src;

public class ItemSpyglass extends ModItem {

	protected ItemSpyglass(int i, int tex, int tey, String name) {
		super(i, tex, tey, name);
		this.maxStackSize = 1;
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        EntityRenderer.zoom ^= true;
    	return itemstack;
    }

}
