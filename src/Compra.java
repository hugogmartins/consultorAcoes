public class Compra {
    String codigo;
    String cpf;
    String data;
    int qtde;

    public Compra(String linha)
    {
        String [] linhaTratada = linha.split(";");
        codigo = linhaTratada[0];
        cpf = linhaTratada[1];
        data = linhaTratada[2];
        qtde = Integer.parseInt(linhaTratada[3]);
    }

    public void imprimir()
    {
        System.out.println("CÓDIGO: " + this.codigo);
        System.out.println("DATA: " + this.data);
        System.out.println("QUANTIDADE: " + this.qtde);
    }
}
