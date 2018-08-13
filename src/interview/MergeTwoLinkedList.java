package interview;

public class MergeTwoLinkedList {
	// list will be in non-decreasing order
	// merge in ascending order.
	ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		
		// holds head pointer to result linked list in ascending order
		ListNode<Integer> result = new ListNode<Integer>(0);
		
		// store current node to be compared
		ListNode<Integer> current = result;
		
		// iterate while both list still exist
		while(l1 != null || l2 != null)	{
			// if either list is null break
			if(l1 == null)	{
				break;
			}
			else if(l2 == null)	{
				break;
			}else {
				// compare values and add to result accordingly
				if(l1.value <= l2.value)	{
					current.next = l1;
					current = current.next;
					l1 = l1.next;
				}else	{
					current.next = l2;
					current = current.next;
					l2 = l2.next;
				}
			}
		}
		// while list1 exists, fill in result list
		while(l1 != null)	{
			current.next = l1;
			current = current.next;
			l1 = l1.next;
		}
		// while list2 exists, fill in result list
		while(l2 != null)	{
			current.next = l2;
			current = current.next;
			l2 = l2.next;
		}
		// return the ascending order of both list merged
		return result.next;
	}
	
	public void displayList(ListNode<Integer> list)	{
		while(list != null)	{
			System.out.print(list.value + " ");
			list = list.next;
		}System.out.println("");
	}
	public static void main(String[] args) {
		
		ListNode<Integer> list1_n1 = new ListNode<Integer>(1);
		ListNode<Integer> list1_n2 = new ListNode<Integer>(2);
		ListNode<Integer> list1_n3 = new ListNode<Integer>(3);
		
		ListNode<Integer> list2_n1 = new ListNode<Integer>(4);
		ListNode<Integer> list2_n2 = new ListNode<Integer>(5);
		ListNode<Integer> list2_n3 = new ListNode<Integer>(6);
		
		
		list1_n1.next = list1_n2;
		list1_n2.next = list1_n3;
		list1_n3.next = null;
		
		list2_n1.next = list2_n2;
		list2_n2.next = list2_n3;
		list2_n3.next = null;
		
		MergeTwoLinkedList merge = new MergeTwoLinkedList();
		
		merge.displayList(list1_n1);
		merge.displayList(list2_n1);
		
		ListNode<Integer> result = merge.mergeTwoLinkedLists(list1_n1, list2_n1);
		merge.displayList(result);

	}

}
