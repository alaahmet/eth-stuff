
public class LinkedIntList {
	private static IntNode front; // front has first, last, size
	public static void addFirst(int value) {
		if(front.size==0) {
			front = new IntNode(0,1,new IntNode(value));
		}
		else {
			IntNode temp = new IntNode(value,front.first);
			front.first = temp;
			front.size = front.size + 1;
		}
	}
	public static int removeFirst() {
		if(front.first == null) {
			Errors.error("There is no first element!");
			System.exit(-1);
		}
		else if(front.size==1){
			System.out.println(front.size);
			int first_element = front.first.value;
			front = new IntNode(0,null,null);
			front.size = front.size - 1;
			return first_element;
		}
		else {
			int first_element = front.first.value;
			front.first = front.first.next;
			front.size = front.size - 1;
			return first_element;
		}
		return -1;
	}
	public static int removeLast() {
		if(front.first == null) {
			Errors.error("There is no last element!");
			System.exit(-1);
		}
		else if(front.size==1){
			int first_element = front.first.value;
			front = new IntNode(0,null,null);
			front.size = front.size - 1;
			return first_element;
		}
		else {
			int last_element = front.last.value;
			IntNode current = front.first;
			while(current.next.next != null) {
				current = current.next;
			}
			front.last = current;
			front.last.next = null;
			front.size = front.size - 1;
			return last_element;
		}
		return -1;
	}
	public static void clear() {
		front = new IntNode(0,null,null);
	}
	public static boolean isEmpty() {
		return front.size == 0 ? true : false;
	}
	public static int get(int index) {//// I assume indexing starts from 0
		if(front.size <= index) {
			Errors.error("There is no element at given index");
			System.exit(-1);
		}
		IntNode current = front.first;
		for(int i=0;i<index;i++) {
			current = current.next;
		}
		return current.value;
	}
	public static void set(int index, int value) {//// I assume indexing starts from 0
		if(front.size <= index) {
			Errors.error("There is no element at given index");
			System.exit(-1);
		}
		IntNode current = front.first;
		for(int i=0;i<index;i++) {
			current = current.next;
		}
		current.value = value;
	}
	public static void main(String[] args) {
		front = new IntNode(0,null,null);// it is my LinkedIntList object and has first,last and size
		addFirst(1);
		addFirst(3);
		addFirst(5);
		addFirst(7);
		
		
//		System.out.println(get(3));
//		set(3,21);
//		System.out.println(get(3));
//		System.out.println(removeLast());
//		System.out.println(front.first.value);
//		System.out.println(removeLast());
//		System.out.println(front.last.value);
		
	}

}
