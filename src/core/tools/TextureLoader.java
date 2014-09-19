package core.tools;

import com.engine.graphics.SpriteSheet;

public class TextureLoader {

	public static SpriteSheet inventoryGui;

	public static void load() {

		inventoryGui = new SpriteSheet("/textures/inventoryGui.png");
		inventoryGui.loadSprite("INVENTORYGUI", 0, 0, 89, 89);

	}

}
