package interview;

public class ReverseNodesInKGroups {
	
	public ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k)	{
		
		if(l == null|| k == 1)
	        return l;
 
		// new linked list to return when finished
	    ListNode<Integer> result = new ListNode<Integer>(0);
	    
	    // keep track of subgroups -- when counter = k --
	    int counter = 0;
	    
	    // link head to result list
	    result.next = l;
	    
	    // node before next subgroup head
	    ListNode<Integer> previous = result;
	    
	 
	    ListNode<Integer> current = l;
	    
	    while(current != null){
	    	counter++;
	    	if(counter % k == 0)	{
	    		previous = reverse(previous, current.next);
	    		current = previous.next;
	    	}else{
	    		current = current.next; 
	    	}
	    }
 
    	return result.next; 
	}
	
	public ListNode<Integer> reverse(ListNode<Integer> previous, ListNode<Integer> next){
		
		ListNode<Integer> last = previous.next;
		ListNode<Integer> curr = last.next;
 
	    while(curr != next){
	        last.next = curr.next;
	        curr.next = previous.next;
	        previous.next = curr;
	        curr = last.next;
	    }
 
    return last; 
	}
	
	public void displayList(ListNode<Integer> l, String s)	{
		
		ListNode<Integer> current = l;
		
		System.out.print(s);
		while(current != null)	{
			System.out.print(current.value + " ");
			current = current.next;
		}System.out.println("");
	}

	public static void main(String[] args) {
		ReverseNodesInKGroups result = new ReverseNodesInKGroups();
		
		int n = 2;
		ListNode<Integer> n1 = new ListNode<Integer>(1);
		ListNode<Integer> n2 = new ListNode<Integer>(2);
		ListNode<Integer> n3 = new ListNode<Integer>(3);
		ListNode<Integer> n4 = new ListNode<Integer>(4);
		ListNode<Integer> n5 = new ListNode<Integer>(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		result.displayList(n1,"Original: ");
		System.out.println("n: " + n);
		ListNode<Integer> current = result.reverseNodesInKGroups(n1, n);
		result.displayList(current,"ReArranged: ");
	}

}