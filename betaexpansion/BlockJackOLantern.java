package net.minecraft.src;

public class BlockJackOLantern extends BlockContainer {

	public int override;
	
	public BlockJackOLantern(int i, int j, String name) {
		super(i + 100,Material.pumpkin);
        isBlockContainer[i + 100] = true;
		this.blockIndexInTexture = j;
		this.setBlockName(name);
		ModLoader.AddName(this, name);
		ModLoader.RegisterBlock(this);
		override = -1;
	}
	
	public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(i == 1)
        {
            return blockIndexInTexture;
        }
        if(i == 0)
        {
            return blockIndexInTexture;
        }
		
        TileEntityPumpkin te = (TileEntityPumpkin) iblockaccess.getBlockTileEntity(i, j, k);
    	if (te == null || override == -1){
    		return blockIndexInTexture;
    	}
    	
    	int meta = iblockaccess.getBlockMetadata(i, j, k);
    	if(meta == 2 && l == 2)
        {
            return override;
        }
        if(meta == 3 && l == 5)
        {
            return override;
        }
        if(meta == 0 && l == 3)
        {
            return override;
        }
        if(meta == 1 && l == 4)
        {
            return override;
        } else
    	
    	return blockIndexInTexture;
    }
	
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        TileEntityPumpkin te = (TileEntityPumpkin) world.getBlockTileEntity(i, j, k);
        if (te == null){
        	return false;
        }
    	if (entityplayer.getCurrentEquippedItem() == null){
    		ItemStack item = te.getItem();
    		if (item.itemID > 0){
	        	world.entityJoinedWorld(new EntityItem(world, i + 0.5, j + 1, k + 0.5, te.getItem()));
	        	te.storedBlock = new ItemStack(0, 0, 0);
    		} else {
    			return false;
    		}
        } else{
        	if (te.storedBlock.itemID != 0){
        		return false;
        	}
        	ItemStack item = entityplayer.getCurrentEquippedItem();
        	te.storedBlock = new ItemStack(item.itemID, 1, item.getItemDamage());
        	if (item.stackSize == 1){
        		item = null;
        	} else{
        		item.stackSize--;
        	}
        	entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, item);
        }
    	return true;
    }
    
    @Override
    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);
        TileEntityPumpkin te = (TileEntityPumpkin) world.getBlockTileEntity(i, j, k);
        for (int iter = 0; iter < world.rand.nextInt(40); iter++){
        	te.cycleFace();
        }
        for (int iter = 0; iter < world.rand.nextInt(40); iter++){
        	te.cycleEyes();
        }
        int rand = world.rand.nextInt(3);
        if (rand == 2){
        	te.storedBlock = new ItemStack(Block.torchWood);
        } else if (rand == 1){
        	te.storedBlock = new ItemStack(Block.torchRedstoneActive);
        } else{
        	te.storedBlock = new ItemStack(0, 0, 0);
        }
    }
	
    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        int l = world.getBlockId(i, j, k);
        return (l == 0 || Block.blocksList[l].blockMaterial.getIsGroundCover()) && world.isBlockNormalCube(i, j - 1, k);
    }

	@Override
	protected TileEntity getBlockEntity() {
		return new TileEntityPumpkin();
	}
	
	@Override
	 public boolean renderAsNormalBlock()
    {
        return false;
    }
	
    public int getRenderType()
    {
        return BERender.jackOLanternRenderID;
    }

}
