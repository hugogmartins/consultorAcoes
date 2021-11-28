public class Acoes {
    String codigo;
    String nome;
    ListaDinamicaCotacoes cotacoes;

    public Acoes(String linha)
    {
        String[] linhaTratada = linha.split(";");
        codigo = linhaTratada[0];
        nome = linhaTratada[1];
        cotacoes = new ListaDinamicaCotacoes();
    }

    public void imprimir()
    {
        System.out.println("CODIGO: " + this.codigo);
        System.out.println("NOME: " + this.nome);
    }
}
