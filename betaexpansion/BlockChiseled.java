package net.minecraft.src;

public class BlockChiseled extends ModBlock {

	public BlockChiseled(int i, int j, String name, int maxID){
		super(i, j, Material.rock, name);
		this.maxID = maxID;
	}
	
	public void texInit(int base){
    	orangeTexture = base;
    	redTexture = orangeTexture + 1;
    	purpleTexture = orangeTexture + 2;
    	blueTexture = orangeTexture + 3;
    	greenTexture = orangeTexture + 4;
    	whiteTexture = orangeTexture + 5;
    	blackTexture = orangeTexture + 6;
    }
	
	public boolean chiselBlock(int x, int y, int z, World world, int meta){
		int newID = blockID + 1;
		if (newID > maxID){
			if (Config.HARD_CHISEL){
				world.setBlockAndMetadataWithNotify(x, y, z, 0, 0);
			}
			return false;
		}
		world.setBlockAndMetadataWithNotify(x, y, z, newID, meta);
		return true;
	}
	
	@Override
    protected int damageDropped(int i)
    {
    	return i;
    }
    
    @Override
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        switch (j){
        case 1:
        	return orangeTexture;
        case 2:
        	return redTexture;
        case 3:
        	return purpleTexture;
        case 4:
        	return blueTexture;
        case 5:
        	return greenTexture;
        case 6:
        	return whiteTexture;
        case 7:
        	return blackTexture;
        default:
        	return this.blockIndexInTexture;
        }
    }
	
    private int orangeTexture;
    private int redTexture;
    private int purpleTexture;
    private int blueTexture;
    private int greenTexture;
    private int whiteTexture;
    private int blackTexture;
	
	private int maxID;
	
}
