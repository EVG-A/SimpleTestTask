package main.task03;

public final class MagicSquareUtils {
    /**
     * Don't let anyone instantiate this class.
     */
    private MagicSquareUtils() {}

    /**
     * The typical (or normal) magic square consists of consecutive integers (starting with 1 and ending with n²) placed into 'n' rows by 'n' columns so that all rows, all columns and both diagonals sum to the same total.
     * It is impossible to construct a 2 by 2 magic square (n = 2)
     *
     * @param n - length of the matrix. int[n][n];
     * @return magic square;
     * if n = 2 or n = 0 return null;
     */
    public static int[][] get(int n) {
        int length = Math.abs(n);
        if (length == 2 || length == 0) {
            return null;
        }
        int[][] arr = new int[length][length];

        if (length % 2 == 1) {
            fillSector(arr, 0, length - 1, 0, length - 1, 1, length * length);
        }
        if (length % 4 != 0 && length % 2 == 0) {
            int barrier = length * length / 4;
            int index = length / 2;
            fillSector(arr, 0, index - 1, 0, index - 1, 1, barrier);
            fillSector(arr, index, length - 1, index, length - 1, barrier + 1, barrier * 2);
            fillSector(arr, 0, index - 1, index, length - 1, barrier * 2 + 1, barrier * 3);
            fillSector(arr, index, length - 1, 0, index - 1, barrier * 3 + 1, barrier * 4);
            switchSubSquare(arr);
        }
        if (length % 4 == 0) {
            fillDoublySquare(arr);
        }
        return arr;
    }

    private static void fillDoublySquare(int[][] arr) {
        int n = arr[0].length;
        int x = n / 4;
        int y = n / 2;
        int count = 1;
        int revCount = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ((i < x || i >= x + y) && (j < x || j >= x + y)) || (j >= x && j < x + y && i >= x && i < x + y) ? count : revCount;
                revCount--;
                count++;
            }
        }
    }

    private static void fillSector(int[][] arr, int startI, int endI, int startJ, int endJ, int count, int barrier) {
        int i = startI;
        int halfSector = (endJ - startJ) / 2;
        int j = startJ == 0 ? halfSector : halfSector + arr[0].length / 2;
        int tempI = i;
        int tempJ = j;
        int value = count;
        while (value <= barrier) {
            if (arr[i][j] != 0) {
                i = tempI == endI ? startI : tempI + 1;
                j = tempJ;
            }
            arr[i][j] = value;
            value++;
            tempI = i;
            tempJ = j;
            j = j == endJ ? startJ : j + 1;
            i = i == startI ? endI : i - 1;
        }
    }

    private static void switchSubSquare(int[][] arr) {
        int n = arr[0].length / 2;
        int x = n;
        int rightStartIndex = 3 * n / 2 + 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                switchCell(arr, i, i == n / 2 ? j + 1 : j, x);
            }
            for (int j = rightStartIndex; j < arr[0].length; j++) {
                switchCell(arr, i, j, x);
            }
            x++;
        }
    }

    private static void switchCell(int[][] arr, int i, int j, int x) {
        int a = arr[i][j];
        arr[i][j] = arr[x][j];
        arr[x][j] = a;
    }
}
