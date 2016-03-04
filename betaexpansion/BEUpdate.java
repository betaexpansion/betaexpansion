package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class BEUpdate {

	private static Minecraft minecraft;
	
	public static void init(){
		System.out.println(Ansi.WHITE+"Setting up betaexpansion update loop"+Ansi.RESET);
		minecraft = ModLoader.getMinecraftInstance();
		System.out.println(Ansi.GREEN+"Done."+Ansi.RESET);
	}
	
	public static void tick(){
		if (minecraft.isGamePaused){
			return;
		}
		SeasonManager.tick(minecraft);
	
		
		if (minecraft.thePlayer == null){
			return;
		}
		
		frostbite();
		dynamicLight();
		
	}
	
	private static void dynamicLight(){
		EntityPlayer player = minecraft.thePlayer;
		World world = minecraft.theWorld;
		
		boolean hasLamp = minecraft.thePlayer.getCurrentEquippedItem() != null &&
					      minecraft.thePlayer.getCurrentEquippedItem().itemID == BEBlocks.lamp.blockID;
		
		for (int i = -5; i < 6; i++){
			for (int j = -5; j < 6; j++){
				for (int k = -5; k < 6; k++){
					 if (world.getBlockId(i + (int) player.posX, j + (int) player.posY, k + (int) player.posZ) == 
							   BEBlocks.light.blockID){
						 if (Util.distanceSquared(i, j, k, 0, 0, 0) > 4 || !hasLamp){
							 world.setBlockWithNotify(i + (int) player.posX, j + (int) player.posY, k + (int) player.posZ, 0);
						 }
					 }
				}
			}
		}
		
		if (!hasLamp){
			return;
		}
		
		if (world.rand.nextInt(100) == 0){
			world.spawnParticle("reddust", player.posX + world.rand.nextFloat() - world.rand.nextFloat(), 
								player.posY - 0.5, player.posZ + world.rand.nextFloat() - world.rand.nextFloat(), 
							    255f / 255f, 193f / 255f, 66f / 255f);
		}
		
		int x = 0;
		int y = 0;
		int z = 0;
		int dist = 0x10000;
		for (int i = -1; i < 2; i++){
			for (int j = -1; j < 2; j++){
				for (int k = -1; k < 2; k++){
					if (world.getBlockId(i + (int) player.posX, j + (int) player.posY, k + (int) player.posZ) == 0){
						if (Util.distanceSquared(0, 0, 0, i, j, k) < dist){
							x = i;
							y = j;
							z = k;
							dist = Util.distanceSquared(0, 0, 0, x, y, z);
						}
					} else if (world.getBlockId(i + (int) player.posX, j + (int) player.posY, k + (int) player.posZ) == 
							   BEBlocks.light.blockID){
						return;
					}
				}
			}
		}
		if (dist == 0x10000){
			return;
		}
		
		world.setBlockWithNotify(x + (int) player.posX, y + (int) player.posY, z + (int) player.posZ, 
								 BEBlocks.light.blockID);
		
	}
	
	private static void frostbite(){
		if (SeasonManager.winter && Config.FROSTBITE){
			int count = 0;
			if (minecraft.thePlayer.inventory.armorItemInSlot(0) != null){
				if (minecraft.thePlayer.inventory.armorItemInSlot(0).itemID == Item.bootsLeather.shiftedIndex){
					count += 4;
				}
			}
			if (minecraft.thePlayer.inventory.armorItemInSlot(1) != null){
				if (minecraft.thePlayer.inventory.armorItemInSlot(1).itemID == Item.legsLeather.shiftedIndex){
					count += 7;
				}
			}
			
			if (minecraft.thePlayer.inventory.armorItemInSlot(2) != null){
				if (minecraft.thePlayer.inventory.armorItemInSlot(2).itemID == Item.plateLeather.shiftedIndex){
					count += 8;
				}
			}
			
			if (minecraft.thePlayer.inventory.armorItemInSlot(3) != null){
				if (minecraft.thePlayer.inventory.armorItemInSlot(3).itemID == Item.helmetLeather.shiftedIndex){
					count += 5;
				}
			}
			
			if (count <= Config.FROSTBITE_DIFFICULTY){
				if (!minecraft.theWorld.canBlockSeeTheSky((int) Math.round(minecraft.thePlayer.posX), (int) Math.round(minecraft.thePlayer.posY), (int) Math.round(minecraft.thePlayer.posZ))){
					return;
				}
				if (minecraft.theWorld.rand.nextInt(1000) == 0){
					minecraft.thePlayer.attackEntityFrom(null, 1);
				}
			}
		}
	}
	
}
