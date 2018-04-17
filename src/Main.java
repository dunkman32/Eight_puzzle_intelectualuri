public class Main {
    static final int[][] finalState = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
    };

    public static void main(String... args) {

        System.out.println("     [ რვიანი ]  " + System.getProperty("line.separator"));

        final int zeroX = 0;
        final int zeroY = 0;
//        final int zeroY = 2;

        int[][] currentState = {
//                {1, 2, 0},
//                {4, 5, 3},
//                {7, 8, 6}
                {0, 5, 2},
                {1, 4, 3},
                {7, 8, 6}
        };


        BFS puzzle = new BFS(currentState, finalState);

        puzzle.bfs(zeroX, zeroY);
    }
}

