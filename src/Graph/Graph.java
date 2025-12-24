/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

/**
 *
 * @author waa_2
 * @param <E>
 */
public class Graph <E>{
    
    private final int adjMatrix [][];
    private final int vertices;
    private int countEdge = 0;
    
    public Graph(int v){
       vertices = v;
       adjMatrix = new int [v][v]; 
    }
    
    public void addEdge(int start, int end){
        adjMatrix [start][end] = 1;
        countEdge++;
    }
    
    public void printGraph(){
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix [i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    public void numberOfVertices(){
        System.out.println("The number of vertices is: " + vertices);
    }
    
    public void DisplayInDegreeOfAllVertices(){
        for (int j = 0; j < vertices; j++) {
            int InDegree = 0;
            for (int i = 0; i < vertices; i++) {
                InDegree += adjMatrix[i][j];
            }
            System.out.printf("In-degree of %d = %d\n", j, InDegree);  
        }        
    }
    
    public void DisplayOutDegreeOfAllVertices(){
        for (int i = 0; i < vertices; i++) {
            int OutDegree = 0;
            for (int j = 0; j < vertices; j++) {
                OutDegree += adjMatrix[i][j]; 
            }
            System.out.printf("Out-degree of %d = %d\n", i, OutDegree);  
        }
    }
    
     public void DisplaySourceVertices(){
         System.out.println("The source vertices are: ");
         for (int j = 0; j < vertices; j++) {
            int InDegree = 0;
            for (int i = 0; i < vertices; i++) {
                InDegree += adjMatrix[i][j];
            }
            if (InDegree == 0){
                System.out.println(j);
            } 
        }        
    }
     
     public void DisplaySinksVertices(){
         System.out.println("The sinks vertices are: ");
         for (int i = 0; i < vertices; i++) {
            int OutDegree = 0;
            for (int j = 0; j < vertices; j++) {
                OutDegree += adjMatrix[i][j]; 
            }
            if (OutDegree == 0){
                System.out.println(i);
            } 
        }
    }
     
     public void DisplaySlingVertices(){        
         System.out.println("The sling vertices are: ");
         for (int i = 0; i < vertices; i++) {
             if (adjMatrix[i][i] == 1){
                 System.out.println(i);
            }
        }
    }
     
      public void DisplayConnectedGraph(){        

         int NumberOfConnectedVertices = 0;
         
         for (int i = 0; i < vertices; i++) {
             for (int j = 0; j < vertices; j++) {   
             if (adjMatrix[i][j] == 1 || adjMatrix[j][i] == 1){
                 NumberOfConnectedVertices++;
             }
             }
         }
         if (NumberOfConnectedVertices < (Math.pow(vertices, 2))){
             System.out.println("The Graph is not connected");
         }else {
             System.out.println("The Graph is connected");
         }
    }
     
     public void DisplayCompleteGraph(){        
        
         int NumberOfConnectedVertices = 0;
         
         for (int i = 0; i < vertices; i++) {
             for (int j = 0; j < vertices; j++) {   
             if (adjMatrix[i][j] == 1){
                NumberOfConnectedVertices++;
             }
             }
         }
         if (NumberOfConnectedVertices < (Math.pow(vertices, 2))){
             System.out.println("The Graph is not complete");
         }else {
             System.out.println("The Graph is complete");
         }
    }
     
     public void BFS(int start){
         boolean visited [] = new boolean [vertices];
         Queue queue = new Queue();
         
         visited[start] = true;
         queue.Enqueue(start);
         
         while(!queue.empty()){
             int visit = (int) queue.Dequeue();
             System.out.println(visit);
             
             for (int i = 0; i < vertices; i++) {
                 if (adjMatrix[visit][i] == 1 && !visited[i]){
                     visited[i] = true;
                     queue.Enqueue(i);
                 }
             }
         }    
     }
     
     public void DFS(int start){
         boolean visited [] = new boolean [vertices];
         DFS(start, visited);
     }
     
     private void DFS(int visit, boolean visited[]){
         visited[visit] = true;
         System.out.println(visit);
         
         for (int i = 0; i < vertices; i++) {
              if (adjMatrix[visit][i] == 1 && !visited[i]){
                     DFS(i, visited);
                 }
         }
     }
     
     public void numberOfEdges(){
         System.out.println("The number of edges is: " + countEdge);
     }
}
