package core.game;

import java.awt.Graphics;

import com.engine.LEngine;
import com.engine.state.State;

import core.game.item.Inventory;
import core.game.world.Player;
import core.game.world.World;

public class Game extends State {
	
	public int itemID = -1;
	
	private Inventory inventory = new Inventory();

	public static int xOff, yOff;
	
	public static final int TILE_DISPLAY_SIZE = 64;
	
	public static World currentWorld;
	
	public static Player player;
	
	public Game(String name) {
		super(name);
		
		currentWorld = new World();
		
		player = new Player();
		
		currentWorld.entities.add(player);
		
	}

	@Override
	public void update() {
		
		xOff = player.x - LEngine.WIDTH / 2;
		yOff = player.y - LEngine.HEIGHT / 2;
		
		currentWorld.update();
		inventory.update();
	}
	
	@Override
	public void render(Graphics g) {
		currentWorld.render(g);
		inventory.render(g);
	}



}
