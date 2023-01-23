class NodeDouble{

	int data;
	NodeDouble prev,next;
	NodeDouble(int data){

		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
public class DoubleLinkedList{

	NodeDouble head = null,tail = null;
	public void add(int data){

		NodeDouble newNode = new NodeDouble(data);
		if(head == null){

			head = newNode;
			tail = newNode;
		}
		else{

			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	public void update(int index,int newValue){

		int count = -1;
		NodeDouble curr = head;
		boolean exist = false;
		while(curr != null){
		
			count++;
			if(index == count){
				
				exist = true;
				curr.data = newValue;
				System.out.println("Data updated!!");
				print();
				break;	
			}
			curr = curr.next;
		}
		if(exist == false){

			System.out.println("Index Not found");
		}
	}
	public void add(int index,int data){

		NodeDouble curr = head;
		NodeDouble temp = new NodeDouble(data);
		int count = -1;
		boolean exist = false;
		while(curr != null){

			count++;
			if(index == count){
			
				temp.prev = curr.prev;
				temp.next = curr;
				curr.prev = temp;
				temp.prev.next = temp;
				exist = true;
				print();
				break; 	
			}
			curr = curr.next;
		}
		if(exist == false){

			System.out.println("Index Not found");			
		}
	}
	public void delete(int index){

		NodeDouble curr = head;
		int count = -1;
		boolean exist = false;
		while(curr != null){

			count++;
			if(count == index){

				curr.next.prev = curr.prev;
				curr.prev.next = curr.next;
				exist = true;
				print();
				break;
			}
			curr = curr.next;
		}
	}
	public void print(){

		NodeDouble curr = head;
		System.out.println("Linked List Elements");
		while(curr != null){
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	public static void main(String[] args){

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.add(1);
		dll.add(2);
		dll.add(3);
		dll.print();
		dll.update(2,4);
		dll.delete(0);
		dll.add(2,5);
	}
}