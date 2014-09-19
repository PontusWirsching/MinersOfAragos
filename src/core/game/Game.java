package core.game;

import java.awt.Graphics;

import com.engine.state.State;

import core.item.Inventory;

public class Game extends State {
	
	private Inventory inventory = new Inventory();

	public static int xOff, yOff;
	
	public static final int TILE_DISPLAY_SIZE = 96;
	
	public Game(String name) {
		super(name);
	}

	@Override
	public void update() {
		inventory.update();
	}
	
	@Override
	public void render(Graphics g) {
		inventory.render(g);
	}



}
