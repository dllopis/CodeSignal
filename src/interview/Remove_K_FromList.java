package interview;

public class Remove_K_FromList {
	
	ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
		
	ListNode<Integer> head = new ListNode<Integer>(0); 	// will create a starting node
	ListNode<Integer> temp = head; 	// will modify the links between nodes to remove k
	
	// iterate through each node value until null is encountered
    while(l != null)	{
       if(l.value != k)	{
    	   temp.next = new ListNode<Integer>(l.value);
    	   temp = temp.next;    	   
       }
       l = l.next;
    }
    return head.next;
}
	
	public static void main(String[] args) {
		
		// create nodes with values
		ListNode<Integer> n1 = new ListNode<Integer>(1);
		ListNode<Integer> n2 = new ListNode<Integer>(5);
		ListNode<Integer> n3 = new ListNode<Integer>(5);
		ListNode<Integer> n4 = new ListNode<Integer>(5);
		ListNode<Integer> n5 = new ListNode<Integer>(3);
		ListNode<Integer> n6 = new ListNode<Integer>(3);
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
		
		System.out.print("Original List: ");
		// iterate through each node and printout value
		while(current != null)
		{
			System.out.print(current.value + " ");
			// set next node as current
			current = current.next;
		}System.out.println("");
		
		Remove_K_FromList removeK = new Remove_K_FromList();
		int k = 5;
		current = removeK.removeKFromList(n1, k);
	  
		System.out.println("");
		
		System.out.print("Modified List -- removed instances of [" + k + "]: "); 
		// iterate through each node and printout value
		while(current != null)
		{
			System.out.print(current.value + " ");
			// set next node as current
			current = current.next;
		}System.out.println("");
	}

}
