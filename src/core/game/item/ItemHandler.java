package core.game.item;

import java.util.ArrayList;

import core.tools.TextureLoader;

public class ItemHandler {
	
	public static ArrayList<Item> items = new ArrayList<Item>();

	// Define items here and properties
	
	public static Item testItem = new Item(0, "Test Item", 0, TextureLoader.itemSpriteSheet.get("SWORD"));

}
