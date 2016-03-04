package net.minecraft.src;

public class BlockRedSandstone extends ModBlock {

	public BlockRedSandstone(int i, int j, Material material, String name) {
		super(i, j, material, name);
	}
	
	public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return blockIndexInTexture;
        }
        if(i == 0)
        {
            return blockIndexInTexture + 2;
        } else
        {
            return blockIndexInTexture + 1;
        }
    }
	
	public boolean chiselBlock(int x, int y, int z, World world, int meta){
		if (this.blockID != BEBlocks.redSandstone.blockID){
			return false;
		}
		world.setBlockAndMetadataWithNotify(x, y, z, BEBlocks.redSandBricks.blockID, meta);
		return true;
	}

}
