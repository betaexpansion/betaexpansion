// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            Block, ItemStack, Item

public class FurnaceRecipes
{

    public static final FurnaceRecipes smelting()
    {
        return smeltingBase;
    }

    private FurnaceRecipes()
    {
        smeltingList = new HashMap<>();
        addSmelting(new ItemStack(Block.oreIron), new ItemStack(Item.ingotIron));
        addSmelting(new ItemStack(Block.oreGold), new ItemStack(Item.ingotGold));
        addSmelting(new ItemStack(Block.oreDiamond), new ItemStack(Item.diamond));
        addSmelting(new ItemStack(Block.sand), new ItemStack(Block.glass));
        addSmelting(new ItemStack(Item.porkRaw), new ItemStack(Item.porkCooked));
        addSmelting(new ItemStack(Item.fishRaw), new ItemStack(Item.fishCooked));
        addSmelting(new ItemStack(Item.clay), new ItemStack(Item.brick));
        addSmelting(new ItemStack(Block.cactus), new ItemStack(Item.dyePowder, 1, 2));
        addSmelting(new ItemStack(Block.wood), new ItemStack(Item.coal, 1, 1));
        
        for (int i = 0; i < 8; i++){
        	addSmelting(new ItemStack(Block.cobblestone, 1, i), new ItemStack(Block.stone, 1, i));
        }
    }

    public void addSmelting(ItemStack i, ItemStack itemstack)
    {
        smeltingList.put(i, itemstack);
    }

    public ItemStack getSmeltingResult(ItemStack i)
    {
        return smeltingList.get(i);
    }

    public HashMap<ItemStack, ItemStack> getSmeltingList()
    {
        return smeltingList;
    }

    private static final FurnaceRecipes smeltingBase = new FurnaceRecipes();
    private HashMap<ItemStack, ItemStack> smeltingList;

}
