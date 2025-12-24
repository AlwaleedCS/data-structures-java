/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author waa_2
 * @param <E>
 */
public class Stack <E> {
   
    DLL stack = new DLL();
   
    
    public void push(E data){ 
        stack.insertFirst(data);
        stack.DisplayList();
        stack.displayCount();
        System.out.println("");

    }
    
    public void pop (){
        stack.deleteFirst();
        stack.DisplayList();
        stack.displayCount();
        System.out.println("");
    }
    
    private E popReverse (){
        DoubleNode oldHead = stack.head;
        stack.deleteFirst();
        return  (E) oldHead.data;      
    }

    public void peek (){
        
        stack.displayFirst();
        
    }
    
    public void empty(){
        
        stack.empty();
        
    }
    
    public void size(){
 
        stack.DisplayList();
        stack.displayCount();
        
    }
    
    public void reverseStack(){
       
        Stack temp = new Stack();
        
        while (!stack.empty()){
            
          temp.push(popReverse());            
        }   
    }
}
