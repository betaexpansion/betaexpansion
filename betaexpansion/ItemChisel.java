package net.minecraft.src;

public class ItemChisel extends ItemModTool {

	protected ItemChisel(int i, int j, EnumToolMaterial enumtoolmaterial, int tex, int tey, String name) {
		super(i, j, enumtoolmaterial, blocksEffectiveAgainst, tex, tey, name);
	}

	@Override
    public void breakBlockWith(int i, int j, int k, int id, int meta, World world, EntityPlayer entityplayer){

		Block b = Block.blocksList[id];
		if (b == null){
			return;
		}

		if (b instanceof BlockChiseled){
			((BlockChiseled) b).chiselBlock(i, j, k, world, meta);
		} else if (b instanceof BlockMetaChiseled){
			((BlockMetaChiseled) b).chiselBlock(i, j, k, world, meta);
		} else if (b instanceof BlockStone){
			((BlockStone) b).chiselBlock(i, j, k, world, meta);	
		} else if (b instanceof BlockRedSandstone){
			((BlockRedSandstone) b).chiselBlock(i, j, k, world, meta);	
		} else if (b instanceof BlockSandStone){
			((BlockSandStone) b).chiselBlock(i, j, k, world, meta);	
		}
    }
	
	@Override
	public boolean canHarvestBlock(Block block)
    {
		for (Block b : blocksEffectiveAgainst){
			if (b.blockID == block.blockID){
				return true;
			}
		}
		return false;
    }
	
	public static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
        	Block.stone, Block.sandStone, BEBlocks.stoneBricks, BEBlocks.stoneBricksSquare, BEBlocks.stoneBricksSmall, 
        	BEBlocks.stoneBricksFancy, BEBlocks.redSandstone, BEBlocks.sandBricks, BEBlocks.redSandBricks
        });
    }

}
