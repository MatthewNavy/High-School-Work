import java.util.*;

public class PostFixSolver
{
	public static int solve( String s )
	{
		Stack<Integer> stack = new Stack<Integer>();
		String[] expression = s.split(" ");
		for(int i = 0; i < expression.length; i++)
		{
			
			if(expression[i].matches("\\d+"))
			{		
				stack.push(Integer.parseInt(expression[i]));
			}
			
			else if(expression[i].equals("+"))
			{
				int a = stack.get(stack.size()-2);
				int b = stack.peek();
				
				stack.pop();
				stack.pop();
				
				stack.push(a + b);
			}
			else if(expression[i].equals("-"))
			{
				int a = stack.get(stack.size()-2);
				int b = stack.peek();
				
				stack.pop();
				stack.pop();
				
				stack.push(a - b);
			}
			else if(expression[i].equals("*"))
			{
				int a = stack.get(stack.size()-2);
				int b = stack.peek();
				
				stack.pop();
				stack.pop();
				
				stack.push(a * b);
			}
			else if(expression[i].equals("/"))
			{
				int a = stack.get(stack.size()-2);
				int b = stack.peek();
				
				stack.pop();
				stack.pop();
				
				stack.push(a / b);
			}
		}
		return stack.peek();
	}
	
	public static String convertToPostfix( String s )
	{
		String[] expression = s.split(" ");
		String str = "";
		Stack<String> stack = new Stack<String>();
		
		for(int i = 0; i < expression.length; i++)
		{
			String x = expression[i];
			
			if(x.matches("\\d+"))
			{
				str += x + " ";
			}
			
			else if(stack.isEmpty())
			{
				stack.push(x);
			}
			else
			{
				if((x.equals("+") || x.equals("-")) && (stack.peek().equals("*") || stack.peek().equals("/")))
				{
					while(!stack.isEmpty())
					{
						str += stack.pop() + " ";
					}
				}
				
				else if( (x.equals("+") || x.equals("-")) && (stack.peek().equals("+") || stack.peek().equals("-")) )
				{
					str += stack.pop() + " ";
				}
				
				else if( (x.equals("*") || x.equals("/")) && (stack.peek().equals("*") || stack.peek().equals("/")) )
				{
					str += stack.pop() + " ";
				}
				
				
				stack.push(x);	
					
					
					
				/*
				while((stack.peek().equals("*") || stack.peek().equals("-") ||   )) && (x.equals("+") || x.equals("-")))
				{
					str += stack.peek() + " ";
					stack.pop();
				}
				stack.push(x);
				*/
			}
			//System.out.println(stack);
			//System.out.println(str);
			
		}
		
		for(int j = 0; j < stack.size() + 1; j++)
		{
			str += stack.pop() + " ";
		}
		
		return str;
	}	
}

