package net.minecraft.src;

public class ModBlock extends Block {
	
	private static int offset;
	
	public ModBlock(int i, int j, Material material, String name){
		super(i + offset, j, material);
		this.blockIndexInTexture = j;
		this.setBlockName(name);
		ModLoader.AddName(this, name);
		ModLoader.RegisterBlock(this);
	}
	
	public static void setOffset(int offset){
		ModBlock.offset = offset;
	}
	
	public void setStoneLike(){
		setHardness(1.5F).setResistance(10F).setStepSound(soundStoneFootstep);
		
		Block[] old = ItemPickaxe.blocksEffectiveAgainst;
		Block[] b = new Block[old.length + 1];
		System.arraycopy(old, 0, b, 0, old.length);
		b[b.length - 1] = this;
		ItemPickaxe.blocksEffectiveAgainst = b;
		
		Item.itemsList[blockID] = new ItemStone(blockID - 256);
	}
	
	public void setWoodLike(){
		setHardness(2.0F);
		setResistance(5F);
		setStepSound(soundWoodFootstep); 
		
		Block[] old = ItemAxe.blocksEffectiveAgainst;
		Block[] b = new Block[old.length + 1];
		System.arraycopy(old, 0, b, 0, old.length);
		b[b.length - 1] = this;
		ItemAxe.blocksEffectiveAgainst = b;
	}
	
	public void setSandLike(){
		setHardness(0.5F).setStepSound(soundSandFootstep);
		
		Block[] old = ItemSpade.blocksEffectiveAgainst;
		Block[] b = new Block[old.length + 1];
		System.arraycopy(old, 0, b, 0, old.length);
		b[b.length - 1] = this;
		ItemSpade.blocksEffectiveAgainst = b;
	}
	
	public void setSandstoneLike(){
		setStoneLike();
		setHardness(0.8F);
		
		Item.itemsList[blockID] = new ItemStone(blockID - 256);
	}
	
	public void setGrassLike(){
		setHardness(0.0F).setStepSound(soundGrassFootstep);
	}

}
