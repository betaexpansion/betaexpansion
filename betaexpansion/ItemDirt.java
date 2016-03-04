package net.minecraft.src;

public class ItemDirt extends ItemBlock{
	
	protected ItemDirt(int i) {
		super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        this.setItemName("dirt_item");
	}
	
	public int getIconFromDamage(int i)
    {
		return Block.dirt.getBlockTextureFromSideAndMetadata(2, i);
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }
    
}
