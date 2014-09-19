package core.game.item;

import java.awt.Graphics;
import java.awt.Image;

public class Item {

	protected int id, maxStack;
	protected String itemName;
	protected Image image;

	public Item(int id, String itemName, int maxStack, Image image) {
		this.id = id;
		this.maxStack = maxStack;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public String getItemName() {
		return itemName;
	}

	public void render(Graphics g) {
		if (Inventory.inventoryShowing) {
			g.drawImage(this.image, 342, 192, 65, 65, null);
		}
	}
}
