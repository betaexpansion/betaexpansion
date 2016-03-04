package net.minecraft.src;

public class ItemStone extends ItemBlock {

	protected ItemStone(int i) {
		super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        this.setItemName("Stone_item");
	}
	
	public int getIconFromDamage(int i)
    {
		return Block.stone.getBlockTextureFromSideAndMetadata(2, i);
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }

}
