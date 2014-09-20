package core.game;

import java.awt.Graphics;

import com.engine.state.State;

import core.game.world.World;
import core.item.Inventory;

public class Game extends State {
	
	private Inventory inventory = new Inventory();

	public static int xOff, yOff;
	
	public static final int TILE_DISPLAY_SIZE = 64;
	
	public static World currentWorld;
	
	public Game(String name) {
		super(name);
		
		currentWorld = new World();
		
	}

	@Override
	public void update() {
		currentWorld.update();
		inventory.update();
	}
	
	@Override
	public void render(Graphics g) {
		currentWorld.render(g);
		inventory.render(g);
	}



}
