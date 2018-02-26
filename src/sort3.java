//The java code takes text files as input, processes them and performs verious sorting practices 
//outputs the data to another text file

//Sorting Mechanism

//Bubble Sort- bsort.txt	
//Insertion Sort - isort.txt
//QuickSort - dsort.txt




import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Author: Ashwin Ravishankar


public class sort3 
{
    public static void main (String[] args) throws IOException
    {
        
        FileReader fileRead = new FileReader(args[0]);
        FileWriter fileWriteBSort = new FileWriter("bsort.txt");
        FileWriter fileWriteISort = new FileWriter("isort.txt");
        FileWriter fileWriteDSort = new FileWriter("dsort.txt");
        
        BubbleSort objBubbleSort = new BubbleSort();
        InsertionSort objInsertionSort = new InsertionSort();
        QuickSort objQuickSort = new QuickSort();
        
        int[] inputIntegers = new int [100000];
        int[] inputBubble = new int [100000];
        int[] inputInsert = new int [100000];
        int[] inputDivide = new int [100000];
        int i=0, counter=0;
        
            Scanner input = new Scanner(fileRead);
            
            while (input.hasNext()) 
            {
                inputIntegers[i] = input.nextInt();
                counter++; i++;
            }
            
            for(i=0; i<counter; i++)
            {
                inputBubble[i] = inputIntegers[i];
                inputInsert[i] = inputIntegers[i];
                inputDivide[i] = inputIntegers[i];
            }
            
            inputBubble = objBubbleSort.BubbleSort(inputBubble, counter);
            for(i=0; i<counter; i++)
            {
                fileWriteBSort.write(Integer.toString(inputBubble[i]));
                fileWriteBSort.write(System.getProperty( "line.separator" ));
                fileWriteBSort.flush();
            }
            
            inputInsert = objInsertionSort.InsertionSort(inputInsert);
            for(i=0; i<counter; i++)
            {
                fileWriteISort.write(Integer.toString(inputInsert[i]));
                fileWriteISort.write(System.getProperty( "line.separator" ));
                fileWriteISort.flush();
            }
            
            inputDivide = objQuickSort.QuickSort(inputDivide);
            for(i=0; i<counter; i++)
            {
                fileWriteDSort.write(Integer.toString(inputDivide[i]));
                fileWriteDSort.write(System.getProperty( "line.separator" ));
                fileWriteDSort.flush();
            }
    }   
}

class BubbleSort {
    public int[] BubbleSort(int[] arrayList, int count)
    {
        int temp = 0;
        long swapCount=0;
        long start, end;
        System.out.println("Start of BUBBLE SORT");
        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            for (int j = 1; j < (count - i); j++) {

                if (arrayList[j - 1] > arrayList[j]) {
                    temp = arrayList[j - 1];
                    arrayList[j - 1] = arrayList[j];
                    arrayList[j] = temp;
                    swapCount++;
                }
            }
        }
        end = System.nanoTime();
        //System.out.println("Start Time is: " + start);
        //System.out.println("End Time is: " + end);
        System.out.println("Swap Count is: " + swapCount);
        System.out.println("Duration of sort is: " + (end - start) + " NanoSeconds");
        System.out.println("End of BUBBLE SORT");
        return arrayList;
    }
}

class InsertionSort {
    public int[] InsertionSort (int[] arrayList)
    {
        int temp;
        long swapCount=0;
        long start, end;
        System.out.println("Start of INSERTION SORT");
        start = System.nanoTime();
        int count = 0;
        for (int i = 1; i < count; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arrayList[j] < arrayList[j-1]){
                    temp = arrayList[j];
                    arrayList[j] = arrayList[j-1];
                    arrayList[j-1] = temp;
                    swapCount++;
                }
            }
        }
        end = System.nanoTime();
        System.out.println("Swap Count is: " + swapCount);
        System.out.println("Duration of sort is: " + (end - start) + " NanoSeconds");
        System.out.println("End of INSERTION SORT ");
        System.out.println("");
        return arrayList;
    }
}

class QuickSort {
    public int[] QuickSort (int[] arrayList)
    {
        int count = 0;

        int temp, low=0, high=count-1;
        long start, end;
        System.out.println("Start of QUICK SORT for");
        start = System.nanoTime();
                
        arrayList = QuickSortSwapAlg(arrayList, low, high);
        
        end = System.nanoTime();
        System.out.println("Duration of sort is: " + (end - start) + " NanoSeconds");
        System.out.println("End of QUICK SORT");
        return arrayList;
    }
    
    public static int[] QuickSortSwapAlg (int[] arrayList, int low, int high)
    {
        // pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arrayList[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arrayList[i] < pivot) {
				i++;
			}
 
			while (arrayList[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arrayList[i];
				arrayList[i] = arrayList[j];
				arrayList[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			QuickSortSwapAlg(arrayList, low, j);
 
		if (high > i)
			QuickSortSwapAlg(arrayList, i, high);
    
        return arrayList;
    }
}
