package net.minecraft.src;

public class ItemTrowel extends ItemModTool {

	protected ItemTrowel(int i, int j, EnumToolMaterial enumtoolmaterial, int tex, int tey, String name) {
		super(i, j, enumtoolmaterial, blocksEffectiveAgainst, tex, tey, name);
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockId(i, j, k);
        int j1 = world.getBlockId(i, j + 1, k);
        if(l != 0 && j1 == 0 && i1 == Block.grass.blockID || i1 == Block.dirt.blockID)
        {
            Block block = Block.tilledField;
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.stepSound.func_1145_d(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
            if(world.multiplayerWorld)
            {
                return true;
            } else
            {
                world.setBlockWithNotify(i, j, k, block.blockID);
                itemstack.damageItem(2, entityplayer);
                return true;
            }
        } else
        {
            return false;
        }
    }
	
	 public static Block blocksEffectiveAgainst[];

	    static 
	    {
	        blocksEffectiveAgainst = (new Block[] {
	            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField
	        });
	    }

}
