package core.game.world;

import java.awt.Image;

public class Tile {

	public String id;
	public Image image;
	public boolean solid = false;
	
	
	
	public Tile(String id, Image image) {
		this.id = id;
		this.image = image;
	}

	public Tile setSolid(boolean b) {
		solid = b;
		return this;
	}
	
}
