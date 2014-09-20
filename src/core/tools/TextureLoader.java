package core.tools;

import com.engine.graphics.SpriteSheet;

public class TextureLoader {
	
	public static SpriteSheet inventoryGui;
	
	public static SpriteSheet tiles;
	
		public static SpriteSheet itemSpriteSheet;
	
	public static void load() {

		tiles = new SpriteSheet("/textures/tiles.png");
		tiles.loadSprite("SPRITE_DIRT", 0, 0, 16, 16);
		tiles.loadSprite("LEFT_UPPER_CORNER_STONE", 16, 0, 16, 16);
		tiles.loadSprite("MIDDLE_UPPER_STONE", 32, 0, 16, 16);
		tiles.loadSprite("LEFT_UPPER_CORNER_STONE", 48, 0, 16, 16);
		tiles.loadSprite("LEFT_MIDDLE_STONE", 16, 16, 16, 16);
		tiles.loadSprite("RIGHT_MIDDLE_STONE", 48, 16, 16, 16);
		tiles.loadSprite("LEFT_LOWER_CORNER_STONE", 16, 32, 16, 16);
		tiles.loadSprite("LOWER_MIDDLE_STONE", 32, 32, 16, 16);
		tiles.loadSprite("RIGHT_LOWER_CORNER_STONE", 48, 32, 16, 16);
		
		inventoryGui = new SpriteSheet("/textures/inventoryGui.png");
		itemSpriteSheet = new SpriteSheet("/textures/items.png");
		inventoryGui.loadSprite("INVENTORYGUI", 0, 0, 89, 89);
		itemSpriteSheet.loadSprite("SWORD", 0, 0, 16, 16);
	}

}
