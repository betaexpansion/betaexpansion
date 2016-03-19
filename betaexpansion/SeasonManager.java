package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class SeasonManager {

	public static boolean winter = false;
	public static int season;
	
	public static boolean needsColorShift = false;
	
	public static String worldName = "";
	
	public static void init(World world){
		worldName = world.worldInfo.getWorldName();
		season = Math.max(0, world.worldInfo.season - 1);
		needsColorShift = true;
	}
	
	public static void tick(Minecraft minecraft){
		if (minecraft.theWorld == null){
			return;
		}
		if (worldName.isEmpty() || !worldName.equals(minecraft.theWorld.worldInfo.getWorldName())){
			init(minecraft.theWorld);
		}
		
		season = minecraft.theWorld.worldInfo.season;
		if (season == -1){
			return;
		}
	
		if (minecraft.theWorld.worldInfo.getWorldTime() % 24000L == 10){
			minecraft.theWorld.worldInfo.day++;
			if (minecraft.theWorld.worldInfo.day >= Math.pow(2, minecraft.theWorld.worldInfo.timeScale)){
				season++;
				minecraft.theWorld.worldInfo.season++;
				minecraft.theWorld.worldInfo.day = 0;
				if (season == 2 || season == 0){
					needsColorShift = true;
				}
				if (season > 3){
					minecraft.theWorld.worldInfo.season = 0;
					season = 0;
					minecraft.theWorld.worldInfo.year++;
					minecraft.theWorld.worldInfo.setRaining(false);
					minecraft.theWorld.worldInfo.setRainTime(0);
				}
			}
		}
		
		if (minecraft.theWorld.worldInfo.winterMode || season == 3){
			minecraft.theWorld.worldInfo.setRaining(true);
			minecraft.theWorld.worldInfo.setRainTime(0x100);
			winter = true;
		} else{
			winter = false;
		}
		
		if (needsColorShift){
			needsColorShift = false;
			setColors(minecraft, minecraft.theWorld);
		}
	}
	
	private static void setColors(Minecraft minecraft, World world){
		if ((season == 2 || season == 3) && !world.worldInfo.winterMode){
	        ColorizerGrass.func_28181_a(minecraft.renderEngine.func_28149_a("/betaexpansion/misc/grasscolorAutumn.png"));
	        ColorizerFoliage.func_28152_a(minecraft.renderEngine.func_28149_a("/betaexpansion/misc/foliagecolorAutumn.png"));
		}
		else{
	        ColorizerGrass.func_28181_a(minecraft.renderEngine.func_28149_a("/misc/grasscolor.png"));
	        ColorizerFoliage.func_28152_a(minecraft.renderEngine.func_28149_a("/misc/foliagecolor.png"));
		}
	}
	
}
