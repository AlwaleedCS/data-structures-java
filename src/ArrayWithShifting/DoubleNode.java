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
public class DoubleNode <E> {
    
     E data;
     DoubleNode next = null;
     DoubleNode prev = null;
    
    DoubleNode(E data){
        this.data = data;
    }
    
}
