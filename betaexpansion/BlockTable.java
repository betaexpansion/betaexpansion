package net.minecraft.src;
 
public class BlockTable extends BlockFurniture {

	public BlockTable(int i, Block b, String name) {
		super(i, b, name);
		setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
	}

	@Override
	public int getRenderType() {
		return BERender.tableRenderID;
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return AxisAlignedBB.getBoundingBoxFromPool((double)i + minX, (double)j + minY, (double)k + minZ, (double)i + maxX, (double)j + 1, (double)k + maxZ);
    }

}
