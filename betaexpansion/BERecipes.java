package net.minecraft.src;

public class BERecipes {
	
	public static void init(){
		System.out.println(Ansi.WHITE+"Loading betaexpansion recipes..."+Ansi.RESET);
		
		ModLoader.AddRecipe(new ItemStack(Block.stone, 4), new Object[] {"SS", 
			 														  "SS", 
			 											'S', Block.stone});
		
		ModLoader.AddRecipe(new ItemStack(Block.cobblestone, 4), new Object[] {"SS", 
																			"SS", 
															  'S', Block.cobblestone});
		
		ModLoader.AddRecipe(new ItemStack(Block.dirt, 4), new Object[] {"SS", 
																	 "SS", 
													   'S', Block.dirt});
		
		ModLoader.AddRecipe(new ItemStack(BEBlocks.redSandstone), new Object[] {"SS", 
																				"SS",
																  'S', BEBlocks.redSand});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.chisel), new Object[] {"  I", 
																		 " L ", 
																		 "S  ", 
														   'I', Item.ingotIron, 'L', Item.leather, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.hatchetWood), new Object[] {"MM", 
			   																  "S ",
			 													'M', Block.planks, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.hatchetStone), new Object[] {"MM", 
																			   "S ",
																 'M', Block.cobblestone, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.hatchetIron), new Object[] {"MM", 
			   																  "S ",
																'M', Item.ingotIron, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.hatchetEmerald), new Object[] {"MM", 
																				 "S ",
																	'M', Item.diamond, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.hatchetGold), new Object[] {"MM", 
			   																  "S ",
																'M', Item.ingotGold, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.trowelWood), new Object[] {" M", 
																			  "S ",
																'M', Block.planks, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.trowelStone), new Object[] {" M", 
																			   "S ",
																 'M', Block.cobblestone, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.trowelIron), new Object[] {" M", 
																			  "S ",
																'M', Item.ingotIron, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.trowelEmerald), new Object[] {" M", 
																			 	 "S ",
																   'M', Item.diamond, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.trowelGold), new Object[] {" M", 
																			  "S ",
																'M', Item.ingotGold, 'S', Item.stick});
		
		ModLoader.AddRecipe(new ItemStack(BEBlocks.lamp), new Object[] {" I ",
																	    "GDG",
																	    " S ", 
														  'I', Item.ingotIron, 'G', Block.glass, 'D', Item.lightStoneDust, 'S', Block.stairSingle});
		
		ModLoader.AddRecipe(new ItemStack(BEBlocks.cryingObsidian, 1), new Object[] {" O ","OLO"," O ", 'O', Block.obsidian, 'L', Block.blockLapis});
		
		ModLoader.AddRecipe(new ItemStack(BEBlocks.woodChair, 1), new Object[]{"W  ", "WWW", "W W", 'W', Block.planks});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.logChair, 1), new Object[] {"W  ","WWW","W W", 'W', Block.wood});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.cobbleChair, 1), new Object[] {"S  ","SSS","S S", 'S', Block.cobblestone});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.stoneChair, 1), new Object[] {"S  ","SSS","S S", 'S', Block.stone});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.ironChair, 1), new Object[] {"S  ","SSS","S S", 'S', Block.blockSteel});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.goldChair, 1), new Object[] {"S  ","SSS","S S", 'S', Block.blockGold});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.lapisChair, 1), new Object[] {"S  ","SSS","S S", 'S', Block.blockLapis});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.diamondChair, 1), new Object[] {"S  ","SSS","S S", 'S', Block.blockDiamond});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneChair, 1), new Object[] {"S  ","SSS","S S", 'S', Block.sandStone});
		
		ModLoader.AddRecipe(new ItemStack(BEBlocks.woodTable, 1), new Object[] {"WWW","W W", 'W', Block.planks});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.logTable, 1), new Object[] {"WWW","W W", 'W', Block.wood});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.cobbleTable, 1), new Object[] {"SSS","S S", 'S', Block.cobblestone});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.ironTable, 1), new Object[] {"S  ","SSS","S S", 'S', Block.blockSteel});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.goldTable, 1), new Object[] {"S  ","SSS","S S", 'S', Block.blockGold});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.lapisTable, 1), new Object[] {"S  ","SSS","S S", 'S', Block.blockLapis});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.diamondTable, 1), new Object[] {"S  ","SSS","S S", 'S', Block.blockDiamond});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneTable, 1), new Object[] {"S  ","SSS","S S", 'S', Block.sandStone});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.boosterMinecart), new Object[] {"I", "M", 'I', Block.blockSteel, 'M', Item.minecartEmpty});
		
		ModLoader.AddRecipe(new ItemStack(BEItems.dough, 1), new Object[] { "WW", Character.valueOf('W'), Item.wheat});
		ModLoader.AddSmelting(BEItems.dough.shiftedIndex, new ItemStack(Item.bread, 1));
		
		ModLoader.AddRecipe(new ItemStack(BEBlocks.blueBerryPie, 1), new Object[] {"WWW","BSB","WWW", 'W', BEItems.dough, 'M', Item.bucketMilk, 'B', BEItems.blueBerry, 'S', Item.sugar});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.raspberryPie, 1), new Object[] {"WWW","BSB","WWW", 'W', BEItems.dough, 'M', Item.bucketMilk, 'B', BEItems.redBerry, 'S', Item.sugar});
		ModLoader.AddRecipe(new ItemStack(BEBlocks.pumpkinPie, 1), new Object[] {"WWW","BSB","WWW", 'W', BEItems.dough, 'M', Item.bucketMilk, 'B', Block.pumpkin, 'S', Item.sugar});
		ModLoader.AddRecipe(new ItemStack(Item.cake, 1), new Object[] {
            "AAA", "BEB", "CCC", Character.valueOf('A'), Item.bucketMilk, Character.valueOf('B'), Item.sugar, Character.valueOf('C'), BEItems.dough, Character.valueOf('E'), 
            Item.egg
        });
		
        ModLoader.AddRecipe(new ItemStack(BEBlocks.weakThatch, 4), new Object[] {
            "RR", "RR", Character.valueOf('R'), BEItems.rushStock
 });
        
