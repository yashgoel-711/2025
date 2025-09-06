import java.util.Scanner;

public class SpiralMatrix {

    public static void arrayQuestions(int arr[][]){
        int startRow = 0 , endRow = arr.length -1 , startCol = 0 , endCol = arr[0].length - 1;
        while((startCol <= endCol) && (startRow <= endRow)){
            int i = startRow;
            int j = startCol;

            while(j<endCol && startCol < endCol){
                System.out.print(arr[i][j] + " ");
                j++;
            }
            while(i<endRow && startRow < endRow){
                System.out.print(arr[i][j] + " ");
                i++;
            }
            while(j > startCol && startCol < endCol){
                System.out.print(arr[i][j] + " ");
                j--;
            }
            while(i> startRow && startRow< endRow){
                System.out.print(arr[i][j] + " ");
                i--;
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;

            
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for (int i =0  ; i<arr.length ; i++){
            for(int j = 0 ; j< arr[0].length ; j++){
                arr[i][j]= sc.nextInt();
            }
        }

        arrayQuestions(arr);
        sc.close();
    }
}