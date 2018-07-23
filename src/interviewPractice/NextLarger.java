package interviewPractice;

import java.util.Stack;

public class NextLarger {

	public int[] nextLarger(int[] a)	{
		
		// this will return solution after values are placed in their correct index
		int[] b = new int[a.length];
		
		// stack implementation will allow O(n) + O(n) = O(n) complexity
		Stack<Integer> stack = new Stack<Integer>();

		// traverse the array once and store into stack accordingly using the values index
		for(int i = 0;i<a.length;i++)	{
			// if nothing exists in stack, push it
			if(stack.isEmpty())	{
				stack.push(i);
			}
			else	{
				
				// check to see if our current a[i] value is greater than what is on top of the stack
				// if so, then that index on top of stack will be assigned to the index for our solution 'b' array index
				while(!stack.isEmpty() && a[i] > a[stack.peek()])	{
					System.out.println("Store at index: " + stack.peek() + " | " + a[stack.peek()] + " --> " + a[i]);
					b[stack.pop()] = a[i];
				}
				stack.push(i);
			}
		}
		
		// clean out the stack and assign the index value to -1 since no greater element exists
		while(!stack.isEmpty())	{
			System.out.println("Store at index: " + stack.peek() + " | " + a[stack.peek()] + " --> " + -1);
			b[stack.pop()] = -1;
		}
		return b;
	}

	public int[] nextLargerBrute(int[] a)	{
		
		int[] b = new int[a.length];
		
		for(int i = 0;i<a.length;i++)	{
			int next = -1;
			for(int j = i+1; j < a.length;j++)	{
				if(a[j] > a[i])	{
					next = a[j];
					break;
				}
			}
			//System.out.println(a[i] + " --> " + next);
			b[i] = next;
		}
		return b;
	}
	public void display(int[] a, String s)	{
		
		System.out.print(s + "[");
		for(int i = 0;i<a.length;i++)	{
			if(i == a.length-1)
				System.out.println(a[i] + "]");
			else
				System.out.print(a[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6, 2, 7, 3, 1, 0, 4, 5};
		
		NextLarger result = new NextLarger();
		int[] b = result.nextLarger(a);
		result.display(b, "Solution: ");
	}
		
}
