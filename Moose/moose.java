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


class moose
{
	private char[][] mat;  
	private int count;
	private int max;
	
	public void run()throws Exception
	{		
		
		Scanner file=new Scanner(new File("moose.dat"));		
					
		int loops=file.nextInt();
		for(int loop=0; loop<loops; loop++)
		{
			int rows=10;					
			int cols=10;
			file.nextLine();
			
			count = 0;
			max = 0;
			
			//read in the maze
			mat = new char[rows][cols];
			
			
			
			for(int i = 0; i < rows; i++)
			{
				String s = file.next();
				for(int j = 0; j < cols; j++)
				{
					mat[i][j] = s.charAt(j);
				}
			}
			
			for(char[] x : mat)
			{
				System.out.println(Arrays.toString(x));
			}
			
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					if(mat[i][j] == 'M')
					{
						count = 0;
						recur(i,j);
						if(count > max)
						{
							max = count;
						}
					}
				}
			}
			
			
			
			//print the matrix
			
			
			
			
			System.out.println("Biggest population: " + max + "\n");
		   
		}
		file.close();
	}
	
	public void recur(int r, int c)
	{
		if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && mat[r][c] == 'M')
		{
			count++;
			mat[r][c] = '.';
			recur(r+1,c);
			recur(r-1,c);
			recur(r,c+1);
			recur(r,c-1);
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		moose a = new moose();
		a.run();
	}	
}


/*
moose.dat

1
M...E..MMM
...B....MM
EMMCC.BBMM
MMMM..B..M
MMM.B..FMM
MMMMFFFMMM
CC.BM..MMM
BECMM...FJ
..CMMFF.B.

*/
