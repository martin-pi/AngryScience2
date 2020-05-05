package com.pharaoh439.angrysciencemod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import java.util.stream.Stream;

public class CounterBlock extends Block {

    // Block Properties
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final IntegerProperty MODEL = IntegerProperty.create("model",0,11);

    // Names for the possible values of the MODEL IntegerProperty
    private static final int MODEL_N = 0;
    private static final int MODEL_E = 1;
    private static final int MODEL_S = 2;
    private static final int MODEL_W = 3;
    private static final int MODEL_INNER_SW = 4;
    private static final int MODEL_INNER_NW = 5;
    private static final int MODEL_INNER_NE = 6;
    private static final int MODEL_INNER_SE = 7;
    private static final int MODEL_OUTER_NE = 8;
    private static final int MODEL_OUTER_SE = 9;
    private static final int MODEL_OUTER_SW = 10;
    private static final int MODEL_OUTER_NW = 11;

    // Collision Models
    private static final VoxelShape STRAIGHT_N = Stream.of(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 1, 16, 13, 16),
            Block.makeCuboidShape(2, 3, 0.5, 14, 12, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape STRAIGHT_E = Stream.of(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 0, 15, 13, 16),
            Block.makeCuboidShape(15, 3, 2, 15.5, 12, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape STRAIGHT_S = Stream.of(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 0, 16, 13, 15),
            Block.makeCuboidShape(2, 3, 15, 14, 12, 15.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape STRAIGHT_W = Stream.of(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(1, 0, 0, 16, 13, 16),
            Block.makeCuboidShape(0.5, 3, 2, 1, 12, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape INNER_SW = Stream.of(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(1, 0, 0, 16, 13, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 13, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape INNER_NW = Stream.of(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 1, 16, 13, 16),
            Block.makeCuboidShape(1, 0, 0, 16, 13, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape INNER_NE = Stream.of(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 0, 15, 13, 16),
            Block.makeCuboidShape(15, 0, 1, 16, 13, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape INNER_SE = Stream.of(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 0, 16, 13, 15),
            Block.makeCuboidShape(0, 0, 15, 15, 13, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape OUTER_NE = VoxelShapes.combineAndSimplify(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 1, 15, 13, 16), IBooleanFunction.OR);
    private static final VoxelShape OUTER_SE = VoxelShapes.combineAndSimplify(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 0, 0, 15, 13, 15), IBooleanFunction.OR);
    private static final VoxelShape OUTER_SW = VoxelShapes.combineAndSimplify(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(1, 0, 0, 16, 13, 15), IBooleanFunction.OR);
    private static final VoxelShape OUTER_NW = VoxelShapes.combineAndSimplify(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(1, 0, 1, 16, 13, 16), IBooleanFunction.OR);


    public CounterBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState()
                .with(FACING, Direction.NORTH)
                .with(MODEL, MODEL_N));
    }

    /**
     * Specific to CounterBlock. Determines whether a block, represented by
     * its BlockState, is a CounterBlock.
     * @param state the BlockState of a Block.
     * @return true if the BlockState is from a CounterBlock.
     */
    public static boolean isBlockCounter(BlockState state) {
        return state.getBlock() instanceof CounterBlock;
    }

    /**
     * Specific to CounterBlock. Checks the surrounding blocks to determine
     * which model to use. Allows for "Connected" blocks.
     * @param stateIn This Counter's state right now
     * @param worldIn The World that this Counter is located in
     * @param pos The location of this Counter in the World
     * @return an updated BlockState with the proper Model value.
     */
    private static BlockState recalculateBlockState(BlockState stateIn, IWorld worldIn, BlockPos pos) {
        Direction direction = stateIn.get(FACING);
        // Check in front. If there is a counter, create an Inner to match.
        // (Prioritize making Inners to avoid gaps in the cabinets.)
        BlockState front = worldIn.getBlockState(pos.offset(direction));
        if (isBlockCounter(front)) {
            // Which way is the other counter facing? If 'left' or 'right' to this counter, we can make an inner.
            Direction frontFacing = front.get(FACING);
            if (frontFacing == direction.rotateYCCW() || frontFacing == direction.rotateY()) {
                int model = MODEL_N;
                switch(direction) {
                    case NORTH:
                        model = frontFacing == Direction.EAST ? MODEL_INNER_NE : MODEL_INNER_NW;
                        return stateIn.with(MODEL, model);
                    case EAST:
                        model = frontFacing == Direction.NORTH ? MODEL_INNER_NE : MODEL_INNER_SE;
                        return stateIn.with(MODEL, model);
                    case SOUTH:
                        model = frontFacing == Direction.EAST ? MODEL_INNER_SE : MODEL_INNER_SW;
                        return stateIn.with(MODEL, model);
                    case WEST:
                        model = frontFacing == Direction.NORTH ? MODEL_INNER_NW : MODEL_INNER_SW;
                        return stateIn.with(MODEL, model);
                }
            }
        }

        // Check behind. If there is a counter, Create an Outer to match.
        BlockState behind = worldIn.getBlockState(pos.offset(direction.getOpposite()));
        if (isBlockCounter(behind)) {
            // Which way is the other counter facing? If 'left' or 'right' to this counter, we can make an outer.
            Direction behindFacing = behind.get(FACING);
            if (behindFacing == direction.rotateYCCW() || behindFacing == direction.rotateY()) {
                int model = MODEL_N;
                switch(direction) {
                    case NORTH:
                        model = behindFacing == Direction.EAST ? MODEL_OUTER_NE : MODEL_OUTER_NW;
                        return stateIn.with(MODEL, model);
                    case EAST:
                        model = behindFacing == Direction.NORTH ? MODEL_OUTER_NE : MODEL_OUTER_SE;
                        return stateIn.with(MODEL, model);
                    case SOUTH:
                        model = behindFacing == Direction.EAST ? MODEL_OUTER_SE : MODEL_OUTER_SW;
                        return stateIn.with(MODEL, model);
                    case WEST:
                        model = behindFacing == Direction.NORTH ? MODEL_OUTER_NW : MODEL_OUTER_SW;
                        return stateIn.with(MODEL, model);
                }
            }
        }

        // Default to Straight If this counter is on its own.
        switch(direction) {
            case EAST:
                worldIn.setBlockState(pos, stateIn.with(MODEL, MODEL_E), 3);
                return stateIn.with(MODEL, MODEL_E);
            case SOUTH:
                worldIn.setBlockState(pos, stateIn.with(MODEL, MODEL_S), 3);
                return stateIn.with(MODEL, MODEL_S);
            case WEST:
                worldIn.setBlockState(pos, stateIn.with(MODEL, MODEL_W), 3);
                return stateIn.with(MODEL, MODEL_W);
            default:
                worldIn.setBlockState(pos, stateIn.with(MODEL, MODEL_N), 3);
                return stateIn.with(MODEL, MODEL_N);
        }
    }

    /**
     * Returns a VoxelShape to define the collision model for a Counter.
     * @param state A BlockState from a Counter
     * @param worldIn The IWorld that the Counter is in
     * @param pos The Counter's position in the World.
     * @param context Unused? Not sure what this does.
     * @return a VoxelShape representing the collision model of the Counter.
     */
    @Override
    @Deprecated // But Not Really.
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(FACING);
        // Check in front. If it is a counter, create an Inner to match.
        // (Prioritize making Inners to avoid gaps in the cabinets.)
        BlockState front = worldIn.getBlockState(pos.offset(direction));
        if (isBlockCounter(front)) {
            // Which way is the other counter facing? If 'left' or 'right' to this counter, we can make an inner.
            Direction frontFacing = front.get(FACING);
            if (frontFacing == direction.rotateYCCW() || frontFacing == direction.rotateY()) {
                switch(direction) {
                    case NORTH:
                        return frontFacing == Direction.EAST ? INNER_NE : INNER_NW;
                    case EAST:
                        return frontFacing == Direction.NORTH ? INNER_NE : INNER_SE;
                    case SOUTH:
                        return frontFacing == Direction.EAST ? INNER_SE : INNER_SW;
                    case WEST:
                        return frontFacing == Direction.NORTH ? INNER_NW : INNER_SW;
                }
            }
        }

        // Check behind. If it is a counter, Create an Outer to match.
        BlockState behind = worldIn.getBlockState(pos.offset(direction.getOpposite()));
        if (isBlockCounter(behind)) {
            // Which way is the other counter facing? If 'left' or 'right' to this counter, we can make an outer.
            Direction behindFacing = behind.get(FACING);
            if (behindFacing == direction.rotateYCCW() || behindFacing == direction.rotateY()) {
                switch(direction) {
                    case NORTH:
                        return behindFacing == Direction.EAST ? OUTER_NE : OUTER_NW;
                    case EAST:
                        return behindFacing == Direction.NORTH ? OUTER_NE : OUTER_SE;
                    case SOUTH:
                        return behindFacing == Direction.EAST ? OUTER_SE : OUTER_SW;
                    case WEST:
                        return behindFacing == Direction.NORTH ? OUTER_NW : OUTER_SW;
                }
            }
        }

        // Default to Straight If this counter is on its own.
        switch(direction) {
            case EAST:
                return STRAIGHT_E;
            case SOUTH:
                return STRAIGHT_S;
            case WEST:
                return STRAIGHT_W;
            default:
                return STRAIGHT_N;
        }
    }

    /**
     * Runs at the instant a block is placed, determines the State of a Counter
     * @param context An object representing the Action that a User has taken
     * @return A BlockState to apply to the new Counter.
     */
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos pos = context.getPos();
        IWorld world = context.getWorld();
        BlockState state = this.getDefaultState();
        state = state.with(FACING, context.getPlacementHorizontalFacing().getOpposite());
        return recalculateBlockState(state, world, pos);
    }

    /**
     * Runs whenever an adjacent block is updated (Such as being placed or
     * removed), allowing this block to change.
     * @param stateIn The current state of this block
     * @param facing The direction of the update?
     * @param facingState The state of the updated block?
     * @param worldIn The world that both Blocks are in
     * @param pos The position of this block
     * @param facingPos The position of the updated block?
     * @return A new BlockState to represent this Block.
     */
    @Override
    @Deprecated // But not really. Minecraft currently uses this.
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
        return recalculateBlockState(stateIn, worldIn, pos);
    }

    /**
     * Add default properties to this block's BlockState.
     * Was apparently updated in 1.14 to be un-overrideable.
     *
     * See the constructor for the new method?
     */
    /*@Deprecated
    public final BlockState getDefaultState() {
        BlockState state = super.getDefaultState()
        state = state.with(FACING, Direction.NORTH);
        state = state.with(MODEL, MODEL_N);
        return state;
    }*/

    /**
     * During Initialization defines what a BlockState for a Counter looks like.
     * @param builder
     */
    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(FACING, MODEL);
    }

    @Override
    @Deprecated // Deprecated, only here for backward compatibility.
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    @Deprecated // Deprecated, only here for backward compatibility.
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }
}
