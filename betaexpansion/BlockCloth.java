// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockCloth extends Block
{

    public BlockCloth()
    {
        super(35, 64, Material.cloth);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j == 0)
        {
            return blockIndexInTexture;
        } else
        {
            j = ~(j & 0xf);
            return Util.normalizeTexture(113) + ((j & 8) >> 3) + (j & 7) * 64;
        }
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public static int func_21034_c(int i)
    {
        return ~i & 0xf;
    }

    public static int func_21035_d(int i)
    {
        return ~i & 0xf;
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if (entityplayer.inventory.getCurrentItem() != null &&
            entityplayer.inventory.getCurrentItem().itemID ==
            Item.dyePowder.shiftedIndex){
            world.setBlockMetadataWithNotify(i, j, k, 
                                             0x0f -
                                             entityplayer.inventory.getCurrentItem().
                                             getItemDamage());
            entityplayer.inventory.decrStackSize(entityplayer.inventory.currentItem, 1); 
            return true;
        }
        return false;
    }
}
