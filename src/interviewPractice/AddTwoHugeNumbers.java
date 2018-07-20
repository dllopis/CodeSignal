package interviewPractice;

class ListNode<T> {
	  
	ListNode(T x) {
	     value = x;
	}
	T value;
	ListNode<T> next;
}

public class AddTwoHugeNumbers {

	 /* Function to reverse the linked list */
	 public ListNode<Integer> reverse(ListNode<Integer> n) {
		ListNode<Integer> previous = null;
		ListNode<Integer> current = n;
		ListNode<Integer> next = null;
		
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        n = previous;
        return n;
    }
	
	 public ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
		    ListNode<Integer> result = new ListNode<Integer>(0);
		    ListNode<Integer> head = result;
		    
		    int carry=0;
		    
		    ListNode<Integer> current_A = reverse(a);
		    ListNode<Integer> current_B = reverse(b); 
		    
		    while(current_A !=null || current_B !=null)	{
		        
		    	if(current_A != null){
		            carry += a.value;
		            current_A=current_A.next;
		        }
		        if(current_B != null){
		            carry += current_B.value;
		            current_B= current_B.next;
		        }
		        head.next = new ListNode<Integer>(carry % 10000);
		        head = head.next;
		        carry = carry / 10000;
		    }
		    if(carry >= 1)
		        head.next= new ListNode<Integer>(carry);
		    
		    return reverse(result.next);
		    
		}
	public static void displayList(ListNode<Integer> node)	{
		
		ListNode<Integer> current = node;
		
		while(current != null)	{
			System.out.print(current.value + " ");
			current = current.next;
		}System.out.println("");
	}
	public static void main(String[] args) {
		// instance of class
		AddTwoHugeNumbers instance = new AddTwoHugeNumbers();
		
		// 1st list
		ListNode<Integer> list1_n1 = new ListNode<Integer>(9999);
		ListNode<Integer> list1_n2 = new ListNode<Integer>(9999);
		ListNode<Integer> list1_n3 = new ListNode<Integer>(9999);
		ListNode<Integer> list1_n4 = new ListNode<Integer>(9999);
		ListNode<Integer> list1_n5 = new ListNode<Integer>(9999);
		ListNode<Integer> list1_n6 = new ListNode<Integer>(9999);
		
		// link nodes together
		list1_n1.next = list1_n2;
		list1_n2.next = list1_n3;
		list1_n3.next = list1_n4;
		list1_n4.next = list1_n5;
		list1_n5.next = list1_n6;
		list1_n6.next = null;
		
		// 2nd list
		ListNode<Integer> list2_n1 = new ListNode<Integer>(1);
		
		// link nodes together
		list2_n1.next = null;
		
		// display each linked list
		System.out.print("List 1: ");
		displayList(list1_n1);
		
		System.out.print("List 2: ");
		displayList(list2_n1);
		
		System.out.print("Reversed list 1: ");
		displayList(list1_n1);
		
		System.out.print("Reversed list 2: ");
		displayList(list2_n1);
		
		// Add both huge numbers
		ListNode<Integer> result = instance.addTwoHugeNumbers(list1_n1, list2_n1);
		
		// display result
		System.out.print("Result: ");
		displayList(result);
		
		

	}

}