package com.collinhoskins.mccourse.item;

import com.collinhoskins.mccourse.MCCourseMod;
import com.collinhoskins.mccourse.block.ModFluids;
import com.collinhoskins.mccourse.util.Registration;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
            () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    // Dragon
    public static final RegistryObject<Item> DRAGON_INGOT =
            Registration.ITEMS.register("dragon_ingot",
                    () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> DRAGON_SWORD =
            Registration.ITEMS.register("dragon_sword",
                    () -> new SwordItem(DragonTier.DRAGON,8,3f,
                            new Item.Properties()
                                    .defaultMaxDamage(1000)
                                    .group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> DRAGON_MACE =
            Registration.ITEMS.register("dragon_mace",
                    () -> new SwordItem(DragonTier.DRAGON, 12, 1,
                            new Item.Properties()
                                    .defaultMaxDamage(1000)
                                    .group(MCCourseMod.COURSE_TAB)));
    // Emerald
    public static final RegistryObject<Item> EMERALD_INGOT =
            Registration.ITEMS.register("emerald_ingot",
                    () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> EMERALD_SWORD =
            Registration.ITEMS.register("emerald_sword",
                    () -> new SwordItem(EmTier.EMERALD, 6, 2f,
                            new Item.Properties()
                                    .defaultMaxDamage(600)
                                    .group(MCCourseMod.COURSE_TAB)));

    // Dragon Destroyer

    public static final RegistryObject<Item> DRAGON_ORB =
            Registration.ITEMS.register("dragon_orb",
                    () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> DRAGON_DESTROYER_HELMET =
            Registration.ITEMS.register("dragon_destroyer_helmet",
                    () -> new ArmorItem(DragonArmorMaterial.DRAGON, EquipmentSlotType.HEAD,
                           new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> DRAGON_DESTROYER_CHESTPLATE =
            Registration.ITEMS.register("dragon_destroyer_chestplate",
                    () -> new ArmorItem(DragonArmorMaterial.DRAGON, EquipmentSlotType.CHEST,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> DRAGON_DESTROYER_LEGGINGS =
            Registration.ITEMS.register("dragon_destroyer_leggings",
                    () -> new ArmorItem(DragonArmorMaterial.DRAGON, EquipmentSlotType.LEGS,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> DRAGON_DESTROYER_BOOTS =
            Registration.ITEMS.register("dragon_destroyer_boots",
                    () -> new ArmorItem(DragonArmorMaterial.DRAGON, EquipmentSlotType.FEET,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    // Armor

    public static final RegistryObject<Item> EMERALD_HELMET =
            Registration.ITEMS.register("emerald_helmet",
                    () -> new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.HEAD,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE =
            Registration.ITEMS.register("emerald_chestplate",
                    () -> new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.CHEST,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> EMERALD_LEGGINGS =
            Registration.ITEMS.register("emerald_leggings",
                    () -> new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.LEGS,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> EMERALD_BOOTS =
            Registration.ITEMS.register("emerald_boots",
                    () -> new ArmorItem(EmeraldArmorMaterial.EMERALD, EquipmentSlotType.FEET,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> OIL_BUCKET =
            Registration.ITEMS.register("oil_bucket",
                    () -> new BucketItem(ModFluids.OIL_FLUID::get,
                            new Item.Properties().group(MCCourseMod.COURSE_TAB).maxStackSize(1)));
//    // Spawn Egg
//
//    public static final RegistryObject<ModSpawnEggItem> WERE_WOLF_EGG =
//            Registration.ITEMS.register("were_wolf_egg",
//                    () -> new ModSpawnEggItem(ModEntityTypes.WERE_WOLF, 0xF02F4A, 0x70334F1),
//                    new Item.Properties().group(MCCourseMod.COURSE_TAB));

    public static void register() { }

    public enum EmeraldArmorMaterial implements IArmorMaterial
    {
        EMERALD(400, new int[] {4, 9, 7, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                Ingredient.fromStacks(new ItemStack(ModItems.EMERALD_INGOT.get())),
                MCCourseMod.MOD_ID + ":emerald", 2, 0.5f);

        private final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackRestistance;

        EmeraldArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, Ingredient repairMaterial, String name, float toughness, float knockbackRestistance) {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackRestistance = knockbackRestistance;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackRestistance;
        }

    }


    public enum DragonArmorMaterial implements IArmorMaterial
    {
        DRAGON(4000, new int[] {7, 16, 10, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                Ingredient.fromStacks(new ItemStack(ModItems.DRAGON_ORB.get())),
                MCCourseMod.MOD_ID + ":dragon", 4, 1.0f);

        private final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackRestistance;

        DragonArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, Ingredient repairMaterial, String name, float toughness, float knockbackRestistance) {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackRestistance = knockbackRestistance;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackRestistance;
        }

    }

    public enum DragonTier implements IItemTier
    {
        DRAGON(6, 4000, 6.5f, 0f, 25,
                Ingredient.fromStacks(new ItemStack(ModItems.DRAGON_INGOT.get())));
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        DragonTier(int harvestLevel, int maxUses, float efficiency,
                    float attackDamage, int enchantability, Ingredient repairMaterial)
        {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses()
        {
            return maxUses;
        }

        @Override
        public float getEfficiency()
        {
            return efficiency;
        }

        @Override
        public float getAttackDamage()
        {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel()
        {
            return harvestLevel;
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return repairMaterial;




 }

}
    public enum EmTier implements IItemTier
    {
        EMERALD(3, 1500, 10f, 0f, 25,
                Ingredient.fromStacks(new ItemStack(ModItems.EMERALD_INGOT.get())));
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        EmTier(int harvestLevel, int maxUses, float efficiency,
                   float attackDamage, int enchantability, Ingredient repairMaterial)
        {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses()
        {
            return maxUses;
        }

        @Override
        public float getEfficiency()
        {
            return efficiency;
        }

        @Override
        public float getAttackDamage()
        {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel()
        {
            return harvestLevel;
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return repairMaterial;




        }

    }
    }