package algorithms;
import java.util.Random;
import java.util.Date;
import java.util.Scanner;
/* This is a programme to analyse sorting algorithms -quick, merge, heap, counting, insertion- */
//TAHA YUSUF KÖMÜR
//150114064



public class Main {

    public static void main(String[] args) {


Scanner sc = new Scanner(System.in);
Scanner sc2 = new Scanner(System.in);
Scanner sc3 = new Scanner(System.in);
Scanner sc4 = new Scanner(System.in);
boolean x = true;



       while(x){

            System.out.println("You can choose the algorithm by pressing 1-5");
            System.out.println("1: Insertion \n2: Merge \n3: Quick \n4: Heap \n5: Counting\n");
            int sort = sc.nextInt();
            System.out.println("You can choose the array type by pressing 1-3");
            System.out.print("\n1: Totally Random\n2: Ordered Random\n3:Reverse Ordered Random \n ");
            int type = sc.nextInt();
            System.out.println("You can choose the iteration amount by entering it 'we recommend <10 to have faster solutions' \n ");
            int iteration = sc.nextInt();
           System.out.println("You can choose the array size amount by entering it 'we recommend <25000 to have faster solutions' \n ");
           int rows = sc.nextInt();

            if(sort == 1) {
                if(type == 1 ) {
                    System.out.println("Insertion sort with full random array with iterations of " + iteration+" ");
                }
                if(type == 2 ) {
                    System.out.println("Insertion sort with ordered random array with iterations of " + iteration+" ");
                }
                if(type == 3 ) {
                    System.out.println("Insertion sort with reverse ordered random array with iterations of " + iteration+" ");
                }
            }
            else if(sort == 2) {
                if(type == 1 ) {
                    System.out.println("Merge sort with full random array with iterations of " + iteration+" ");
                }
                if(type == 2 ) {
                    System.out.println("Merge sort with ordered random array with iterations of " + iteration+" ");
                }
                if(type == 3 ) {
                    System.out.println("Merge sort with reverse ordered random array with iterations of " + iteration+" ");
                }
            }
            else if(sort == 3) {
                if(type == 1 ) {
                    System.out.println("Quick sort with full random array with iterations of " + iteration+" ");
                }
                if(type == 2 ) {
                    System.out.println("Quick sort with ordered random array with iterations of " + iteration+" ");
                }
                if(type == 3 ) {
                    System.out.println("Quick sort with reverse ordered random array with iterations of " + iteration+" ");
                }
            }
            else if(sort == 4) {
                if(type == 1 ) {
                    System.out.println("Heap sort with full random array with iterations of " + iteration+" ");
                }
                if(type == 2 ) {
                    System.out.println("Heap sort with ordered random array with iterations of " + iteration+" ");
                }
                if(type == 3 ) {
                    System.out.println("Heap sort with reverse ordered random array with iterations of " + iteration+" ");
                }
            }
           else if(sort == 5) {
                if(type == 1 ) {
                    System.out.println("Counting sort with full random array with iterations of " + iteration+" ");
                }
                if(type == 2 ) {
                    System.out.println("Counting sort with ordered random array with iterations of " + iteration+" ");
                }
                if(type == 3 ) {
                    System.out.println("Counting sort with reverse ordered random array with iterations of " + iteration+" ");
                }
            }

        long[] res = tester(type,sort,iteration,rows);

            System.out.println("BEST: "+res[0]+" milisecond AVERAGE: "+res[1]+" milisecond WORSE: "+res[2]+" milisecond");


        }






    }

    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /*
    @createRandomArr, creates an array with parameters rows, bound and type
      rows specifies array size, bound specifies limit of each element inside array.
      Type specifies the style of array: 1 for regular random; 2 for ordered random; 3 for reverse ordered random
     */
    public static int [] createRandomArr(int rows, int bound, int type) {
        int arr[] = new int[rows];
        Random rand = new Random();
        int reversed[] = new int[rows];
        countingSort count = new countingSort();
       if(type == 1) {

           for (int i = 0; i < rows; i++) {
               arr[i] = rand.nextInt(bound);
           }
       }

       if(type == 2){
           for (int i = 0; i < rows; i++) {
               arr[i] = rand.nextInt(bound);
           }
          count.countSort(arr);
       }
        if(type == 3){
            for (int i = 0; i < rows; i++) {
                arr[i] = rand.nextInt(bound);
            }
            count.countSort(arr);
            int j = 0;
            for(int i = rows-1; i>=0; i--){
                reversed[j] = arr[i];
                j++;
            }
        return reversed;
        }
        return arr;
    }
    /*
    @printArr, prints one dimensional array with only integer array parameter
     */
    public static void printArr(int[]arr) {
        int rows = arr.length;

        for (int i = 0; i < rows; i++) {
            if(i%10 == 0){System.out.println();}
            System.out.print(" " + arr[i]);
            spaceAdjuster(arr[i]);
        }
        System.out.println("");
    }
    /*
    @spaceAdjuster, is an utility function which adjusts the table view for the array
     */
    public static void spaceAdjuster(int x){

        if(x<10){  System.out.print("   ");}
        else if(x<100){  System.out.print("  ");}
        else if(x<1000){  System.out.print(" ");}

    }
    /*
    @tester, is the testing function. It takes 3 parameters: -type, sort- iteration-

    Type parameter declares the array style, its implies the type parameter to @createRandomArr function
    Sort parameter declares the sorting algorithm to use
    Iteration parameter is the number of time the function implies sorting algorithm on random array.
     */
    public static long[] tester(int type, int sort, int iteration,int rows)
    {
        long res[] = new long[3];
        countingSort counting = new countingSort();
        heapSort heap = new heapSort();
        MergeSort merge = new MergeSort();
        QuickSort quick = new QuickSort();

        long best = 10000000L;
        long average = 0L;
        long worse = 0L;
        long total =0L;

            if (sort == 1) {
                for (int i = 0; i < iteration; i++) {
                    int[] arr = createRandomArr(rows, 1000, type);
                    long lStartTime = new Date().getTime();
                    insertionSort(arr);
                    long lEndTime = new Date().getTime();
                    long lTotalTime = lEndTime - lStartTime;
                    total += lTotalTime;
                    if (lTotalTime < best) {
                        best = lTotalTime;
                    }
                    if (lTotalTime > worse) {
                        worse = lTotalTime;
                    }


                }
                average = total / iteration;
                res[0] = best;
                res[1] = average;
                res[2] = worse;
            }
            if (sort == 2) {
                for (int i = 0; i < iteration; i++) {
                    int[] arr = createRandomArr(rows, 1000, type);
                    long lStartTime = new Date().getTime();
                    merge.sort(arr,0, rows-1);
                    long lEndTime = new Date().getTime();
                    long lTotalTime = lEndTime - lStartTime;
                    total += lTotalTime;
                    if (lTotalTime < best) {
                        best = lTotalTime;
                    }
                    if (lTotalTime > worse) {
                        worse = lTotalTime;
                    }


                }
                average = total / iteration;
                res[0] = best;
                res[1] = average;
                res[2] = worse;
            }
            if (sort == 3) {   for (int i = 0; i < iteration; i++) {
                int high = rows-1;
                int low = 1;

                int[] arr = createRandomArr(rows, 1000, type);
                long lStartTime = new Date().getTime();
                qS(arr,low, high);
                long lEndTime = new Date().getTime();
                long lTotalTime = lEndTime - lStartTime;
                total += lTotalTime;
                if (lTotalTime < best) {
                    best = lTotalTime;
                }
                if (lTotalTime > worse) {
                    worse = lTotalTime;
                }


            }
                average = total / iteration;
                res[0] = best;
                res[1] = average;
                res[2] = worse;}
            if (sort == 4) {
                for (int i = 0; i < iteration; i++) {
                    int[] arr = createRandomArr(rows, 1000, type);
                    long lStartTime = new Date().getTime();
                    heap.sort(arr);
                    long lEndTime = new Date().getTime();
                    long lTotalTime = lEndTime - lStartTime;
                    total += lTotalTime;
                    if (lTotalTime < best) {
                        best = lTotalTime;
                    }
                    if (lTotalTime > worse) {
                        worse = lTotalTime;
                    }


                }
                average = total / iteration;
                res[0] = best;
                res[1] = average;
                res[2] = worse;
            }
            if (sort == 5) {   for (int i = 0; i < iteration; i++) {
                int[] arr = createRandomArr(rows, 1000, type);
                long lStartTime = new Date().getTime();
                counting.countSort(arr);
                long lEndTime = new Date().getTime();
                long lTotalTime = lEndTime - lStartTime;
                total += lTotalTime;
                if (lTotalTime < best) {
                    best = lTotalTime;
                }
                if (lTotalTime > worse) {
                    worse = lTotalTime;
                }


            }
                average = total / iteration;
                res[0] = best;
                res[1] = average;
                res[2] = worse;}

        return res;
    }
  public static  int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

   public static void qS(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            qS(arr, left, index - 1);
        if (index < right)
            qS(arr, index, right);
    }

}

