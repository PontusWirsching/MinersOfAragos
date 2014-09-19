package core.game;

import java.awt.Graphics;

import com.engine.state.State;

import core.item.Inventory;

public class Game extends State {
	
	private Inventory inventory = new Inventory();

	public static int xOff, yOff;
	
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
