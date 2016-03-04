package net.minecraft.src;

public class BlockMetaChiseled extends ModBlock {

	public BlockMetaChiseled(int i, int j, String name, int maxMeta) {
		super(i, j, Material.rock, name);
		this.maxMeta = maxMeta;
	}
	
	public boolean chiselBlock(int x, int y, int z, World world, int meta){
		meta++;
		if (meta >= maxMeta){
			if (Config.HARD_CHISEL){
				world.setBlockAndMetadataWithNotify(x, y, z, 0, 0);
			}
			return false;
		}
		world.setBlockAndMetadataWithNotify(x, y, z, blockID, meta);

		return true;
	}
	
	@Override
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
		if (world.getBlockMetadata(i, j, k) < maxMeta){
			world.setBlockMetadataWithNotify(i, j, k, world.getBlockMetadata(i, j, k) + 1);
		}
        return true;
    }
	
	@Override
    protected int damageDropped(int i)
    {
    	return i;
    }
	
	@Override
	public int getBlockTextureFromSideAndMetadata(int side, int meta){
		return tex[meta];
	}
	
	private int maxMeta;
	
	public void texInit(int... tex){
		this.tex = tex;
	}
	
	private int[] tex;

}
