package LinkedList;

public class test {

	public static void main(String[] args) {
		//SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.insertAtBegining("apple");
        list.insertAtBegining("pear");
        list.insertAtEnd("peach");
        list.insertAtEnd("banana");
        list.insertAtIndex("Hello", 2);
        System.out.println(list.size());
        System.out.print("original: ");
        for (String item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
        
        list.removeFromBegining();
        System.out.println(list.size());
        System.out.print("1st change: ");
        for (String item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
        
        list.removeFromEnd();
        System.out.println(list.size());
        System.out.print("2nd change: ");
        for (String item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
        
        System.out.println(list.removeItem("Hello"));
        System.out.println(list.size());
        System.out.print("3rd change: ");
        for (String item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
        
        System.out.println(list.removeItem("peach"));
        System.out.println(list.size());
        System.out.print("4th change: ");
        for (String item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
        
	}

}
