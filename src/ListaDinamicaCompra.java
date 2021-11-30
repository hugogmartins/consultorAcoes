public class ListaDinamicaCompra {
    ElementoCompra sentinela, ultimo;

    public ListaDinamicaCompra()
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
            if(aux2.dados.codigo.equals(procura))
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

    public Compra buscar(String procura)
    {
        if(listaVazia())
        {
            return null;
        }
        ElementoCompra aux = sentinela.proximo;
        while(aux != null)
        {
            if(aux.dados.codigo.equals(procura))
            {
                Compra dados = aux.dados;
                return dados;
            }
            aux = aux.proximo;
        }
        System.out.println("DADOS NÃO ENCONTRADOS");
        return null;
    }

    public String imprimir()
    {
        ElementoCompra aux = sentinela.proximo;
        StringBuilder dados = new StringBuilder();
        if(listaVazia())
        {
            return "";
        }
        while(aux != null)
        {
            dados.append("CÓDIGO: " + aux.dados.codigo +  " | DATA: " + aux.dados.data + " | QUANTIDADE: " + aux.dados.qtde +"\n");
            aux = aux.proximo;
        }
        dados.append("========================");
        return dados.toString();
    }
}
