public class ListaDinamicaAcoes {
    ElementoAcoes sentinela, ultimo;

    public ListaDinamicaAcoes()
    {
        sentinela = new ElementoAcoes(null);
        ultimo = sentinela;
    }

    public boolean listaVazia()
    {
        return (sentinela == ultimo);
    }

    public void inserir(Acoes qual)
    {
        ElementoAcoes nova = new ElementoAcoes(qual);
        ultimo.proximo = nova;
        ultimo = nova;
    }

    public Acoes remover(String procura)
    {
        if(listaVazia())
        {
            return null;
        }
        ElementoAcoes aux1 = sentinela;
        ElementoAcoes aux2 = sentinela.proximo;
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

    public Acoes buscar(String procura)
    {
        if(listaVazia())
        {
            return null;
        }
        ElementoAcoes aux = sentinela.proximo;
        while(aux != null)
        {
            if(aux.dados.codigo.equals(procura))
            {
                Acoes dados = aux.dados;
                return dados;
            }
            aux = aux.proximo;
        }
        return null;
    }

    public String imprimir()
    {
        ElementoAcoes aux = sentinela.proximo;
        StringBuilder dados = new StringBuilder();
        if(listaVazia())
        {
            return "";
        }
        while(aux != null)
        {
            dados.append("CÓDIGO: " + aux.dados.codigo +  " | NOME: " + aux.dados.nome +"\n");
            aux = aux.proximo;
        }
        dados.append("========================");
        return dados.toString();
    }

    public String imprimirCotacoes()
    {
        ElementoAcoes aux = sentinela.proximo;
        StringBuilder dados = new StringBuilder();
        if(listaVazia())
        {
            return "";
        }
        while(aux != null)
        {
            dados.append("CÓDIGO: " + aux.dados.codigo +  " | NOME: " + aux.dados.nome +"\n");
            dados.append(aux.dados.cotacoes.imprimir() + "\n");
            aux = aux.proximo;
        }
        dados.append("========================");
        return dados.toString();
    }
}
