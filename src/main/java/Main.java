/**
 * Created by ddkatona on 7/31/2018.
 */
import org.apache.commons.math.complex.Complex;

import java.awt.*;
import java.io.*;
import java.awt.image.*;
import java.util.Comparator;
import javax.imageio.*;

public class Main{
	public static void main(String args[]){
		
		getMBValue(new Complex(1, 1));
		
		try{
			BufferedImage img = new BufferedImage(
					500, 500, BufferedImage.TYPE_INT_RGB );
			
			File f = new File("MyFile.png");
			for(int x = 0; x < 500; x++){
				for(int y = 20; y < 500; y++){
					Complex c = map(new Complex(x, y), -2, 2);
					int val = getMBValue(c);
					Color col = iterColor(val);
					img.setRGB(x, y, col.getRGB());
				}
			}
			ImageIO.write(img, "PNG", f);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int getMBValue(Complex c) {
		Complex z = new Complex(0, 0);
		
		int i = 0;
		while (i < 100) {
			//System.out.println(z.getReal() + " " + z.getImaginary());
			z = z.multiply(z).add(c);
			if(Math.abs(z.getImaginary() + z.getReal()) > 60) {
				return i;
			}
			i++;
		}
		
		return i;
	}
	
	public static Color iterColor(int i) {
		double norm = i / 100.0;
		int rgb = (int)Math.floor(norm*255);
		return new Color(rgb, rgb, rgb);
	}
	
	public static Complex map(Complex c, double min, double max) {
		double real = c.getReal();
		double imag = c.getImaginary();
		
		real /= 500;
		imag /= 500;
		
		real *= max - min;
		imag *= max - min;
		
		real += min;
		imag += min;
		
		return new Complex(real, imag);
	}
}

