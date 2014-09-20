package core.game.item;

import java.awt.Color;
import java.awt.Graphics;

public class Slot {

	public int item = -1;

	public Slot() {

	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getItem() {
		return item;
	}

	public void render(Graphics g, int x, int y) {
		if (item != -1) {
			g.drawImage(ItemHandler.loadedItems.get(item).image, x, y, 65, 65,
					null);
		}
		
		g.setColor(Color.RED);
		g.drawString("" + item, x, y);
		
	}

}
