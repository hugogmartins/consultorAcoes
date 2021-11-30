public class ElementoAcoes {
    Acoes dados;
    ElementoAcoes proximo;

    public ElementoAcoes(Acoes qual)
    {
        dados = qual;
        proximo = null;
    }
}