public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        inserirRecursivo(novoNo, this.raiz);
    }
    private void inserirRecursivo(No no, No atual) {
        if(estaVazia()) {
            this.raiz = no;
            return;
        }
        if(no.getConteudo() > atual.getConteudo()) {
            if(atual.getDireita() == null) {
                atual.setDireita(no);
                return;
            } else {
                inserirRecursivo(no, atual.getDireita());
            }
        } else {
            if(atual.getEsquerda() == null) {
                atual.setEsquerda(no);
                return;
            } else {
                inserirRecursivo(no, atual.getEsquerda());
            }
        }
    }

    public boolean estaVazia() {
        if(this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void exibir(String percurso) {
        switch(percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }

    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void remover(Integer conteudo) {
        if (estaVazia()) {
            return;
        }
        this.raiz = removerRecursivo(this.raiz, conteudo);

        // Mantém a consistência do estado "vazio" definido no construtor da classe
        if (this.raiz == null) {
            this.raiz = new No(null);
        }
    }

    private No removerRecursivo(No atual, Integer conteudo) {
        if (atual == null || atual.getConteudo() == null) {
            return null;
        }

        if (conteudo < atual.getConteudo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), conteudo));
        } else if (conteudo > atual.getConteudo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), conteudo));
        } else {
           
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

          
            No sucessor = encontrarMinimo(atual.getDireita());
            atual.setConteudo(sucessor.getConteudo());
            atual.setDireita(removerRecursivo(atual.getDireita(), sucessor.getConteudo()));
        }
        return atual;
    }

    private No encontrarMinimo(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
}