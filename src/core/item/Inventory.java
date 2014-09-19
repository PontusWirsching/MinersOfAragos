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
	}

	public void render(Graphics g) {
		// Rendering Inventory
		if (inventoryShowing) {
			g.drawImage(TextureLoader.inventoryGui.get("INVENTORYGUI"),
					LEngine.WIDTH / 2 - 200, LEngine.HEIGHT / 2 - 200, 400,
					400, null);
		}
	}
	
	public void selectBox() {
		// Mouse Input Selecting Inventory Boxes
		if(inventoryShowing) {
			if(Mouse.getButton() == 1) {
				for(int i = 0; i < 4; i++) {
				}
				for(int i = 0; i < 4; i++) {
					
				}
			}
		}
	}

}
