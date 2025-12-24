/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

/**
 *
 * @author waa_2
 * @param <E>
 */
public class Queue <E> {
    
    private final  SLL_Tail queue = new SLL_Tail();
    
    public boolean empty(){
       return queue.empty(); 
    }
    
    public void enqueue(E data){  
        queue.insertLast(data);
        queue.DisplayList();
        queue.displayCount();
        System.out.println("");
    }
    
    public void dequeue(){       
        queue.deleteFirst();
        queue.DisplayList();
        queue.displayCount();
        System.out.println("");
    }
    
    private E dequeueReverse(){
        SingleNode oldTail = queue.tail;
        queue.deleteLast();
        return (E) oldTail.data;
    }
    
    public void first(){
        queue.displayFirst();
    }
    
    public void size(){
        queue.countNodes();        
        queue.displayCount();
        queue.DisplayList();
    }
    
   public void reverseQueue(){   
       Queue temp = new Queue();
       
       while(!queue.empty()){
           temp.enqueue(dequeueReverse());
       }      
   }
   
   protected void Enqueue(E data){
       queue.insertLast(data);
   }
   
   protected E Dequeue(){
       E data = (E) queue.head.data;
       queue.deleteFirst();
       return data;
   }
   
}
