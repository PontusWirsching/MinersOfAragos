package builder.editor;

import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.engine.LEngine;
import com.engine.input.Mouse;

public class Start extends LEngine {

	public static EditorPane editor;

	/*
	 * Menu shit:
	 */
	public static MenuBar bar = new MenuBar();

	public static Menu file = new Menu("File");
	public static Menu edit = new Menu("Edit");
	public static Menu view = new Menu("View");

	public static MenuItem save = new MenuItem("Save");
	public static MenuItem load = new MenuItem("Load");

	/*
	 * Menu end
	 */

	public JSplitPane splitter;
	
	public static int displaySize = 64;

	public static int xOff;
	public static int yOff;

	public Start(int width, int height, String title) {

		
		super(width, height, title);

		FRAME.setResizable(true);
		editor = new EditorPane();

		editor.setMinimumSize(new Dimension(200, 200));
		editor.addMouseListener(new Mouse());
		editor.addMouseMotionListener(new Mouse());
		
		splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, editor, new JPanel());
		splitter.setDividerLocation(686);
		
		
		
//		splitter.add(editor);
		
		FRAME.add(splitter);

		file.add(save);
		file.add(load);

		bar.add(file);
		bar.add(edit);
		bar.add(view);

		FRAME.setMenuBar(bar);

		FRAME.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				
				
				if (e.getPreciseWheelRotation() > 0) {
					displaySize /= 1.2;
					if (displaySize < 16) {
						displaySize = 16;
					} else {
//						xOff += (displaySize * 50) / 10;
//						yOff += (displaySize * 50) / 10;
					}
				} else {
					displaySize *= 1.2;
					
					if (displaySize > 256) {
						displaySize = 256;
					} else {
//						xOff -= (displaySize * 50) / 10;
//						yOff -= (displaySize * 50) / 10;
					}
				}

//				xOff = WIDTH / 2 - (displaySize * 50) / 2; 
//				yOff = HEIGHT / 2 - (displaySize * 50) / 2;
				
			}
		});

		disable(LE_GRAPHICS);

		skipIntro();
		start();
	}

	boolean isPressing = false;

	int xDiff, yDiff;

	@Override
	public void update() {

		if (Mouse.getButton() == Mouse.BUTTON_MIDDLE && !isPressing) {
			isPressing = true;

			xDiff = Mouse.getX() - xOff;
			yDiff = Mouse.getY() - yOff;
		} else if (Mouse.getButton() != Mouse.BUTTON_MIDDLE && isPressing) {
			isPressing = false;
		}
		if (Mouse.getButton() == Mouse.BUTTON_MIDDLE) {
			xOff = Mouse.getX() - xDiff;
			yOff = Mouse.getY() - yDiff;
		}

	}

	@Override
	public void render() {
		FRAME.paintAll(g);
	}

	public static void main(String[] args) {
		new Start(1024, 720, "Miners of Aragos - Level Builder");
	}

}
