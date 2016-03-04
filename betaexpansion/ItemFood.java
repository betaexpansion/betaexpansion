// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, EntityPlayer, World

public class ItemFood extends Item
{

    public ItemFood(int i, int j, boolean flag)
    {
        super(i);
        healAmount = j;
        isWolfsFavoriteMeat = flag;
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if ((entityplayer.health != 20 || entityplayer.isSneaking()) && (cooldown == 0 || (itemstack.getItem().shiftedIndex != cooldownid[0] && itemstack.getItem().shiftedIndex != cooldownid[1]))){
	    	itemstack.stackSize--;
	        entityplayer.heal(healAmount);
	        cooldown = 600;
	        cooldownid[1] = cooldownid[0];
	        if (itemstack.getItem().maxStackSize != 1){
	        	cooldownid[0] = itemstack.getItem().shiftedIndex;
	        }
        }
        return itemstack;
    }

    public int getHealAmount()
    {
        return healAmount;
    }

    public boolean getIsWolfsFavoriteMeat()
    {
        return isWolfsFavoriteMeat;
    }
    
    public static int cooldown = 0;
    public static int[] cooldownid = new int[2];

    private int healAmount;
    private boolean isWolfsFavoriteMeat;
}
