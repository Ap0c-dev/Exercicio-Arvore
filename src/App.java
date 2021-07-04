import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {


        //********************************Primeiro Exercicio**********************************
        //Pré-ordem: 8, 9, 11, 15, 19, 20, 21, 7, 3, 2, 1, 5, 6, 4, 13, 14, 10, 12, 17, 16, 18
        //In-ordem:  19, 15, 11, 21, 20, 9, 2, 3, 7, 1, 8, 13, 4, 6, 14, 10, 5, 16, 14, 12, 18
        //Pós-ordem: 19, 15, 21, 20, 11, 2, 3, 1, 7, 9, 13, 4, 10, 14, 6, 16, 14, 18, 12, 5, 8
        
        int valor;
        Arvore arvore = new Arvore();
        Random rand = new Random();
        int valorBusca = 0;

        System.out.print("Valores Arvore Binária: ");
        for (int i = 0; i < 10; i++) {
            valor = rand.nextInt(100);
            System.out.print(valor + " ");
            arvore.insereNo(valor);
            if (i == 5) {
                valorBusca = valor;
            }
        }

        System.out.print("\n\nPreOrdem: ");
        arvore.preOrdemRecursivoTransversal();

        System.out.print("\n\nInOrdem: ");
        arvore.inOrdemRecursivoTransversal();

        System.out.print("\n\nPosOrdem: ");
        arvore.posOrdemRecursivoTransversal();

        No aux = arvore.buscar(valorBusca);
        arvore.buscar(valorBusca);
        if (aux != null) {
            System.out.printf("\nO valor %d está na arvore binária\n", aux.valor);
        } else {
            System.out.println("\nO valor não está na arvore binária\n");
        }
        No aux2 = arvore.buscar(101);
        arvore.buscar(101);
        if (aux2 != null) {
            System.out.printf("\nO valor %d está na arvore binária\n", aux2.valor);
        } else {
            System.out.println("\nO valor não está na arvore binária\n");
        }
    }
}