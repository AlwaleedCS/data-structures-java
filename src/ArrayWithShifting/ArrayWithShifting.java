/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraywithshifting;

/**
 *
 * @author waa_2
 */
public class ArrayWithShifting <E> {

        int array [];
        int capacity = 0;
        int count = 0;

    ArrayWithShifting(int capacity){
          this.capacity = capacity;        
          array = new int [capacity];
     }
    
    public boolean full(){
         return capacity == count;
     }
    
    public boolean empty(){
         return count == 0;
     }
    
    public void insertFirst(int data){
         if(full()){
         System.out.println("The list is full!");
         return;
     }
     for (int i = count; i > 0; i--){
         array[i] = array[i-1];
         }
         array[0] = data;
         count++;
     }
   
    public void insertLast(int data){
         if(full()){
         System.out.println("The list is full!");
         return;
         }
         array[count] = data;
         count++;
    }
   
    public void push(int data){
        insertLast(data);
    }
   
    public int deleteFirst(){
            if(empty()){
            System.out.println("The list is empty!");
            return 0;
    }
    int data = array[0];
        count--;
        for (int i = 1; i <= count; i++){
        array[i-1] = array[i];
        }
        return data;
    }
   
    public int deleteLast(){
        if(empty()){
        System.out.println("The list is empty!");
        return 0;
    }
    int data = array[count-1];
        count--;
        return data; 
    }
    
    public int pop(){
        return deleteLast();
    }
   
    public void displayList(){
        for (int i = 0; i < count; i++){
        System.out.println(array[i] + " ");
        }
    }
    
    public void displayFirst(){
        System.out.println("The first element is " + array[0]);
    }
   
    public void displayLast(){
        System.out.println("The last element is " + array[count]);
    }
   
    public void displayCount(){
        System.out.println("The number of elements is " + count);
    }
   
    public void convertArrayToLinkedList(){
        DLL dll = new DLL();
        for (int i = 0; i < count; i++) {
            dll.insertLast(array[i]);
            System.out.printf("Linked List element %d is %d ", count+1, array[i]);
        }
    }
    
    public void binarySerach(int target){       
            if(empty()){              
                System.out.println("The list is empty!");
                return;
            }   
            if(binarySerach(array, target, 0, count)){         
                System.out.printf("The element %d is in the list.\n", target);
            }else{               
                 System.out.printf("The element %d is not in the list.", target);
            }
        }

    private boolean binarySerach(int[] info, int target, int low, int high){         
            int mid;          
            if(low > high){           
                return false;
            }else{               
                mid = (low + high)/2;               
                if(info[mid] == target){                  
                    return true;
                }else if(target < info[mid]){                   
                    return binarySerach(info, target, low, mid - 1);
                }else{                 
                    return binarySerach(info, target, mid + 1, high);
                }
            }
        }
        
    public void bubbleSort(){      
            bubbleSort(array, count);
        }
       
    private void bubbleSort(int[] array, int length){      
            for(int i = 0; i < length - 1; i++){          
                for(int j = length - 1; j > i; j--){              
                    if(array[j - 1] > array[j]){                
                        int temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        
    public void selectionSort(){
           selectionSort(array);
}

    private void selectionSort(int[] list){
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;

            for (int j = i + 1; j < n; j++) {
                if (list[j] < list[indexMin]) {
                    indexMin = j;
                }
            }

            if (indexMin != i) {
                int temp = list[indexMin];
                list[indexMin] = list[i];
                list[i] = temp;
        }
    }
       
}
       
        public void insertionSort(){
           insertionSort(array);
        }
    

        private void insertionSort(int [] list){
            int n = list.length;
            for (int i = 1; i < n; i++) {
                int val = list[i];
                int pos = i;
               
                while (pos > 0 && list[pos - 1] > val){
                    list[pos] = list[pos - 1];
                    pos = pos - 1;
                }
                list[pos] = val;
            }    
        }
        
        private int partition (int [] list, int min, int max){
            int mid = (min + max)/2;
            int pivot = list[mid];     
            
            int temp = list[mid];
            list[mid] = list[min];
            list[min] = temp;
            
            int left = min;
            int right = max;
           
            while (left < right){
                while(left < right && list[left] <= pivot){
                    left++;      
                }
                while (list[right] > pivot){
                    right--;
                }
                
                if (left < right){
                    temp = list[left];
                    list[left] = list[right];
                    list[right] = temp;                  
                }
                                       
            }
                    temp = list[min];
                    list[min] = list[right];
                    list[right] = temp; 
            
            return right; 
        }
        
        private void quickSort(int[] list, int min, int max){
                   if (min < max){
                       int pivotindex = partition(list, min, max);
                       quickSort(list, min, pivotindex - 1);
                       quickSort(list, pivotindex + 1, max); 
                   }
        }
        
        public void quickSort(){
            quickSort(array, 0, array.length - 1);
        }
        
        private void merge(int [] list, int first, int mid, int last){
            int [] temp = new int [list.length];
            
            int first1 = first;
            int last1 = mid;
            int first2 = mid + 1;
            int last2 = last;
            int index = first1;
            
            while (first1 <= last1 && first2 <= last2){
                if (list[first1] < list[first2]){
                    temp[index] = list[first1];
                    first1++;       
                }else {
                    temp[index] = list[first2];
                    first2++;
                }
                index++;
            }
            
            while (first1 <= last1){
                temp[index] = list[first1];
                first1++; 
                index++;
            }
            
            while (first2 <= last2){
                temp[index] = list[first2];
                first2++; 
                index++;
            }
            
            for (index = first; index <= last; index++) {
                list[index] = temp[index];
            }   
        }
        
        private void mergeSort(int list[], int min, int max){
            if(min < max){
                int mid = (min + max)/2;
                mergeSort(list, min, mid);
                mergeSort(list, mid + 1, max);
                merge(list, min, mid, max);
            }
        }
        
        public void mergeSort(){
            mergeSort(array, 0, array.length - 1);
        }
        
        public void heapSort(){
           heapSort(array, count);
        }
        
        private void heapSort(int[] list,int n){
            for (int i = (n/2) - 1; i >= 0; i--) {
                maxHeap(array, i, n);
            }
            
            for (int i = n - 1; i >= 1; i--) {
                int temp = list[0];
                list[0] = list[i];
                list[i] = temp;
                
                maxHeap(array, 0, i);   
            }
            
        }
        
        private void maxHeap(int[] list, int i, int heapSize){
            int left = 2 * i +1;
            int right = 2 * i + 2;
            int max = i;
            
            if (left < heapSize && list[left] > list[max]){
                max = left;
            }
            
            if (right < heapSize && list[right] > list[max]){
                max = right;
            }
            
            if (max != i){
                int temp = list[i];
                list[i] = list[max];
                list[max] = temp;
                            
                maxHeap(array, max, heapSize); 
            }
        }      
        
}
