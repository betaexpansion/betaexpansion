package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class BERender {
	
	public static int oreRenderID;
	public static int rushesRenderID;
	public static int lampRenderID;
	public static int tableRenderID;
	public static int chairRenderID;
	public static int jackOLanternRenderID;
	
	public static void init(){
		System.out.println(Ansi.WHITE+"Loading BetaExpansion rendering..."+Ansi.RESET);
		
		oreRenderID = ModLoader.getUniqueBlockModelID(null, false);
		rushesRenderID = ModLoader.getUniqueBlockModelID(null, false);
		oreRenderID = ModLoader.getUniqueBlockModelID(null, false);
		tableRenderID = ModLoader.getUniqueBlockModelID(null, false);
		chairRenderID = ModLoader.getUniqueBlockModelID(null, false);
		jackOLanternRenderID = ModLoader.getUniqueBlockModelID(null, false);
		
		System.out.println(Ansi.GREEN+"Done."+Ansi.RESET);
	}
	
	public static boolean renderJackOLantern(Block block, int i, int j, int k, RenderBlocks renderblocks, IBlockAccess blockAccess)
	{
		TileEntityPumpkin te = (TileEntityPumpkin) blockAccess.getBlockTileEntity(i, j, k);
		if (te == null){
			return false;
		}
		BlockJackOLantern jl = (BlockJackOLantern) block;
		jl.override = te.getEyes();
		renderblocks.renderStandardBlock(jl, i, j, k);
		jl.override = te.getFace();
		renderblocks.renderStandardBlock(jl, i, j, k);
		jl.override = -1;
		
		return true;
	}
	
	public static boolean renderBlockChair(Block block, int i, int j, int k, RenderBlocks renderblocks, IBlockAccess blockAccess)
	{
		int meta = blockAccess.getBlockMetadata(i, j, k);
		if (meta == 2){
			block.setBlockBounds(0f, 8f/ 16f, 1f - (1f / 8f), 1f, 1, 1f);
			renderblocks.renderStandardBlock(block, i, j, k);
		} else if (meta == 3){
			block.setBlockBounds(0f, 8f/ 16f, 0f, 1f, 1, (1f / 8f));
			renderblocks.renderStandardBlock(block, i, j, k);
		} else if (meta == 4){
			block.setBlockBounds(1f - (1f / 8f), 8f/ 16f, 0f, 1f, 1, 1f);
			renderblocks.renderStandardBlock(block, i, j, k);
		} else if (meta == 5){
			block.setBlockBounds(0f, 8f/ 16f, 0f, 1f / 8f, 1, 1f);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		block.setBlockBounds(0f, 6f/ 16f, 0f, 1f, 8f /16f, 1f);
		renderblocks.renderStandardBlock(block, i, j, k);
		

		
		block.setBlockBounds(0f, 0f, 0, 1f / 8f, 6f / 16f, 1f / 8f);
		renderblocks.renderStandardBlock(block, i, j, k);
		
		block.setBlockBounds(7f / 8f, 0f, 0, 1f, 6f / 16f, 1f / 8f);
		renderblocks.renderStandardBlock(block, i, j, k);
		
		block.setBlockBounds(7f / 8f, 0f, 7f / 8f, 1f, 6f / 16f, 1f);
		renderblocks.renderStandardBlock(block, i, j, k);
		
		block.setBlockBounds(0f, 0f, 7f / 8f, 1f / 8f, 6f / 16f, 1f);
		renderblocks.renderStandardBlock(block, i, j, k);
		
		block.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
		
		return true;
	}
	
	public static boolean renderChairInv(Block block, RenderBlocks renderblocks)
	{
		block.setBlockBounds(0f, 6f/ 16f, 0f, 1f, 8f /16f, 1f);
		renderBlockInInv(block, renderblocks);
		
		block.setBlockBounds(0f, 8f/ 16f, 0f, 1f, 1, (1f / 8f));
		renderBlockInInv(block, renderblocks);
		
		block.setBlockBounds(0f, 0f, 0, 1f / 8f, 6f / 16f, 1f / 8f);
		renderBlockInInv(block, renderblocks);
		
		block.setBlockBounds(7f / 8f, 0f, 0, 1f, 6f / 16f, 1f / 8f);
		renderBlockInInv(block, renderblocks);
		
		block.setBlockBounds(7f / 8f, 0f, 7f / 8f, 1f, 6f / 16f, 1f);
		renderBlockInInv(block, renderblocks);
		
		block.setBlockBounds(0f, 0f, 7f / 8f, 1f / 8f, 6f / 16f, 1f);
		renderBlockInInv(block, renderblocks);
		
		block.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
		
		return true;
	}
	
	public static boolean renderBlockTable(Block block, int i, int j, int k, RenderBlocks renderblocks, IBlockAccess blockAccess)
	{
		block.setBlockBounds(0f, 14f / 16f, 0f, 1f, 1f, 1f);
		renderblocks.renderStandardBlock(block, i, j, k);
		
		boolean n = !(Block.blocksList[blockAccess.getBlockId(i, j, k + 1)] instanceof BlockTable);
		boolean s = !(Block.blocksList[blockAccess.getBlockId(i, j, k - 1)] instanceof BlockTable);
		boolean e = !(Block.blocksList[blockAccess.getBlockId(i + 1, j, k)] instanceof BlockTable);
		boolean w = !(Block.blocksList[blockAccess.getBlockId(i - 1, j, k)] instanceof BlockTable);
		
		if (n && w){
			block.setBlockBounds(0f, 0f, 14f / 16f, 1f / 8f, 14f / 16f, 1f);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		if (n && e){
			block.setBlockBounds(7f / 8f, 0f, 14f / 16f, 1f, 14f / 16f, 1f);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		if (s && w){
			block.setBlockBounds(0f, 0f, 0f, 1f / 8f, 14f / 16f, 1f / 8f);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		if (s && e){
			block.setBlockBounds(7f / 8f, 0f, 0f, 1f, 14f / 16f, 1f / 8f);
			renderblocks.renderStandardBlock(block, i, j, k);
		}
		
		block.setBlockBounds(0f, 0f, 0f, 1f, 1, 1f);
		
		return true;
	}
	
	public static boolean renderTableInv(Block block, RenderBlocks renderblocks)
	{

		block.setBlockBounds(0f, 14f / 16f, 0f, 1f, 1f, 1f);
        renderBlockInInv(block, renderblocks);

		block.setBlockBounds(0f, 0f, 14f / 16f, 1f / 8f, 14f / 16f, 1f);
        renderBlockInInv(block, renderblocks);
        
		block.setBlockBounds(7f / 8f, 0f, 14f / 16f, 1f, 14f / 16f, 1f);
        renderBlockInInv(block, renderblocks);
        
		block.setBlockBounds(0f, 0f, 0f, 1f / 8f, 14f / 16f, 1f / 8f);
        renderBlockInInv(block, renderblocks);
        
		block.setBlockBounds(7f / 8f, 0f, 0f, 1f, 14f / 16f, 1f / 8f);
        renderBlockInInv(block, renderblocks);
        
        block.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
        
		return true;
	}
	
	public static boolean renderBlockOre(Block block, int i, int j, int k, RenderBlocks rb, IBlockAccess ba){
		int neighborMeta = 0;
		int closestDist = 0xffff;
		for (int x = -3; x < 4; x++){
			for (int y = -3; y < 4; y++){
				for (int z = -3; z < 4; z++){
					if (ba.getBlockId(x + i, y + j, z + k) == Block.stone.blockID){
						if (Util.distanceSquared(0, 0, 0, x, y, z) < closestDist){
							neighborMeta = ba.getBlockMetadata(x + i, y + j, z + k);
						}
					}
				}
			}
		}
		
		int temp = Block.stone.blockIndexInTexture;
		Block.stone.blockIndexInTexture = Block.stone.getBlockTextureFromSideAndMetadata(0, neighborMeta);
		rb.renderStandardBlock(Block.stone, i, j, k);
		Block.stone.blockIndexInTexture = temp;
		
		rb.renderStandardBlock(block, i, j, k);

		return true;
	}
	
	public static boolean renderBlockRushes(Block block, int i, int j, int k, RenderBlocks renderblocks, IBlockAccess blockAccess)
	{
		Tessellator tessellator = Tessellator.instance;
        float f = block.getBlockBrightness(blockAccess, i, j, k);
        int l = block.colorMultiplier(blockAccess, i, j, k);
        float f1 = (float)(l >> 16 & 0xff) / 255F;
        float f2 = (float)(l >> 8 & 0xff) / 255F;
        float f3 = (float)(l & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
        double d = i;
        double d1 = j;
        double d2 = k;
        renderblocks.renderCrossedSquares(block, blockAccess.getBlockMetadata(i, j, k), d, d1, d2);
        
        if (block.blockID == BEBlocks.rushes.blockID){
        	renderBlockRushesBottom((BlockWaterPlant) block, i, j - 1, k, renderblocks, blockAccess);
        }
		return true;
	}
	
	private static void renderBlockRushesBottom(BlockWaterPlant block, int i, int j, int k, RenderBlocks renderblocks, IBlockAccess blockAccess){
        
        block.swapTextures();
		
		Tessellator tessellator = Tessellator.instance;
        float f = block.getBlockBrightness(blockAccess, i, j, k);
        int l = block.colorMultiplier(blockAccess, i, j, k);
        float f1 = (float)(l >> 16 & 0xff) / 255F;
        float f2 = (float)(l >> 8 & 0xff) / 255F;
        float f3 = (float)(l & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
        double d = i;
        double d1 = j;
        double d2 = k;
        renderblocks.renderCrossedSquares(block, blockAccess.getBlockMetadata(i, j, k), d, d1, d2);
        

        block.swapTextures();
	}
	
	public static boolean renderBlockLamp(Block block, int i, int j, int k, RenderBlocks renderblocks, IBlockAccess blockAccess)
	{
		renderblocks.renderStandardBlock(block, i, j, k);
		
		int meta = blockAccess.getBlockMetadata(i, j, k);
		int normalIndex = block.blockIndexInTexture;
	
		BlockLamp lamp = BEBlocks.lamp;
		lamp.blockIndexInTexture = lamp.top;
		
		if (meta == 1){
			lamp.setBlockBounds(0f, 7f/16f, 7f/ 16f, 0.250001f, 9f/16f, 9f / 16f);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
			lamp.setBlockBounds(0f, 1f/16f, 7f/ 16f, 0.250001f, 3f/16f, 9f / 16f);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
		} else if (meta == 2){
			lamp.setBlockBounds(0.750001f, 7f/16f, 7f/ 16f, 1f, 9f/16f, 9f / 16f);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
			lamp.setBlockBounds(0.750001f, 1f/16f, 7f/ 16f, 1f, 3f/16f, 9f / 16f);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
		} else if (meta == 3){
			lamp.setBlockBounds(7f/ 16f, 7f/16f, 0.0f, 9f / 16f, 9f/16f, 0.250001f);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
			lamp.setBlockBounds(7f/ 16f, 1f/16f, 0.0f, 9f / 16f, 3f/16f, 0.250001f);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
		} else if (meta == 4){
			lamp.setBlockBounds(7f/ 16f, 7f/16f, 0.75001f, 9f / 16f, 9f/16f, 1f);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
			lamp.setBlockBounds(7f/ 16f, 1f/16f, 0.75001f, 9f / 16f, 3f/16f, 1f);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
		} else if (meta == 6){
			float off = 7f/16f;
			lamp.setBlockBounds(off, 10f/16f, off, 1 - off, 1, 1 - off);
			renderblocks.renderStandardBlock(lamp, i, j, k);	
		}
		
        float f = 0.25F;
		lamp.setBlockBounds(f, 0, f, 1-f, 5f/8f, 1-f);
		lamp.blockIndexInTexture = normalIndex;
		
		return true;
	}
	
	public static void renderBlockInInv(Block block, RenderBlocks renderblocks){
        int i = 0;
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderblocks.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderblocks.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderblocks.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderblocks. renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderblocks.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderblocks.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, i));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

}
