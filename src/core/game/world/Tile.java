package core.game.world;

import java.awt.Graphics;
import java.awt.Image;

import core.game.Game;

public class Tile {

	public String id;
	public Image image;
	public int color;
	public boolean solid = false;

	public Tile(String id, Image image, int color) {
		this.id = id;
		this.image = image;
		this.color = color;
		Tiles.loadedTiles.add(this);
	}

	public Tile setSolid(boolean b) {
		solid = b;
		return this;
	}

	public void update() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(image, x * Game.TILE_DISPLAY_SIZE, y * Game.TILE_DISPLAY_SIZE, Game.TILE_DISPLAY_SIZE, Game.TILE_DISPLAY_SIZE, null);
	}

}
