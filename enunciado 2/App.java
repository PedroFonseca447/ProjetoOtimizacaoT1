public class App {
    public static void main(String[] args) {
        // Matrizes de entrada (2x2)
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        // Criação do objeto Strassen
        StrassenMatrixMultiplication strassen = new StrassenMatrixMultiplication();

        // Multiplicação
        int[][] result = strassen.multiply(A, B);

        // Impressão do resultado
        System.out.println("Resultado da multiplicação:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
