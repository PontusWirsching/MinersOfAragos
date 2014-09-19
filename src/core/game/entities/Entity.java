package core.game.entities;

import java.awt.Graphics;

public class Entity {

	public int x, y;

	private boolean removed = false;

	public Entity() {

	}

	public void update() {

	}

	public void render(Graphics g) {

	}

	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

}
