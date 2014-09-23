package core.game.item;

import java.awt.Graphics;
import java.awt.Image;

public class Item {

	protected int maxStack;
	protected String itemName;
	protected String itemDesc = "SET DESCRIPTION!";
	protected Image image;

	public Item(String itemName, int maxStack, Image image) {
		this.itemName = itemName;
		this.maxStack = maxStack;
		this.image = image;
		ItemHandler.inventoryItems.add(this);
	}

	public Item(String itemName, int maxStack, Image image, String desc) {
		this.itemName = itemName;
		this.maxStack = maxStack;
		this.image = image;
		this.itemDesc = desc;
		ItemHandler.inventoryItems.add(this);
	}

	
	public String getItemName() {
		return itemName;
	}

	public String getDesc() {
		return itemDesc;
	}
	
	public void render(Graphics g) {
		
	}
	
}
