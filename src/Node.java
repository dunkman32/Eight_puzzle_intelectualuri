/*
 ===========================================================================================================
|                    კვანძის კლასი წარმოდგენილია შემდეგი ველებით                                            |
|                         (Parent, Matrix, X, Y, ChangedBox)                                                |
| თითეული მათგანის სახელი ნათლად წარმოსახავს მის ვალდებულებებს კლასში                                       |
| Parent-მშობელი კვანძის შესახებ ინფორმაცია,                                                                |
| matrix-ორგანზომილებიანი მატრიცა სადაც ინფორმაცია ინახება 8იანის ელემნტთა განლაგების შესახებ               |
| X,Y შესაბამისად განლაგების კოორდინატებია,                                                                 |
| ხოლო ChangedBox არის ველი რომელშიც მომავალში შეინახება ინფორმაცია იმის შესახებ თუ რამდენად განსხვავებულია |
| ჩვენი მატრიცი ორიგინალისგან! ამ ფუნქციას ევრისტიკის დამატების შემთხვევაში შეიძლება მრავალი გამოყენება     |
| მოეძებნოს მაგრამ აქ მხოლოდ იმისთვის გამოიყენება რომ გაჩერების პირობაში შედარება მოვახდინოთ მიმდინარე და   |
| ორიგინალი მატრიცის                                                                                        |
|                                                                                                           |
 ===========================================================================================================
 */
class Node {

    // მშობლის მისამართი
    Node parent;

    // თამაშის მატრიცა
    private int matrix[][];

    // ცარიელი უჯრის კოორდინატები
    private int x;
    private int y;

    // მიზნის მატრიცისგან განსხვავებული უჯრების რაოდენობა
    private int changedBox;

    private static final int SIZE = 3;

    Node(int[][] matrix, int x, int y, int newX, int newY) {
        this.matrix = new int[SIZE][SIZE];
        copy(matrix, this.matrix);

        int tmp = this.matrix[x][y];
        this.matrix[x][y] = this.matrix[newX][newY];
        this.matrix[newX][newY] = tmp;
        this.x = newX;
        this.y = newY;
    }

    int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    int getChangedBox() {
        return changedBox;
    }

    void setChangedBox(int changedCells) {
        this.changedBox = changedCells;
    }

    private void copy(int[][] Matrix, int[][] copyMatrix) {
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(Matrix[i], 0, copyMatrix[i], 0, SIZE);
        }
    }
}


