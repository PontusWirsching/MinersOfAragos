package builder.editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.engine.LEngine;
import com.engine.input.Mouse;

public class EditorPane extends JPanel {

	public EditorPane() {

	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LEngine.WIDTH, LEngine.HEIGHT);

		g.setColor(Color.blue);
		for (int x = 0; x < 50; x++) {
			for (int y = 0; y < 50; y++) {
				g.drawRect(x * Start.displaySize + Start.xOff, y * Start.displaySize + Start.yOff, Start.displaySize, Start.displaySize);

			}
		}

		int mouseOnTileX = (Mouse.getX() - Start.xOff) / Start.displaySize;
		int mouseOnTileY = (Mouse.getY() - Start.yOff) / Start.displaySize;

		g.setColor(Color.MAGENTA);
		g.drawRect(mouseOnTileX * Start.displaySize + Start.xOff, mouseOnTileY * Start.displaySize + Start.yOff, Start.displaySize, Start.displaySize);

		g.setColor(Color.RED);
		g.drawString("" + 50 * Start.displaySize, Start.xOff + Start.displaySize / 2, Start.yOff - 60);
		g.drawLine(Start.xOff, Start.yOff - 50, Start.xOff + 50 * Start.displaySize, Start.yOff - 50);
		g.drawLine(Start.xOff + 50 * Start.displaySize, Start.yOff - 50, Start.xOff + 50 * Start.displaySize, Start.yOff);
		g.drawLine(Start.xOff, Start.yOff - 50, Start.xOff, Start.yOff);
		g.drawLine(Start.xOff - 50, Start.yOff, Start.xOff - 50, Start.yOff + 50 * Start.displaySize);
		g.drawLine(Start.xOff - 50, Start.yOff, Start.xOff, Start.yOff);
		g.drawLine(Start.xOff - 50, Start.yOff + 50 * Start.displaySize, Start.xOff, Start.yOff + 50 * Start.displaySize);
		g.setColor(Color.green);
		g.drawString("" + Start.displaySize, Start.xOff + Start.displaySize / 2, Start.yOff - 30);
		g.drawLine(Start.xOff, Start.yOff - 25, Start.xOff + Start.displaySize, Start.yOff - 25);
		g.drawLine(Start.xOff, Start.yOff - 25, Start.xOff, Start.yOff);
		g.drawLine(Start.xOff + Start.displaySize, Start.yOff - 25, Start.xOff + Start.displaySize, Start.yOff);
		g.drawLine(Start.xOff - 25, Start.yOff, Start.xOff - 25, Start.yOff + Start.displaySize);
		g.drawLine(Start.xOff - 25, Start.yOff, Start.xOff, Start.yOff);
		g.drawLine(Start.xOff - 25, Start.yOff + Start.displaySize, Start.xOff, Start.yOff + Start.displaySize);
		g.setColor(Color.yellow);
		g.setFont(new Font("Arial", 1, 20));
		// g.drawString("" + (Mouse.getX() - 3 - Start.xOff) / Start.displaySize
		// + ", " + (Mouse.getY() - 45 - Start.yOff) / Start.displaySize + ", ("
		// + (Mouse.getX() - 3 - Start.xOff) + ", " + (Mouse.getY() - 45 -
		// Start.yOff) + ")", Mouse.getX(),
		// Mouse.getY());
		g.drawLine(0, Mouse.getY(), 50, Mouse.getY());

		g.drawLine(Mouse.getX(), 0, Mouse.getX(), 50);
		
		
		g.setColor(Color.cyan);
		g.drawLine(getWidth() / 2, 0, getWidth() / 2, 50);
		g.drawLine(0, getHeight() / 2, 50,getHeight() / 2);

	}

}
