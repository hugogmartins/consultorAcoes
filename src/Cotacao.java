public class Cotacao {
    String id;
    String data;
    double valor;
    public Cotacao(String linha)
    {
        String[] dados = linha.split(";");
        id = dados[0];
        data = dados[1];
        valor = Double.parseDouble(dados[2].replace(",", "."));
    }
}
