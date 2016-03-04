// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockSandStone extends Block
{

    public BlockSandStone(int i)
    {
        super(i, 192, Material.rock);
    }

    public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return blockIndexInTexture - 64;
        }
        if(i == 0)
        {
            return blockIndexInTexture + 64;
        } else
        {
            return blockIndexInTexture;
        }
    }
    
    public boolean chiselBlock(int x, int y, int z, World world, int meta){
		if (this.blockID != Block.sandStone.blockID){
			return false;
		}
		world.setBlockAndMetadataWithNotify(x, y, z, BEBlocks.sandBricks.blockID, 0);
		return true;
	}
}
