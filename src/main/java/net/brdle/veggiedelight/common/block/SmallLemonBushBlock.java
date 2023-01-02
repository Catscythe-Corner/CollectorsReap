package net.brdle.veggiedelight.common.block;

import net.brdle.veggiedelight.common.item.VDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;

public class SmallLemonBushBlock extends BushBlock implements BonemealableBlock {
	public static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 11.0, 12.0);

	public SmallLemonBushBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull BlockState state) {
		return new ItemStack(VDItems.LEMON_SEEDS.get());
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return state.is(BlockTags.DIRT);
	}

	@Override
	public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, BlockPos pos) {
		BlockPos below = pos.below();
		return this.mayPlaceOn(level.getBlockState(below), level, below);
	}

	@Override
	public boolean isRandomlyTicking(@NotNull BlockState state) {
		return true;
	}

	@Override
	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource random) {
		if (ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(20) == 0)) {
			this.performBonemeal(level, random, pos, state);
			ForgeHooks.onCropsGrowPost(level, pos, state);
		}
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level world, @NotNull RandomSource rand, @NotNull BlockPos pos, @NotNull BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel world, @NotNull RandomSource rand, @NotNull BlockPos pos, @NotNull BlockState state) {
		world.setBlockAndUpdate(pos, VDBlocks.MEDIUM_LEMON_BUSH.get().defaultBlockState());
	}


	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 30;
	}
}
