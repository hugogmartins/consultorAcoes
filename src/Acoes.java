import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Acoes {
    String codigo;
    String nome;
    ListaDinamicaCotacoes cotacoes;

    public Acoes(String linha)
    {
        String[] linhaTratada = linha.split(";");
        codigo = linhaTratada[0];
        nome = linhaTratada[1];
        cotacoes = new ListaDinamicaCotacoes();
    }

    public void imprimir() throws ParseException
    {
        System.out.println("CODIGO: " + this.codigo);
        System.out.println("NOME: " + this.nome);
        System.out.println("ULTIMA COTACAO: " + this.ultima().data + "   R$" + this.ultima().valor);
    }

    public Cotacao ultima() throws ParseException
    {
        ElementoCotacao aux = this.cotacoes.sentinela.prox;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data1 = sdf.parse(aux.dados.data);
        Cotacao ultima = aux.dados;
        while(aux.prox != null)
        {
            Date data2 = sdf.parse(aux.prox.dados.data);
            if(data1.compareTo(data2) < 0)
            {
                data1 = data2;
                ultima = aux.prox.dados;
            }
            aux = aux.prox;
        }
        return ultima;
    }
}
