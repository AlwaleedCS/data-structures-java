/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doubly_linked_list;


/**
 *
 * @author waa_2
 * @param <E>
 */
public class DLL <E> {
     
    DoubleNode head = null;
    DoubleNode tail = null;
    
    
    public boolean empty(){
    
        return head == null;
    }
    
    public void insertFirst(E data){
    
        DoubleNode newNode = new DoubleNode(data);
        if(empty()){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = null;
            head = newNode;
            
            
        }
    }   
  
    public void insertLast(E data){
    
        DoubleNode newNode = new DoubleNode(data);
  
        if(empty()){
           insertFirst(data);
                               
        }else{           
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;         
       }
    } 
    
    public void insert(E data){
        insertLast(data);
    }  
   
    public void insertInBetween (E data, E data1, E data2){
       
        DoubleNode newNode = new DoubleNode(data);
        DoubleNode cur = head;
       
        if (empty()){
            System.out.println("The List is Empty");
            return;
        }
        while (cur.next != null){
            if (cur.data.equals(data1) && cur.next.data.equals(data2)){
               
                newNode.next = cur.next;
                newNode.prev = cur;
               
                cur.next.prev = newNode;
                cur.next = newNode;
               
                return;
            }
            cur = cur.next;
        } 
        System.out.println("Not Found");
    }
    
    public void insertAfterNode (E data, E data1){
         
         DoubleNode newNode = new DoubleNode(data);
         DoubleNode cur = head;
         
         if (empty()){
             System.out.println("The List is Empty");
             return;
         }
         while (cur != null){
             if (cur.data.equals(data1)){
               
                 newNode.next = cur.next;
                 newNode.prev = cur;
                
                 if(cur.next != null){
                
                 cur.next.prev = newNode;
                 cur.next = newNode;
                 } else {
                     tail = newNode;
                 }
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
        
        if (empty()){
            System.out.println("The List is Empty");
            return;
        }
        if (head == tail){
            deleteFirst();
        } else {
            tail = tail.prev.next = null;
        }
         
    }
   
    public void deleteNode(E data){
        
          if (empty()){
            System.out.println("The List is Empty");
            return;
        }
         if (head == tail && head.data.equals(data)){
             deleteFirst();
             return;
         }
         if (head.data.equals(data)){
             deleteFirst();
             return;
         }
         if (tail.data.equals(data)){
             deleteLast();
             return;
         }
         DoubleNode cur = head;
         while (cur.next != null){
             if (cur.data.equals(data)){    
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;               
                return;
             }
             cur = cur.next;
         }
         System.out.println("Data not found");
    }
    
    public void deleteAfterNode(E data) {
    if (empty()) {
        System.out.println("The list is empty");
        return;
    }

    if (head.next == null) {
        System.out.println("Only one node");
        return;
    }

    DoubleNode cur = head;

    while (cur.next != null) {
        if (cur.data.equals(data)) {
            if (cur.next == null) {
                System.out.println("No node after this node");
                return;
            }

            cur.next = cur.next.next;
            if (cur.next != null) {
                cur.next.prev = cur;
            }

            System.out.println("Node after " + data + " deleted");
            return;
        }
        cur = cur.next;
    }

    System.out.println("Node not found");
}
   
     public int countNodes(){
        
        int count = 0;
        DoubleNode cur = head;
     
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
        DoubleNode cur = head;
        
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
        DoubleNode cur = head;
     
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
        System.out.println("The Last element is: "+ tail.data);
    }
  
    public void displayPreSussNode(E data){
    
        DoubleNode cur = head;
        
        if(empty()){
        
            System.out.println("the list is empty!");
            return;
        }
        
        while(cur != null){
    
            if(cur.data == data && cur.prev != null && cur.next != null){
            
                System.out.println("The predecessor is " + cur.prev.data);
                System.out.println("The successor is " + cur.next.data);
                return;
            }
            
            if(cur.data == data && cur.prev != null && cur.next == null){
            
               System.out.println("The predecessor is " + cur.prev.data);
               System.out.println("There is no successor.");
               return;
        } 
         
            if(cur.data == data && cur.prev == null && cur.next != null){
                
             System.out.println("There is no predecessor.");
             System.out.println("The successor is " + cur.next.data);
             return;
        }             
            cur = cur.next;
        }
        System.out.println("Data not found");
    }

   public void displayCount(){    
       System.out.printf("The number of nodes is %d \n" , countNodes());
   }
   
   public void sumRecursion (){
       System.out.println(sumRecursion(head)); 
   }
   
   private int sumRecursion(DoubleNode num){
    if (num == null){
        return 0;
    }
    return (int) num.data + sumRecursion(num.next);

   }
  
   public void maxRecursion(){
       System.out.println(maxRecursion(head)); 
   }
   
   private int maxRecursion(DoubleNode num){
        
        if(num.next == null){
            
            return (int)num.data;
        }
      
        if((int)num.data > maxRecursion(num.next)){
            
           return (int)num.data;
        }else{
            
            return maxRecursion(num.next);
        }
    }
   
   public void searchRecursion (int val){
       System.out.println(searchRecursion(head, val));
   }
   
   private String searchRecursion(DoubleNode num, int val){
       if (num == null){
           return "Doesn't exists";
       }
       if ((int) num.data == val){
          return "The number exists";
       }  
       return searchRecursion(num.next, val);
   }
   
   public void search5and6Recursion(){
        search5and6Recursion (head);
   } 
   
  private void search5and6Recursion(DoubleNode num) {
    if (num == null) {
        return;
    }

    if ((int)num.data % 5 == 0 || (int)num.data % 6 == 0) {
        System.out.println(num.data);
    }
    search5and6Recursion(num.next);
}
   
   public void convertLinkedListToArray(){
       
        int A[]= new int [countNodes()];
        DoubleNode cur = head;
        int i = 0;
        
        while (cur != null){
            A[i] = (int) cur.data;
            System.out.printf("Array element number %d is %d \n", i+1 ,A[i]);
            i++;
            cur = cur.next;
        }   
     } 
}


   
