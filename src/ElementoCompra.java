public class ElementoCompra {
    Compra dados;
    ElementoCompra proximo;

    public ElementoCompra(Compra qual)
    {
        dados = qual;
        proximo = null;
    }
}
