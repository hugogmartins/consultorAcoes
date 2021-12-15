public class ListaDinamicaCotacoes 
{
    ElementoCotacao sentinela, ultimo;

    public ListaDinamicaCotacoes()
    {
        sentinela = new ElementoCotacao(null);
        ultimo = sentinela;
    }

    public boolean listaVazia()
    {
        return (sentinela == ultimo);
    }

    public void inserir(Cotacao qual)
    {
        ElementoCotacao nova = new ElementoCotacao(qual);
        ultimo.prox = nova;
        ultimo = nova;
    }

    public Cotacao remover(String procura)
    {
        if(listaVazia())
        {
            return null;
        }
        ElementoCotacao aux1 = sentinela;
        ElementoCotacao aux2 = sentinela.prox;
        while(aux2 != null)
        {
            if(aux2.dados.data.equals(procura))
            {
                aux1.prox = aux2.prox;
                aux2.prox = null;
                return aux2.dados;
            }
            aux1 = aux1.prox;
            aux2 = aux2.prox;
        }
        return null;
    }

    public Cotacao busca(String procura)
    {
        if(listaVazia())
        {
            return null;
        }
        ElementoCotacao aux = sentinela.prox;
        while(aux != null)
        {
            if(aux.dados.data.equals(procura))
            {
                Cotacao dados = aux.dados;
                return dados;
            }
            aux = aux.prox;
        }
        System.out.println("DADOS NÃO ENCONTRADOS");
        return null;
    }

    public String imprimir()
    {
        ElementoCotacao aux = sentinela.prox;
        StringBuilder dados = new StringBuilder();
        if(listaVazia())
        {
            return "";
        }
        while(aux != null)
        {
            dados.append("CÓDIGO: " + aux.dados.codigo +  " | DATA: " + aux.dados.data + " | VALOR: " + aux.dados.valor +"\n");
            aux = aux.prox;
        }
        return dados.toString();
    }
}
