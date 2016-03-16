// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, EntityPlayer, EntityLiving, MathHelper, 
//            World, Block, Vec3D, AxisAlignedBB, 
//            MovingObjectPosition, NBTTagCompound, ItemStack, Item, 
//            InventoryPlayer

public class EntityArrow extends EntityProjectile
{

    public EntityArrow(World world)
    {
        super(world);
    }

    public EntityArrow(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    public EntityArrow(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
        if (entityliving instanceof EntityPlayer)
        {
            item = new ItemStack(Item.arrow, 1);
        }
    }
}
