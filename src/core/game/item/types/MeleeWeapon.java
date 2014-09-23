package core.game.item.types;

import java.awt.Image;

import core.game.item.Item;

public class MeleeWeapon extends Item {
	
	public boolean wearable = false;

	public MeleeWeapon(String itemName, int maxStack, Image image) {
		super(itemName, maxStack, image);
		
	}

}
