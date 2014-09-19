package core.game;

import com.engine.LEngine;
import com.engine.state.StateHandler;

import core.tools.TextureLoader;

public class Start extends LEngine {

	public Start(int width, int height, String title) {
		super(width, height, title);
		
		TextureLoader.load();
		
		StateHandler.addState(new Game("GAME"));
		StateHandler.setState("GAME");
		
		skipIntro();
		start();
	}

	@Override
	public void update() {
		StateHandler.update();
	}
	
	@Override
	public void render() {	
		StateHandler.render(g);
	}

	public static void main(String[] args) {
		new Start(1024, 720, "Miners of Aragos");
	}

}
