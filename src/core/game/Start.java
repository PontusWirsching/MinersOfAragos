package core.game;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import com.engine.LEngine;
import com.engine.state.StateHandler;

import core.tools.TextureLoader;

@SuppressWarnings("resource")
public class Start extends LEngine {

	public static final String PATH = System.getenv("APPDATA") + "\\LostSourceStudios\\MinersOfAragos";

	/**
	 * Will check that game folders exist else create new ones and download latest map files.
	 */
	static {
		File file = new File(PATH);

		if (!file.exists()) {
			file.mkdirs();
		}

		File world = new File(PATH + "\\Worlds");

		if (!world.exists()) {
			world.mkdirs();
		}
		try {
			URL website = new URL("http://www.lostsourcestudios.com/resources/MinersOfAragos/level.tmx");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(PATH + "\\worlds\\" + "level.tmx");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (Exception e) {

		}
		try {
			URL website = new URL("http://www.lostsourcestudios.com/resources/MinersOfAragos/tiles.png");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(PATH + "\\worlds\\" + "tiles.png");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (Exception e) {

		}


	}

	public Start(int width, int height, String title) {
		super(width, height, title);
		TextureLoader.load();

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
