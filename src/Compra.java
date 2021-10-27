public class Compra {
    String codigo;
    String token;
    String data;
    double valor;

    public Compra(String linha)
    {
        String [] linhaTratada = linha.split(";");
        codigo = linhaTratada[0];
        token = linhaTratada[1];
        data = linhaTratada[2];
        valor = Double.parseDouble(linhaTratada[3]);
    }
}
