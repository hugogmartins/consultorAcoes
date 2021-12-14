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

    public static Cotacao[] vetorizar(ListaDinamicaCotacoes dados){
        ElementoCotacao aux = dados.sentinela.prox;
        int contador = 0;
        while(aux != null){
            contador++;
            aux = aux.prox;
        }
        Cotacao[] vetorAux = new Cotacao[contador];
        aux = dados.sentinela.prox;
        while(aux != null){
            vetorAux[contador - 1] = aux.dados;
            aux = aux.prox;
            contador--;
        }
        vetorAux = insercao(vetorAux);
        return vetorAux;
    }

    public static Cotacao[] insercao(Cotacao[] dados){
        Cotacao[] dadosOrd = dados.clone();
        int tamanho = dadosOrd.length;
        for(int i = 1; i < tamanho; i++){
            Cotacao referencia = dadosOrd[i];
            int pos = i - 1;
            while(pos >= 0 && referencia.valor < dadosOrd[pos].valor){
                pos--;
            }
            for(int j = i; j > (pos + 1); j--){
                dadosOrd[j] = dadosOrd[j-1];
            }
            dadosOrd[pos+1] = referencia;
        }
        return dadosOrd;
    }

    public void top10(){
        Cotacao[] dados = vetorizar(this.cotacoes);
        int aux;
        if(dados.length < 10){
            aux = dados.length;
        }
        else{
            aux = 10;
        }
        for(int i = 0; i < aux; i++){
            System.out.println("TOP " + (i+1) + ": ");
            dados[dados.length - 1 - i].imprimir();
            System.out.println("\n");
        }
    }
}
