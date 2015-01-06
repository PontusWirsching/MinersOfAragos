package core.game.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import tiled.core.Map;
import tiled.core.MapLayer;
import tiled.core.ObjectGroup;
import tiled.core.Tile;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;
import tiled.view.MapRenderer;
import tiled.view.OrthogonalRenderer;

import com.engine.LEngine;

import core.game.Game;
import core.game.Start;
import core.game.entities.Entity;

public class World {

	public String name = "WORLD";

	public ArrayList<Entity> entities = new ArrayList<>();

	public int width = 4, height = 4;

	public Map map;
	public MapRenderer mapRenderer;

	public World() {
		load("level.tmx");
	}

	public Entity getEntity(int index) {
		return entities.get(index);
	}

	public void load(String path) {
		try {
			TMXMapReader mapReader = new TMXMapReader();
			map = mapReader.readMap(Start.PATH + "\\Worlds\\" + path);
		} catch (Exception e) {
			System.out.println("Error while reading the map:\n" + e.getMessage());
			return;
		}
		width = map.getWidth();
		height = map.getHeight();
		mapRenderer = createRenderer(map);
		o = new ObjectGroup(map);

	}

	ObjectGroup o;

	private static MapRenderer createRenderer(Map map) {
		switch (map.getOrientation()) {
		case Map.ORIENTATION_ORTHOGONAL:
			return new OrthogonalRenderer(map);
		default:
			return null;
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

		int scale = 2;



		g.setClip(0,0, LEngine.WIDTH, LEngine.HEIGHT);

		// NOTE - When player gets added, show mig.

		
		g.setColor(Color.red);

		int xo = Game.xOff;
		int yo = Game.yOff;
		
		for (MapLayer layer : map) {
			if (layer instanceof TileLayer) {
				for (int x = (xo / 64); x < (xo / 64) + 17; x++) {
					for (int y = (yo / 64); y < (yo / 64) + 13; y++) {
						if(x < layer.getWidth() && y < layer.getHeight()) {
							Tile t = ((TileLayer) layer).getTileAt(x, y);
							if (t != null) {
								g.drawImage(t.getImage(), x * 64 - xo, y * 64 - yo, 64, 64, null);
							
								if (t.getProperties().containsKey("collision")) {
//									g.fillRect(x * 64 - xo, y * 64 - yo, 64, 64);
								}
							}
						}
					}
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
