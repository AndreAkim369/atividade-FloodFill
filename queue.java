public class queue<par> {
    private int top = -1;
    private int base = 0;
    private par[] data;


    public queue(int tamanho) {
        this.data = (par[]) new Object[tamanho];
    }

    public boolean isFull() {
        if (this.base == this.top) {
            return true;

        } else {
            return false;

        }
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;

        } else {
            return false;

        }
    }

    public void entra(par data) {
        top = move(top);
        if (isFull() == true) {

        } else {
            if (this.top == -1) {
                this.top = 0;
                this.data[top] = data;
                this.top++;

            } else {

                this.data[top] = data;
                this.top++;

            }
        }
    }

    public par remove() {
        if (!isEmpty()) {
            par item = data[base];
            base++;
            if (this.base == this.top) {
                this.top = -1;
                this.base = 0;
            }
            return item;
        } else {

        }
        return null;
    }



    private int move(int position) {
        if (position + 1 == this.data.length + 1) {
            return 0;

        } else {
            return position++;

        }
    }
}