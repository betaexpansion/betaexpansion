package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class EntityDart extends EntityProjectile
{

    public EntityDart(World world)
    {
        super(world);
        damage = 2;
    }

    public EntityDart(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
        damage = 2;
    }

    public EntityDart(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
        damage = 2;
    }
}
