package net.minecraft.src;

public class ItemHatchet extends ItemModTool {

	protected ItemHatchet(int i, int j, EnumToolMaterial enumtoolmaterial, int tex, int tey, String name) {
		super(i, j, enumtoolmaterial, blocksEffectiveAgainst, tex, tey, name);
		weaponDamage = 3 + enumtoolmaterial.getDamageVsEntity();
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
        world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if(!world.multiplayerWorld)
        {
            world.entityJoinedWorld(new EntityHatchet(world, entityplayer, itemstack));
        }
        return itemstack;
    }
	
    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.workbench, Block.fence, BEBlocks.wildGrass
        });
    }
    
    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }
    
    private int weaponDamage;

}
