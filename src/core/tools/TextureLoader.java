package core.tools;

import com.engine.graphics.SpriteSheet;

public class TextureLoader {
	
	public static SpriteSheet inventoryGui;
	public static SpriteSheet inventoryGuiTemplate;
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
		
		
		// Loading Sprite Sheets
		
		inventoryGui = new SpriteSheet("/textures/inventoryGui.png");
		inventoryGuiTemplate = new SpriteSheet("/textures/inventoryGuiTemplate.png");
		itemSpriteSheet = new SpriteSheet("/textures/items.png");
		inventoryGui.loadSprite("INVENTORYGUI", 0, 0, 133, 89);
		inventoryGuiTemplate.loadSprite("INVENTORYGUITEMPLATE", 0, 0, 133, 89);
	
		// Loading Inventory Items
		
		itemSpriteSheet.loadSprite("SWORD_ITEM", 0, 0, 16, 16);
		itemSpriteSheet.loadSprite("NECKLACE_ITEM", 16 * 2, 0, 16, 16);
		itemSpriteSheet.loadSprite("LARGE_COIN_STACK_ITEM", 16 * 3, 0, 16, 16);
		itemSpriteSheet.loadSprite("MEDIUM_COIN_STACK_ITEM", 16 * 4, 0, 16, 16);
		itemSpriteSheet.loadSprite("SMALL_COIN_STACK_ITEM", 16 * 5, 0, 16, 16);
		itemSpriteSheet.loadSprite("ORANGE_FOOD_ITEM", 16 * 6, 0, 16, 16);
		itemSpriteSheet.loadSprite("RING_ITEM", 16 * 1, 0, 16, 16);
	}

}
