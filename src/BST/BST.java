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
public class BST<E> {
   
    TreeNode root = null;
   
    public boolean empty(){
        return root == null;
    }
    
    public void insert(E data){
         root = insert(root, data);
    }
    
    private TreeNode insert (TreeNode newNode, E data){
        
        if (newNode == null){
             newNode = new TreeNode((Comparable) data);
        }else {
            if (newNode.data.compareTo(data) > 0){
                newNode.left = insert (newNode.left, data);
            }else {
                newNode.right = insert (newNode.right, data);
            }
        }
        return (newNode);
    }
    
   public void delete(int data){
        root = delete(root, data);
    }
    
    private TreeNode delete(TreeNode node, int data) {
    if (node == null) {
        System.out.println("The tree is empty or value not found");
        return null;
    }

    if (node.data.compareTo(data) > 0) {
        node.left = delete(node.left, data);
    } 
    else if (node.data.compareTo(data) < 0) {
        node.right = delete(node.right, data);
    } 
    else { 
        
        if (node.left == null && node.right == null) { // leaf node
            return null;
        }
       
        else if (node.left == null) { // one right node
            return node.right;
        }
        
        else if (node.right == null) { // one left node
            return node.left;
        }
        
        else {
            TreeNode successor = findMin(node.right); // two child node
            node.data = successor.data; 
            node.right = delete(node.right, (int)successor.data);
        }
    }
       return node;
}
    
    public void displayRoot (){
        if (empty()){
            System.out.println("The tree is empty");
            return;          
        }
        System.out.println("The root is: " + root.data);
    }
    
    public void displayAllDegree0(){
        if (root == null){
            System.out.println("The tree is empty");
            return;          
        }   
        displayAllDegree0(root);
    }
    
    private void displayAllDegree0(TreeNode node){
        if (node == null){        
            return;          
        }
      
        if (node.left == null && node.right == null){
            System.out.println(node.data);
            
        }
            displayAllDegree0(node.left);
            displayAllDegree0(node.right);
    }
    
    public void displayAllDegree1(){
        if (root == null){
            System.out.println("The tree is empty");
            return;          
        }
        
        displayAllDegree1(root);
    }
    
    private void displayAllDegree1(TreeNode node){
        if (node == null){        
            return;          
        }
      
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)){
            System.out.println(node.data);
            
        }
            displayAllDegree1(node.left);
            displayAllDegree1(node.right);
    }
    
    public void displayAllDegree2(){
        if (root == null){
            System.out.println("The tree is empty");
            return;          
        }
        
        displayAllDegree2(root);
    }
    
    private void displayAllDegree2(TreeNode node){   
        if (node == null){        
            return;          
        }
      
        if (node.left != null && node.right != null){
            System.out.println(node.data);        
            
        }
            displayAllDegree2(node.left);
            displayAllDegree2(node.right);
    }
   
    public void search(E data){
        search(root, data);
    }
 
    private TreeNode search(TreeNode node, E data){  
        if (empty()){
            System.out.println("The tree is empty");
            return null;
        }
        if (node == null) {
            System.out.println("value " + data + " not found in the tree");
            return node;
        }
        if (node.data.equals(data)){
            System.out.println("The node " + node.data + " exists");
            return null;
        }
        
        if (node.data.compareTo(data) > 0){
            return search(node.left, data);
        }else {
            return search(node.right, data);
        }  
    }
    
     public void preorderFromLeftToRight(){
        preorderFromLeftToRight(root);
    }
    
     private void preorderFromLeftToRight(TreeNode node){
          if(node == null){
              return;
          }else {
          System.out.print(node.data + " ");
          preorderFromLeftToRight(node.left);
          preorderFromLeftToRight(node.right);
          }
    }
      
      public void preorderFromRightToLeft(){
        preorderFromRightToLeft(root);
    }
    
      private void preorderFromRightToLeft(TreeNode node){
          if(node == null){
              return;
          }else {
          System.out.print(node.data + " ");
          preorderFromRightToLeft(node.right);
          preorderFromRightToLeft(node.left);
          }
    }
      
      public void inorderFromLeftToRight(){
        inorderFromLeftToRight(root);
    }
     
      private void inorderFromLeftToRight(TreeNode node){
          if(node == null){
              return;
          }else {
          inorderFromLeftToRight(node.left);
          System.out.print(node.data + " ");
          inorderFromLeftToRight(node.right);
          }
    }
      
      public void inorderFromRightToLeft(){
        inorderFromRightToLeft(root);
    }
     
      private void inorderFromRightToLeft(TreeNode node){
          if(node == null){
              return;
          }else {
          inorderFromRightToLeft(node.right);
          System.out.print(node.data + " ");
          inorderFromRightToLeft(node.left);
          }
    }
      
      public void postorderFromLeftToRight(){
        postorderFromLeftToRight(root);
    }
      
      private void postorderFromLeftToRight(TreeNode node){
          if(node == null){
              return;
          }else {
          postorderFromLeftToRight(node.left);
          postorderFromLeftToRight(node.right);
          System.out.print(node.data + " ");
          }
    }
      
      public void postorderFromRightToLeft(){
        postorderFromRightToLeft(root);
    }
      
      private void postorderFromRightToLeft(TreeNode node){
          if(node == null){
              return;
          }else {
          postorderFromRightToLeft(node.right);
          postorderFromRightToLeft(node.left);
          System.out.print(node.data + " ");
          }
    } 
    
   public void findMax(){
         if (empty()){
            System.out.println("The tree is empty"); 
            return;
        }        
        System.out.println(findMax(root));
    }

    private TreeNode findMax (TreeNode node){
           if (node.right == null){
              return (TreeNode) node.data;     
           }else {
               return findMax(node.right);
           }
        }

        public void findMin(){
             if (empty()){
                System.out.println("The tree is empty"); 
                return;
            } 
            System.out.println(findMin(root));
        }

        private TreeNode findMin (TreeNode node){
               if (node.left == null){
                   return (TreeNode) node.data;
               }else {
                   return findMin(node.left);
               }
            } 

        private int size (TreeNode node){
            if (node == null){
                return 0;
        }else {
              return 1 + size(node.left) + size(node.right);  
            }
        }

        public void size(){
            System.out.println(size(root));
        }


        public void sizeLeft(){
            System.out.println(size(root.left));
        }

        public void sizeRight(){
            System.out.println(size(root.right));
        }  

        public void NumberofEdges(){
            System.out.println(size(root) - 1);
        }
        
        
    }