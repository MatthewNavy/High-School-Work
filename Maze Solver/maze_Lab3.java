import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class maze_Lab3
{
	private char[][] mat;   //a
	private boolean solved;
	private int min;	//a
	private int[][] shadow;
	
	public void run()throws Exception
	{		
		//1s are walls
		//0s are open spaces
		//S is start
		//E is end
		
		Scanner file=new Scanner(new File("maze.dat"));		
					
		int loops=file.nextInt();
		for(int loop=0; loop<loops; loop++)
		{
			int rows=file.nextInt();					
			int cols=file.nextInt(); 
			file.nextLine();
			
			solved = false;
			min = rows * cols;
			
			//read in the maze
			mat = new char[rows][cols];
			shadow = new int[rows][cols];
			
			int sR = 0;
			int sC = 0;
			
			for(int i = 0; i < rows; i++)
			{
				String s = file.next();
				for(int j = 0; j < cols; j++)
				{
					mat[i][j] = s.charAt(j);
					shadow[i][j] = rows * cols;
					if(mat[i][j] == 'S')
					{
						sR = i;
						sC = j;
						System.out.println("Starting position: " + sR + ", " + sC);
					}
				}
			}
			
			
			//print the matrix
			for(char[] x : mat)
			{
				System.out.println(Arrays.toString(x));
			}
			
			
			//find the start - S
			
			
		   //call the recur method
			recur(sR, sC, 0);
			if(!solved)
			{
				System.out.println("No exit found :(\n");
			}
			else 
			{
				System.out.println("Maze exit found!");
				System.out.println("Shortest path steps: " + min + "\n");
			}
			//print the matrix
			//for(int[] x : shadow)
			//{
			//	System.out.println(Arrays.toString(x));
			//}
		   
		}
		file.close();
	}
	
	public void recur(int r, int c, int steps)
	{
		//add a base case
		if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && mat[r][c] != '1' && steps < min && steps < shadow[r][c])
		{
			char saveChar = mat[r][c];
			if(mat[r][c] == 'E' && steps < min)
			{
				solved = true;
				min = steps;
			}
			shadow[r][c] = steps;
			
			mat[r][c] = '1';
			recur(r+1,c,steps+1);
			recur(r-1,c,steps+1);
			recur(r,c+1,steps+1);
			recur(r,c-1,steps+1);
			mat[r][c] = saveChar;
		}
	
		//add in 4 recursive calls
	}
	
	public static void main(String[] args)throws Exception
	{
		maze_Lab3 a = new maze_Lab3();
		a.run();
	}	
}


/*
maze.dat

2
6 6
1S1111
000111
010011
0110E1
000001
000001
6 6
1S1111
000111
010011
0111E1
011110
000000

*/
