import java.util.Scanner;

public class Main {
    static final int[][] finalState = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 0}
            {2,8,3},
            {1,6,4},
            {7,0,5}
    };

    public static void main(String... args) {

        System.out.println("              [ რვიანი ]  " +
                System.getProperty("line.separator"));
        int zeroX;
        int zeroY;
        int[][] currentState = new int[3][3];

        System.out.println("    შეიყვანე დასალაგებელი მატრიცი! ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                currentState[i][j] = scanner.nextInt();
            }
        }
        System.out.println(" შემოიტანე ცარიელი უჯრის კოორდინატები");

        System.out.print("  სვეტის ნომერი : ");
        zeroX = scanner.nextInt() - 1;
        System.out.print("  სტრიქონის ნომერი : ");
        zeroY = scanner.nextInt() - 1;
        scanner.close();

        BFS puzzle = new BFS(currentState, finalState);

      //  puzzle.bfs(zeroX, zeroY);
        puzzle.bfs(zeroY, zeroX);
    }
}

