package core.tools;

import com.engine.graphics.SpriteSheet;

public class TextureLoader {
	
	public static SpriteSheet inventoryGui;
	public static SpriteSheet itemSpriteSheet;

	public static void load() {
		inventoryGui = new SpriteSheet("/textures/inventoryGui.png");
		itemSpriteSheet = new SpriteSheet("/textures/items.png");
		inventoryGui.loadSprite("INVENTORYGUI", 0, 0, 89, 89);
		itemSpriteSheet.loadSprite("SWORD", 0, 0, 16, 16);
	}

}
