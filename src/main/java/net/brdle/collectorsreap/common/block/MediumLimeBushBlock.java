package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class MediumLimeBushBlock extends SmallLimeBushBlock {
	private static final VoxelShape SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D));

	public MediumLimeBushBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	public void performBonemeal(ServerLevel world, @NotNull RandomSource rand, @NotNull BlockPos pos, @NotNull BlockState state) {
		if (world.isEmptyBlock(pos.above())) {
			world.setBlockAndUpdate(pos, CRBlocks.LIME_BUSH.get().defaultBlockState());
			world.setBlockAndUpdate(pos.above(), CRBlocks.LIME_BUSH.get().defaultBlockState().setValue(LimeBushBlock.HALF, DoubleBlockHalf.UPPER));
		}
	}
}
