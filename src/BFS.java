import java.util.LinkedList;
import java.util.Queue;

class BFS {

    private static final int MATRIX_SIZE = 3;
    private static final int MAX_MOVES = 4;
    // მოძრაობა სტრიქონისა და სვეტის მიხედვით
    private static final int[] ROW = {1, 0, -1, 0};
    private static final int[] COLUMN = {0, -1, 0, 1};
    private int movesCounter = 0;

    //საწყისი მატრიცი
    private int[][] incipienceMatrix;
    //საბოლოო მატრიცი
    private int[][] originalMatrix;

    // კონსტრუკტორი
    BFS(int[][] incipienceMatrix, int[][] originalMatrix) {
        this.incipienceMatrix = incipienceMatrix;
        this.originalMatrix = originalMatrix;
    }

    // განსხვავებული უჯრების რაოდენობის დათვლა!
    private int countChangedCells(int[][] initialMatrix, int[][] finalMatrix) {
        int answer = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (initialMatrix[i][j] != finalMatrix[i][j]) {
                    if (initialMatrix[i][j] != 0) {
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }

    /*
        საზღვრების დაცვა (ფუნქია რომელიც არ გვაძლევს საშუალებას გავცდეთ საზღვრებს)
     */
    private boolean isCorrect(int x, int y) {
        if ((x >= 0 && x < MATRIX_SIZE) && (y >= 0 && y < MATRIX_SIZE)) {
            return true;
        }
        return false;
    }

//     მგდომარეობის მატრიცის ბეჭდვა
//     გამოვიყენებ რეკურსიულ ფუნქციაში, რომელიც მშობლამდე ადის და ბეჭდავს გზას

    private void printMatrix(int[][] matrix) {
        System.out.println("    ბიჯი ნომერი ");
        System.out.println("     **[ " + movesCounter + " ]**");
        for (int i = 0; i < MATRIX_SIZE; i++) {

            System.out.print("     * ");
            for (int j = 0; j < MATRIX_SIZE; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("*");
            System.out.println();

        }
        System.out.println("=    *********    = ");
    }

    /*
        საწყისი მატრიციდან საბოლოო მატრიცამდე გზის ბეჭდვა რეკურსიულად
    */
    private void printCurrentPath(Node finalEight) {
        if (finalEight.parent == null) {
            printMatrix(finalEight.getMatrix());
            return;
        }
        printCurrentPath(finalEight.parent);
        this.movesCounter++;
        printMatrix(finalEight.getMatrix());
    }


    /*
        BFS ალგორითმი, რომელშიც ვახდენთ ახალი კვანძის შექმნას ...
        შემდეგ ვამატებთ რიგის ბოლოში!!! ()
        შემდეგ ციკლს ვატრიალებ და ვიღებ პირველ ელემენტს და ვშლი რიგიდან
        შემდეგ გაჩერების პირობა
        და ამ ელემენტის შვილებს დავიჭერ და ამ ელემენტის მშობელს გავხდი currents...

    */
    void bfs(int blankX, int blankY) {
        Queue<Node> myNodesQueue = new LinkedList<>();
        // ახალი კვანზის შექმნა
        Node node = new Node(incipienceMatrix, blankX, blankY, blankX, blankY);
        node.parent = null;
        node.setChangedBox(countChangedCells(incipienceMatrix, originalMatrix));
        // ახალი NODE-ს გროვაში ჩაგდება
        myNodesQueue.add(node);
        // მანამ სანამ რიგი ცარიელი არაა შეასრულე შემდეგი ...
        while (!myNodesQueue.isEmpty()) {
            Node current = myNodesQueue.poll();

            // როცა განხილვაში საბოლოო მატრიცა გვექნება მაშინ საჭიროა,
            // რომ დავასრულოთ მოქმედებები და დავბეჭდოთ მისასვლელი გზა!
            if (current.getChangedBox() == 0) {
                printCurrentPath(current);
                return;
            }
            // მიმდინარე კვანძის გროვაში ჩამატება
            // ჩვენმა ფიგურამ შეიძლება იმოძრავოს მაქსიმუმ 4 მიმართულებით
            // მიმართულების ცვლილება მოცემულია მატრიცებში, რომლებიც განსაზღვრულია და დეკლალრილებური
            // კლასიის თავში თუ ვმოძრაობ მარჯვნივ მაშინ შესაბამისი სვეტის ნომერს ვუმატებ 1 და ამ
            // ლოგიკით ვახდენ მოძრაობას ნებისმიერი მიმარტულებით
            for (int i = 0; i < MAX_MOVES; i++) {
                int X = current.getX() + ROW[i];
                int Y = current.getY() + COLUMN[i];
                if (isCorrect(X, Y)) {
                    Node nextNode = new Node(current.getMatrix(), current.getX(), current.getY(), X, Y);
                    nextNode.parent = current;
                    nextNode.setChangedBox(countChangedCells(nextNode.getMatrix(), originalMatrix));
                    myNodesQueue.add(nextNode);
                }
            }
        }
    }
}


