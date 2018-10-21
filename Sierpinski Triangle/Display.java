import java.awt.*;
import javax.swing.JFrame;
import java.util.*;

public class Display extends JFrame
{
	Fractal fractal;
	final int width_;
	final int height_;
	//int[] c;
	
	
	public Display()
	{
		super("Sierpinski triangle");
		
		
		width_ = 800;
		height_ = 800;
		
		//c = new int[3];
		fractal = new Fractal(7);
		
		
		setSize(width_,height_);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paint(Graphics window)
	{
		int[] xpoints = {width_/8, width_/2, (width_/8)*7};
		int[] ypoints = {(height_/8)*7, height_/8, (height_/8)*7};
		
		Polygon p = new Polygon(xpoints,ypoints,3);
		
		window.drawPolygon(p);
		
		
			fractal.recur(p,0);
		
		Stack<Polygon> stack = fractal.getStack();
		
		try
		{
			while(!stack.isEmpty())
			{
				Thread.sleep(5);
				window.drawPolygon(stack.pop());
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("whoops");
		}
		/*
		TreeMap<int[],Polygon[]> map = fractal.getMap();
		
		for(int[] color : map.keySet())
		{
			Color c1 = new Color(color[0],color[1],color[2]);
			
			window.setColor(c1);
			Polygon[] shapes = map.get(color);
			for(int i = 0; i < 3; i++)
			{
				window.drawPolygon(shapes[i]);
			}
		}
		*/
		
	}
	
	
	public static void main(String[] args)
	{
		Display execute = new Display();
	}
	
	
	
}
