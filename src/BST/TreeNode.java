/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bianrysearchtree;

/**
 *
 * @author waa_2
 * @param <E>
 */
public class TreeNode <E extends Comparable<E>>{
   
    E data; 
    TreeNode right = null;
    TreeNode left = null;
    
    TreeNode (E data){
        this.data = data;
    }   
}
