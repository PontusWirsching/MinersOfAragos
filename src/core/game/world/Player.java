package core.game.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.engine.input.Keyboard;

import core.game.Game;
import core.game.entities.mob.Mob;

public class Player extends Mob {

	public int speed = 5;

	public Player() {

	}

	public void update() {
		int xv = 0;
		int yv = 0;
		if (Keyboard.isKeyPressed(KeyEvent.VK_W)) {
			yv -= speed;
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_A)) {
			xv -= speed;
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_S)) {
			yv += speed;
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_D)) {
			xv += speed;
		}
		
		
		x += xv;
		y += yv;
		
		xv = 0;
		yv = 0;
		
		
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(x - Game.xOff, y - Game.yOff, 64,64);
	}

}
