import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        FilaDinamica conjuntoCotacoes = lerDadosParaFilaDinamica("Cotacoes.txt");
        ListaDinamica conjuntoCompras = lerDadosParaListaDinamica("CompraAcoes_1.txt");
        ABB conjuntoInvestidores = lerDadosParaArvoreBinaria("Investidores_2021-2.txt");
        insercaoComprasInvestidores(conjuntoCompras, conjuntoInvestidores);

        Scanner teclado = new Scanner(System.in);

        int opcao;
        do
        {
            opcao = menu(teclado);
            switch(opcao)
            {
                case 1:
                limparTela();
                System.out.println("ACRESCENTAR COTAÇÃO");
                String id, data;
                double valor;
                System.out.print("ID: ");
                id = teclado.nextLine();
                System.out.print("Data: ");
                data = teclado.nextLine();
                System.out.print("Valor: ");
                valor = Double.parseDouble(teclado.nextLine());
                String linhaCotacao = id + ";" + data + ";" + valor;
                Cotacao novaCotacao = new Cotacao(linhaCotacao);
                conjuntoCotacoes.enfileirar(novaCotacao);
                break;

                case 2:
                limparTela();
                System.out.println("ACRESCENTAR COMPRA");
                String token, codigo, dataCompra;
                String valorCompra;
                System.out.println("TOKEN: ");
                token = teclado.nextLine();
                System.out.println("CODIGO: ");
                codigo = teclado.nextLine();
                System.out.println("DATA: ");
                dataCompra = teclado.nextLine();
                System.out.println("VALOR: ");
                valorCompra = teclado.nextLine();
                String linhaCompra = token + ";" + codigo + ";" + dataCompra + ";" + valorCompra;
                Compra novaCompra = new Compra(linhaCompra);
                conjuntoCompras.inserir(novaCompra);
                break;

                case 3:
                limparTela();
                System.out.println(conjuntoCotacoes.imprimir());
                break;

                case 4:
                limparTela();
                System.out.println(conjuntoCompras.imprimir());
                break;

                case 5:
                limparTela();
                System.out.println(conjuntoInvestidores.impressao(conjuntoInvestidores));

                case 6:
                limparTela();
                System.out.println(conjuntoInvestidores.impressaoInvestidorCompras(conjuntoInvestidores));
                break;
                
                case 7:
                limparTela();
                opcao = 0;
                break;
            }
        }while(opcao != 0);
    }

    public static void limparTela()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    static FilaDinamica lerDadosParaFilaDinamica(String caminho) throws FileNotFoundException
    {
        File arqDados = new File(caminho);
        Scanner leitor = new Scanner(arqDados);
        
        FilaDinamica conjuntoCotacoes = new FilaDinamica();

        while(leitor.hasNextLine())
        {
            String linha = leitor.nextLine();
            Cotacao qual = new Cotacao(linha);
            conjuntoCotacoes.enfileirar(qual);
        }
        leitor.close();
        return conjuntoCotacoes;
    }

    static ListaDinamica lerDadosParaListaDinamica(String caminho) throws FileNotFoundException
    {
        File dados = new File(caminho);
        Scanner leitor = new Scanner(dados);
        
        ListaDinamica conjuntoCompras = new ListaDinamica();

        while(leitor.hasNextLine())
        {
            String linha = leitor.nextLine();
            Compra qual = new Compra(linha);
            conjuntoCompras.inserir(qual);
        }

        leitor.close();
        return conjuntoCompras;
    }

    static ABB lerDadosParaArvoreBinaria(String caminho) throws FileNotFoundException
    {
        File dados = new File(caminho);
        Scanner leitor = new Scanner(dados);
        Investidor novo = new Investidor(leitor.nextLine());

        ABB arvore = new ABB(novo);

        while(leitor.hasNextLine())
        {
            novo = new Investidor(leitor.nextLine());
            arvore.inserir(novo, arvore);
        }

        leitor.close();
        return arvore;
    }

    static void insercaoComprasInvestidores(ListaDinamica comprasGerais, ABB investidores)
    {
        ElementoCompra auxCompra = comprasGerais.sentinela.proximo;
        Investidor busca = new Investidor(auxCompra.dados.cpf + ";Mock;0;0");
        Investidor auxInvestidor;
        while(auxCompra != null)
        {
            busca.cpf = auxCompra.dados.cpf;
            auxInvestidor = investidores.buscar(busca, investidores);
            if(auxInvestidor != null){
                auxInvestidor.compras.inserir(auxCompra.dados);
            }
            auxCompra = auxCompra.proximo;
        }
    }

    public static int menu(Scanner teclado)
    {
        System.out.println("1 - Adicionar cotação");
        System.out.println("2 - Adicionar compra");
        System.out.println("3 - Imprimir cotações");
        System.out.println("4 - Imprimir compras");
        System.out.println("5 - Imprimir investidores");
        System.out.println("6 - Imprimir listas de compras dos investidores");
        System.out.println("7 - Sair");
        int resposta = Integer.parseInt(teclado.nextLine());
        return resposta;
    }
}