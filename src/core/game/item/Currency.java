package core.game.item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import core.tools.TextureLoader;

public class Currency {

	public static boolean updateCurrency_1 = false;
	public static boolean updateCurrency_2 = false;

	public static int currentCurrency = 0;
	public static int maxCurrencyStack_1 = 100, maxCurrencyStack_2 = 1000,
			maxCurrencyStack_3 = 100000;
	
	public void addCurrency(int amount) {
		currentCurrency = currentCurrency + amount;
	}
	
	public int getCurrentCurrency() {
		return currentCurrency;
	}
	
	public void update() {
		if(currentCurrency >= maxCurrencyStack_1) {
			updateCurrency_1 = true;
		}
		if(currentCurrency >= maxCurrencyStack_2) {
			updateCurrency_2 = true;
		}
	}
	
	public void render(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 12));
		g.setColor(Color.WHITE);
		g.drawString("" + currentCurrency, + Slot.getIX() + 188, Slot.getIY() + 37);
		g.drawImage(TextureLoader.itemSpriteSheet.get("LARGE_COIN_STACK_ITEM"), Slot.getIX() + 124, Slot.getIY() + 10, 45, 45, null);
	}

}
