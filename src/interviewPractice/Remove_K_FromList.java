package interviewPractice;


class ListNode<T> {
	
	ListNode(T x) {
		value = x;
	}
    T value;
    ListNode<T> next;
    
}

public class Remove_K_FromList {
	

		
	ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
		
	ListNode<Integer> listNode = new ListNode<Integer>(0); 	// will create a starting node
	ListNode<Integer> current = listNode; 	// will modify the links between nodes to remove k
	
	// iterate through each node value until null is encountered
    while(l != null)	{
        
    	// check to see if current node value is not equal to k
    	if(l.value != k)	{ // if not -- add to temps node and move the pointer to next node for temp
    		current.next = l;
    		current = current.next;
        } 
        // move l's node pointer to check next node value
    	l = l.next;
    }
    	current.next = null;
	     return listNode.next; // return the first ListNode
	}
	
	public static void main(String[] args) {
		
		// create nodes with values
		ListNode<Integer> n1 = new ListNode<Integer>(1);
		ListNode<Integer> n2 = new ListNode<Integer>(2);
		ListNode<Integer> n3 = new ListNode<Integer>(3);
		ListNode<Integer> n4 = new ListNode<Integer>(4);
		ListNode<Integer> n5 = new ListNode<Integer>(5);
		ListNode<Integer> n6 = new ListNode<Integer>(6);
		ListNode<Integer> n7 = new ListNode<Integer>(7);
		
		// link nodes together
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		
		// establish a starting node
		ListNode<Integer> current = n1;
		
		// iterate through each node and printout value
		while(current != null)
		{
			System.out.println(current.value);
			// set next node as current
			current = current.next;
		}
		
		Remove_K_FromList removeK = new Remove_K_FromList();
		current = removeK.removeKFromList(n1, 10);
	  
		System.out.println("");
		
		// iterate through each node and printout value
		while(current != null)
		{
			System.out.println(current.value);
			// set next node as current
			current = current.next;
		}
	}

}
