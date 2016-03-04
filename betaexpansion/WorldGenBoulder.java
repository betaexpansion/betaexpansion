package net.minecraft.src;

import java.util.Random;

public class WorldGenBoulder extends WorldGenerator {

	private int meta;
	
	public WorldGenBoulder(int meta){
		this.meta = meta;
	}
	
	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		j -= 3;
		for (int x = -4; x < 5; x++){
			for (int y = 0; y < 5; y++){
				for (int z = -4; z < 5; z++){
					if (random.nextInt(10) == 0){
						world.setBlockAndMetadataWithNotify(i + x, j + y, k + z, Block.stone.blockID, meta);
					}
				}
			}
		}
		
		int chance = 10;
		
		for (int iter = 0; iter < 6; iter++){
			for (int x = -4; x < 5; x++){
				for (int y = 0; y < 5; y++){
					for (int z = -4; z < 5; z++){
						if (world.getBlockId(i + x, j + y, k + z) == Block.stone.blockID){
							if (world.getBlockMetadata(i + x, j + y, k + z) == meta){
								if (world.rand.nextInt(chance) == 0){
									world.setBlockAndMetadata(i + x + 1, y + j, k + z, Block.stone.blockID, meta);
								}
								if (world.rand.nextInt(chance) == 0){
									world.setBlockAndMetadata(i + x, j + y + 1, k + z, Block.stone.blockID, meta);
								}
								if (world.rand.nextInt(chance) == 0){
									world.setBlockAndMetadata(i + x, j + y, k + z + 1, Block.stone.blockID, meta);
								}
								if (world.rand.nextInt(chance) == 0){
									world.setBlockAndMetadata(i + x - 1, y + j, k + z, Block.stone.blockID, meta);
								}
								if (world.rand.nextInt(chance) == 0){
									world.setBlockAndMetadata(i + x, j + y - 1, k + z, Block.stone.blockID, meta);
								}
								if (world.rand.nextInt(chance) == 0){
									world.setBlockAndMetadata(i + x, j + y, k + z - 1, Block.stone.blockID, meta);
								}
							}
						}
					}
				}
			}
		}
		
		for (int x = -5; x < 6; x++){
			for (int y = 0; y < 6; y++){
				for (int z = -5; z < 6; z++){
					if (world.getBlockId(i + x, j + y, k + z) == Block.stone.blockID){
						if (world.getBlockMetadata(i + x, j + y, k + z) == meta){
							int count = 0;
							if (world.getBlockId(i + x + 1, j + y, k + z) != 0){
								count++;
							}
							if (world.getBlockId(i + x, j + y + 1, k + z) != 0){
								count++;
							}
							if (world.getBlockId(i + x, j + y, k + z + 1) != 0){
								count++;
							}
							if (world.getBlockId(i + x - 1, j + y, k + z) != 0){
								count++;
							}
							if (world.getBlockId(i + x, j + y - 1, k + z) != 0){
								count++;
							}
							if (world.getBlockId(i + x, j + y, k + z - 1) != 0){
								count++;
							}
							if (count < 3){
								world.setBlock(i + x, j + y, k + z, 0);
							}
						}
					} if (world.getBlockId(i + x, j + y, k + z) == 0){
						int count = 0;
						if (world.getBlockId(i + x + 1, j + y, k + z) != 0){
							count++;
						}
						if (world.getBlockId(i + x, j + y + 1, k + z) != 0){
							count++;
						}
						if (world.getBlockId(i + x, j + y, k + z + 1) != 0){
							count++;
						}
						if (world.getBlockId(i + x - 1, j + y, k + z) != 0){
							count++;
						}
						if (world.getBlockId(i + x, j + y - 1, k + z) != 0){
							count++;
						}
						if (world.getBlockId(i + x, j + y, k + z - 1) != 0){
							count++;
						}
						if (count > 2){
							world.setBlockAndMetadata(i + x, j + y, k + z, Block.stone.blockID, meta);
						}
					}
				}
			}
		}
		
		return false;
	}

}
