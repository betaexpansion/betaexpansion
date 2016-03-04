package net.minecraft.src;

public class ItemCobblestone extends ItemBlock {
	
	protected ItemCobblestone(int i) {
		super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        this.setItemName("cobblestone_item");
        ModLoader.AddName(this, "Cobblestone");
	}
	
	public int getIconFromDamage(int i)
    {
		return Block.cobblestone.getBlockTextureFromSideAndMetadata(2, i);
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }
    
}
