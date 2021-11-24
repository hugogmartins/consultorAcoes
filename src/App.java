import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        FilaDinamica conjuntoCotacoes = lerDadosParaFilaDinamica("Cotacoes.txt");
        ABB conjuntoInvestidores = lerDadosParaArvoreBinaria("Investidores_2021-2.txt");
        lerDadosComprasListaInvestidores("CompraAcoes_1.txt", conjuntoInvestidores);

        Scanner teclado = new Scanner(System.in);
        int opcao;

        do
        {
            opcao = menu(teclado);
            String auxiliar = "";
            Investidor auxiliarInvestidor;
            Cotacao auxiliarCotacao;
            Compra auxiliarCompra;
            ABB auxiliarABB;
            switch(opcao)
            {
                case 1:
                opcao = submenu(teclado);
                while(opcao != -1)
                {
                    limparTela();

                    switch(opcao)
                    {
                        case 1:
                        System.out.print("DIGITE O NOME: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.print("DIGITE O CPF: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.print("DIGITE O LOGIN: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.print("DIGITE A SENHA: ");
                        auxiliar += teclado.nextLine();
                        auxiliarInvestidor = new Investidor(auxiliar);
                        conjuntoInvestidores.inserir(auxiliarInvestidor, conjuntoInvestidores);
                        break;

                        case 2:
                        System.out.println("DIGITE O IDENTIFICADOR: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE A DATA: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE O VALOR: ");
                        auxiliar += teclado.nextLine();
                        auxiliarCotacao = new Cotacao(auxiliar);
                        conjuntoCotacoes.enfileirar(auxiliarCotacao);
                        break;

                        case 3:
                        System.out.println("DIGITE O CÓDIGO: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE O CPF: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE O DATA: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE A QUANTIDADE: ");
                        auxiliar += teclado.nextLine();
                        auxiliarCompra = new Compra(auxiliar);
                        auxiliarInvestidor = conjuntoInvestidores.buscar(new Investidor(auxiliarCompra.cpf + ";Mock;0;0"), conjuntoInvestidores);
                        if(auxiliarInvestidor != null)
                        {
                            auxiliarInvestidor.compras.inserir(auxiliarCompra);
                        }
                        else
                        {
                            System.out.println("INVESTIDOR NÃO CADASTRADO");
                        }
                        break;

                        case 4:
                        opcao = -1;
                        break;

                        default:
                        System.out.println("OPCAO INCORRETA");
                        System.out.println("\nAPERTE ENTER PARA CONTINUAR");
                        teclado.nextLine();
                        break;
                    }
                }
                break;

                case 2:
                opcao = submenu(teclado);
                while(opcao != -1)
                {
                    limparTela();
                    switch(opcao)
                    {
                        case 1:
                        System.out.println("DIGITE O CPF DO INVESTIDOR A SER REMOVIDO: ");
                        auxiliar = teclado.nextLine();
                        auxiliarInvestidor = new Investidor(auxiliar + ";Mock;0;0");
                        auxiliarABB = conjuntoInvestidores.retirar(auxiliarInvestidor, conjuntoInvestidores);
                        if(auxiliarABB != null)
                        {
                            auxiliarABB.raiz.dados.imprimir();
                        }
                        System.out.println("ENTER PARA CONTINUAR");
                        teclado.nextLine();
                        break;

                        case 2:
                        System.out.println("A COTAÇÃO ESTÁ ORGANIZADA EM FILA");
                        System.out.println("DESEJA REMOVER O PRIMEIRO ELEMENTO INSERIDO? ");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        opcao = Integer.parseInt(teclado.nextLine());
                        if(opcao == 1)
                        {
                            auxiliarCotacao = conjuntoCotacoes.desenfileirar();
                            auxiliarCotacao.imprimir();
                            System.out.println("COTAÇÃO REMOVIDA COM SUCESSO");
                            teclado.nextLine();
                        }
                        break;

                        case 3:
                        System.out.println("DIGITE O CPF VINCULADO A COMPRA A SER REMOVIDA: ");
                        auxiliar = teclado.nextLine();
                        auxiliarInvestidor = conjuntoInvestidores.buscar(new Investidor(auxiliar + ";Mock;0;0"), conjuntoInvestidores);
                        if(auxiliarInvestidor != null)
                        {
                            System.out.println("DIGITE O CODIGO VINCULADO AO INESTIDOR A SER REMOVIDA: ");
                            auxiliar = teclado.nextLine();
                            auxiliarCompra = auxiliarInvestidor.compras.remover(auxiliar);
                            if(auxiliarCompra != null)
                            {
                                auxiliarCompra.imprimir();
                                System.out.println("COMPRA REMOVIDA COM SUCESSO");
                            }
                            else
                            {
                                System.out.println("COMPRA NÃO CADASTRADA");
                            }
                        }
                        else
                        {
                            System.out.println("INVESTIDOR NÃO CADASTRADO");
                        }
                        System.out.println("ENTER PARA CONTINUAR");
                        teclado.nextLine();
                        break;

                        case 4:
                        opcao = -1;
                        break;

                        default:
                        System.out.println("OPCAO INCORRETA");
                        System.out.println("\nENTER PARA CONTINUAR");
                        teclado.nextLine();
                        break;
                    }
                }

                break;

                case 3:
                opcao = submenu(teclado);
                limparTela();
                switch(opcao)
                {
                    case 1:
                    System.out.println("DIGITE O CPF DO INVESTIDOR A SER BUSCADO: ");
                    auxiliar = teclado.nextLine();
                    auxiliarInvestidor = new Investidor(auxiliar + ";Mock;0;0");
                    auxiliarInvestidor = conjuntoInvestidores.buscar(auxiliarInvestidor, conjuntoInvestidores);
                    if(auxiliarInvestidor != null)
                    {
                        auxiliarInvestidor.imprimir();
                    }
                    System.out.println("ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    break;

                    case 2:
                    System.out.println("DIGITE O IDENTIFICADOR DA COTAÇÃO A SER BUSCADA: ");
                    auxiliar = teclado.nextLine();
                    auxiliarCotacao = conjuntoCotacoes.buscar(auxiliar);
                    if(auxiliarCotacao != null)
                    {
                        auxiliarCotacao.imprimir();
                    }
                    System.out.println("ENTER PARA CONTINUAR");
                    break;

                    case 3:
                    System.out.println("DIGITE O CPF VINCULADO A COMPRA A SER BUSCADO: ");
                    auxiliar = teclado.nextLine();
                    auxiliarInvestidor = conjuntoInvestidores.buscar(new Investidor(auxiliar + ";Mock;0;0"), conjuntoInvestidores);
                    if(auxiliarInvestidor != null)
                    {
                        System.out.println("DIGITE O CODIGO VINCULADO AO INESTIDOR A SER BUSCADO: ");
                        auxiliar = teclado.nextLine();
                        auxiliarCompra = auxiliarInvestidor.compras.buscar(auxiliar);
                        if(auxiliarCompra != null)
                        {
                            auxiliarCompra.imprimir();
                        }
                        else
                        {
                            System.out.println("COMPRA NÃO CADASTRADA");
                        }
                    }
                    else
                    {
                        System.out.println("INVESTIDOR NÃO CADASTRADO");
                    }
                    System.out.println("ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    break;

                    case 4:
                    opcao = -1;
                    break;

                    default:
                    System.out.println("OPCAO INCORRETA");
                    System.out.println("\nAPERTE ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    break;
                }
                break;

                case 4:
                opcao = submenu(teclado);
                limparTela();
                switch(opcao)
                {
                    case 1:
                    System.out.println(conjuntoInvestidores.impressao(conjuntoInvestidores));
                    System.out.println("\nAPERTE ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    break;

                    case 2:
                    System.out.println(conjuntoCotacoes.imprimir());
                    System.out.println("\nAPERTE ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    break;

                    case 3:
                    System.out.println(conjuntoInvestidores.impressaoInvestidorCompras(conjuntoInvestidores));
                    System.out.println("\nAPERTE ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    break;

                    case 4:
                    opcao = -1;
                    break;

                    default:
                    System.out.println("OPCAO INCORRETA");
                    System.out.println("\nAPERTE ENTER PARA CONTINUAR");
                    teclado.nextLine();
                    break;
                }
                break;

                case 5:
                opcao = 0;
                break;

                default:
                System.out.println("OPCAO INCORRETA");
                System.out.println("\nENTER PARA CONTINUAR");
                teclado.nextLine();
                break;

            }
        }while(opcao != 0);
        teclado.close();
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

    static void lerDadosComprasListaInvestidores(String caminho, ABB arvore) throws FileNotFoundException
    {
        File dados = new File(caminho);
        Scanner leitor = new Scanner(dados);
        while(leitor.hasNextLine())
        {
            String linha = leitor.nextLine();
            Compra qual = new Compra(linha);
            Investidor busca = arvore.buscar(new Investidor(qual.cpf + ";Mock;0;0"), arvore);
            if(busca != null)
            {
                busca.compras.inserir(qual);
            }
        }
        leitor.close();
    }

    public static int menu(Scanner teclado)
    {
        limparTela();
        System.out.println("1 - Adicionar");
        System.out.println("2 - Remover");
        System.out.println("3 - Buscar");
        System.out.println("4 - Imprimir Estrutura de Dados");
        System.out.println("5 - Sair");
        int resposta = Integer.parseInt(teclado.nextLine());
        return resposta;
    }

    public static int submenu(Scanner teclado)
    {
        limparTela();
        System.out.println("1 - Investidor");
        System.out.println("2 - Cotação");
        System.out.println("3 - Compra");
        System.out.println("4 - Sair");
        int resposta = Integer.parseInt(teclado.nextLine());
        return resposta;
    }
}