package core.game.item;

import java.util.ArrayList;

import core.tools.TextureLoader;

public class ItemHandler {
	
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static ArrayList<Item> inventoryItems = new ArrayList<>();
	
	// Define items here and properties
	
	public static Item swordItem = new Item("Sword", 1, TextureLoader.itemSpriteSheet.get("SWORD_ITEM"));
	public static Item ringItem = new Item("Ring", 1, TextureLoader.itemSpriteSheet.get("RING_ITEM"));
	public static Item necklaceItem = new Item("Necklace", 15, TextureLoader.itemSpriteSheet.get("NECKLACE_ITEM"));
	public static Item largeCoinStackItem = new Item("Large Coin Stack", 2147483647, TextureLoader.itemSpriteSheet.get("LARGE_COIN_STACK_ITEM"));
	public static Item mediumCoinStackItem = new Item("Medium Coin Stack", 1000, TextureLoader.itemSpriteSheet.get("MEDIUM_COIN_STACK_ITEM"));
	public static Item smallCoinStackItem = new Item("Small Coin Stack", 10, TextureLoader.itemSpriteSheet.get("SMALL_COIN_STACK_ITEM"));
	public static Item orangeFoodItem = new Item("Orange", 1, TextureLoader.itemSpriteSheet.get("ORANGE_FOOD_ITEM"));

}
