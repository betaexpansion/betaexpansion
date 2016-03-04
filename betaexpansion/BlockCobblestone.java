package net.minecraft.src;

public class BlockCobblestone extends Block{
	
	public BlockCobblestone(int i, int j)
    {
        super(i, j, Material.rock);
    }
	
	 public static void texInit(){
	    	orangeTexture = 16 + 64;
	    	redTexture = orangeTexture + 1;
	    	purpleTexture = orangeTexture + 2;
	    	blueTexture = orangeTexture + 3;
	    	greenTexture = orangeTexture + 4;
	    	whiteTexture = orangeTexture + 5;
	    	blackTexture = orangeTexture + 6;
	    }
	    
	    @Override
	    protected int damageDropped(int i)
	    {
	        if (i == 8){
	        	return 0;
	        }
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
	    
	    private static int orangeTexture;
	    private static int redTexture;
	    private static int purpleTexture;
	    private static int blueTexture;
	    private static int greenTexture;
	    private static int whiteTexture;
	    private static int blackTexture;
    
}
