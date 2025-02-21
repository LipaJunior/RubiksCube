import java.util.List;

public class RubiksCube {
    static char[][] W = { { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, { 'W', 'W', 'W' } };
    static char[][] R = { { 'B', 'O', 'Y' }, { 'R', 'R', 'R' }, { 'R', 'R', 'R' } };
    static char[][] B = { { 'G', 'B', 'Y' }, { 'B', 'B', 'B' }, { 'B', 'B', 'B' } };
    static char[][] G = { { 'O', 'Y', 'Y' }, { 'G', 'G', 'G' }, { 'G', 'G', 'G' } };
    static char[][] O = { { 'G', 'Y', 'R' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
    static char[][] Y = { { 'Y', 'R', 'O' }, { 'Y', 'Y', 'G' }, { 'R', 'Y', 'B' } };

    public static void main(String[] args) {
        RubiksCube cube = new RubiksCube();
        cube.printCube();

        String[] moves = cube.solveCrossOnLastLayer(Y);
        for (int i = 0; i < moves.length; i++) {
            System.out.print(moves[i]);
        }

    }

    private static void printCube() {
        System.out.println("Up");
        printFace(W);
        System.out.println("Front");
        printFace(R);
        System.out.println("Right");
        printFace(B);
        System.out.println("Left");
        printFace(G);
        System.out.println("Down");
        printFace(Y);
        System.out.println("Back");
        printFace(O);
    }

    private boolean isCubeCompleted() {
        if (isFaceComplted(W) && isFaceComplted(R) && isFaceComplted(B) && isFaceComplted(G) && isFaceComplted(O)
                && isFaceComplted(Y)) {
            return true;
        }
        return false;
    }

    private static boolean isFaceComplted(char[][] face) {
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face.length; j++) {
                if (face[i][j] != face[1][1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printFace(char[][] face) {
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face.length; j++) {
                System.out.print(face[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateClockWise(char[][] face) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face.length; j++) {
                temp[j][2 - i] = face[i][j];
            }
        }
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face.length; j++) {
                face[i][j] = temp[i][j];
            }
        }

    }

    private static void rotateAntiClockWise(char[][] face) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face.length; j++) {
                temp[2 - j][i] = face[i][j];
            }
        }
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face.length; j++) {
                face[i][j] = temp[i][j];
            }
        }
    }

    private static void moveR() {
        rotateClockWise(B);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = W[i][2];
            W[i][2] = R[i][2];
            R[i][2] = Y[i][2];
            Y[i][2] = O[2 - i][0];
            O[2 - i][0] = temp[i];
        }
        printCube();
    }

    private static void moveRprim() {
        rotateAntiClockWise(B);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = W[i][2];
            W[i][2] = O[2 - i][0];
            O[2 - i][0] = Y[i][2];
            Y[i][2] = R[i][2];
            R[i][2] = temp[i];
        }
        printCube();
    }

    private static void moveL() {
        rotateClockWise(G);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = W[i][0];
            W[i][0] = O[2 - i][2];
            O[2 - i][2] = Y[i][0];
            Y[i][0] = R[i][0];
            R[i][0] = temp[i];
        }
        printCube();
    }

    private static void moveLprim() {
        rotateAntiClockWise(G);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = W[i][0];
            W[i][0] = R[i][0];
            R[i][0] = Y[i][0];
            Y[i][0] = O[2 - i][2];
            O[2 - i][2] = temp[i];
        }
        printCube();
    }

    private static void moveU() {
        rotateClockWise(W);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = R[0][i];
            R[0][i] = B[0][i];
            B[0][i] = O[0][i];
            O[0][i] = G[0][i];
            G[0][i] = temp[i];
        }
        printCube();
    }

    private static void moveUprim() {
        rotateAntiClockWise(W);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = R[0][i];
            R[0][i] = G[0][i];
            G[0][i] = O[0][i];
            O[0][i] = B[0][i];
            B[0][i] = temp[i];
        }
        printCube();
    }

    private static void moveF() {
        rotateClockWise(R);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = W[2][i];
            W[2][i] = G[i][2];
            G[i][2] = Y[0][i];
            Y[0][i] = B[i][0];
            B[i][0] = temp[i];
        }
        printCube();
    }

    private static void moveFprim() {
        rotateAntiClockWise(R);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = W[2][i];
            W[2][i] = B[i][0];
            B[i][0] = Y[0][i];
            Y[0][i] = G[i][2];
            G[i][2] = temp[i];
        }
        printCube();
    }

    private static void moveD() {
        rotateClockWise(Y);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = R[2][i];
            R[2][i] = G[2][i];
            G[2][i] = O[2][i];
            O[2][i] = B[2][i];
            B[2][i] = temp[i];
        }
        printCube();
    }

    private static void moveDprim() {
        rotateClockWise(Y);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = R[2][i];
            R[2][i] = B[2][i];
            B[2][i] = O[2][i];
            O[2][i] = G[2][i];
            G[2][i] = temp[i];
        }
        printCube();
    }

    private static void moveB() {
        rotateClockWise(O);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = W[0][i];
            W[0][i] = B[i][2];
            B[i][2] = Y[2][i];
            Y[2][i] = G[i][0];
            G[i][0] = temp[i];
        }
        printCube();
    }

    private static void moveBprim() {
        rotateAntiClockWise(O);
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = W[0][i];
            W[0][i] = G[i][0];
            G[i][0] = Y[2][i];
            Y[2][i] = B[i][2];
            B[i][2] = temp[i];
        }
        printCube();
    }

    private static void sexyMove() {
        moveR();
        moveU();
        moveRprim();
        moveUprim();
    }

    private static String[] solveCrossOnLastLayer(char[][] face) {
        char center = face[1][1];
        char upper = face[0][1];
        char left = face[1][0];
        char right = face[1][2];
        char down = face[2][1];
        if (upper != center && left != center && right != center && down != center) {
            return new String[] { "F", "R", "U", "R'", "U'", "F'", "B", "L", "U", "L'", "U", "B'", "F", "R", "U", "R'",
                    "U'", "F'" };
        } else if (upper == center && left == center) {
            return new String[] { "F", "R", "U", "R'", "U'", "R", "U", "R'", "U'", "F'" };
        } else if (upper == center && right == center) {
            return new String[] { "L", "F", "U", "F'", "U'", "F", "U", "F'", "U'", "L'" };
        } else if (down == center && left == center) {
            return new String[] { "R", "B", "U", "B'", "U'", "B", "U", "B'", "U'", "R'" };
        } else if (down == center && right == center) {
            return new String[] { "B", "L", "U", "L'", "U", "B'", "F", "R", "U", "R'", "U'", "F'" };
        } else if (down == center && upper == center) {
            return new String[] { "R", "B", "U", "B'", "U'", "R'" };
        } else if (left == center && right == center) {
            return new String[] { "F", "R", "U", "R'", "U'", "F'" };
        } else {
            return null;
        }

    }

    private static String[] lastLayerPart2(char[][] front, char[][] right, char[][] left, char[][] back) {
        char frontSticker = front[0][1];
        char frontCenter = front[1][1];
        char rightSticker = right[0][1];
        char rightCenter = right[1][1];
        char leftSticker = left[0][1];
        char leftCenter = left[1][1];
        char backSticker = back[0][1];
        char backCenter = back[1][1];
        int count = howManyStickersInPlaceForPart2(front, right, left, back);
        while (count < 2) {
            moveU();

        }
        if (frontSticker == frontCenter && rightSticker == rightCenter && leftSticker == leftCenter
                && backSticker == backCenter) {
            return null;
        }
    }

    private static int howManyStickersInPlaceForPart2(char[][] front, char[][] right, char[][] left, char[][] back) {
        int count = 0;
        char frontSticker = front[0][1];
        char frontCenter = front[1][1];
        char rightSticker = right[0][1];
        char rightCenter = right[1][1];
        char leftSticker = left[0][1];
        char leftCenter = left[1][1];
        char backSticker = back[0][1];
        char backCenter = back[1][1];
        if (frontSticker == frontCenter) {
            count++;
        }
        if (rightSticker == rightCenter) {
            count++;
        }
        if (leftSticker == leftCenter) {
            count++;
        }
        if (backSticker == backCenter) {
            count++;
        }
        return count;
    }

}