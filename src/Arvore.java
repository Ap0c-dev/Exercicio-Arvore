public class Arvore {

    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void insereNo(int valorIsercao) {
        if (this.raiz == null) {
            this.raiz = new No(valorIsercao);
        } else {
            this.raiz.insereNo(valorIsercao);
        }
    }

    public No buscarRecursivo(int valorBusca) {
        return buscar(this.raiz, valorBusca);
    }
    public No buscar(int valorBusca) {
        if (raiz == null)
            return null; 
        No atual = raiz; 
        while (atual.valor != valorBusca) { 
            if (valorBusca < atual.valor)
                atual = atual.noEsquerdo;
            else
                atual = atual.noDireito; 
            if (atual == null)
                return null; 
        } 
        return atual; 
    }
    public No buscar(No raiz, int valorBusca) {
        No aux = raiz;
        if (aux == null) {
            return null;
        } else if (aux.valor != valorBusca) {
            if (valorBusca < aux.valor) {
                aux = aux.noEsquerdo;
                aux = buscar(aux, valorBusca);
            } else {
                aux = aux.noDireito;
                aux = buscar(aux, valorBusca);
            }
        }
        return aux;
    }
    public No remover(int valorRemocao) {
        if (this.raiz == null) {
            return null; 
        }
        No atual = this.raiz;
        No pai = this.raiz;
        boolean filho_esq = true;

        while (atual.valor != valorRemocao) { 
            pai = atual;
            if (valorRemocao < atual.valor) { 
                atual = atual.noEsquerdo;
                filho_esq = true; 
            } else { 
                atual = atual.noDireito;
                filho_esq = false;
            }
            if (atual == null)
                return null; 
        } 
        if (atual.noEsquerdo == null && atual.noDireito == null) {
            if (atual == this.raiz)
                this.raiz = null; 
            else if (filho_esq)
                pai.noEsquerdo = null; 
            else
                pai.noDireito = null; 
        }
        else if (atual.noDireito == null) {
            if (atual == this.raiz)
                this.raiz = atual.noEsquerdo; 
            else if (filho_esq)
                pai.noEsquerdo = atual.noEsquerdo; 
            else
                pai.noDireito = atual.noDireito; 
        }
        else if (atual.noEsquerdo == null) {
            if (atual == this.raiz)
                this.raiz = atual.noDireito; 
            else if (filho_esq)
                pai.noEsquerdo = atual.noDireito; 
            else
                pai.noDireito = atual.noDireito; 
        }
        else {
            No sucessor = no_sucessor(atual);
           
            if (atual == this.raiz)
                this.raiz = sucessor; 
            else if (filho_esq)
                pai.noEsquerdo = sucessor; 
            else
                pai.noDireito = sucessor; 
            sucessor.noEsquerdo = atual.noEsquerdo; 
        }
        return atual;
    }
    public No no_sucessor(No apaga) { 
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.noDireito; 

        while (atual != null) { 
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.noEsquerdo; 
        }
        if (sucessor != apaga.noDireito) { 
            paidosucessor.noEsquerdo = sucessor.noDireito; 
            sucessor.noDireito = apaga.noDireito; 
        }
        return sucessor;
    }
    public void preOrdemTransversal() {
        preOrdemAuxiliar(this.raiz);
    }
    private void preOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        System.out.printf(" %d ", no.valor);
        preOrdemAuxiliar(no.noEsquerdo);
        preOrdemAuxiliar(no.noDireito);
    }
    public void inOrdemTransversal() {
        inOrdemAuxiliar(this.raiz);
    }
    private void inOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        inOrdemAuxiliar(no.noEsquerdo);
        System.out.printf(" %d ", no.valor);
        inOrdemAuxiliar(no.noDireito);
    }
    public void posOrdemTransversal() {
        posOrdemAuxiliar(this.raiz);
    }
    private void posOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        posOrdemAuxiliar(no.noEsquerdo);
        posOrdemAuxiliar(no.noDireito);
        System.out.printf(" %d ", no.valor);
    }
    public void preOrdemRecursiva(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdemRecursiva(no.noEsquerdo);
            preOrdemRecursiva(no.noDireito);
        }
    }
    public void posOrdemRecursiva(No no) {
        if (no != null) {
            posOrdemRecursiva(no.noEsquerdo);
            posOrdemRecursiva(no.noDireito);
            System.out.print(no.valor + " ");
        }
    }
    public void inOrdemRecursivo(No no) {
        if (no != null) {
            inOrdemRecursivo(no.noEsquerdo);
            System.out.print(no.valor + " ");
            inOrdemRecursivo(no.noDireito);
        }
    }
    public void preOrdemRecursivoTransversal() {
        preOrdemRecursiva(this.raiz);
    }
    public void inOrdemRecursivoTransversal() {
        inOrdemRecursivo(this.raiz);
    }
    public void posOrdemRecursivoTransversal() {
        posOrdemRecursiva(this.raiz);
    }
}