public class RubiksCube {
    char[][] W = { { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, { 'W', 'W', 'W' } };
    char[][] R = { { 'R', 'R', 'R' }, { 'R', 'R', 'R' }, { 'R', 'R', 'R' } };
    char[][] B = { { 'B', 'B', 'B' }, { 'B', 'B', 'B' }, { 'B', 'B', 'B' } };
    char[][] G = { { 'G', 'G', 'G' }, { 'G', 'G', 'G' }, { 'G', 'G', 'G' } };
    char[][] O = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
    char[][] Y = { { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' } };

    public static void main(String[] args) {
        RubiksCube cube = new RubiksCube();
        int count = 0;
        cube.moveR();
        cube.moveUprim();
        while (!cube.isCubeCompleted()) {
            cube.moveR();
            cube.moveUprim();
            count++;
        }
        System.out.print(count + 1);
    }

    private void printCube() {
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

    private void moveR() {
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

    private void moveRprim() {
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

    private void moveL() {
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

    private void moveLprim() {
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

    private void moveU() {
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

    private void moveUprim() {
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

    private void moveF() {
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

    private void moveFprim() {
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

    private void moveD() {
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

    private void moveDprim() {
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

    private void moveB() {
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

    private void moveBprim() {
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

    private void sexyMove() {
        moveR();
        moveU();
        moveRprim();
        moveUprim();
    }

}