public class FilaDinamica {
    
    public Elemento primeiro, ultimo;

    public FilaDinamica()
    {
        primeiro = new Elemento(null);
        ultimo = primeiro;
    }

    public boolean filaVazia()
    {
        return (primeiro == ultimo);
    }

    public void enfileirar(Cotacao qual)
    {
        Elemento novo = new Elemento(qual);
        ultimo.prox = novo;
        ultimo = novo;
    }

    public Cotacao desenfileirar()
    {
        if(filaVazia())
        {
            return null;
        }
        Elemento aux = primeiro.prox;
        primeiro.prox = aux.prox;
        aux.prox = null;
        if(aux == ultimo)
        {
            ultimo = primeiro;
        }
        return aux.dados;
    }

    public String imprimir()
    {
        if(filaVazia())
        {
            return "Fila Vazia";
        }
        StringBuilder sb = new StringBuilder("FILA: \n");
        Elemento aux = primeiro.prox;
        while(aux != null)
        {
            sb.append(aux.dados.id + " : " + aux.dados.data + " - R$" + aux.dados.valor +"\n");
            aux = aux.prox;
        }
        sb.append("====================");
        return sb.toString();
    }
}