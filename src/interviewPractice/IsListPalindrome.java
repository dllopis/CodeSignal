package interviewPractice;

import java.util.ArrayList;

public class IsListPalindrome {
	
	public boolean isListPalindrome(ListNode<Integer> l) {
		
		// current will serve as our reference node as we traverse through each node
		ListNode<Integer> current = l;
		
		// get a printout of what are list consist of
		System.out.print("ListNode: ");
		
		while(current != null)	{
			System.out.print(current.value + " ");
			current = current.next;
		}System.out.println("");
		
		// reinitialize our current to starting node
		current = l;
		
		//create an arraylist in order to store our list and check for palindrome condition
		//this will serve as the additional O(1) space complexity to solve this in O(n) time complexity
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		//traverse through and add each node's value to arraylist a
		while(current != null)	{
			a.add(current.value);
			current = current.next;
		}
		// get a printout to verify contents
		System.out.println("ArrayList[" + a.size() + "]: " + a);
		
		// now we check for palindome condition
		// initialize j to last element
		int j = a.size() - 1;
		
		// then we compare last element to first element and increment i and decrement j to check again
		for(int i = 0;i<=j;i++)
		{
			if((int)a.get(i) != (int)a.get(j))
	            return false; // palindome condition fails here - return false
			j--;
		}
		// palindrome condition passes - return true
		return true;

	}
	
	public static void main(String[] args) {
	
		// create nodes with values
		ListNode<Integer> n1 = new ListNode<Integer>(1);
		ListNode<Integer> n2 = new ListNode<Integer>(-100);
		ListNode<Integer> n3 = new ListNode<Integer>(1);
		ListNode<Integer> n4 = new ListNode<Integer>(-100);
		ListNode<Integer> n5 = new ListNode<Integer>(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		IsListPalindrome isPalindrome = new IsListPalindrome();
		System.out.println("Palindrome? : " + isPalindrome.isListPalindrome(n1));
		
		System.out.println("\n---- Next ListNodes ----\n");
		// create nodes with values
		ListNode<Integer> n6 = new ListNode<Integer>(1);
		ListNode<Integer> n7 = new ListNode<Integer>(1000000000);
		ListNode<Integer> n8 = new ListNode<Integer>(-1000000000);
		ListNode<Integer> n9 = new ListNode<Integer>(-1000000000);
		ListNode<Integer> n10 = new ListNode<Integer>(1000000000);
		ListNode<Integer> n11 = new ListNode<Integer>(1);
		
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n11;
		n11.next = null;
		
		IsListPalindrome isPalindrome2 = new IsListPalindrome();
		System.out.println("Palindrome? : " + isPalindrome2.isListPalindrome(n6));
				

	}

}
