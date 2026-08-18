package net.MIKH.forgemodmikh.worldgen.tree;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower MAPLE = new TreeGrower(ForgeModMIKH.MOD_ID + ":" + "maple",
            Optional.empty(),Optional.of(ModConfiguredFeatures.MAPLE_KEY),Optional.empty());

}
