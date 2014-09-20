package core.game.item;

import java.awt.Graphics;
import java.awt.Image;

public class Item {

	protected int maxStack;
	public String itemName;
	protected Image image;

	public Item(String itemName, int maxStack, Image image) {
		this.itemName = itemName;
		this.maxStack = maxStack;
		this.image = image;
		ItemHandler.inventoryItems.add(this);
	}

	public String getItemName() {
		return itemName;
	}

	public void render(Graphics g) {
		
	}
}
