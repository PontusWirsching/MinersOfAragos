package core.game.item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Slot {

	public int itemID = -1;
	public int amount = 0;

	public String itemName = "";
	
	public static int iX;
	public static int iY;

	public Slot() {

	}

	public void setItemData(int itemID, int amount) {
		this.itemID = itemID;
		setAmount(amount);
	}

	public int getItemID() {
		return itemID;
	}

	public int getAmount() {
		return amount;
	}

	public String getItemName() {
		itemName = ItemHandler.inventoryItems.get(itemID).getItemName();
		return itemName;
	}

	public int getMaxStack() {
		return ItemHandler.inventoryItems.get(itemID).maxStack;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Image getImage() {
		return ItemHandler.inventoryItems.get(itemID).image;
	}

	public void render(Graphics g, int x, int y) {
		iX = x;
		iY = y;

		// Drawing Items In The Inventory

		if (itemID != -1) {
			g.drawImage(ItemHandler.inventoryItems.get(itemID).image, x, y, 65,
					65, null);

			// Adding Amount String Above Item

			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.setColor(Color.WHITE);
			g.drawString("" + amount, x + 68 - new String("" + amount).length() * 9, y + 64);
		}
	}

	public void delAmount(int amount) {
		this.amount = this.amount - amount;
	}
	
	public static int getIX() {
		return iX;
	}
	
	public static int getIY() {
		return iY;
	}

}
