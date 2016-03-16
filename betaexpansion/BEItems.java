package net.minecraft.src;

public class BEItems {
	
	public static final int offset = 1500;
	
	public static ItemChisel chisel;
	
	public static ItemHatchet hatchetWood;
	public static ItemHatchet hatchetStone;
	public static ItemHatchet hatchetIron;
	public static ItemHatchet hatchetEmerald;
	public static ItemHatchet hatchetGold;
	public static ItemHatchet hatchetObsidian;
	
	public static ItemTrowel trowelWood;
	public static ItemTrowel trowelStone;
	public static ItemTrowel trowelIron;
	public static ItemTrowel trowelEmerald;
	public static ItemTrowel trowelGold;
	public static ItemTrowel trowelObsidian;
	
	public static ItemBoosterCart boosterMinecart;
	
	public static ItemModFood blueBerry;
	public static ItemModFood redBerry;
	
	public static ModItem dough;
	
	public static ItemPlantableFood radish;
	public static ItemPlantableFood corn;
	public static ItemPlantableFood peanuts;
	
	public static ItemModFood popcorn;
	
	public static ItemSpyglass spyglass;

    public static ModItem pillow;

    public static ModItem rushStock;

    public static ModItem dart;

	public static void init(){
		System.out.println(Ansi.WHITE+"Loading betaexpansion items..."+Ansi.RESET);
		
		chisel = new ItemChisel(0 + offset, 2, EnumToolMaterial.IRON, 17, 2, "Chisel");
		
		hatchetWood = new ItemHatchet(1 + offset, 0, EnumToolMaterial.SMALL_WOOD, 16, 1, "Wood Hatchet");
		hatchetStone = new ItemHatchet(2 + offset, 0, EnumToolMaterial.SMALL_STONE, 17, 1, "Stone Hatchet");
		hatchetIron = new ItemHatchet(3 + offset, 0, EnumToolMaterial.SMALL_IRON, 18, 1, "Iron Hatchet");
		hatchetEmerald = new ItemHatchet(4 + offset, 0, EnumToolMaterial.SMALL_EMERALD, 19, 1, "Diamond Hatchet");
		hatchetGold = new ItemHatchet(5 + offset, 0, EnumToolMaterial.SMALL_GOLD, 20, 1, "Gold Hatchet");
		hatchetObsidian = new ItemHatchet(6 + offset, 0, EnumToolMaterial.SMALL_OBSIDIAN, 21, 1, "Obsidian Hatchet");
		
		trowelWood = new ItemTrowel(7 + offset, 0, EnumToolMaterial.SMALL_WOOD, 16, 0, "Wood Trowel");
		trowelStone = new ItemTrowel(8 + offset, 0, EnumToolMaterial.SMALL_STONE, 17, 0, "Stone Trowel");
		trowelIron = new ItemTrowel(9 + offset, 0, EnumToolMaterial.SMALL_IRON, 18, 0, "Iron Trowel");
		trowelEmerald = new ItemTrowel(10 + offset, 0, EnumToolMaterial.SMALL_EMERALD, 19, 0, "Diamond Trowel");
		trowelGold = new ItemTrowel(11 + offset, 0, EnumToolMaterial.SMALL_GOLD, 20, 0, "Gold Trowel");
		trowelObsidian = new ItemTrowel(11 + offset, 0, EnumToolMaterial.SMALL_OBSIDIAN, 21, 0, "Obsidian Trowel");
		
		boosterMinecart = new ItemBoosterCart(12 + offset, 7, 8, "Booster Minecart");
		
		blueBerry = new ItemModFood(13 + offset, 0, 16, "Blueberry", 1, false, 8);
		redBerry = new ItemModFood(14 + offset, 1, 16, "Raspberry", 1, false, 8);
		
		dough = new ModItem(15 + offset, 8, 16, "Dough");
		
		radish = new ItemPlantableFood(16 + offset, 2, 16, "Radish", 2, false, 4, BEBlocks.radishCrop.blockID);
		corn = new ItemPlantableFood(17 + offset, 3, 16, "Corn", 2, false, 4, BEBlocks.cornCrop.blockID);
		peanuts = new ItemPlantableFood(18 + offset, 5, 16, "Peanuts", 1, false, 16, BEBlocks.peanutCrop.blockID);
		
		popcorn = new ItemModFood(19 + offset, 4, 16, "Popcorn", 1, false, 16);
		
		spyglass = new ItemSpyglass(20 + offset, 19, 2, "Spyglass");
		
        pillow = new ModItem(21 + offset, 0, 0, "Pillow");

        rushStock = new ModItem(22 + offset, 0, 0, "Rush Stock");

        dart = new ModItem(23 + offset, 0, 0, "Dart");

		System.out.println(Ansi.GREEN+"Done."+Ansi.RESET);
	}

}
