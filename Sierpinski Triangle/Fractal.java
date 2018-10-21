import java.util.*;
import java.awt.*;

public class Fractal
{
	int iterations;
	Stack<Polygon> stack;
	//int[] c;
	//TreeMap<int[],Polygon[]> map;
	
	public Fractal(int i)
	{
		iterations = i;
		stack = new Stack<Polygon>();
		//c = q;
		//map = new TreeMap<int[],Polygon[]>();
	
	}
	
	public void recur(Polygon p, int its)
	{
		if(its < iterations)
		{		
			
			int[] p1xpoints = new int[3];
			int[] p1ypoints = new int[3];
			
			int[] p2xpoints = new int[3];
			int[] p2ypoints = new int[3];
			
			int[] p3xpoints = new int[3];
			int[] p3ypoints = new int[3];
			
			
			p1xpoints[0] = p.xpoints[0];	//unchanged from p
			p1xpoints[1] = (p.xpoints[0] + p.xpoints[1]) / 2;
			p1xpoints[2] = p.xpoints[1]; 
			
			p1ypoints[0] = p.ypoints[0];	//unchanged from p
			p1ypoints[1] = (p.ypoints[0] + p.ypoints[1]) / 2;
			p1ypoints[2] = p.ypoints[2];	//unchanged from p
			
			
			
			p2xpoints[0] = (p.xpoints[0] + p.xpoints[1]) / 2;
			p2xpoints[1] = p.xpoints[1];	//unchanged from p
			p2xpoints[2] = (p.xpoints[1] + p.xpoints[2]) / 2;
			
			p2ypoints[0] = (p.ypoints[0] + p.ypoints[1]) / 2;
			p2ypoints[1] = p.ypoints[1];	//unchanged from p
			p2ypoints[2] = (p.ypoints[1] + p.ypoints[2]) / 2;
			
			
			
			p3xpoints[0] = p.xpoints[1];
			p3xpoints[1] = (p.xpoints[1] + p.xpoints[2]) / 2;
			p3xpoints[2] = p.xpoints[2]; 	//unchanged from p
			
			p3ypoints[0] = p.ypoints[0];	//unchanged from p
			p3ypoints[1] = (p.ypoints[1] + p.ypoints[2]) / 2;
			p3ypoints[2] = p.ypoints[2];	//unchanged from p
			
			
			Polygon p1 = new Polygon(p1xpoints,p1ypoints,3);
			Polygon p2 = new Polygon(p2xpoints,p2ypoints,3);
			Polygon p3 = new Polygon(p3xpoints,p3ypoints,3);
			//Polygon[] shapes = {p1,p2,p3};
			
			
			/*
			int r = colors[0];
			int g = colors[1];
			int b = colors[2];
			
			if(r < 255)
			{
				b = 0;
				r += 5;
			}
			else if(g < 255)
			{
				r = 0;
				g += 5;
			}
			else if(b < 255)
			{
				g = 0;
				b += 5;
			}
			
			int[] color = {r,g,b};
			
			
			map.put(color,shapes);
			
			 */
			
			stack.push(p1);
			stack.push(p2);
			stack.push(p3);
			
			recur(p1,its+1);
			recur(p2,its+1);
			recur(p3,its+1);
		}
		
	}
	
	public Stack<Polygon> getStack()
	{
		return stack;
	}
	
	//public TreeMap<int[],Polygon[]> getMap()
	//{
	//	return map;
	//}
	
}