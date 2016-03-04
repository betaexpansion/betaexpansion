package net.minecraft.src;

import java.util.List;

public class EntityHatchet extends Entity{
	private int xTileHatchet;
	private int yTileHatchet;
	private int zTileHatchet;
	private int inTileHatchet;
	private boolean inGroundHatchet;
	public int shakeHatchet;
	private EntityLiving thrower;
	private int ticksInGroundHatchet;
	private int ticksInAirHatchet;
	public ItemStack item;

	public EntityHatchet(World world) {
		super(world);
		xTileHatchet = -1;
		yTileHatchet = -1;
		zTileHatchet = -1;
		inTileHatchet = 0;
		inGroundHatchet = false;
		shakeHatchet = 0;
		ticksInAirHatchet = 0;
		setSize(0.25F, 0.25F);
	}

	public EntityHatchet(World world, EntityLiving entityliving, ItemStack item)
	{
		super(world);
		xTileHatchet = -1;
		yTileHatchet = -1;
		zTileHatchet = -1;
		inTileHatchet = 0;
		inGroundHatchet = false;
		shakeHatchet = 0;
		ticksInAirHatchet = 0;
		thrower = entityliving;
		setSize(0.25F, 0.25F);
		setLocationAndAngles(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
		posX -= MathHelper.cos((rotationYaw / 180F) * 3.141593F) * 0.16F;
		posY -= 0.10000000149011612D;
		posZ -= MathHelper.sin((rotationYaw / 180F) * 3.141593F) * 0.16F;
		setPosition(posX, posY, posZ);
		yOffset = 0.0F;
		float f = 0.4F;
		motionX = -MathHelper.sin((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F) * f;
		motionZ = MathHelper.cos((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F) * f;
		motionY = -MathHelper.sin((rotationPitch / 180F) * 3.141593F) * f;
		setHatchetHeading(motionX, motionY, motionZ, 1.5F, 1.0F);
		this.item = item;
	}

	public void setHatchetHeading(double d, double d1, double d2, float f, 
			float f1)
	{
		float f2 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
		d /= f2;
		d1 /= f2;
		d2 /= f2;
		d += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;
		d1 += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;
		d2 += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;
		d *= f;
		d1 *= f;
		d2 *= f;
		motionX = d;
		motionY = d1;
		motionZ = d2;
		float f3 = MathHelper.sqrt_double(d * d + d2 * d2);
		prevRotationYaw = rotationYaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
		prevRotationPitch = rotationPitch = (float)((Math.atan2(d1, f3) * 180D) / 3.1415927410125732D);
		ticksInGroundHatchet = 0;
	}

	public void setVelocity(double d, double d1, double d2)
	{
		motionX = d;
		motionY = d1;
		motionZ = d2;
		if(prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
		{
			float f = MathHelper.sqrt_double(d * d + d2 * d2);
			prevRotationYaw = rotationYaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
			prevRotationPitch = rotationPitch = (float)((Math.atan2(d1, f) * 180D) / 3.1415927410125732D);
		}
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub

	}

	public boolean isInRangeToRenderDist(double d)
	{
		double d1 = boundingBox.getAverageEdgeLength() * 4D;
		d1 *= 64D;
		return d < d1 * d1;
	}


	public void onUpdate()
	{
		lastTickPosX = posX;
		lastTickPosY = posY;
		lastTickPosZ = posZ;
		super.onUpdate();
		if(shakeHatchet > 0)
		{
			shakeHatchet--;
		}
		if(inGroundHatchet)
		{
			int i = worldObj.getBlockId(xTileHatchet, yTileHatchet, zTileHatchet);
			if(i != inTileHatchet)
			{
				inGroundHatchet = false;
				motionX *= rand.nextFloat() * 0.2F;
				motionY *= rand.nextFloat() * 0.2F;
				motionZ *= rand.nextFloat() * 0.2F;
				ticksInGroundHatchet = 0;
				ticksInAirHatchet = 0;
			} else
			{
				ticksInGroundHatchet++;
				if(ticksInGroundHatchet == 1200)
				{
					setEntityDead();
				}
				return;
			}
		} else
		{
			ticksInAirHatchet++;
		}
		Vec3D vec3d = Vec3D.createVector(posX, posY, posZ);
		Vec3D vec3d1 = Vec3D.createVector(posX + motionX, posY + motionY, posZ + motionZ);
		MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks(vec3d, vec3d1);
		vec3d = Vec3D.createVector(posX, posY, posZ);
		vec3d1 = Vec3D.createVector(posX + motionX, posY + motionY, posZ + motionZ);
		if(movingobjectposition != null)
		{
			vec3d1 = Vec3D.createVector(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
		}
		if(!worldObj.multiplayerWorld)
		{
			Entity entity = null;
			List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
			double d = 0.0D;
			for(int l = 0; l < list.size(); l++)
			{
				Entity entity1 = (Entity)list.get(l);
				if(!entity1.canBeCollidedWith() || entity1 == thrower && ticksInAirHatchet < 5)
				{
					continue;
				}
				float f4 = 0.3F;
				AxisAlignedBB axisalignedbb = entity1.boundingBox.expand(f4, f4, f4);
				MovingObjectPosition movingobjectposition1 = axisalignedbb.func_1169_a(vec3d, vec3d1);
				if(movingobjectposition1 == null)
				{
					continue;
				}
				double d1 = vec3d.distanceTo(movingobjectposition1.hitVec);
				if(d1 < d || d == 0.0D)
				{
					entity = entity1;
					d = d1;
				}
			}

			if(entity != null)
			{
				movingobjectposition = new MovingObjectPosition(entity);
			}
		}
		if(movingobjectposition != null)
		{
			if(movingobjectposition.entityHit != null)
			{
				if(!movingobjectposition.entityHit.attackEntityFrom(thrower, item.getDamageVsEntity(movingobjectposition.entityHit)));
				item.damageItem(4, thrower);
			}
			for(int j = 0; j < 8; j++)
			{

			}
			if (item.stackSize > 0){
				worldObj.entityJoinedWorld(new EntityItem(worldObj, posX, posY, posZ, item));
			}
			setEntityDead();
		}
		posX += motionX;
		posY += motionY;
		posZ += motionZ;
		float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
		rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / 3.1415927410125732D);
		for(rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / 3.1415927410125732D); rotationPitch - prevRotationPitch < -180F; prevRotationPitch -= 360F) { }
		for(; rotationPitch - prevRotationPitch >= 180F; prevRotationPitch += 360F) { }
		for(; rotationYaw - prevRotationYaw < -180F; prevRotationYaw -= 360F) { }
		for(; rotationYaw - prevRotationYaw >= 180F; prevRotationYaw += 360F) { }
		rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
		rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
		float f1 = 0.99F;
		float f2 = 0.03F;
		if(isInWater())
		{
			for(int k = 0; k < 4; k++)
			{
				float f3 = 0.25F;
				worldObj.spawnParticle("bubble", posX - motionX * (double)f3, posY - motionY * (double)f3, posZ - motionZ * (double)f3, motionX, motionY, motionZ);
			}

			f1 = 0.8F;
		}
		motionX *= f1;
		motionY *= f1;
		motionZ *= f1;
		motionY -= f2;
		setPosition(posX, posY, posZ);
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		nbttagcompound.setShort("xTile", (short)xTileHatchet);
		nbttagcompound.setShort("yTile", (short)yTileHatchet);
		nbttagcompound.setShort("zTile", (short)zTileHatchet);
		nbttagcompound.setByte("inTile", (byte)inTileHatchet);
		nbttagcompound.setByte("shake", (byte)shakeHatchet);
		nbttagcompound.setByte("inGround", (byte)(inGroundHatchet ? 1 : 0));
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		xTileHatchet = nbttagcompound.getShort("xTile");
		yTileHatchet = nbttagcompound.getShort("yTile");
		zTileHatchet = nbttagcompound.getShort("zTile");
		inTileHatchet = nbttagcompound.getByte("inTile") & 0xff;
		shakeHatchet = nbttagcompound.getByte("shake") & 0xff;
		inGroundHatchet = nbttagcompound.getByte("inGround") == 1;
	}

	public void onCollideWithPlayer(EntityPlayer entityplayer)
	{
		if(inGroundHatchet && thrower == entityplayer && shakeHatchet <= 0 && entityplayer.inventory.addItemStackToInventory(new ItemStack(Item.arrow, 1)))
		{
			worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			entityplayer.onItemPickup(this, 1);
			setEntityDead();
		}
	}

	public float getShadowSize()
	{
		return 0.5F;
	}
}
