package core.game.item.items;

import java.awt.Image;

import core.game.item.types.Jewellery;

public class Ring extends Jewellery {

	public Ring(String itemName, int maxStack, Image image) {
		super(itemName, maxStack, image);
		wearable = true;
		itemDesc = "     A unique-n diamond ring-nused for testing.";
		
	}


}
