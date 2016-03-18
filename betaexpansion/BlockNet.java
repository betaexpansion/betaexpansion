package net.minecraft.src;

import java.util.Random;

public class BlockNet extends ModBlock
{

	public BlockNet(int i, int j, String name){
		super(i, j, Material.cloth, name);
        setBlockBounds(0.0f, 14.0f / 16.0f, 0.0f, 
                       1.0f, 15.0f / 16.0f, 1.0f);
	}

    public boolean isOpaqueCube()
    {
        return false;
    }

}
