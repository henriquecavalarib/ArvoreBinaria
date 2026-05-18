public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(50);
        arvoreBinaria.inserir(30);
        arvoreBinaria.inserir(70);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(40);
        arvoreBinaria.remover(20);
        arvoreBinaria.remover(70);
        arvoreBinaria.remover(50);
        arvoreBinaria.exibir("Em");
    }
}