ModLoader.AddRecipe(new ItemStack(BEBlocks.thatch, 4), new Object[] {
            "RR", "RR", Character.valueOf('R'), Item.wheat
 });
		
		ModLoader.AddSmelting(BEItems.corn.shiftedIndex, new ItemStack(BEItems.popcorn, 1));
		
		ModLoader.AddShapelessRecipe(new ItemStack(BEBlocks.appleSapling), new Object[]{Item.appleRed});
		
        ModLoader.AddShapelessRecipe(new ItemStack(Item.silk, 4), new Object[]{Block.cloth});
	
        ModLoader.AddRecipe(new ItemStack(BEBlocks.launcher, 1),
        new Object[] {"O", "P", 'O', BEItems.pillow, 'P', Block.pistonBase});

		ModLoader.AddRecipe(new ItemStack(BEItems.spyglass, 1), new Object[] {"IGI","W W","IGI", 'W', Block.planks, 'I', Item.ingotIron, 'G', Block.glass});
		
        ModLoader.AddRecipe(new ItemStack(BEBlocks.ropeLadder, 4), new Object[] {"S S","SWS","S S", 'S', Item.silk, 'W', Item.stick});

        ModLoader.AddRecipe(new ItemStack(BEItems.pillow, 1), new Object[] {"FF",
        "FF", 'F', Item.feather});

        ModLoader.AddRecipe(new ItemStack(BEItems.dart, 8), new Object[] {" F",
        "R ", 'F', Item.flint, 'R', BEItems.rushStock});

        CraftingManager.getInstance().addRecipe(new ItemStack(Item.bed, 1), new Object[] {
            "P##", "XIX", Character.valueOf('#'), Block.cloth, Character.valueOf('X'), Block.planks
        , 'P', BEItems.pillow, 'I', Item.ingotIron});

        ModLoader.AddRecipe(new ItemStack(BEBlocks.net, 2), new Object[]{
        "R R", " R ", "R R", 'R', BEItems.rushStock});

		if (BetaExpansion.debug){
			System.out.println("Loading betaexpansion debug recipes...");
			ModLoader.AddShapelessRecipe(new ItemStack(Block.pistonBase, 64), new Object[] {Block.dirt});
		}
		
		System.out.println(Ansi.GREEN+"Done."+Ansi.RESET);
	}

}
