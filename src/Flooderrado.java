import java.lang.management.MemoryType;
import java.util.Scanner;

import javax.print.FlavorException;


public class Flooderrado{
    public static void printa_image( int[][] image){
        for ( int[] elemento: image) {
            for ( int pixel: elemento){
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    public static void vizinhos_fila(int x,int y, int[][] image, queue filapintura){ // responsavel pela direcao
        int xnovo = x - 1; //move para esquerda
        int ynovo = y;
        posicao parnovo;
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length)== true){
            parnovo = new posicao(xnovo, ynovo);
            filapintura.entra(parnovo);
        }
        xnovo = x + 1; //move para direita
        ynovo = y;
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length)== true){
            parnovo = new posicao(xnovo, ynovo);
            filapintura.entra(parnovo);
        }
        xnovo = x;
        ynovo = y - 1; //move para baixo
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length)== true){
            parnovo = new posicao(xnovo, ynovo);
            filapintura.entra(parnovo);
        }
        xnovo = x;
        ynovo = y + 1; //move para cima
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length)== true){
            parnovo = new posicao(xnovo, ynovo);
            filapintura.entra(parnovo);
        }
    }

    public static void pintar_fila(int[][] image, int startX, int startY, int cor_inicial, int cor_nova) {
        posicao parinicio = new posicao(startX, startY);
        queue<posicao> queuepintura = new queue<>(200);
        queuepintura.entra(parinicio);

        while (!queuepintura.isEmpty()) {
            posicao paratual = queuepintura.remove();
            int x = paratual.getX();
            int y = paratual.getY();

            if (COR(image, paratual, cor_inicial, cor_nova)) {
                vizinhos_fila(x, y, image, queuepintura);
                image[x][y] = cor_nova;
                System.out.println("---------------------------");
                printa_image(image);  // Printa a matriz após pintar um pixel
            }
        }
    }


    public static boolean COR(int[][] image, posicao paratual, int cor_inicial, int cor_nova) { //pega o numero original
        int x = paratual.getX();
        int y = paratual.getY();
        if (image[x][y] == cor_inicial){
            return true;
        }else{
            return false;
        }

    }

    public static void vizinhos_pilha(int x, int y, int[][] image, Pilhas<posicao> pilhaPintura){
        int xnovo = x - 1; //move para esquerda
        int ynovo = y;
        posicao parnovo;
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length)== true){
            parnovo = new posicao(xnovo, ynovo);
            pilhaPintura.entrapilha(parnovo);
        }
        xnovo = x + 1; //move para direita
        ynovo = y;
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length)== true){
            parnovo = new posicao(xnovo, ynovo);
            pilhaPintura.entrapilha(parnovo);
        }
        xnovo = x;
        ynovo = y - 1; //move para baixo
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length)== true){
            parnovo = new posicao(xnovo, ynovo);
            pilhaPintura.entrapilha(parnovo);
        }
        xnovo = x;
        ynovo = y + 1; //move para cima
        if ((xnovo >= 0 && xnovo < image.length && ynovo >= 0 && ynovo < image.length)== true){
            parnovo = new posicao(xnovo, ynovo);
            pilhaPintura.entrapilha(parnovo);
        }
    }


    public static void pintar_pilha(int[][] image, int startX, int startY, int cor_inicial, int cor_nova) {
        int tamanhoPilha = image.length * image[0].length;
        Pilhas<posicao> pilhaPintura = new Pilhas<>(tamanhoPilha);

        pilhaPintura.entrapilha(new posicao(startX, startY));

        while (!pilhaPintura.isEmpty()) {
            posicao paratual = pilhaPintura.saipilha();
            int x = paratual.getX();
            int y = paratual.getY();

            if (COR(image, paratual, cor_inicial, cor_nova)) {
                vizinhos_pilha(x, y, image, pilhaPintura);
                image[x][y] = cor_nova;
                System.out.println("---------------------------");
                printa_image(image);  // Printa a matriz após pintar um pixel
            }
        }
    }
    public static void main(String[] args) {
        int cor_inicial;
        int[][] Matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        printa_image(Matrix);
        Scanner scanner = new Scanner(System.in);
        System.out.print("X: ");
        int startX = scanner.nextInt();
        System.out.print("Y: ");
        int startY = scanner.nextInt();
        cor_inicial = Matrix[startX][startY];
        System.out.print("Novo Valor: ");
        int cor_nova = scanner.nextInt();
        System.out.print("Pilha[1], Fila[2] (digitar o numero): ");
        int Tipo = scanner.nextInt();
        if (Tipo == 1){
            System.out.print("Vc escolheu Pilha!! ");
            pintar_pilha(Matrix, startX, startY, cor_inicial, cor_nova);

        } else if (Tipo == 2) {
            System.out.print("Vc escolheu Fila!! ");
            pintar_fila(Matrix, startX, startY, cor_inicial, cor_nova);

        } else {
            System.out.print("Escolha um numero valido na prox");

        }

    }
}
