/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author kdriley0 from the book by Goodrich 
 */
public class CirclularLinkedList
{
      public static class Node{
      private  String name;
      private String gender;
      private int age;
      private Node next;     //reference to the subsequent node in the list
      private Node prev;
      public Node(String na, String g,int a, Node n, Node p){
          name =na;
          gender = g;
          age= a;
          next = n;
          prev= p;
      }
      public String getName(){return name;}
      public String getGender(){return gender;}
      public int getAge(){return age;}
      public Node getNext(){return next; }
      public void setNext(Node n) { next=n;}
  }
      private Node tail=null;
      public int size =0;
      
      public CirclularLinkedList(){}//creates a circular linked list
      //access methods 
      public int getSize() {return size;}
      public String getFirst(){ return tail.getNext().getName();}
      
       
      public boolean isEmpty(){return size== 0;}
      public Node first(){ //return the first element if not empty does not remove
          if(isEmpty()) return null;
          return tail;//the "head is after the tail
      }
      public String getGender(){return tail.getGender();}
      public String last(){//returns but does not remove the last element 
          if(isEmpty()) return null;
           return tail.getName();
      }
      // update methods 
      public void rotate(){
          if (tail != null)// if empty do nothing
          tail=tail.getNext();// the old head becomes the tail 
      }
      public void addFirst(String na, String g,int a){// adds element e to the front of the list
          if(size == 0){
              tail=new Node(na, g, a,  null, null);
              tail.setNext(tail);   // links ro itself circularly 
          }else {
             Node newest = new Node(na,g, a, tail.getNext(), tail);
             tail.setNext(newest);
          }
          size++; 
      }
      public void addLast(String na, String g,int a){     //adds a new element to the end of the list 
          addFirst(na, g, a);              // adds a element to the front
          tail=tail.getNext();      //new element becomes tail
      }
      public String removeFirst(){       //removes and returns the first element
          if(isEmpty()) return null;//nothing to remove 
          Node head = tail.getNext();
          if(head == tail) tail=null;//only one element 
          else tail.setNext(head.getNext());//removes the "head" from the list
          size--;
          return head.getName();
              
          
      }

      public Node removeHead()
      {
          if(isEmpty()) return null;//nothing to remove 
          Node head = tail.getNext();
          if(head == tail) tail=null;//only one element 
          else tail.setNext(head.getNext());//removes the "head" from the list
          size--;
          return head;
          
      }
     public String seeHead(){return tail.getNext().name;}
     public String toString(){
          String out= "";
          if(tail!=null) return out;
          Node ref = tail;
          while(ref.next!= tail){
              out+=ref.name;
              out+=ref.getGender();
          }
              return out;
      }
    
}

    
                
            
    
    
    

