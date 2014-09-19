package core.tools;

import com.engine.graphics.SpriteSheet;

public class TextureLoader {

	public static SpriteSheet inventoryGui;
	
	public static SpriteSheet tiles;
	
	
	public static void load() {

		tiles = new SpriteSheet("/textures/tiles.png");
		tiles.loadSprite("SPRITE_DIRT", 0, 0, 16, 16);
		
		
		inventoryGui = new SpriteSheet("/textures/inventoryGui.png");
		inventoryGui.loadSprite("INVENTORYGUI", 0, 0, 89, 89);

	}

}
