package net.minecraft.src;

public class ModItem extends Item {

	protected ModItem(int i, int tex, int tey, String name) {
		super(i);
		setItemName(name);
		ModLoader.AddName(this, name);
		setIconCoord(tex, tey);
	}

}
