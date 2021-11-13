public class Compra {
    String codigo;
    long cpf;
    String data;
    double valor;

    public Compra(String linha)
    {
        String [] linhaTratada = linha.split(";");
        codigo = linhaTratada[0];
        cpf = Long.parseLong(linhaTratada[1].replace("-", ""));
        data = linhaTratada[2];
        valor = Double.parseDouble(linhaTratada[3]);
    }
}
