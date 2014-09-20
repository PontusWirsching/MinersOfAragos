package core.game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.engine.tools.Loader;

import core.game.entities.Entity;

public class World {

	public String name = "WORLD";

	public ArrayList<Entity> entities = new ArrayList<>();

	public int width = 4, height = 4;

	public Tile[][] tiles;

	public World() {
		load(Loader.loadBufferedImage("/worlds/world.png"));
	}

	public Entity getEntity(int index) {
		return entities.get(index);
	}

	public void load(BufferedImage image) {
		width = image.getWidth();
		height = image.getHeight();
		tiles = new Tile[width][height];

		int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				for (Tile t : Tiles.loadedTiles) {
					if (pixels[x + y * width] == t.color) {
						tiles[x][y] = t;
					}
				}
			}
		}

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

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (tiles[x][y] != null) {
					tiles[x][y].render(g, x, y);
				}
			}
		}

		for (Entity e : entities) {
			if (e != null) {
				e.render(g);
			}
		}
	}

}
