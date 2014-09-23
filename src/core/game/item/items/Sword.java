package core.game.item.items;

import java.awt.Image;

import core.game.item.types.MeleeWeapon;

public class Sword extends MeleeWeapon {

	public Sword(String itemName, int maxStack, Image image) {
		super(itemName, maxStack, image);
		wearable = true;
		itemDesc = "A sword used for-n       testing.";
	}

}
