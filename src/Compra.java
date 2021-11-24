public class Compra {
    String codigo;
    long cpf;
    String data;
    int qtde;

    public Compra(String linha)
    {
        String [] linhaTratada = linha.split(";");
        codigo = linhaTratada[0];
        cpf = Long.parseLong(linhaTratada[1].replace("-", ""));
        data = linhaTratada[2];
        qtde = Integer.parseInt(linhaTratada[3]);
    }

    public void imprimir()
    {
        System.out.println("CÓDIGO: " + this.codigo);
        System.out.println("DATA: " + this.data);
        System.out.println("QUANTIDADE: " + this.qtde);
    }

    //resultado
}
