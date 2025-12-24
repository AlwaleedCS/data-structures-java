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
public class QueueAsSimpleArray <E> {
    
    protected int [] queue;
    protected int rear;
    protected int front;
    protected int capacity;
    int size;
  
    public QueueAsSimpleArray(int capacity){
        queue = new int [capacity];
        this.capacity = capacity;
        front = 0;
        rear = 0;
        size =0;
    }
    
    public boolean empty(){
        return front == rear;
    }
    
    public boolean full(){
        return rear == capacity;
    }
    
    public void peek(){
       if (empty()){
            System.out.println("The array is empty"); 
            return;
       }  
        System.out.println(queue[front]);
    }
    
    public void enqueue(int data){
       if (full()){
            System.out.println("The array is full"); 
            return;
       } 
       queue [rear++] = data;
       size++;
    }
   
    public int dequeue(){   
        if (!empty()){
        return queue [front++];
        } else {
            size++;
        return 0;
        }
    }
    
    public void print (){
        for (int i = front; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
    }
    
}


