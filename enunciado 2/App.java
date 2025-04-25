public class App {
    public static void main(String[] args) {
        // Matrizes de entrada (2x2)
        int[][] A = {
            {3, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 12}
        };

        // Criação do objeto Strassen
        StrassenMatrixMultiplication strassen = new StrassenMatrixMultiplication();

        // Multiplicação
        int[][] result = strassen.multiply(A, B);

        // Impressão do resultado
        System.out.println("Resultado da multiplicação:");
        for (int[] result1 : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result1[j] + "\t");
            }
            System.out.println();
        }
    }
}
