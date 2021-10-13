import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        FilaDinamica conjuntoCotacoes = lerDadosParaFilaDinamica("Cotacoes.txt");

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
                System.out.println(conjuntoCotacoes.imprimir());
                break;
                case 3:
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
    public static int menu(Scanner teclado)
    {
        System.out.println("1 - Adicionar Cotação");
        System.out.println("2 - Imprimir");
        System.out.println("3 - Sair");
        int resposta = Integer.parseInt(teclado.nextLine());
        return resposta;
    }
}
