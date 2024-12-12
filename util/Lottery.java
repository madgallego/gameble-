package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
    private int [][] card;
    private int [][] arr;
    private File f;
    private Scanner scan;
    private int []lotteryVal;
    private  int drawCount;
    private Random randVal;
    private PatternTracker set;
    private int rand;
    private int cardNumber;
    private boolean result;

    
    public Lottery() throws FileNotFoundException {
        arr = new int[5][5];
        card = new int[5][5];
        lotteryVal = new int [75];
        randVal = new Random();
        cardNumber = (randVal.nextInt(5)+1);
        f = new File("database\\cards\\"+cardNumber+".txt");
        scan = new Scanner(f);
        PatternTracker set = new PatternTracker();

        FileValueRead();
        BingoRoll();
    }

    private void FileValueRead () throws FileNotFoundException{
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        
    }
    public int getValue (int i, int j){
        return arr[i][j];
    }

    private void BingoRoll(){
        drawCount=0;
        while(drawCount<75){
            while(true){
                rand = randVal.nextInt(75)+1;
                for(int j=0; j<=drawCount;j++){
                    if(lotteryVal[j]==rand) 
                        rand=0;
                }
                if(rand!=0){
                    lotteryVal[drawCount]=rand;
                    drawCount++;
                    break;
                    
                }
            }
        }
    }//end of block for Bingo Roll

    public String get5DrawnNumbers(int i){
        String drawn = new String();
        for(int j=0; j<5;j++){
            drawn = drawn + lotteryVal[i] + " | ";
            i++;
        }
        return drawn;
    }

    public void cardMarker(int i){
        //MARKER FOR B (i, 0)
        if(lotteryVal[i]<16){
            for(int j=0;j<5;j++){
                if(lotteryVal[i]==arr[j][0]){
                    set.BingoMarker(j, 0);
                }
            }
        }
        //MARKER FOR I
        else if(lotteryVal[i]<31){
            for(int j=0;j<5;j++){
                if(lotteryVal[i]==arr[j][1]){
                    set.BingoMarker(j, 1);
                }
            }
        }
        //MARKER FOR N
        else if(lotteryVal[i]<46){
            for(int j=0;j<5;j++){
                if(lotteryVal[i]==arr[j][2]){
                    set.BingoMarker(j, 2);
                }
            }
        }
        //MARKER FOR G
        else if(lotteryVal[i]<61){
            for(int j=0;j<5;j++){
                if(lotteryVal[i]==arr[j][3]){
                    set.BingoMarker(j, 3);
                }
            }
        }
        //MARKER FOR O
        else if(lotteryVal[i]<=75){
            for(int j=0;j<5;j++){
                if(lotteryVal[i]==arr[j][4]){
                    set.BingoMarker(j, 4);
                }
            }
        }

    }//END OF FUNC BLOCK

    public boolean getResult(){
        result = set.CardChecker();
        return result;
    }
}
