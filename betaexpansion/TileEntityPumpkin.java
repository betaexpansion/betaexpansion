package net.minecraft.src;

public class TileEntityPumpkin extends TileEntity {

	public TileEntityPumpkin(){
		storedBlock = new ItemStack(0, 0, 0);
		face = -1;
		eyes = -1;
	}
	
	public ItemStack storedBlock;
	
	public int face;
	public int eyes;
	
	public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        
        nbttagcompound.setTag("storedBlock", storedBlock.writeToNBT(new NBTTagCompound()));
        nbttagcompound.setInteger("face", face);
        nbttagcompound.setInteger("eyes", eyes);
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
    	super.readFromNBT(nbttagcompound);
    	
    	//storedBlock = nbttagcompound.getInteger("storedBlock");
    	storedBlock = new ItemStack(0, 0, 0);
    	storedBlock.readFromNBT(nbttagcompound.getCompoundTag("storedBlock"));
    	face = nbttagcompound.getInteger("face");
    	eyes = nbttagcompound.getInteger("eyes");
    }
    
    public int getFace(){
    	if (face == -1){
    		return -1;
    	}
    	int y = 21;
    	if (storedBlock.itemID == Block.torchWood.blockID){
    		y = 22;
    	} else if (storedBlock.itemID == Block.torchRedstoneActive.blockID){
    		y = 23;
    	}
    	return Util.tex(face, y);
    }
    
    public ItemStack getItem(){
    	return new ItemStack(storedBlock.itemID, 1, 0);
    }
    
    public int getEyes(){
    	if (eyes == -1){
    		return -1;
    	}
    	int y = 21;
    	if (storedBlock.itemID == Block.torchWood.blockID){
    		y = 22;
    	} else if (storedBlock.itemID == Block.torchRedstoneActive.blockID){
    		y = 23;
    	}
    	return Util.tex(eyes + 4, y);
    }
	
    public void cycleFace(){
    	face++;
    	if (face > 3){
    		face = -1;
    	}
    }
    
    public void cycleEyes(){
    	eyes++;
    	if (eyes > 3){
    		eyes = -1;
    	}
    }
}
