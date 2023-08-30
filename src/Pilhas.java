public class Pilhas<par> {
    private int top = -1;
    private par[] data;

    public Pilhas(int tamanho) {
        this.data = (par[]) new Object[tamanho];
    }


    public boolean isFull() { //ve se a pilha ta cheia
        return top == data.length - 1;
    }

    public boolean isEmpty() { // ve se a pilha ta vazia
        if (this.top == -1) {
            return true;

        } else {
            return false;
        }

    }


    public void entrapilha(par item) {
        if (!isFull()) {
            top++;
            data[top] = item;
        } else {
            System.out.println();
        }
    }

    public par saipilha() {
        if (!isEmpty()) {
            par item = (par) data[top];
            data[top] = null;
            top--;
            return item;
        } else {
            System.out.println();
        }
        return null;
    }
}
