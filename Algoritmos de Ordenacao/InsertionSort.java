
public class InsertionSort {
    public static void main(String[] args) {
        int[] vetor = {5, 3, 8, 1, 4};

        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = chave;
        }

        for (int numero : vetor) {
            System.out.print(numero + " ");
        }
    }
}
