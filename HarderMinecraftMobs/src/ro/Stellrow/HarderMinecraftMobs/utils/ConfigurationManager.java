package ro.Stellrow.HarderMinecraftMobs.utils;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigurationManager {

    public void updateValues(FileConfiguration configuration){
        updateAffectValues(configuration);
        updateMobStats(configuration);
        updateMobStatsAffect(configuration);
        updateMobGear(configuration);
        updateChance(configuration);
    }

    public boolean affectZombies;
    public boolean affectSkeletons;
    public boolean affectSpiders;
    public boolean affectCreepers;

    private void updateAffectValues(FileConfiguration configuration){
        affectZombies = configuration.getBoolean("General.MobConfig.affectZombies",true);
        affectSkeletons = configuration.getBoolean("General.MobConfig.affectSkeletons",true);
        affectSpiders = configuration.getBoolean("General.MobConfig.affectSpiders",true);
        affectCreepers = configuration.getBoolean("General.MobConfig.affectCreeper",true);
    }

    public boolean affectZombieHealth;
    public boolean affectZombieSpeed;
    public boolean affectZombieAttack;
    public boolean affectSkeletonHealth;
    public boolean affectSkeletonSpeed;
    public boolean affectSkeletonAttack;
    public boolean affectSpiderHealth;
    public boolean affectSpiderSpeed;
    public boolean affectSpiderAttack;
    public boolean affectCreeperHealth;
    public boolean affectCreeperSpeed;

    private void updateMobStatsAffect(FileConfiguration configuration){
        affectZombieHealth = affectEntityHealth("Zombie",configuration);
        affectSkeletonHealth = affectEntityHealth("Skeleton",configuration);
        affectSpiderHealth = affectEntityHealth("Spider",configuration);
        affectCreeperHealth = affectEntityHealth("Creeper",configuration);

        affectZombieSpeed = affectEntitySpeed("Zombie",configuration);
        affectSkeletonSpeed = affectEntitySpeed("Skeleton",configuration);
        affectSpiderSpeed = affectEntitySpeed("Spider",configuration);
        affectCreeperSpeed = affectEntitySpeed("Creeper",configuration);

        affectZombieAttack = affectEntityAttack("Zombie",configuration);
        affectSkeletonAttack = affectEntityAttack("Skeleton",configuration);
        affectSpiderAttack = affectEntityAttack("Spider",configuration);
    }


    public int zombieHealth;
    public int skeletonHealth;
    public int spiderHealth;
    public int creeperHealth;

    public double zombieSpeed;
    public double skeletonSpeed;
    public double spiderSpeed;
    public double creeperSpeed;

    public double zombieAttack;
    public double skeletonAttack;
    public double spiderAttack;

    private void updateMobStats(FileConfiguration configuration){
        zombieHealth = configuration.getInt("Stats.Zombie.Health",20);
        skeletonHealth = configuration.getInt("Stats.Skeleton.Health",20);
        spiderHealth = configuration.getInt("Stats.Spider.Health",20);
        creeperHealth = configuration.getInt("Stats.Creeper.Health",20);

        zombieSpeed = configuration.getDouble("Stats.Zombie.Speed",0.23);
        skeletonSpeed = configuration.getDouble("Stats.Skeleton.Speed",0.25);
        spiderSpeed = configuration.getDouble("Stats.Spider.Speed",0.3);
        creeperSpeed = configuration.getDouble("Stats.Creeper.Speed",0.25);

        zombieAttack = configuration.getDouble("Stats.Zombie.Attack",4);
        skeletonAttack = configuration.getDouble("Stats.Skeleton.Attack",4);
        spiderAttack = configuration.getDouble("Stats.Spider.Attack",4);
    }

    public boolean zombieRandomGear;
    public boolean skeletonRandomGear;

    private void updateMobGear(FileConfiguration configuration){
        zombieRandomGear = configuration.getBoolean("General.MobConfig.MobStrength.Zombie.randomGear",true);
        skeletonRandomGear = configuration.getBoolean("General.MobConfig.MobStrength.Skeleton.randomGear",true);
    }


    public int randomGearChance;

    private void updateChance(FileConfiguration configuration){
        randomGearChance = configuration.getInt("General.ChanceConfig.spawnWithRandomGearChance",30);
    }

    private boolean affectEntityHealth(String type,FileConfiguration configuration){
        return configuration.getBoolean("General.MobConfig.MobStrength."+type+".higherHealth",true);
    }
    private boolean affectEntitySpeed(String type,FileConfiguration configuration){
        return configuration.getBoolean("General.MobConfig.MobStrength."+type+".higherSpeed",true);
    }
    private boolean affectEntityAttack(String type,FileConfiguration configuration){
        return configuration.getBoolean("General.MobConfig.MobStrength."+type+".higherAttack",true);
    }


}
