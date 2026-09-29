import java.util.Arrays;

public class Ordenacao {

    // =========================================================
    // CLASSE PESSOA - EXEMPLO DE POO
    // =========================================================

    static class Pessoa {
        String nome;
        int idade;
        double salario;

        public Pessoa(String nome, int idade, double salario) {
            this.nome = nome;
            this.idade = idade;
            this.salario = salario;
        }

        @Override
        public String toString() {
            return nome + " | idade: " + idade + " | salario: " + salario;
        }
    }

    // =========================================================
    // 1. SELECTION SORT
    // =========================================================

    static void selectionSort(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            int menor = i;

            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }

            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
    }

    // Selection Sort DECRESCENTE
    static void selectionSortDecrescente(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            int maior = i;

            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[j] > vetor[maior]) {
                    maior = j;
                }
            }

            int temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;
        }
    }

    // =========================================================
    // 2. BUBBLE SORT
    // =========================================================

    static void bubbleSort(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            boolean trocou = false;

            for (int j = 0; j < vetor.length - 1 - i; j++) {

                if (vetor[j] > vetor[j + 1]) {

                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;

                    trocou = true;
                }
            }

            // Se não houve troca, já está ordenado
            if (!trocou) {
                break;
            }
        }
    }

    // Bubble Sort DECRESCENTE
    static void bubbleSortDecrescente(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            for (int j = 0; j < vetor.length - 1 - i; j++) {

                if (vetor[j] < vetor[j + 1]) {

                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    // =========================================================
    // 3. INSERTION SORT
    // =========================================================

    static void insertionSort(int[] vetor) {

        for (int i = 1; i < vetor.length; i++) {

            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {

                vetor[j + 1] = vetor[j];

                j--;
            }

            vetor[j + 1] = chave;
        }
    }

    // Insertion Sort DECRESCENTE
    static void insertionSortDecrescente(int[] vetor) {

        for (int i = 1; i < vetor.length; i++) {

            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] < chave) {

                vetor[j + 1] = vetor[j];

                j--;
            }

            vetor[j + 1] = chave;
        }
    }

    // =========================================================
    // 4. MERGE SORT
    // =========================================================

    static void mergeSort(int[] vetor, int inicio, int fim) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;

            mergeSort(vetor, inicio, meio);

            mergeSort(vetor, meio + 1, fim);

            merge(vetor, inicio, meio, fim);
        }
    }

    static void merge(int[] vetor, int inicio, int meio, int fim) {

        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        int[] esquerda = new int[tamanhoEsquerda];
        int[] direita = new int[tamanhoDireita];

        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = vetor[inicio + i];
        }

        for (int j = 0; j < tamanhoDireita; j++) {
            direita[j] = vetor[meio + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < tamanhoEsquerda && j < tamanhoDireita) {

            if (esquerda[i] <= direita[j]) {

                vetor[k] = esquerda[i];
                i++;

            } else {

                vetor[k] = direita[j];
                j++;
            }

            k++;
        }

        while (i < tamanhoEsquerda) {

            vetor[k] = esquerda[i];

            i++;
            k++;
        }

        while (j < tamanhoDireita) {

            vetor[k] = direita[j];

            j++;
            k++;
        }
    }

    // =========================================================
    // MERGE SORT DECRESCENTE
    // =========================================================

    static void mergeSortDecrescente(int[] vetor, int inicio, int fim) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;

            mergeSortDecrescente(vetor, inicio, meio);

            mergeSortDecrescente(vetor, meio + 1, fim);

            mergeDecrescente(vetor, inicio, meio, fim);
        }
    }

    static void mergeDecrescente(int[] vetor, int inicio, int meio, int fim) {

        int[] temporario = new int[fim - inicio + 1];

        int i = inicio;
        int j = meio + 1;
        int k = 0;

        while (i <= meio && j <= fim) {

            if (vetor[i] >= vetor[j]) {

                temporario[k] = vetor[i];
                i++;

            } else {

                temporario[k] = vetor[j];
                j++;
            }

            k++;
        }

        while (i <= meio) {

            temporario[k] = vetor[i];

            i++;
            k++;
        }

        while (j <= fim) {

            temporario[k] = vetor[j];

            j++;
            k++;
        }

        for (int x = 0; x < temporario.length; x++) {

            vetor[inicio + x] = temporario[x];
        }
    }

    // =========================================================
    // MAIOR VALOR
    // =========================================================

    static int maior(int[] vetor) {

        int maior = vetor[0];

        for (int i = 1; i < vetor.length; i++) {

            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }

        return maior;
    }

    // =========================================================
    // MENOR VALOR
    // =========================================================

    static int menor(int[] vetor) {

        int menor = vetor[0];

        for (int i = 1; i < vetor.length; i++) {

            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }

        return menor;
    }

    // =========================================================
    // BUSCAR UM VALOR
    // =========================================================

    static boolean buscar(int[] vetor, int valor) {

        for (int numero : vetor) {

            if (numero == valor) {
                return true;
            }
        }

        return false;
    }

    // =========================================================
    // SELECTION SORT COM POO
    // Ordenando por idade
    // =========================================================

    static void selectionSortPorIdade(Pessoa[] pessoas) {

        for (int i = 0; i < pessoas.length - 1; i++) {

            int menor = i;

            for (int j = i + 1; j < pessoas.length; j++) {

                if (pessoas[j].idade < pessoas[menor].idade) {
                    menor = j;
                }
            }

            Pessoa temp = pessoas[i];
            pessoas[i] = pessoas[menor];
            pessoas[menor] = temp;
        }
    }

    // =========================================================
    // BUBBLE SORT COM POO
    // Ordenando por salário
    // =========================================================

    static void bubbleSortPorSalario(Pessoa[] pessoas) {

        for (int i = 0; i < pessoas.length - 1; i++) {

            for (int j = 0; j < pessoas.length - 1 - i; j++) {

                if (pessoas[j].salario > pessoas[j + 1].salario) {

                    Pessoa temp = pessoas[j];

                    pessoas[j] = pessoas[j + 1];

                    pessoas[j + 1] = temp;
                }
            }
        }
    }

    // =========================================================
    // INSERTION SORT COM POO
    // Ordenando por nome
    // =========================================================

    static void insertionSortPorNome(Pessoa[] pessoas) {

        for (int i = 1; i < pessoas.length; i++) {

            Pessoa chave = pessoas[i];

            int j = i - 1;

            while (j >= 0 &&
                   pessoas[j].nome.compareToIgnoreCase(chave.nome) > 0) {

                pessoas[j + 1] = pessoas[j];

                j--;
            }

            pessoas[j + 1] = chave;
        }
    }

    // =========================================================
    // EXIBIR VETOR
    // =========================================================

    static void imprimir(int[] vetor) {

        for (int numero : vetor) {
            System.out.print(numero + " ");
        }

        System.out.println();
    }

    // =========================================================
    // EXIBIR PESSOAS
    // =========================================================

    static void imprimirPessoas(Pessoa[] pessoas) {

        for (Pessoa pessoa : pessoas) {

            System.out.println(pessoa);
        }

        System.out.println();
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        // =====================================================
        // VETOR ORIGINAL
        // =====================================================

        int[] vetor = {8, 3, 10, 1, 7, 5, 2};

        System.out.println("Vetor original:");
        imprimir(vetor);

        // =====================================================
        // SELECTION SORT
        // =====================================================

        int[] selection = vetor.clone();

        selectionSort(selection);

        System.out.println("\nSelection Sort crescente:");
        imprimir(selection);

        // =====================================================
        // BUBBLE SORT
        // =====================================================

        int[] bubble = vetor.clone();

        bubbleSort(bubble);

        System.out.println("\nBubble Sort crescente:");
        imprimir(bubble);

        // =====================================================
        // INSERTION SORT
        // =====================================================

        int[] insertion = vetor.clone();

        insertionSort(insertion);

        System.out.println("\nInsertion Sort crescente:");
        imprimir(insertion);

        // =====================================================
        // MERGE SORT
        // =====================================================

        int[] merge = vetor.clone();

        mergeSort(merge, 0, merge.length - 1);

        System.out.println("\nMerge Sort crescente:");
        imprimir(merge);

        // =====================================================
        // ORDEM DECRESCENTE
        // =====================================================

        int[] decrescente = vetor.clone();

        selectionSortDecrescente(decrescente);

        System.out.println("\nSelection Sort decrescente:");
        imprimir(decrescente);

        // =====================================================
        // MAIOR E MENOR
        // =====================================================

        System.out.println("\nMaior valor:");
        System.out.println(maior(vetor));

        System.out.println("\nMenor valor:");
        System.out.println(menor(vetor));

        // =====================================================
        // BUSCA
        // =====================================================

        System.out.println("\nO valor 7 existe?");
        System.out.println(buscar(vetor, 7));

        // =====================================================
        // POO
        // =====================================================

        Pessoa[] pessoas = {

            new Pessoa("Gabriel", 20, 3000),
            new Pessoa("Ana", 25, 4500),
            new Pessoa("Carlos", 18, 2500),
            new Pessoa("Beatriz", 22, 5000)
        };

        // =====================================================
        // ORDENAÇÃO POR IDADE
        // =====================================================

        System.out.println("\nPessoas ordenadas por idade:");

        Pessoa[] porIdade = pessoas.clone();

        selectionSortPorIdade(porIdade);

        imprimirPessoas(porIdade);

        // =====================================================
        // ORDENAÇÃO POR SALÁRIO
        // =====================================================

        System.out.println("Pessoas ordenadas por salário:");

        Pessoa[] porSalario = pessoas.clone();

        bubbleSortPorSalario(porSalario);

        imprimirPessoas(porSalario);

        // =====================================================
        // ORDENAÇÃO POR NOME
        // =====================================================

        System.out.println("Pessoas ordenadas por nome:");

        Pessoa[] porNome = pessoas.clone();

        insertionSortPorNome(porNome);

        imprimirPessoas(porNome);
    }
}
