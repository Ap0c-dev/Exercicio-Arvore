public class No {
    
    public No noEsquerdo;
    public int valor;
    public No noDireito;

    public No(int valor) {
        this.valor = valor;
        noDireito = null;
        noEsquerdo = null;
    }
    public void insereNo(int valorIsercao) {
        if (valorIsercao < this.valor) {
            if (this.noEsquerdo == null) {
                this.noEsquerdo = new No(valorIsercao);
            } else {
                this.noEsquerdo.insereNo(valorIsercao);
            }
        } else if (valorIsercao > this.valor) {
            if (this.noDireito == null) {
                this.noDireito = new No(valorIsercao);
            } else {
                this.noDireito.insereNo(valorIsercao);
            }
        }
    }
}