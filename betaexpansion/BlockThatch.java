package net.minecraft.src;

import java.util.Random;

public class BlockThatch extends ModBlock {
    
    private boolean tmp;

	public BlockThatch(int i, int j, String name, boolean tmp){
		super(i, j, Material.leaves, name);
        this.tmp = tmp;
        setWoodLike();
        setGrassLike();
        setHardness(0.2f);
        setResistance(0.0f);

        if (tmp)
            setTickOnLoad(true);
    }
    
    @Override
    public void updateTick(World world, int i, int j, int k, Random random){
        if (!tmp)
            return;
        if (random.nextInt(Config.WEAK_THATCH_LIFE) == 0){
            world.setBlockWithNotify(i, j, k, 0);
        }
    }
}
