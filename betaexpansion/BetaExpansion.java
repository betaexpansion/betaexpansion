package net.minecraft.src;

public class BetaExpansion {
	
	public static String vn = "1.2_dev";
	public static boolean debug = false;

	public static void init(){
		System.out.println(Ansi.BLUE+"betaexpansion version "+vn+Ansi.RESET);
		
		BEBlocks.init();
		BEItems.init();
		
		BERecipes.init();
		
		BERender.init();
		
		BEUpdate.init();
		System.out.println(Ansi.GREEN+"betaexpansion initialization successful!"+Ansi.RESET);
	}
	
}
