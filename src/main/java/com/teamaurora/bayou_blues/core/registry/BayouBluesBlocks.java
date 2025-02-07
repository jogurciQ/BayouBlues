package com.teamaurora.bayou_blues.core.registry;

import com.minecraftabnormals.abnormals_core.common.blocks.*;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.thatch.ThatchBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.thatch.ThatchSlabBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.thatch.ThatchStairsBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.thatch.ThatchVerticalSlabBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.wood.*;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.mojang.datafixers.util.Pair;
import com.teamaurora.bayou_blues.common.block.*;
import com.teamaurora.bayou_blues.common.block.trees.CypressTree;
import com.teamaurora.bayou_blues.core.BayouBlues;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BayouBlues.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BayouBluesBlocks {
    public static final BlockSubRegistryHelper HELPER = BayouBlues.REGISTRY_HELPER.getBlockSubHelper();

    // cypress
    public static final RegistryObject<Block> STRIPPED_CYPRESS_LOG = HELPER.createBlock("stripped_cypress_log", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_CYPRESS_WOOD = HELPER.createBlock("stripped_cypress_wood", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_LOG= HELPER.createBlock("cypress_log", ()->new AbnormalsLogBlock(STRIPPED_CYPRESS_LOG, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_WOOD = HELPER.createBlock("cypress_wood", ()->new WoodBlock(STRIPPED_CYPRESS_WOOD, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_LEAVES = HELPER.createBlock("cypress_leaves", ()->new AbnormalsLeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn((BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity)->(entity == EntityType.OCELOT || entity == EntityType.PARROT)).setSuffocates((BlockState state, IBlockReader reader, BlockPos pos)->false).setBlocksVision((BlockState state, IBlockReader reader, BlockPos pos)->false)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_SAPLING = HELPER.createBlock("cypress_sapling", ()->new AbnormalsSaplingBlock(new CypressTree(), Block.Properties.from(Blocks.OAK_SAPLING)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_CYPRESS_SAPLING = HELPER.createBlockNoItem("potted_cypress_sapling", ()->new FlowerPotBlock(CYPRESS_SAPLING.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> CYPRESS_PLANKS = HELPER.createBlock("cypress_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_SLAB = HELPER.createBlock("cypress_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_STAIRS = HELPER.createBlock("cypress_stairs", ()->new WoodStairsBlock(CYPRESS_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_PRESSURE_PLATE = HELPER.createBlock("cypress_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> CYPRESS_FENCE = HELPER.createFuelBlock("cypress_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_FENCE_GATE = HELPER.createFuelBlock("cypress_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), 300, ItemGroup.REDSTONE);
    public static final RegistryObject<Block> CYPRESS_BUTTON = HELPER.createBlock("cypress_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> CYPRESS_DOOR = HELPER.createBlock("cypress_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> CYPRESS_TRAPDOOR = HELPER.createBlock("cypress_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> CYPRESS_SIGNS = HELPER.createSignBlock("cypress", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> CYPRESS_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "cypress_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> VERTICAL_CYPRESS_PLANKS = HELPER.createCompatBlock("quark", "vertical_cypress_planks", ()->new Block(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "cypress_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), 150, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_LADDER = HELPER.createCompatFuelBlock("quark", "cypress_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_LEAF_CARPET = HELPER.createBlock("cypress_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(CYPRESS_LEAVES.get())), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_CYPRESS_POST = HELPER.createCompatFuelBlock("quark", "stripped_cypress_post", () -> new WoodPostBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_POST = HELPER.createCompatFuelBlock("quark", "cypress_post", () -> new WoodPostBlock(STRIPPED_CYPRESS_POST, AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_HEDGE = HELPER.createCompatFuelBlock("quark", "cypress_hedge", () -> new HedgeBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> CYPRESS_CHESTS = HELPER.createCompatChestBlocks("cypress", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> CYPRESS_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "cypress_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> HANGING_CYPRESS_LEAVES = HELPER.createBlock("hanging_cypress_leaves", ()->new HangingCypressLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> CYPRESS_KNEE = HELPER.createBlock("cypress_knee", ()->new CypressKneeBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD).notSolid()), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> LARGE_CYPRESS_KNEE = HELPER.createBlock("large_cypress_knee", ()->new DoubleCypressKneeBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD).notSolid()), ItemGroup.DECORATIONS);

    // gooseberries
    public static final RegistryObject<Block> CYPRESS_BRANCH = HELPER.createBlock("cypress_branch", ()->new CypressBranchBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.BAMBOO_SAPLING)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> GOOSEBERRY_SACK = HELPER.createCompatBlock("quark", "gooseberry_sack", ()->new Block(Block.Properties.create(Material.WOOL, MaterialColor.GREEN).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)), ItemGroup.DECORATIONS);

    // lilies
    public static final RegistryObject<Block> BLUE_LILY = HELPER.createBlockNoItem("blue_lily", ()->new LilyFlowerBlock(BayouBluesItems.BLUE_LILY, AbstractBlock.Properties.from(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> LIGHT_GRAY_LILY = HELPER.createBlockNoItem("light_gray_lily", ()->new LilyFlowerBlock(BayouBluesItems.LIGHT_GRAY_LILY, AbstractBlock.Properties.from(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> CYAN_LILY = HELPER.createBlockNoItem("cyan_lily", ()->new LilyFlowerBlock(BayouBluesItems.CYAN_LILY, AbstractBlock.Properties.from(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> LIGHT_BLUE_LILY = HELPER.createBlockNoItem("light_blue_lily", ()->new LilyFlowerBlock(BayouBluesItems.LIGHT_BLUE_LILY, AbstractBlock.Properties.from(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> MAGENTA_LILY = HELPER.createBlockNoItem("magenta_lily", ()->new LilyFlowerBlock(BayouBluesItems.MAGENTA_LILY, AbstractBlock.Properties.from(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> PINK_LILY = HELPER.createBlockNoItem("pink_lily", ()->new LilyFlowerBlock(BayouBluesItems.PINK_LILY, AbstractBlock.Properties.from(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> PURPLE_LILY = HELPER.createBlockNoItem("purple_lily", ()->new LilyFlowerBlock(BayouBluesItems.PURPLE_LILY, AbstractBlock.Properties.from(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> WHITE_LILY = HELPER.createBlockNoItem("white_lily", ()->new LilyFlowerBlock(BayouBluesItems.WHITE_LILY, AbstractBlock.Properties.from(Blocks.LILY_PAD)));

    public static final RegistryObject<Block> POTTED_BLUE_LILY = HELPER.createBlockNoItem("potted_blue_lily", ()->new FlowerPotBlock(BLUE_LILY.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> POTTED_LIGHT_GRAY_LILY = HELPER.createBlockNoItem("potted_light_gray_lily", ()->new FlowerPotBlock(LIGHT_GRAY_LILY.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> POTTED_CYAN_LILY = HELPER.createBlockNoItem("potted_cyan_lily", ()->new FlowerPotBlock(CYAN_LILY.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> POTTED_LIGHT_BLUE_LILY = HELPER.createBlockNoItem("potted_light_blue_lily", ()->new FlowerPotBlock(LIGHT_BLUE_LILY.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> POTTED_MAGENTA_LILY = HELPER.createBlockNoItem("potted_magenta_lily", ()->new FlowerPotBlock(MAGENTA_LILY.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> POTTED_PINK_LILY = HELPER.createBlockNoItem("potted_pink_lily", ()->new FlowerPotBlock(PINK_LILY.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> POTTED_PURPLE_LILY = HELPER.createBlockNoItem("potted_purple_lily", ()->new FlowerPotBlock(PURPLE_LILY.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> POTTED_WHITE_LILY = HELPER.createBlockNoItem("potted_white_lily", ()->new FlowerPotBlock(WHITE_LILY.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));

    // algae
    public static final RegistryObject<Block> ALGAE = HELPER.createBlockNoItem("algae", ()->new AlgaeBlock(AbstractBlock.Properties.create(Material.PLANTS).zeroHardnessAndResistance().sound(SoundType.LILY_PADS).notSolid().doesNotBlockMovement()));
    public static final RegistryObject<Block> ALGAE_THATCH = HELPER.createBlock("algae_thatch", ()->new ThatchBlock(Properties.ALGAE_THATCH), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_SLAB = HELPER.createBlock("algae_thatch_slab", ()->new ThatchSlabBlock(Properties.ALGAE_THATCH), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_STAIRS = HELPER.createBlock("algae_thatch_stairs", ()->new ThatchStairsBlock(ALGAE_THATCH.get().getDefaultState(), Properties.ALGAE_THATCH), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "algae_thatch_vertical_slab", ()->new ThatchVerticalSlabBlock(Properties.ALGAE_THATCH), ItemGroup.BUILDING_BLOCKS);

    // other
    public static final RegistryObject<Block> BEARD_MOSS_BLOCK = HELPER.createFuelBlock("beard_moss_block", ()->new BeardMossBlockBlock(AbstractBlock.Properties.create(Material.PLANTS).hardnessAndResistance(0.1F).sound(SoundType.PLANT).notSolid()), 800, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BEARD_MOSS = HELPER.createFuelBlock("beard_moss", ()->new BeardMossBlock(AbstractBlock.Properties.create(Material.PLANTS).zeroHardnessAndResistance().sound(SoundType.PLANT).notSolid().doesNotBlockMovement().tickRandomly()), 800, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> GIANT_FERN = HELPER.createBlock("giant_fern", ()->new DoublePlantBlock(AbstractBlock.Properties.from(Blocks.TALL_GRASS)), ItemGroup.DECORATIONS);

    public static class Properties {
        public static final AbstractBlock.Properties ALGAE_THATCH = AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.LIME).hardnessAndResistance(0.5F).sound(SoundType.PLANT).notSolid().harvestTool(ToolType.HOE);
    }
}
