package net.minecraft.src;

public class BEBlocks {
	
	public static BlockChiseled stoneBricks;
	public static BlockChiseled stoneBricksSquare;
	public static BlockChiseled stoneBricksSmall;
	public static BlockChiseled stoneBricksFancy;
	
	public static BlockRedSand redSand;
	public static BlockRedSandstone redSandstone;
	
	public static BlockMetaChiseled sandBricks;
	public static BlockMetaChiseled redSandBricks;
	
	public static BlockWaterPlant rushes;
	
	public static BlockWildgrass wildGrass;
	
	public static BlockRoots roots;
	
	public static BlockTorchOff torchOff;
	
	public static BlockLamp lamp;
	
	public static BlockLight light;
	
	public static BlockCryingObsidian cryingObsidian;
	
	public static BlockChair woodChair;
	public static BlockChair logChair;
	public static BlockChair cobbleChair;
	public static BlockChair stoneChair;
	public static BlockChair ironChair;
	public static BlockChair goldChair;
	public static BlockChair diamondChair;
	public static BlockChair lapisChair;
	public static BlockChair sandstoneChair;
	
	public static BlockTable woodTable;
	public static BlockTable logTable;
	public static BlockTable cobbleTable;
	public static BlockTable stoneTable;
	public static BlockTable ironTable;
	public static BlockTable goldTable;
	public static BlockTable diamondTable;
	public static BlockTable lapisTable;
	public static BlockTable sandstoneTable;
	
	public static BlockBerryBush berryBush;
	
	public static BlockPie raspberryPie;
	public static BlockPie blueBerryPie;
	public static BlockPie pumpkinPie;
	
	public static ModBlock radishCrop;
	public static ModBlock cornCrop;
	public static ModBlock peanutCrop;
	
	public static BlockAppleLeaves appleLeaves;
	public static BlockAppleSapling appleSapling;
	
	public static BlockRopeladder ropeLadder;
	
	public static BlockJackOLantern jackOLantern;

    public static BlockThatch weakThatch;
    public static BlockThatch thatch;

    public static BlockNet net;

    public static BlockQuicksand quickSand;

    public static BlockPistonBase launcher; 

