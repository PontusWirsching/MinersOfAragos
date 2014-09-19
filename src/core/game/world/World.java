package core.game.world;

import java.awt.Graphics;
import java.util.ArrayList;

import core.game.entities.Entity;

public class World {

	public String name = "WORLD";

	public ArrayList<Entity> entities = new ArrayList<>();

	
	
	public World() {

	}

	public Entity getEntity(int index) {
		return entities.get(index);
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			getEntity(i).update();
		}
		for (int i = 0; i < entities.size(); i++) {
			if (getEntity(i).isRemoved()) {
				entities.remove(getEntity(i));
			}
		}
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			if (e != null) {
				e.render(g);
			}
		}
	}

}
