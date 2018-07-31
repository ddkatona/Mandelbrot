import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Contains and executes the animation.
 */
class Animation {
	
	
	void paint (Graphics g) {
		
		Graphics2D graphics = (Graphics2D)g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.clipRect(0, 0, Properties.WIDTH, Properties.HEIGHT);
		
		//graphics.drawImage(new BufferedImage(),);
	}
	
}