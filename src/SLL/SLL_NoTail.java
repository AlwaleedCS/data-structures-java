/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author waa_2
 * @param <E>
 */
public class SLL_NoTail <E> {
        
    SingleNode head = null;
    public boolean empty(){
    
        return head == null;
    }
    
    public void insertFirst(E data){
    
        SingleNode newNode = new SingleNode(data);
        if(empty()){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }   
  
    public void insertLast(E data){
    
        SingleNode newNode = new SingleNode(data);
  
        if(empty()){
           insertFirst(data);
           return;
        }
        SingleNode cur = head;
        
        while (cur.next != null){
            cur = cur.next;
        }
       cur.next = newNode; 
       newNode.next = null;
    } 
   
    public void insert(E data){
        insertLast(data);
    } 
    public void insertInBetween (E data, E data1, E data2){
       
        SingleNode newNode = new SingleNode(data);
        SingleNode cur = head;
       
        if (empty()){
            System.out.println("The List is Empty");
            return;
        }
        while (cur.next != null){
            if (cur.data.equals(data1) && cur.next.data.equals(data2)){
                
                newNode.next = cur.next;
                cur.next = newNode;
                return;
            }
            cur = cur.next;
        } 
        System.out.println("Not Found");
    }
    
    public void insertAfterNode (E data, E data1){
        
         SingleNode newNode = new SingleNode(data);
         SingleNode cur = head;
         
         if (empty()){
             System.out.println("The List is Empty");
             return;
         }
         while (cur != null){
             if (cur.data.equals(data1)){
               
                newNode.next = cur.next;
                cur.next = newNode;
                return;
             }
             cur = cur.next;
         }
         System.out.println("Not Found");
    }
 
    public void deleteFirst(){
         
         if (empty()){
             System.out.println("The List is Empty");
             return;
         } 
        head = head.next;       
    }
   
    public void deleteLast(){
        
        SingleNode cur = head;
        if (empty()){
            System.out.println("The List is Empty");
            return;
        }
        if (head.next == null){
            deleteFirst();
            return;
        }
        
        while (cur.next != null){
            if (cur.next.next == null){
                cur.next = null;
                break;
            }
            cur = cur.next;
        }
    }
   
    public void deleteNode(E data){
        
          if (empty()){
            System.out.println("The List is Empty");
            return;
        }
         if (head.data.equals(data)){
             deleteFirst();
             return;
         }
         SingleNode cur = head;
         while (cur != null){
             if (cur.next.data.equals(data)){
                 cur.next = cur.next.next;
                 return;
             }
             cur = cur.next;
         }
    }
    
    public void deleteAfterNode(E data) {
    if (empty()) {
        System.out.println("The List is Empty");
        return;
    }
    if (head.next == null) {
        System.out.println("Only one node");
        return;
    }

    SingleNode cur = head;

    while (cur.next != null) {
        if (cur.data.equals(data)) {
            cur.next = cur.next.next; 
            System.out.println("Node after " + data + " deleted.");
            return; 
        }
        cur = cur.next;
    }

    System.out.println("Node with data " + data + " not found.");
}

   
    public int countNodes(){
        
        int count = 0;
        SingleNode cur = head;
     
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
  
    public void searchNodes(E data){
        
         if (empty()){
            System.out.println("The List is Empty");
            return;
        }
        
        int count = 0;
        SingleNode cur = head;
        
        while (cur != null){
            if (cur.data.equals(data)){
                count++;
                cur = cur.next;
            }   
        }
        if (count > 0){
           System.out.printf("The value %s was found %d time(s) in the list.\n", data, count);
        }else{
           System.out.printf("The value %s was not found in the list.\n", data);
        }
    }
  
    public void DisplayList (){
    
         if (empty()){
            System.out.println("The List is Empty");
            return;
        }
        
        int count = 0;
        SingleNode cur = head;
     
        while (cur != null){
            System.out.printf("The element number %d is %s \n", count+1, cur.data);
            count++;
            cur = cur.next;
            
        }  
    }
   
    public void displayFirst(){
         
        if (empty()){
            System.out.println("The List is Empty");
            return;
        }
        
        System.out.println("The first element is: " + head.data);
    }
   
    public void displayLast(){
       
        if (empty()){
            System.out.println("The List is Empty");
            return;
        }
        SingleNode cur = head;
        
        while (cur != null){
            if (cur.next == null){
                System.out.println("The last element is: " + cur.data);
                
            }
          cur = cur.next;         
        }
    }
   
    public void displayPreSuccNode(E data) {
   
    SingleNode cur = head;

    if (empty()) {
        System.out.println("The List is Empty");
        return;
    }

    while (cur != null) {

   
    if (cur.next != null && cur.next.data.equals(data)) {
        System.out.println("The predecessor is " + cur.data);

        if (cur.next.next != null) {
            System.out.println("The successor is " + cur.next.next.data);
        } else {
            System.out.println("There is no successor");
        }
        return;

  
    } else if (cur.data.equals(data)) {
        System.out.println("There is no predecessor");

        if (cur.next != null) {
            System.out.println("The successor is " + cur.next.data);
        } else {
            System.out.println("There is no successor");
        }
        return;
    }

    cur = cur.next;
}
       System.out.println("Data not found");
  }
   
   public void displayCount(){
       
       System.out.printf("The number of nodes is %d \n" , countNodes());
   }
}




