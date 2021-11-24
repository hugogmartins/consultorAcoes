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

    public void imprimir()
    {
        System.out.println("ID: " + this.id);
        System.out.println("DATA: " + this.data);
        System.out.println("VALOR: R$" + this.valor);
    }
}