	public static void init(){
		System.out.println(Ansi.BLACK+"Loading betaexpansion blocks..."+Ansi.RESET);
		
		ModBlock.setOffset(100);
		
		stoneBricks = new BlockChiseled(0, 23, "Stonebrick", 103);
		stoneBricks.texInit(16 + 128);
		stoneBricks.setStoneLike();
		
		stoneBricksSquare = new BlockChiseled(1, 23 + 64, "Square Stonebrick", 103);
		stoneBricksSquare.texInit(16 + 192);
		stoneBricksSquare.setStoneLike();
		
		stoneBricksSmall = new BlockChiseled(2, 23 + 128, "Small Stonebrick", 103);
		stoneBricksSmall.texInit(16 + 256);
		stoneBricksSmall.setStoneLike();
		
		stoneBricksFancy = new BlockChiseled(3, 23 + 192, "Fancy Stonebrick", 103);
		stoneBricksFancy.texInit(16 + 320);
		stoneBricksFancy.setStoneLike();
		
		redSand = new BlockRedSand(4, Util.tex(19, 7), Material.sand, "Red Sand");
		redSand.setSandLike();
		
		redSandstone = new BlockRedSandstone(5, Util.tex(16, 7), Material.rock, "Red Sandstone");
		redSandstone.setSandstoneLike();
		
		sandBricks = new BlockMetaChiseled(6, 24, "Sandstone Bricks", 4);
		sandBricks.texInit(Util.tex(24, 0), Util.tex(24, 1), Util.tex(24, 2), Util.tex(24, 3));
		sandBricks.setSandstoneLike();
		
		redSandBricks = new BlockMetaChiseled(7, 25, "Red Sandstone Bricks", 4);
		redSandBricks.texInit(Util.tex(24, 4), Util.tex(24, 5), Util.tex(24, 6), Util.tex(24, 7));
		redSandBricks.setSandstoneLike();
		
		wildGrass = new BlockWildgrass(8, Util.tex(19, 10), Material.plants, "Wild Grass");
		wildGrass.setGrassLike();
		wildGrass.setHardness(0.1f);
		
		rushes = new BlockWaterPlant(9, Util.tex(7, 18), Util.tex(6, 18), "Rushes");
		rushes.setHardness(0.3f);
		
		roots = new BlockRoots(10, Util.tex(8, 18), "Roots");
		roots.setHardness(0.2f);
		
		torchOff = new BlockTorchOff(11, Util.tex(8, 16), "Torch (out)");
		
		lamp = new BlockLamp(12, Util.tex(9, 16), "Glowstone Lantern");
		lamp.texInit(Util.tex(10, 16));
		
		light = new BlockLight(13);
		
		cryingObsidian = new BlockCryingObsidian(14, Util.tex(16, 6), Material.rock, "Crying Obsidian");
		cryingObsidian.setStoneLike();
		cryingObsidian.setHardness(10F).setResistance(2000F);
		
		woodChair = new BlockChair(15, Block.planks, "Wood Chair");
		woodChair.setWoodLike();
		logChair = new BlockChair(16, Block.wood, "Log Chair");
		logChair.setWoodLike();
		cobbleChair = new BlockChair(17, Block.cobblestone, "Cobblestone Chair");
		stoneChair = new BlockChair(18, Block.stone, "Stone Chair");
		ironChair = new BlockChair(19, Block.blockSteel, "Iron Chair");
		goldChair = new BlockChair(20, Block.blockGold, "Gold Chair");
		diamondChair = new BlockChair(21, Block.blockDiamond, "Diamond Chair");
		lapisChair = new BlockChair(22, Block.blockLapis, "Lapis Chair");
		sandstoneChair = new BlockChair(23, Block.sandStone, "Sandstone Chair");
		
		woodTable = new BlockTable(24, Block.planks, "Wood Table");
		woodTable.setWoodLike();
		logTable = new BlockTable(25, Block.wood, "Log Table");
		logTable.setWoodLike();
		cobbleTable = new BlockTable(26, Block.cobblestone, "Cobblestone Table");
		stoneTable = new BlockTable(27, Block.stone, "Stone Table");
		ironTable = new BlockTable(28, Block.blockSteel, "Iron Table");
		goldTable = new BlockTable(29, Block.blockGold, "Gold Table");
		diamondTable = new BlockTable(30, Block.blockDiamond, "Diamond Table");
		lapisTable = new BlockTable(31, Block.blockLapis, "Lapis Table");
		sandstoneTable = new BlockTable(32, Block.sandStone, "Sandstone Table");
		
		berryBush = new BlockBerryBush(33, Util.tex(10, 18), "Berry Bush");
		berryBush.texinit(Util.tex(11, 18), Util.tex(12, 18));
		
		raspberryPie = new BlockPie(34, Util.tex(0, 16), "Raspberry Pie");
		blueBerryPie = new BlockPie(35, Util.tex(0, 17), "Blueberry Pie");
		pumpkinPie = new BlockPie(36, Util.tex(0, 18), "Pumpkin Pie");
		
		radishCrop = new BlockRadishes(37, Util.tex(2,  19), "Radish Crop");
		cornCrop = new BlockCorn(38, Util.tex(9, 19), "Corn Crop");
		peanutCrop = new BlockPeanuts(39, Util.tex(0, 20), "Peanut Crop");
		
		appleLeaves = new BlockAppleLeaves(40 + 100, Util.tex(6, 19));
		appleSapling = new BlockAppleSapling(41 + 100, Util.tex(8, 20));
		
		ropeLadder = new BlockRopeladder(42, Util.tex(16, 15), "Rope Ladder");
		
		
		jackOLantern = new BlockJackOLantern(43, Util.tex(6, 7), "Jack-o'-lantern");
		jackOLantern.setHardness(1.0F).setStepSound(Block.soundWoodFootstep);
		
        weakThatch = new BlockThatch(44, Util.tex(17, 6), "Rush Thatch", true);
        thatch = new BlockThatch(45, Util.tex(17, 6), "Wheat Thatch", false);

        net = new BlockNet(46, Util.tex(18, 6), "Net");

        quickSand = new BlockQuicksand(47, Util.tex(20, 7), "Quicksand");
        
        launcher = new BlockPistonBase(48 + 100, 106, false, true);
        launcher.setBlockName("launcher");
		ModLoader.AddName(launcher, "Launcher");
		ModLoader.RegisterBlock(launcher);
        launcher.disableNeighborNotifyOnMetadataChange();

		BlockStone.texInit();
		Item.itemsList[Block.stone.blockID] = new ItemStone(Block.stone.blockID - 256);
		ModLoader.AddName(Item.itemsList[Block.stone.blockID], "Stone");
		ModLoader.AddName(Block.stone, "Stone");
		
		BlockCobblestone.texInit();
		Item.itemsList[Block.cobblestone.blockID] = new ItemCobblestone(Block.cobblestone.blockID - 256);
		ModLoader.AddName(Item.itemsList[Block.cobblestone.blockID], "Cobblestone");
		ModLoader.AddName(Block.cobblestone, "Cobblestone");
		
		BlockGrass.texInit(Util.tex(16, 9), Util.tex(16, 10), Util.tex(16, 11), Util.tex(16, 8));
		BlockDirt.texInit(Util.tex(16, 8));
		Item.itemsList[Block.dirt.blockID] = new ItemDirt(Block.dirt.blockID - 256);
		
		((BlockClay) Block.blockClay).texInit(Util.tex(23, 5));

        System.out.println("Calling vanilla block BEInit() method...");
        for (int i = 0; i < 255; i++){
            if (Block.blocksList[i] != null){
                Block.blocksList[i].BEInit();
            }
        }

		System.out.println(Ansi.GREEN+"Done."+Ansi.RESET);
	}
}
