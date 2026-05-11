import java.util.Scanner;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        //inserirRecursivo(novoNo, this.raiz);
        inserirIterativo(novoNo);
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

    private void inserirIterativo(No no) {
        if(estaVazia()) {
            this.raiz = no;
            return;
        } else {
            No aux = this.raiz;
            while(aux != null) {
                if(no.getConteudo() > aux.getConteudo()) {
                    if(aux.getDireita() == null) {
                        aux.setDireita(no);
                        return;
                    } else {
                        aux = aux.getDireita();
                    }
                } else {
                    if(aux.getEsquerda() == null) {
                        aux.setEsquerda(no);
                        return;
                    } else {
                        aux = aux.getEsquerda();
                    }
                }
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

    public void menu() {
        Scanner sc =  new Scanner(System.in);

        System.out.println("1 - Exibir");
        System.out.println("2 - Remover");

        System.out.print("R: ");
        int opcao = sc.nextInt();

        switch(opcao){
            case 1:
                exibir();
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

    public void exibir(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - PosOrdem");
        System.out.println("2 - EmOrdem");
        System.out.println("3 - PreOrdem");

        int percurso = 0;

        System.out.print("R: ");
        percurso  = sc.nextInt();

        switch (percurso) {
            case 1:
                posOrdem(this.raiz);
                break;
            case 2:
                emOrdem(this.raiz);
                break;
            case 3:
                preOrdem(this.raiz );
                break;
        
            default:
                break;
        }



        
    }

    private void RemoverNo(No no){
        No aux;
        aux = no;

        if(aux.getConteudo().equals(null)){
            return;
        }
        
        

    }
}
