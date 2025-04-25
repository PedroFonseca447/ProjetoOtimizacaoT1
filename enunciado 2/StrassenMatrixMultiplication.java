public class StrassenMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;

        // Ajusta o tamanho para potência de 2
        int size = nextPowerOfTwo(n);
        int[][] pivoA = new int[size][size];
        int[][] pivoB = new int[size][size];

        // Copia A e B para matrizes maiores com padding de zeros
        for (int i = 0; i < n; i++) {// 
            System.arraycopy(A[i], 0, pivoA[i], 0, n);
            System.arraycopy(B[i], 0, pivoB[i], 0, n);
        }

        int[][] result = strassen(pivoA, pivoB);

        // Remove padding e retorna resultado final n x n
        int[][] finalResult = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(result[i], 0, finalResult[i], 0, n);
        }

        return finalResult;
    }
    //aqui realiza a divisão em conquista para cada 
    private int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        //caso vetor a venha vazio
        if(n == 0){
            return null;
        }

        if (n == 1) { //caso result venha com um unico elemento
            result[0][0] = A[0][0] * B[0][0];
            return result;
        }
        //divida s matrizes de entradas a e b em saida C com n/2 x n/2 sumatrizes
        int newSize = n / 2;
        int[][] a11 = new int[newSize][newSize];
        int[][] a12 = new int[newSize][newSize];
        int[][] a21 = new int[newSize][newSize];
        int[][] a22 = new int[newSize][newSize];

        int[][] b11 = new int[newSize][newSize];
        int[][] b12 = new int[newSize][newSize];
        int[][] b21 = new int[newSize][newSize];
        int[][] b22 = new int[newSize][newSize];

        // Divide matrizes A e B
        split(A, a11, 0, 0);
        split(A, a12, 0, newSize);
        split(A, a21, newSize, 0);
        split(A, a22, newSize, newSize);

        split(B, b11, 0, 0);
        split(B, b12, 0, newSize);
        split(B, b21, newSize, 0);
        split(B, b22, newSize, newSize);
        //calcule p1 até p7, cada matriz de M é n/2 x n/2
        // Calcula M1 a M7
        int[][] M1 = strassen(add(a11, a22), add(b11, b22));
        int[][] M2 = strassen(add(a21, a22), b11);
        int[][] M3 = strassen(a11, subtract(b12, b22));
        int[][] M4 = strassen(a22, subtract(b21, b11));
        int[][] M5 = strassen(add(a11, a12), b22);
        int[][] M6 = strassen(subtract(a21, a11), add(b11, b12));
        int[][] M7 = strassen(subtract(a12, a22), add(b21, b22));
        //calcula as submatrizes 
        

        //monta a matriz C com as submatrizes M1 até M7
        int[][] c11 = add(subtract(add(M1, M4), M5), M7);
        int[][] c12 = add(M3, M5);
        int[][] c21 = add(M2, M4);
        int[][] c22 = add(subtract(add(M1, M3), M2), M6);

            // junta os blocos formados para a matriz C
        join(c11, result, 0, 0);
        join(c12, result, 0, newSize);
        join(c21, result, newSize, 0);
        join(c22, result, newSize, newSize);

        return result;
    }

    // Apoiadores: soma, 
    private int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }
    //operacao de subtracao no strassen
    private int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }
   //quem quebra as matrizes em submatrizes
    private void split(int[][] parent, int[][] child, int row, int col) {
        for (int i = 0; i < child.length; i++)
            System.arraycopy(parent[i + row], col, child[i], 0, child.length);
    }

    private void join(int[][] child, int[][] parent, int row, int col) {
        for (int i = 0; i < child.length; i++)
            System.arraycopy(child[i], 0, parent[i + row], col, child.length);
    }
    //metodo que da um padding na lista caso uma das matrizes seja impar
    private int nextPowerOfTwo(int n) {
        int power = 1;
        while (power < n)
            power *= 2;
        return power;
    }
}
