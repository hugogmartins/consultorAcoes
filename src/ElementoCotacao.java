public class ElementoCotacao {

    public Cotacao dados;
    public ElementoCotacao prox;

    public ElementoCotacao(Cotacao quem)
    {
        dados = quem;
        prox = null;
    }
}
