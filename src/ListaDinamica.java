public class ListaDinamica {
    ElementoCompra sentinela, ultimo;

    public ListaDinamica()
    {
        sentinela = new ElementoCompra(null);
        ultimo = sentinela;
    }

    public boolean listaVazia()
    {
        return (sentinela == ultimo);
    }

    public void inserir(Compra qual)
    {
        ElementoCompra nova = new ElementoCompra(qual);
        ultimo.proximo = nova;
        ultimo = nova;
    }

    public Compra remover(String procura)
    {
        if(listaVazia())
        {
            return null;
        }
        ElementoCompra aux1 = sentinela;
        ElementoCompra aux2 = sentinela.proximo;
        while(aux2 != null)
        {
            if(aux2.dados.token == procura)
            {
                aux1.proximo = aux2.proximo;
                aux2.proximo = null;
                return aux2.dados;
            }
            aux1 = aux1.proximo;
            aux2 = aux2.proximo;
        }
        return null;
    }

    public String buscar(String procura)
    {
        if(listaVazia())
        {
            return "Dados inexistente";
        }
        ElementoCompra aux = sentinela.proximo;
        while(aux != null)
        {
            if(aux.dados.token == procura)
            {
                String dados = "CÓDIGO: " + aux.dados.codigo + " | TOKEN: " + aux.dados.token + " | DATA: " + aux.dados.data + " | VALOR: " + aux.dados.valor;
                return dados;
            }
            aux = aux.proximo;
        }
        return "Dados inexistente";
    }

    public String imprimir()
    {
        ElementoCompra aux = sentinela.proximo;
        StringBuilder dados = new StringBuilder();
        if(listaVazia())
        {
            return "========LISTA VAZIA========";
        }
        dados.append("========IMPRESSÃO========\n");
        while(aux != null)
        {
            dados.append("CÓDIGO: " + aux.dados.codigo + " | TOKEN: " + aux.dados.token + " | DATA: " + aux.dados.data + " | VALOR: " + aux.dados.valor +"\n");
            aux = aux.proximo;
        }
        dados.append("========================");
        return dados.toString();
    }
}
