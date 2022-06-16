package c01;

class Ex14 {

    public static void main(String[] args) {
        int[][] valid = {
                {2, 7, 6},
                {9, 5, 1},
                {4, 3, 8}
        };

        int[][] invalidRows = {
                {2, 7, 6},
                {9, 5, 1},
                {4, 3, 8},
                {4, 3, 8}
        };

        int[][] invalidColumns = {
                {2, 7, 6},
                {9, 5, 1},
                {4, 3, 8, 1}
        };

        int[][] invalidMagicNumber = {
                {2, 7, 6},
                {9, 5, 1},
                {4, 3, 1}
        };

        System.out.println(isMagicSquare(valid));
        System.out.println(isMagicSquare(invalidRows));
        System.out.println(isMagicSquare(invalidColumns));
        System.out.println(isMagicSquare(invalidMagicNumber));
    }

    static boolean isMagicSquare(int[][] t) {
        if (t.length == 0) {
            return false;
        }
        for (final int[] row : t) {
            if (t.length != row.length) {
                return false;
            }
        }

        var magicSum = 0;
        var diagonalSum1 = 0;
        var diagonalSum2 = 0;

        for (int i = 0; i < t.length; i++) {
            var rowSum = 0;

            for (int j = 0; j < t[i].length; j++) {
                rowSum += t[i][j];
                if (i == j) {
                    diagonalSum1 += t[i][j];
                }
                if (j == t[i].length - 1 - i) {
                    diagonalSum2 += t[i][t[j].length - 1 - i];
                }
            }
            if (i == 0) {
                magicSum = rowSum;
            }
            if (rowSum != magicSum) {
                return false;
            }
            if (i == t.length - 1) {
                if (diagonalSum1 != magicSum || diagonalSum2 != magicSum) {
                    return false;
                }
            }
        }
        return true;
    }
}
