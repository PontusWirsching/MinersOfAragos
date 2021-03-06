package core.game.item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.engine.input.Keyboard;
import com.engine.input.Mouse;
import com.engine.tools.Loader;

import core.tools.TextureLoader;

public class Inventory {

	Image inventorySelectImage;

	public int xOff, yOff;

	public Rectangle r = new Rectangle();

	int slot_index = 0;
	int slotX, slotY;

	static int slotSelectedX;
	static int slotSelectedY;

	static boolean slotSelected = false;

	public Random random = new Random();

	boolean[] slotMarks = new boolean[16];

	public static boolean inventoryShowing = false;
	public static boolean boxSelected = false;
	boolean b = false;

	public boolean showingItemDetails = false;

	public static Slot[] slots;

	private Currency currency = new Currency();

	public Inventory() {
		inventorySelectImage = Loader.loadImage("/icons/inventorySelect.png");

		slots = new Slot[16];

		xOff = 212;
		yOff = 160;

		for (int i = 0; i < slots.length; i++) {
			slots[i] = new Slot();
		}
	}

	public void removeItem(int x, int y) {
		if (slots[x + y * 4] != null) {
			if (slots[x + y * 4].amount == 1) {
				slots[x + y * 4].setItemData(-1, 0);
			} else if (slots[x + y * 4].amount > 1) {
				slots[x + y * 4].delAmount(1);
			}
		}
	}

	// Adding Items To The Inventory

	public boolean addInventoryItem(int itemID, int amount) {
		boolean noSpace = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (slots[x + y * 4].getItemID() == itemID) {
					if (slots[x + y * 4].getAmount() + amount > slots[x + y * 4]
							.getMaxStack()) {
						// Adds New Item Stack
					} else {
						setInventoryItem(itemID, x, y,
								slots[x + y * 4].getAmount() + amount);
						x = 5;
						y = 5;
					}
				} else if (slots[x + y * 4].getItemID() == -1) {
					setInventoryItem(itemID, x, y, amount);
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

	public void setInventoryItem(int itemID, int x, int y, int amount) {
		slots[x + y * 4].setItemData(itemID, amount);
	}

	boolean toggle = false;
	boolean bo = false;
	boolean boo = false;

	public void update() {

		r.setBounds(xOff, yOff, 598, 400);

		// Adding Inventory Items (Developer Tools)

		if (inventoryShowing) {
			if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE) && !toggle) {
				addInventoryItem(random.nextInt(4), 1);
				toggle = true;
			} else if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE) == false
					&& toggle) {
				toggle = false;
			}
		}

		// Adding Gold To Gold Variable

		if (inventoryShowing) {
			if (Keyboard.isKeyPressed(KeyEvent.VK_M) && !boo) {
				currency.addCurrency(10000);
				boo = true;
			} else if (Keyboard.isKeyPressed(KeyEvent.VK_M) == false && boo) {
				boo = false;
			}
		}

		// Deleting Inventory Items (Developer Tools)

		if (inventoryShowing) {
			if (Keyboard.isKeyPressed(KeyEvent.VK_DELETE) && !bo) {
				removeItem(slotX, slotY);
				bo = true;
			} else if (Keyboard.isKeyPressed(KeyEvent.VK_DELETE) == false && bo) {
				bo = false;
			}
		}

		// Inventory Logic

		if (Keyboard.isKeyPressed(KeyEvent.VK_I) && !b) {
			b = true;
			inventoryShowing = !inventoryShowing;
		} else if (!Keyboard.isKeyPressed(KeyEvent.VK_I) && b) {
			b = false;
		}

		selectBox();
		currency.update();
	}

	public void render(Graphics g) {
		// Rendering Inventory

		if (inventoryShowing) {
			if (showingItemDetails) {
				g.drawImage(TextureLoader.inventoryGui.get("INVENTORYGUI"),
						xOff, yOff, 598, 400, null);
			} else if (!showingItemDetails) {
				g.drawImage(TextureLoader.inventoryGuiTemplate
						.get("INVENTORYGUITEMPLATE"), xOff, yOff, 598, 400,
						null);
			}

			// Rendering Inventory Selection Icon

			if (inventoryShowing) {
				g.drawImage(inventorySelectImage, (slotX * 76) + 14 * slotX
						+ xOff + 27, (slotY * 76) + 14 * slotY + yOff + 27, 76,
						76, null);

				// Rendering Inventory Items

				for (int x = 0; x < 4; x++) {
					for (int y = 0; y < 4; y++) {
						slots[x + y * 4].render(g, (x * 76) + 14 * x + xOff
								+ 32, (y * 76) + 14 * y + yOff + 33);
					}
				}
			}

			if (Inventory.getSlotSelected()) {
				g.setFont(new Font("Arial", Font.BOLD, 13));
				g.setColor(Color.WHITE);
			}
		}

		if (inventoryShowing) {
			currency.render(g);
		}

		// Render Item Information

		if (inventoryShowing) {
			if (slots[slotSelectedX + slotSelectedY * 4].getItemID() != -1) {
				showingItemDetails = true;
			} else {
				showingItemDetails = false;
			}
		}

		if (inventoryShowing) {
			if (slotSelectedX == slotX && slotSelectedY == slotY) {
				if (slots[slotSelectedX + slotSelectedY * 4].getItemID() != -1) {
					g.setFont(new Font("Arial", Font.BOLD, 12));
					g.setColor(Color.WHITE);
					String s1 = slots[slotSelectedX + slotSelectedY * 4]
							.getItemName().toUpperCase();
					String s2 = slots[slotSelectedX + slotSelectedY * 4]
							.getDesc();
					int stringLength = (int) g.getFontMetrics()
							.getStringBounds(s1, g).getWidth();
					int start = 127 / 2 - stringLength / 2;
					g.drawString(s1, start + Slot.getIX() + 121,
							Slot.getIY() - 250);
					g.drawImage(
							slots[slotSelectedX + slotSelectedY * 4].getImage(),
							Slot.getIX() + 143, Slot.getIY() - 212, 76, 76,
							null);
					g.setFont(new Font("Arial", Font.BOLD, 13));
				
						//g.drawString(slots[slotSelectedX + slotSelectedY * 4].getDesc(), 635, 367);
					drawString(g, s2, start + 601, 354);
				}
			}
		}
	}
	
	public void drawString(Graphics g, String s, int x, int y) {
		for(String newLine : s.split("-n")) {
			g.drawString(newLine, x, y += g.getFontMetrics().getHeight());
		}
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
					if (Mouse.getX() >= (xOff + 27 + i * 76) + 14 * i) {
						x = i;
					}
				}
				for (int i = 0; i < 4; i++) {
					if (Mouse.getY() >= (yOff + 27 + i * 76) + 14 * i) {
						y = i;
					}
				}
				slot_index = x + y * 4;
				slotX = x;
				slotY = y;
				slotSelectedX = slotX;
				slotSelectedY = slotY;
				slotSelected = slotMarks[slot_index];
				slotMarks[slot_index] = true;

			}

		}
	}

	int mouseOnX, mouseOnY;

	boolean p = false;

	public static boolean getSlotSelected() {
		return slotSelected;
	}

	public static int getSlotX() {
		return slotSelectedX;
	}

	public static int getSlotY() {
		return slotSelectedY;
	}

}
