public class Cotacao {
    String codigo;
    String data;
    double valor;

    public Cotacao(String linha)
    {
        String[] dados = linha.split(";");
        codigo = dados[0];
        data = dados[1];
        valor = Double.parseDouble(dados[2].replace(",", "."));
    }

    public void imprimir()
    {
        System.out.println("ID: " + this.codigo);
        System.out.println("DATA: " + this.data);
        System.out.println("VALOR: R$" + this.valor);
    }
}
