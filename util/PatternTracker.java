package util;

public class PatternTracker {
    private int [][] marker = new int [5][5];
    private char [] crossMark = new char[5];
    public PatternTracker(){
    }

    public void BingoMarker(int row, int col){
        if(col==2 && row>=2){
            marker[row+1][col]=1;
        }
        else marker[row][col]=1;
    }

    public boolean CardChecker(){
        if(RowBingo()!=0)
            return true;
        if(ColBingo()!=0)
            return true;
        if(LeftDiagonalBingo()!=0)
            return true;
        if(RightDiagonalBingo()!=0)
            return true;
        return false;
    }

    private int RowBingo(){
        int counter=0;
        for(int i=0; i<5; i++){
            counter=0;
            for(int j=0; j<5; j++){
                counter+=marker[i][j];
            }
            if(i==2 && counter==4)
                return 1;
            else if(counter==5)
                return 1;
        }
        return 0;
    }

    private int ColBingo(){
        int counter=0;
        for(int i=0; i<5; i++){
            counter=0;
            for(int j=0; j<5; j++){
                counter+=marker[j][i];
            }
            if(i==2 && counter==4)
                return 1;
            else if(counter==5)
                return 1;
        }
        return 0;
    }

    private int LeftDiagonalBingo(){
        int counter = marker[0][0] + marker[1][1] + marker[3][3] + marker[4][4];
        if(counter==4)
            return 1;
        else return 0;
    }
    private int RightDiagonalBingo(){
        int counter = marker[0][4] + marker[1][3] + marker[3][1] + marker[4][0];
        if(counter==4)
            return 1;
        else return 0;
    }
}
