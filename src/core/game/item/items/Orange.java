package core.game.item.items;

import java.awt.Image;

import core.game.item.types.Food;

public class Orange extends Food {

	public Orange(String itemName, int maxStack, Image image) {
		super(itemName, maxStack, image);
		eatable = true;
		itemDesc = "A delicious tasting-n  orange used for-n        testing.";
		
	}

}
