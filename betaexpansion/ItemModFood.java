package net.minecraft.src;

public class ItemModFood extends ItemFood {

	public ItemModFood(int i, int tex, int tey, String name, int heal, boolean flag, int stacksize) {
		super(i, heal, flag);
		setIconCoord(tex, tey);
		setItemName(name);
		ModLoader.AddName(this, name);
		this.maxStackSize = stacksize;
	}

}
