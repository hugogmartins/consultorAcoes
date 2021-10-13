public class Elemento {

    public Cotacao dados;
    public Elemento prox;

    public Elemento(Cotacao quem)
    {
        dados = quem;
        prox = null;
    }
}
