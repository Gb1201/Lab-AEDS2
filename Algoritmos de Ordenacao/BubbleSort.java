
public class BubbleSort {
    public static void main(String[] args) {
        int[] vetor = {5, 3, 8, 1, 4};

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        for (int numero : vetor) {
            System.out.print(numero + " ");
        }
    }
}
