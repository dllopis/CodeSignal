package interviewPractice;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumOnStack {
	
	class Stack	{
		
		public Stack(int stackSize)	{
			size = stackSize;
			stack = new int[size];
		}

		Queue<Integer> minQueue = new LinkedList<Integer>();
		
		private int[] stack;
		private int top = -1;
		private int size;
		
		public boolean isEmpty()	{
			if(top == -1)
				return true;
			else
				return false;
		}
		public int getMin()	{
			return findMin();
		}
		public int getTop()	{
			return top;
		}
		public void push(int n)	{
			if(top == stack.length-1)	{
				System.out.println("Stack is full");
				return;
			}
			else	{
				stack[++top] = n;
			}
		}
		public int pop()	{
			
			if(!isEmpty())	{
				return stack[top--];
			}
			System.out.println("Stack is empty");
			return -1;
		}
		public int peek()	{
			if(!isEmpty())	{
				return stack[top];
			}
			System.out.println("Stack is empty");
			return -1;
		}
		public void displayStack()	{
			
			for(int i = 0;i<=top;i++)	{
				System.out.println("| " + stack[i] + "\n --- ");
			}
		}
		
		private int findMin()	{
			int currentMin = stack[0];
			
			for(int i = 0;i<=top;i++)	{
				if(stack[i] < currentMin)	{
					currentMin = stack[i];
				}
			}System.out.println("Min: " + currentMin);
			return currentMin;
		}
	}
	
	int[] minimumOnStack(String[] operations) {
		
		// initialize stack with operations array size
		Stack stack = new Stack(operations.length);
		
		// iterate through operations array and perform calls
		for(int i = 0;i<operations.length;i++)	{
			String[] command = operations[i].split(" ");
			
			System.out.print("Operation: " );
			for(int j = 0;j<command.length;j++)	{
				System.out.print(command[j] + " ");
			}System.out.println("");
			
			int n;
			
			switch(command[0])	{
				case "push" : 	n = Integer.parseInt(command[1]);
								stack.push(n);
								System.out.println("Pushed: " + n + " into stack.");
								System.out.println("Display Stack: ");
								stack.displayStack();
								break;
								
				case "pop"	: 	n = stack.pop();
								System.out.println("Popped: " + n + " from stack.");
								System.out.println("Display Stack: ");
								stack.displayStack();
								break;
								
				case "min"	: 	n = stack.getMin();
								System.out.println("Minimum value in stack: " + n);
								stack.minQueue.add(n);
								System.out.println("MinQueueSize: " + stack.minQueue.size());
								System.out.println("Display Stack: ");
								stack.displayStack();
								break;
								
			default		: 		break;
			}
			System.out.println("");
		}
		int[] result = new int[stack.minQueue.size()];
		int index = 0;
		
		while(stack.minQueue.size() > 0)	{
			result[index] = stack.minQueue.remove();
			System.out.print(result[index] + " ");
			index++;
		}System.out.println("");
		
		return result;

	}

	public static void main(String[] args) {
		String[] s = {"push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"};
		
		MinimumOnStack minStack = new MinimumOnStack();
		minStack.minimumOnStack(s);
		
		
	}

}
