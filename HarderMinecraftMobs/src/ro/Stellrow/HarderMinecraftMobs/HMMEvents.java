package ro.Stellrow.HarderMinecraftMobs;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HMMEvents implements Listener {
    private final HMMobs pl;

    public HMMEvents(HMMobs pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onEntitySpawn(CreatureSpawnEvent event){
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER){
            if (!pl.configurationManager.affectSpawners){
                return;
            }
        }
        if (event.getEntityType()== EntityType.ZOMBIE){
            if (pl.configurationManager.affectZombies){
                Zombie zombie = (Zombie) event.getEntity();
                if (pl.configurationManager.affectZombieHealth) {
                    zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(pl.configurationManager.zombieHealth);
                    zombie.setHealth(pl.configurationManager.zombieHealth);
                }
                if (pl.configurationManager.affectZombieSpeed){
                    zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(pl.configurationManager.zombieSpeed);
                }
                if (pl.configurationManager.affectZombieAttack){
                    zombie.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(pl.configurationManager.zombieAttack);
                }
                if (pl.configurationManager.zombieRandomGear){
                    if (addGear()){
                        applyRandomGear(zombie);
                    }
                }

            }
        }
        if (event.getEntityType()==EntityType.SKELETON){
            if (pl.configurationManager.affectSkeletons){
                Skeleton skeleton = (Skeleton) event.getEntity();
                if (pl.configurationManager.affectSkeletonHealth){
                    skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(pl.configurationManager.skeletonHealth);
                    skeleton.setHealth(pl.configurationManager.skeletonHealth);
                }
                if (pl.configurationManager.affectSkeletonSpeed){
                    skeleton.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(pl.configurationManager.skeletonSpeed);
                }
                if (pl.configurationManager.affectSkeletonAttack){
                    skeleton.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(pl.configurationManager.skeletonAttack);
                }
                if (pl.configurationManager.skeletonRandomGear){
                    if (addGear()){
                        applyRandomGear(skeleton);
                    }
                }

            }
        }
        if (event.getEntityType()==EntityType.SPIDER){
            if (pl.configurationManager.affectSpiders){
                Spider spider = (Spider) event.getEntity();
                if (pl.configurationManager.affectSpiderHealth){
                    spider.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(pl.configurationManager.spiderHealth);
                    spider.setHealth(pl.configurationManager.spiderHealth);
                }
                if (pl.configurationManager.affectSpiderSpeed){
                    spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(pl.configurationManager.spiderSpeed);
                }
                if (pl.configurationManager.affectSpiderAttack){
                    spider.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(pl.configurationManager.spiderAttack);
                }
            }
        }
        if (event.getEntityType()==EntityType.CREEPER){
            if (pl.configurationManager.affectCreepers){
                Creeper creeper = (Creeper) event.getEntity();
                if (pl.configurationManager.affectCreeperHealth){
                    creeper.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(pl.configurationManager.creeperHealth);
                    creeper.setHealth(pl.configurationManager.creeperHealth);
                }
                if (pl.configurationManager.affectCreeperSpeed){
                    creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(pl.configurationManager.creeperSpeed);
                }
            }
        }
    }

    private void applyRandomGear(Entity entity){
        LivingEntity livingEntity = (LivingEntity) entity;
        livingEntity.getEquipment().setHelmet(getRandomHelmet());
        livingEntity.getEquipment().setChestplate(getRandomChestplate());
        livingEntity.getEquipment().setItemInMainHand(getRandomWeapon());
    }

    private List<Material> helmetGear = Arrays.asList(Material.TURTLE_HELMET,Material.IRON_HELMET,Material.GOLDEN_HELMET,Material.LEATHER_HELMET,Material.AIR);
    private List<Material> chestplateGear = Arrays.asList(Material.CHAINMAIL_CHESTPLATE,Material.LEATHER_CHESTPLATE,Material.IRON_CHESTPLATE,Material.AIR);
    private List<Material> weaponGear = Arrays.asList(Material.WOODEN_SWORD,Material.STONE_SWORD,Material.IRON_SWORD,Material.STICK,Material.AIR);

    private final Random random = new Random();

    private boolean addGear(){
        int a = random.nextInt(100);
        if (a<pl.configurationManager.randomGearChance){
            return true;
        }
        return false;
    }
    private ItemStack getRandomHelmet(){
        Material m = helmetGear.get(random.nextInt(helmetGear.size()));
        return new ItemStack(m);
    }
    private ItemStack getRandomChestplate(){
        Material m = chestplateGear.get(random.nextInt(chestplateGear.size()));
        return new ItemStack(m);
    }
    private ItemStack getRandomWeapon(){
        Material m = weaponGear.get(random.nextInt(weaponGear.size()));
        return new ItemStack(m);
    }

}
