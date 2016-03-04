// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


public enum EnumToolMaterial
{
    WOOD("WOOD", 0, 0, 59, 2.0F, 0),
    STONE("STONE", 1, 1, 131, 4F, 1),
    IRON("IRON", 2, 2, 250, 6F, 2),
    EMERALD("EMERALD", 3, 3, 1561, 8F, 3),
    GOLD("GOLD", 4, 2, 64, 12F, 2),
    OBSIDIAN("OBSIDIAN", 5, 2, 1561 * 2, 6F, 2),
    
    SMALL_WOOD("SMALL_WOOD", 6, 0, 59 / 2, 2.0F, 0),
    SMALL_STONE("SMALL_STONE", 7, 1, 131 / 2, 4F, 1),
    SMALL_IRON("SMALL_IRON", 8, 2, 250 / 2, 6F, 2),
    SMALL_EMERALD("SMALL_EMERALD", 9, 3, 1561 / 2, 8F, 3),
    SMALL_GOLD("SMALL_GOLD", 10, 2, 64 / 2, 12F, 2),
    SMALL_OBSIDIAN("SMALL_OBSIDIAN", 11, 2, 1561, 6F, 2);

/*
    public static EnumToolMaterial[] values()
    {
        return (EnumToolMaterial[])field_21209_j.clone();
    }

    public static EnumToolMaterial valueOf(String s)
    {
        return (EnumToolMaterial)Enum.valueOf(net.minecraft.src.EnumToolMaterial.class, s);
    }
*/
    private EnumToolMaterial(String s, int i, int j, int k, float f, int l)
    {
//        super(s, i);
        harvestLevel = j;
        maxUses = k;
        efficiencyOnProperMaterial = f;
        damageVsEntity = l;
    }

    public int getMaxUses()
    {
        return maxUses;
    }

    public float getEfficiencyOnProperMaterial()
    {
        return efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity()
    {
        return damageVsEntity;
    }

    public int getHarvestLevel()
    {
        return harvestLevel;
    }
/*
    public static final EnumToolMaterial WOOD;
    public static final EnumToolMaterial STONE;
    public static final EnumToolMaterial IRON;
    public static final EnumToolMaterial EMERALD;
    public static final EnumToolMaterial GOLD;
*/
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private static final EnumToolMaterial field_21209_j[]; /* synthetic field */

    static 
    {
/*
        WOOD = new EnumToolMaterial("WOOD", 0, 0, 59, 2.0F, 0);
        STONE = new EnumToolMaterial("STONE", 1, 1, 131, 4F, 1);
        IRON = new EnumToolMaterial("IRON", 2, 2, 250, 6F, 2);
        EMERALD = new EnumToolMaterial("EMERALD", 3, 3, 1561, 8F, 3);
        GOLD = new EnumToolMaterial("GOLD", 4, 0, 32, 12F, 0);
*/
        field_21209_j = (new EnumToolMaterial[] {
            WOOD, STONE, IRON, EMERALD, GOLD, OBSIDIAN, 
            SMALL_WOOD, SMALL_STONE, SMALL_IRON, SMALL_EMERALD, SMALL_GOLD, SMALL_OBSIDIAN
        });
    }
}
