package core.game.item.types;

import java.awt.Image;

import core.game.item.Item;

public class Food extends Item {
	
	public boolean eatable = false;

	public Food(String itemName, int maxStack, Image image) {
		super(itemName, maxStack, image);
	}


}
