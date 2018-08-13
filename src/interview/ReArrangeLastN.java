package interview;

public class ReArrangeLastN {

	ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
		
	/*
	 * Plan of attack: 
	 * 	1. Traverse list and get an element count - since definition of list didn't provide a size -
	 * 	2. Store and link elements that will not be rearranged into result
	 * 	3. Make a temp list of nodes that will be rearranged and linked before head node of 'Step 2'
	 */
		

		
		ListNode<Integer> result = new ListNode<Integer>(0);
		ListNode<Integer> head_result = result;
		
		ListNode<Integer> temp = new ListNode<Integer>(0);
		ListNode<Integer> pointer = temp;
		
	/* 1. */
		int size = (listSize(l) - n);
		
	/* 2. */
		for(int i = 0;i < size; i++)	{
			result.next = l;
			result = result.next;
			l = l.next;
		}
		result.next = null;
		result = head_result.next;
	/*3.*/ 
		while(l != null)	{
			temp.next = l;
			temp = temp.next;
			l = l.next;
		}
		temp.next = head_result.next;
		temp = pointer.next;
		result = temp;
		
		return result;
	}
	public int listSize(ListNode<Integer> l)	{
		int size = 0;
		
		while(l != null)	{
			size++;
			l = l.next;
		}
		
		return size;
	}
	
	public void displayList(String s,ListNode<Integer> l)	{
		System.out.print(s);
		
		while(l != null)	{
			System.out.print(l.value + " ");
			l = l.next;
		}System.out.println("");
	}
	
	public static void main(String[] args) {
		
		// original node that will be used to create and link more nodes
		ListNode<Integer> l = new ListNode<Integer>(0);
		// pointer to first node
		ListNode<Integer> head = l;
		
		// create new instances of nodes and link them together
		for(int i = 0;i<5;i++)	{
			l.next = new ListNode<Integer>(i+1);
			l = l.next;
		}
			// set l back to it's first node
			l = head.next;
		
		// represents how many elements from the end will be rearranged
		int n = 3;
		
		// create instance of class and display list
		ReArrangeLastN list = new ReArrangeLastN();
			list.displayList("Original List: ",l);
			
		// initialize a node with the rearranged result and display list
		ListNode<Integer> result = list.rearrangeLastN(l, n);
			list.displayList("Rearranged List when n = " + n +": ",result);
	}

}
