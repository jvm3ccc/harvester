public class Main {

    public static int row = 23;
    public static int col = 12;
    public static int sRow = 23;
    public static int sCol = 1;
    public static String dir= "N";

    public static boolean beginnLEFT = true;

    public static int[][] field = new int[row][col];


    public static void main(String[] args) {

        int max = col * row;
        int counter = 1;

        if(sCol > 1) {
            beginnLEFT = false;
        }

        // BEFUELLEN
        for ( int i = 0; i < row; i++ ) {
            for ( int j = 0; j < col; j++ ) {
                field[i][j] = counter;
                counter++;
            }
        }
        int count = col;

        switch ( dir){
            case "S":
                upToDown(sCol - 1, count);
                break;
            case "N":
                downToUp(sCol - 1, count);
                break;
            case "E":
                rightToLeft2(sRow - 1);
                break;
            case "W":
                leftToRight2(sRow - 1);
                break;
        }



    }

    // NORDEN - SUEDEN | SUEDEN - NORDEN
    private static void northSouth() {
        if (sRow == 1 && sCol == 1) {
            for (int i = 0; i < col; i++) {

                if (i % 2 == 1) {
                    rowEvenDown(i);
                } else {
                    rowOddUp(i);
                }

            }
        }else {
            for ( int i = col - 1; i >= 0; i-- ) {
                if (i % 2 == 1) {
                    rowEvenDown(i);
                } else {
                    rowOddUp(i);
                }
            }
        }
    }


    private static void upToDown(int colI, int count) {
        for (int i = 0; i < row; i++){
            System.out.print(field[i][colI] + " ");
        }
        if (count > 0) {
            count--;
            if(beginnLEFT)
                downToUp(++colI, count);
            else
                downToUp(--colI, count);
        }
    }

    private static void downToUp(int colI, int count) {
        for (int i = row-1; i >= 0; i--){
            System.out.print(field[i][colI] + " ");
        }
        if (count > 0) {
            count--;
            if(beginnLEFT)
                upToDown(++colI, count);
            else
                upToDown(--colI, count);
        }

    }

    private static void leftToRight2(int rowI) {
        for (int i = 0; i < col; i++){
            System.out.print(field[rowI][i] + " ");
        }

        if (field[row].length > rowI){
            rightToLeft2(++rowI);
        }

    }

    private static void rightToLeft2(int rowI) {
        for (int i = col - 1; i >= 0; i--){
            System.out.print(field[rowI][i] + " ");
        }

        if (field[row].length > rowI){
            leftToRight2(++rowI);
        }

    }







    // OSTEN - WESTEN | WESTEN - OSTEN
    private static void eastWest() {
        if (sRow == 1) {
            for (int i = 0; i < row; i++) {
                topStart(i);
            }
        }else {
            for ( int i = row - 1; i >= 0; i-- ) {
                bottomStart(i);
            }
        }
    }

    /**
     * Faengt oben an
     *
     * @param i
     */
    private static void topStart(int i) {
        if(sCol == 1) {
            rightToLeft(i);
        } else {
            leftToRight(i);
        }
    }


    /**
     * Faengt von unten an
     *
     * @param i
     */
    private static void bottomStart(int i) {
        leftToRight(i);
    }


    /**
     * Wenn Gerade von  Links nach Rechts
     * Wenn ungerade von Rechts nach Links
     *
     * @param i
     */
    private static void leftToRight(int i) {
        if (i % 2 == 1) {
            oddUp(i);
        } else {
            evenDown(i);
        }
    }

    /**
     * Wenn Gerade von  Rechts nach Links
     * Wenn ungerade von Links nach Rechts
     *
     * @param i
     */
    private static void rightToLeft(int i) {
        if (i % 2 == 1) {
            evenDown(i);
        } else {
            oddUp(i);
        }
    }

    /**
     * Links nach Rechts
     *
     * @param rowIndex
     */
    private static void oddUp(int rowIndex) {

        for ( int i = 0; i < col; i++ ){
            System.out.print(field[rowIndex][i] + " ");
        }

    }

    /**
     * Zaehlt columns rueckwerts, quasi von Rechts nach Links
     *
     * @param rowIndex
     */
    private static void evenDown(int rowIndex) {
        for ( int i = col - 1; i >= 0; i-- ){
            System.out.print(field[rowIndex][i] + " ");
        }
    }

    private static void rowEvenDown(int rowIndex) {
        for (int i = row - 1; i >= 0; i--) {
            System.out.print(field[i][rowIndex] + " ");
        }
    }

    private static void rowOddUp(int rowIndex) {
        for (int i = 0; i < row; i++) {
            System.out.print(field[i][rowIndex] + " ");
        }
    }


}
