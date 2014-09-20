package core.game.item;

import java.awt.Graphics;
import java.awt.Image;

public class Item {

	protected int itemID, maxStack;
	protected String itemName;
	protected Image image;

	public Item(int itemID, String itemName, int maxStack, Image image) {
		this.itemID = itemID;
		this.maxStack = maxStack;
		this.image = image;
		ItemHandler.loadedItems.add(this);
	}

	public int getId() {
		return itemID;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public String getItemName() {
		return itemName;
	}

	public void render(Graphics g) {

	}
}
