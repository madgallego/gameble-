import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class test {
    private int [][] arr;
    private File f;
    private Scanner scan;
    private Random rand;
    private int cardNumber;
    int[] lemon = new int [75];
    int drawCount;
    int randVal;
    public test() throws FileNotFoundException {
        arr = new int[5][5];
        
        rand = new Random();
        cardNumber = (rand.nextInt(5)+1);
        f = new File("database\\cards\\"+cardNumber+".txt");
        scan = new Scanner(f);



        //FileValueRead();
        //printer();
        BingoRoll();
        for(int i=0;i<75;i++) System.out.print(lemon[i]+ " ");
    }
    private void BingoRoll(){
        drawCount=0;
        while(drawCount<75){
            while(true){
                randVal = rand.nextInt(75)+1;
                for(int j=0; j<=drawCount;j++){
                    if(lemon[j]==randVal) 
                        randVal=0;
                }
                if(randVal!=0){
                    lemon[drawCount]=randVal;
                    drawCount++;
                    break;
                    
                }
            }
        }
    }

    private void FileValueRead () throws FileNotFoundException{
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
