import java.util.*;

class Node{
	int data;
	Node next;
	Node(int data){
		
		this.data = data;
		this.next = null;
	}
}
public class SingleLinkedList{

	Node head = null;
	Node tail = null;
	public void add(int data){
		
		Node newNode = new Node(data);
		if(head == null){

			head = newNode;
			tail = newNode;
		}
		else {

			tail.next = newNode;
			tail = newNode;
		}
	}
	public void add(int index,int data){

		Node newNode = new Node(data);
		Node curr = head;
		int count = 0;
		boolean exist = false;
		if(index > 0 && curr != null){
		
			Node currNext = curr.next;
			while(currNext != null){

				count++;
				if(index == count){

					newNode.next = currNext;
					curr.next = newNode;
					System.out.println("Adding data in particular index");
					traversal();
					exist = true;
					break;
				}
				curr = currNext;
				currNext = currNext.next;
			}	
		} 
		else if(index == 0 && curr != null){

			newNode.next = head;
			head = newNode;
		}
		if(exist == false){
			
			System.out.println("Index not found");
		} 
	}
	public void update(int index,int data){

		Node curr = head;
		int count = -1;
		boolean exist = false;
		while(curr != null){

			count++;
			if(index == count){

				curr.data = data;
				exist = true;
				System.out.println("Update a Element!");
				traversal();
				break;
			}
			curr = curr.next;
		}
		if(exist == false){
			
			System.out.println("Index not found");
		}
	}
	public void delete(int index){

		Node curr = head;
		int count = -1;
		boolean exist = false;
		
			Node currNext = curr.next;
			while(currNext != null){

				count++;
				if(index == count){

					if(index == 0){

						head = curr.next;
					}
					curr.next = currNext;
					
					System.out.println("deleting Node in particular index");
					traversal();
					exist = true;
					break;
				}
				curr = currNext;
				currNext = currNext.next;
			}	
		
		if(exist == false){
			
			System.out.println("Index not found");
		}
	}
	public void traversal(){

		Node curr = head;
		System.out.println("Elements");
		while(curr != null){

			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	public static void main(String[] args){

		SingleLinkedList sll = new SingleLinkedList();
		sll.add(1);
		sll.add(2);
		sll.traversal();
		sll.add(1,4);			
		sll.delete(0);
		sll.update(0,1);
		sll.add(3);
		sll.traversal();
	}	
}