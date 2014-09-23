package core.game.world;

import java.util.ArrayList;

import core.tools.TextureLoader;

public class Tiles {

	public static ArrayList<Tile> loadedTiles = new ArrayList<>();
	
	public static final Tile dirt = new Tile("DIRT", TextureLoader.tiles.get("SPRITE_DIRT"), 0xff68312A);
	public static final Tile stoneBrickWall_corner1 = new Tile("BRICK_STONE_WALL_CORNER_UL", TextureLoader.tiles.get("LEFT_UPPER_CORNER_STONE"), 0xff010101);
	public static final Tile stoneBrickWall_corner2 = new Tile("BRICK_STONE_WALL_CORNER_UR", TextureLoader.tiles.get("RIGHT_UPPER_CORNER_STONE"), 0xff020202);
	public static final Tile stoneBrickWall_corner3 = new Tile("BRICK_STONE_WALL_CORNER_LL", TextureLoader.tiles.get("LEFT_LOWER_CORNER_STONE"), 0xff030303);
	public static final Tile stoneBrickWall_corner4 = new Tile("BRICK_STONE_WALL_CORNER_LR", TextureLoader.tiles.get("RIGHT_LOWER_CORNER_STONE"), 0xff040404);

}
