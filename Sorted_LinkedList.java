package playing;

public class Sorted_LinkedList {
	private static ListNode front;
	public static int get(int index) { // returns the element at index 
		ListNode current = front;
		for(int i=0;i<index;++i) {
			current = current.next;
		}
		return current.data;
	}
	public static void addSorted(int value) {
		if(front==null || value<=front.data) {
			front = new ListNode(value,front);
		}
		else {
			ListNode current = front;
			while(current.next !=null && current.next.data < value) {
				current = current.next;
			}
			current.next = new ListNode(value, current.next);
		}
	}
	public static void add(int value,int index) {
		if(index==0) {
			front = new ListNode(value,front);
		}
		else {
			ListNode current = front;
			for(int i=0;i<index-1;i++) {
				current = current.next;
			}
			current.next = new ListNode(value,current.next);
		}
	}
	public static int remove() {  //removes the element from the 0-th index
		if(front == null) {
			System.exit(-1);
		}
		int result = front.data;
		front = front.next;
		return result;
	}
	public static void remove(int index) {  // removes the element from given index
		if(index==0) {
			front = front.next;
		}
		else {
			ListNode current=front;
			for(int i=0;i<index-1;++i) {
				current = current.next;
			}
			current.next = current.next.next;
		}
	}
	public static void print_List() {
		ListNode current = front;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	public static void main(String[] args) {
		front = null;
		ListNode list = new ListNode(-3,new ListNode(18,new ListNode(42)));
		front = list;
		addSorted(21);
		addSorted(4);
		print_List();
//		remove();
//		remove(3);
		//System.out.println(get(3));
	}
}
