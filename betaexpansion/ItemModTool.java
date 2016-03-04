package net.minecraft.src;

public class ItemModTool extends ItemTool {
	
	protected ItemModTool(int i, int j, EnumToolMaterial enumtoolmaterial,
			Block[] ablock, int tex, int tey, String name) {
		super(i, j, enumtoolmaterial, ablock);
		
		setItemName(name);
		ModLoader.AddName(this, name);
		setIconCoord(tex, tey);
	}

}
