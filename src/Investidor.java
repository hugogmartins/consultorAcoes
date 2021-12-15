import java.text.ParseException;

public class Investidor {
    String cpf;
    String nome;
    String login;
    String senha;
    ListaDinamicaCompra compras;

    public Investidor(String linha)
    {
        String[] linhaTratada = linha.split(";");
        cpf = linhaTratada[0];
        nome = linhaTratada[1];
        login = linhaTratada[2];
        senha = linhaTratada[3];
        compras = new ListaDinamicaCompra();
    }

    public double saldo(ListaDinamicaAcoes dadosAcoes) throws ParseException
    {
        ElementoCompra auxCompra = this.compras.sentinela.proximo;
        Double saldo = 0d;
        while(auxCompra != null)
        {
            Acoes buscaAcao = dadosAcoes.buscar(auxCompra.dados.codigo);
            if(buscaAcao != null)
            {
                Cotacao buscaCotacao = buscaAcao.cotacoes.busca(auxCompra.dados.data);
                if(buscaCotacao != null)
                {
                    saldo -= auxCompra.dados.qtde * buscaCotacao.valor;
                    saldo += auxCompra.dados.qtde * buscaAcao.ultima().valor;
                }
            }
            auxCompra = auxCompra.proximo;
        }
        return saldo;
    }

    public boolean ehMenor(Investidor outro)
    {
        return (Long.parseLong(cpf.replace("-", "")) < Long.parseLong(outro.cpf.replace("-", "")));
    }

    public boolean ehIgual(Investidor outro)
    {
        return (cpf.replace("-", "").equals(outro.cpf.replace("-", "")));
    }

    public void imprimir()
    {
        System.out.println("NOME: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("LOGIN: " + this.login);
        System.out.println("SENHA: " + this.senha);
    }
}
