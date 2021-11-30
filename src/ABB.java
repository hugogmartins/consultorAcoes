public class ABB {
    Nodo raiz;
    ABB subarvoreDireita;//maior
    ABB subarvoreEsquerda;//menor

    public ABB(Investidor qual)
    {
        raiz = new Nodo(qual);
        subarvoreDireita = null;
        subarvoreEsquerda = null;
    }

    public ABB inserir(Investidor novo, ABB subarvore)
    {
        if(subarvore == null)//chegou no destino
        {
            ABB novaSubarvore = new ABB(novo);
            return novaSubarvore;
        }

        else
        {
            if(novo.ehMenor(subarvore.raiz.dados))
            {
                subarvore.subarvoreEsquerda = inserir(novo, subarvore.subarvoreEsquerda);
            }
            else
            {
                subarvore.subarvoreDireita = inserir(novo, subarvore.subarvoreDireita);
            }
            return subarvore;
        }
    }

    public Investidor buscar(Investidor quem, ABB subarvore)
    {
        if(subarvore == null)
        {
            return null;
        }

        else
        {
            if(quem.ehIgual(subarvore.raiz.dados))
            {
                return subarvore.raiz.dados;
            }
            else
            {
                if(quem.ehMenor(subarvore.raiz.dados))
                {
                    return buscar(quem, subarvore.subarvoreEsquerda);
                }
                else
                {
                    return buscar(quem, subarvore.subarvoreDireita);
                }
            }
        }
    }

    public int grau()
    {
        if(subarvoreEsquerda == null)
        {
            if(subarvoreDireita == null)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            if(subarvoreDireita == null)
            {
                return -1;
            }
            else
            {
                return 2;
            }
        }
    }

    public ABB antecessor()
    {
        ABB aux = subarvoreEsquerda;
        while(aux.subarvoreDireita  != null)
        {
            aux = aux.subarvoreDireita;
        }
        return aux;
    }

    public ABB retirar(Investidor quem, ABB subarvore)
    {
        if(subarvore == null)
        {
            return null;
        }
        else
        {
            if(quem.ehIgual(subarvore.raiz.dados))
            {
                int grau = subarvore.grau();
                switch(grau)
                {
                    case 0:
                    return null;

                    case -1:
                    return subarvore.subarvoreEsquerda;

                    case 1:
                    return subarvore.subarvoreDireita;

                    case 2:
                    subarvore.raiz = subarvore.antecessor().raiz;
                    subarvore.subarvoreEsquerda = retirar(subarvore.raiz.dados, subarvore.subarvoreEsquerda);
                    return subarvore;

                    default:
                    return null;
                }
            }
            else
            {
                if(quem.ehMenor(subarvore.raiz.dados))
                {
                    subarvore.subarvoreEsquerda = subarvore.retirar(quem, subarvore.subarvoreEsquerda);
                }
                else
                {
                    subarvore.subarvoreDireita = subarvore.retirar(quem, subarvore.subarvoreDireita);
                }
                return subarvore;
            }
        }
    }

    public String impressao(ABB subarvore)
    {
        if(subarvore == null)
        {
            return "";
        }
        else
        {
            String aux = impressao(subarvore.subarvoreEsquerda);
            aux += subarvore.raiz.dados.cpf + " | " + subarvore.raiz.dados.nome + " | " + subarvore.raiz.dados.login + " | " + subarvore.raiz.dados.senha + "\n";
            aux += impressao(subarvore.subarvoreDireita);
            return aux;
        }
    }

    public String impressaoInvestidorCompras(ABB subarvore)
    {
        if(subarvore == null)
        {
            return "";
        }
        else
        {
            String aux = impressaoInvestidorCompras(subarvore.subarvoreEsquerda);
            aux += subarvore.raiz.dados.cpf + " | " + subarvore.raiz.dados.nome + "\n" + subarvore.raiz.dados.compras.imprimir() +
             "\n";
            aux += impressaoInvestidorCompras(subarvore.subarvoreDireita);
            return aux;
        }
    }
}
