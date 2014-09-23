package core.game.world;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import tiled.core.Map;
import tiled.core.MapLayer;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;
import tiled.view.MapRenderer;
import tiled.view.OrthogonalRenderer;

import com.engine.LEngine;

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

	}

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

	public void render(Graphics g2) {

		int scale = 2;
		
		BufferedImage image = new BufferedImage(LEngine.WIDTH / scale, LEngine.HEIGHT /scale, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = (Graphics2D) image.getGraphics();
		
		g.setClip(0, 0, LEngine.WIDTH / scale, LEngine.HEIGHT / scale);

		//NOTE - When player gets added, show mig.
		

		
		for (MapLayer layer : map) {
			if (layer instanceof TileLayer) {
				mapRenderer.paintTileLayer((Graphics2D) g, (TileLayer) layer);
			}
		}

		for (Entity e : entities) {
			if (e != null) {
				e.render(g);
			}
		}
		
		g2.drawImage(image, 0, 0, LEngine.WIDTH, LEngine.HEIGHT, null);
	}

}
