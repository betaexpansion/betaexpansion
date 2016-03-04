package net.minecraft.src;

public class BlockChair extends BlockFurniture {

	protected BlockChair(int i, Block b, String name) {
		super(i, b, name);
		setBlockBounds(0f, 0f, 0f, 1f, 8f / 16f, 1f);
	}

	@Override
	public int getRenderType() {
		return BERender.chairRenderID;
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return AxisAlignedBB.getBoundingBoxFromPool((double)i + minX, (double)j + minY, (double)k + minZ, (double)i + maxX, (double)j + (8f / 16f), (double)k + maxZ);
    }
    

}
