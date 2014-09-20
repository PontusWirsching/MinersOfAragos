package core.game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.engine.LEngine;
import com.engine.input.Keyboard;
import com.engine.input.Mouse;
import com.engine.tools.Loader;

import core.tools.TextureLoader;

public class Inventory {

	Image inventorySelectImage;

	int slot_index = 0;
	int slotX, slotY;

	boolean[] slotMarks = new boolean[16];

	public static boolean inventoryShowing = true;
	boolean b = false;

	public Slot[] slots;

	public Inventory() {
		inventorySelectImage = Loader.loadImage("/icons/inventorySelect.png");

		slots = new Slot[16];

		for (int i = 0; i < slots.length; i++) {
			slots[i] = new Slot();
		}
	}

	public void removeItem(int x, int y) {
		if (slots[x + y * 4] != null) {
			slots[x + y * 4].setItem(-1);
		}
	}

	public boolean addItem(int id) {
		boolean noSpace = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (slots[x + y * 4].getItem() == -1) {
					setItem(id, x, y);
					noSpace = false;
					x = 5;
					y = 5;
				} else {
					noSpace = true;
				}
			}

		}
		return noSpace;
	}

	public void setItem(int id, int x, int y) {
		slots[x + y * 4].setItem(id);
	}

	boolean toggle = false;
	boolean bo = false;

	public void update() {

		if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE) && !toggle) {
			if (addItem(0)) {
				System.out.println("INVENTORY FULL!");
			}
			toggle = true;
		} else if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE) == false && toggle) {
			toggle = false;
		}

		if (Keyboard.isKeyPressed(KeyEvent.VK_DELETE) && !bo) {
			removeItem(slotX, slotY);
			bo = true;
		} else if (Keyboard.isKeyPressed(KeyEvent.VK_DELETE) == false && bo) {
			bo = false;
		}

		// Inventory Logic
		if (Keyboard.isKeyPressed(KeyEvent.VK_I) && !b) {
			b = true;
			inventoryShowing = !inventoryShowing;
		} else if (!Keyboard.isKeyPressed(KeyEvent.VK_I) && b) {
			b = false;
		}
		selectBox();
	}

	public void render(Graphics g) {
		// Rendering Inventory
		if (inventoryShowing) {
			g.drawImage(TextureLoader.inventoryGui.get("INVENTORYGUI"),
					LEngine.WIDTH / 2 - 200, LEngine.HEIGHT / 2 - 200, 400,
					400, null);
		}
		// Rendering Inventory Selection Icon
		if (inventoryShowing) {
			g.drawImage(inventorySelectImage, (339 + slotX * 76) + 14 * slotX,
					(187 + slotY * 76) + 14 * slotY, 76, 76, null);

			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					slots[x + y * 4].render(g, (342 + x * 76) + 14 * x,
							(192 + y * 76) + 14 * y);
				}
			}

		}
		ItemHandler.testItem.render(g);
	}

	public void selectBox() {
		// Mouse Input Selecting Inventory Boxes
		if (inventoryShowing) {
			if (Mouse.getButton() == 1) {
				int x = 0, y = 0;

				/*
				 * (339) = starting pixel, (i) = current inventory slot, (76) =
				 * size of pixel, (14) pixel space between the boxes.
				 */

				for (int i = 0; i < 4; i++) {
					if (Mouse.getX() >= (339 + i * 76) + 14 * i) {
						x = i;
					}
				}
				for (int i = 0; i < 4; i++) {
					if (Mouse.getY() >= (187 + i * 76) + 14 * i) {
						y = i;
					}
				}
				slot_index = x + y * 4;
				slotX = x;
				slotY = y;
				slotMarks[slot_index] = true;
			}
		}
	}

}
