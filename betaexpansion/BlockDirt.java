// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockDirt extends Block
{

    protected BlockDirt(int i, int j)
    {
        super(i, j, Material.ground);
    }
    
    @Override
    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
    	int meta = iblockaccess.getBlockMetadata(i, j, k);

        switch (meta){
        case 1:
    		return sandTex;
    	case 2:
    		return coolTex;
    	case 3:
    		return warmTex;
    	default:
    		return this.blockIndexInTexture;
    	}
    }
    
    @Override
    public int getBlockTextureFromSideAndMetadata(int i, int meta){
        switch (meta){
        case 1:
    		return sandTex;
    	case 2:
    		return coolTex;
    	case 3:
    		return warmTex;
    	default:
    		return this.blockIndexInTexture;
    	}
    }
    
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
    	if (world.rand.nextInt(40) == 0){
    		world.entityJoinedWorld(new EntityItem(world, i, j, k, new ItemStack(BEItems.peanuts, 1)));
    	}
    	super.harvestBlock(world, entityplayer, i, j, k, l);
    }
    
    @Override
    public int damageDropped(int i){
    	return i;
    }
    
    public static void texInit(int base){
    	sandTex = base;
    	coolTex = sandTex + 1;
    	warmTex = sandTex + 2;
    }
    
    private static int sandTex;
    private static int coolTex;
    private static int warmTex;
}
