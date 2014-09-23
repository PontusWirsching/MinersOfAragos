package core.game.item.items;

import java.awt.Image;

import core.game.item.types.Jewellery;

public class Necklace extends Jewellery {

	public Necklace(String itemName, int maxStack, Image image) {
		super(itemName, maxStack, image);
		wearable = true;
		itemDesc = "A beautiful diamond-nnecklace is used for-n          testing.";
	}
	
	// #migLogic2k14

}
