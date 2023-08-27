import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Posicao { // buscar a posicao na matrix
    int x; //posicao x
    int y; // posicao y

    public Posicao(int x, int y) { //junta as duas posicoes
        this.x = x;
        this.y = y;
    }
}


public class Flood { //responsavel pelo Flood em si
    public static void floodFill(int[][] matrix, int x, int y, int Numero) {


                            // se for -1 em x vai pra esquerda e se for 1 vai pra direita
                            // se for -1 em y vai pra baixo e se for 1 vai pra cima
                              //x, y
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};



        int Linha = matrix.length; //numero de linhas
        int Coluna = matrix[0].length; //numero de colunas
        int Antnumero = matrix[x][y]; // pega o numero naquela posicao


        Queue<Posicao> queue = new LinkedList<>();
        queue.add(new Posicao(x, y)); // guarda todos posicoes em uma lista


        while (!queue.isEmpty()) { // para continuar ate que todos os numero estejam mudados (ate q a lista esteja vazia)
            Posicao posicao = queue.poll(); // remove o topo da lista para sempre ter espaco
            int px = posicao.x;
            int py = posicao.y;
               // se x ou y for menor que 0 quer dizer q esta fora
               // se x for igual ou maior ao numero quer dizer que esta fora
               // se y for igual  ou maior ao numero de colunas quer dizer fora
               // se o numero novo for diferente do numero antigo nao muda pois so muda os numeros iguais
            if (px < 0 || px >= Linha || py < 0 || py >= Coluna || matrix[px][py] != Antnumero) {
                continue; // e se algo disso for verdadeiro n deve fazer nada por isso um if vazio
            }

            matrix[px][py] = 2; // se ele nao passar pelo if ent o numero muda

            for (int[] dir : directions) { // checa as posicoes em volta do posicao escolihda
                int nx = px + dir[0]; //checa as posicoes dos lados
                int ny = py + dir[1]; //checa as posicoes de cima
                queue.add(new Posicao(nx, ny)); // adiciona as posicoes na lista ate q todas tenham sido checadas
            }

        }
    }
    public static void main(String[] args) {
        int[][] matriz = { // a matrix utilizada
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

        for (int[] linha : matriz) { // printa matrix antiga
            for (int posicao : linha) {
                System.out.print(posicao + " ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("X: ");
        int X = scanner.nextInt();
        System.out.print("Y: ");
        int Y = scanner.nextInt();

        floodFill(matriz, X, Y,2); //chama a "classe" anterior com os dados para serem utilizados

        for (int[] row : matriz) { //printa a matrix nova
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
