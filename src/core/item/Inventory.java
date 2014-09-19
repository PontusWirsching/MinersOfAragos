package core.item;

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

	public boolean inventoryShowing = false;
	boolean b = false;

	public Inventory() {
		inventorySelectImage = Loader.loadImage("/icons/inventorySelect.png");
	}

	public void update() {
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
		if(inventoryShowing) {
			g.drawImage(inventorySelectImage, (339 + slotX * 76) + 14 * slotX,
					(187 + slotY * 76) + 14 * slotY, 76, 76, null);
		}
	}

	public void selectBox() {
		// Mouse Input Selecting Inventory Boxes
		if (inventoryShowing) {
			if (Mouse.getButton() == 1) {
				int x = 0, y = 0;
				
				/*
				 * (339) = starting pixel, (i) = current inventory slot,
				 * (76) = size of pixel, (14) pixel space between the boxes.
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
