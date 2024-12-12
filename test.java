import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
    private int [][] arr;
    private File f = new File("database\\cards\\2.txt");
    private Scanner scan = new Scanner(f);

    public test() throws FileNotFoundException {
        arr = new int[5][5];
        builder();
        printer();
    }


    private void builder () throws FileNotFoundException{
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        
    }

    private void printer (){

        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        //while(scan.hasNext()){
        //    System.out.println(scan.nextInt());
        //}
    }

}
