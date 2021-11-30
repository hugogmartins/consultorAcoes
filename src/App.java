import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ListaDinamicaAcoes conjuntoAcoes = lerDadosParaListaAcoes("acoes.txt");
        ABB conjuntoInvestidores = lerDadosParaArvoreBinaria("Investidores_2021-2.txt");
        lerDadosComprasListaInvestidores("CompraAcoes_1.txt", conjuntoInvestidores);
        lerDadosCotacoesListaAcoes("Cotacoes.txt", conjuntoAcoes);

        Scanner teclado = new Scanner(System.in);
        int opcao;

        do
        {
            opcao = menu(teclado);
            String auxiliar = "";
            Investidor auxiliarInvestidor;
            Compra auxiliarCompra;
            Cotacao auxiliarCotacao;
            Acoes auxiliarAcao;
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
                        System.out.print("DIGITE O CPF: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.print("DIGITE O NOME: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.print("DIGITE O LOGIN: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.print("DIGITE A SENHA: ");
                        auxiliar += teclado.nextLine();
                        auxiliarInvestidor = new Investidor(auxiliar);
                        conjuntoInvestidores.inserir(auxiliarInvestidor, conjuntoInvestidores);
                        System.out.println("INVESTIDOR CADASTRADO");
                        pausa(teclado);
                        opcao = -1;
                        break;

                        case 2:
                        System.out.println("DIGITE O CODIGO: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE A DATA: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE O VALOR: ");
                        auxiliar += teclado.nextLine();
                        auxiliarCotacao = new Cotacao(auxiliar);
                        auxiliarAcao = conjuntoAcoes.buscar(auxiliarCotacao.codigo);
                        if(auxiliarAcao != null)
                        {
                            auxiliarAcao.cotacoes.inserir(auxiliarCotacao);
                            System.out.println("COTACAO CADASTRADA");
                        }
                        else
                        {
                            System.out.println("ACAO NAO CADASTRADA");
                        }
                        pausa(teclado);
                        opcao = -1;
                        break;

                        case 3:
                        System.out.println("DIGITE O CÓDIGO: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE O CPF: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE A DATA: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.println("DIGITE A QUANTIDADE: ");
                        auxiliar += teclado.nextLine();
                        auxiliarCompra = new Compra(auxiliar);
                        auxiliarInvestidor = conjuntoInvestidores.buscar(new Investidor(auxiliarCompra.cpf + ";Mock;0;0"), conjuntoInvestidores);
                        if(auxiliarInvestidor != null)
                        {
                            auxiliarInvestidor.compras.inserir(auxiliarCompra);
                            System.out.println("COMPRA CADASTRADA");
                        }
                        else
                        {
                            System.out.println("INVESTIDOR NÃO CADASTRADO");
                        }
                        pausa(teclado);
                        opcao = -1;
                        break;

                        case 4:
                        System.out.print("DIGITE O CODIGO: ");
                        auxiliar += teclado.nextLine() + ";";
                        System.out.print("DIGITE O NOME: ");
                        auxiliar += teclado.nextLine();
                        auxiliarAcao = new Acoes(auxiliar);
                        conjuntoAcoes.inserir(auxiliarAcao);
                        System.out.println("ACAO CADASTRADA");
                        pausa(teclado);
                        opcao = -1;
                        break;

                        case 5:
                        opcao = -1;
                        break;

                        default:
                        System.out.println("OPCAO INCORRETA");
                        pausa(teclado);
                        opcao = -1;
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
                        auxiliarInvestidor = conjuntoInvestidores.buscar(auxiliarInvestidor, conjuntoInvestidores);
                        
                        if(auxiliarInvestidor != null)
                        {
                            conjuntoInvestidores.retirar(auxiliarInvestidor, conjuntoInvestidores);
                            System.out.println("INVESTIDOR REMOVIDO");
                            auxiliarInvestidor.imprimir();
                        }
                        else
                        {
                            System.out.println("INVESTIDOR NAO CADASTRADO");
                        }
                        pausa(teclado);
                        opcao = -1;
                        break;

                        case 2:
                        System.out.println("DIGITE O CODIGO VINCULADO A COTACAO A SER REMOVIDA: ");
                        auxiliar = teclado.nextLine();
                        auxiliarAcao = conjuntoAcoes.buscar(auxiliar);
                        if(auxiliarAcao != null)
                        {
                            System.out.println("DIGITE A DATA VINCULADO A COTACAO A SER REMOVIDA: ");
                            auxiliar = teclado.nextLine();
                            auxiliarCotacao = auxiliarAcao.cotacoes.remover(auxiliar);
                            if(auxiliarCotacao != null)
                            {
                                auxiliarCotacao.imprimir();
                                System.out.println("COTACAO REMOVIDA");
                            }
                            else
                            {
                                System.out.println("COTACAO NAO CADASTRADA");
                            }
                        }
                        else
                        {
                            System.out.println("ACAO NAO CADASTRADA");
                        }
                        pausa(teclado);
                        opcao = -1;
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
                                System.out.println("COMPRA REMOVIDA");
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
                        pausa(teclado);
                        opcao = -1;
                        break;

                        case 4:
                        System.out.println("DIGITE O CODIGO DA ACAO A SER REMOVIDA: ");
                        auxiliar = teclado.nextLine();
                        auxiliarAcao = conjuntoAcoes.remover(auxiliar);
                        if(auxiliarAcao != null)
                        {
                            System.out.println("ACAO REMOVIDA");
                            auxiliarAcao.imprimir();
                        }
                        else
                        {
                            System.out.println("ACAO NAO CADASTRADA");
                        }
                        pausa(teclado);
                        opcao = -1;
                        break;

                        case 5:
                        opcao = -1;
                        break;

                        default:
                        System.out.println("OPCAO INCORRETA");
                        pausa(teclado);
                        opcao = 1;
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
                    pausa(teclado);
                    opcao = -1;
                    break;

                    case 2:
                    System.out.println("DIGITE O CODIGO VINCULADO A COTACAO A SER BUSCADA: ");
                    auxiliar = teclado.nextLine();
                    auxiliarAcao = conjuntoAcoes.buscar(auxiliar);
                    if(auxiliarAcao != null)
                    {
                        System.out.println("DIGITE A DATA VINCULADO A COTACAO A SER BUSCADA: ");
                        auxiliar = teclado.nextLine();
                        auxiliarCotacao = auxiliarAcao.cotacoes.busca(auxiliar);
                        if(auxiliarCotacao != null)
                        {
                            auxiliarCotacao.imprimir();
                        }
                        else
                        {
                            System.out.println("COTACAO NAO CADASTRADA");
                        }
                    }
                    else
                    {
                        System.out.println("ACAO NAO CADASTRADA");
                    }
                    pausa(teclado);
                    opcao = -1;
                    break;

                    case 3:
                    System.out.println("DIGITE O CPF VINCULADO A COMPRA A SER BUSCADO: ");
                    auxiliar = teclado.nextLine();
                    auxiliarInvestidor = conjuntoInvestidores.buscar(new Investidor(auxiliar + ";Mock;0;0"), conjuntoInvestidores);
                    if(auxiliarInvestidor != null)
                    {
                        System.out.println("DIGITE O CODIGO VINCULADO AO INVESTIDOR A SER BUSCADO: ");
                        auxiliar = teclado.nextLine();
                        auxiliarCompra = auxiliarInvestidor.compras.buscar(auxiliar);
                        if(auxiliarCompra != null)
                        {
                            auxiliarCompra.imprimir();
                        }
                        else
                        {
                            System.out.println("COMPRA NAO CADASTRADA");
                        }
                    }
                    else
                    {
                        System.out.println("INVESTIDOR NAO CADASTRADO");
                    }
                    pausa(teclado);
                    opcao = -1;
                    break;

                    case 4:
                    System.out.println("DIGITE O CODIGO DA ACAO A SER BUSCADA: ");
                    auxiliar = teclado.nextLine();
                    auxiliarAcao = conjuntoAcoes.buscar(auxiliar);
                    if(auxiliarAcao != null)
                    {
                        auxiliarAcao.imprimir();
                    }
                    else
                    {
                        System.out.println("ACAO NAO CADASTRADA");
                    }
                    pausa(teclado);
                    opcao = -1;
                    break;

                    case 5:
                    opcao = -1;
                    break;

                    default:
                    System.out.println("OPCAO INCORRETA");
                    pausa(teclado);
                    opcao = -1;
                    break;
                }
                break;

                case 4:
                limparTela();
                System.out.println("DIGITE O CPF DO INVESTIDOR A SER CONSULTADO: ");
                auxiliar = teclado.nextLine();
                
                auxiliarInvestidor = conjuntoInvestidores.buscar(new Investidor(auxiliar + ";Mock;0;0"), conjuntoInvestidores);
                System.out.println("NOME: " + auxiliarInvestidor.nome + "\nCPF: " + auxiliarInvestidor.cpf + "\nSALDO: R$" + auxiliarInvestidor.saldo(conjuntoAcoes));
                pausa(teclado);
                break;

                case 5:
                opcao = submenu(teclado);
                limparTela();
                switch(opcao)
                {
                    case 1:
                    System.out.println(conjuntoInvestidores.impressao(conjuntoInvestidores));
                    pausa(teclado);
                    opcao = -1;
                    break;

                    case 2:
                    System.out.println(conjuntoAcoes.imprimirCotacoes());
                    pausa(teclado);
                    opcao = -1;
                    break;

                    case 3:
                    System.out.println(conjuntoInvestidores.impressaoInvestidorCompras(conjuntoInvestidores));
                    pausa(teclado);
                    opcao = -1;
                    break;

                    case 4:
                    System.out.println(conjuntoAcoes.imprimir());
                    pausa(teclado);
                    opcao = -1;
                    break;

                    case 5:
                    opcao = -1;
                    break;

                    default:
                    System.out.println("OPCAO INCORRETA");
                    pausa(teclado);
                    opcao = -1;
                    break;
                }
                break;

                case 6:
                opcao = 0;
                break;

                default:
                System.out.println("OPCAO INCORRETA");
                pausa(teclado);
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

    public static void pausa(Scanner teclado)
    {

        System.out.println("\nENTER PARA CONTINUAR");
        teclado.nextLine();

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
    
    static void lerDadosCotacoesListaAcoes(String caminho, ListaDinamicaAcoes conjuntoAcoes) throws FileNotFoundException
    {
        File arqDados = new File(caminho);
        Scanner leitor = new Scanner(arqDados);
        while(leitor.hasNextLine())
        {
            String linha = leitor.nextLine();
            Cotacao qual = new Cotacao(linha);
            Acoes busca = conjuntoAcoes.buscar(qual.codigo);
            if(busca != null)
            {
                busca.cotacoes.inserir(qual);
            }
        }
        leitor.close();
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

    static ListaDinamicaAcoes lerDadosParaListaAcoes(String caminho) throws FileNotFoundException
    {
        File arq = new File(caminho);
        Scanner leitor = new Scanner(arq);
        ListaDinamicaAcoes conjuntoAcoes = new ListaDinamicaAcoes();
        while(leitor.hasNextLine())
        {
            String linha = leitor.nextLine();
            Acoes nova = new Acoes(linha);
            conjuntoAcoes.inserir(nova);
        }
        leitor.close();
        return conjuntoAcoes;
    }

    public static int menu(Scanner teclado)
    {
        limparTela();
        System.out.println("1 - ADICIONAR");
        System.out.println("2 - REMOVER");
        System.out.println("3 - BUSCAR");
        System.out.println("4 - CONSULTAR SALDO");
        System.out.println("5 - IMPRIMIR ESTRUTURA DE DADOS");
        System.out.println("6 - SAIR");
        int resposta = Integer.parseInt(teclado.nextLine());
        return resposta;
    }

    public static int submenu(Scanner teclado)
    {
        limparTela();
        System.out.println("1 - INVESTIDOR");
        System.out.println("2 - COTACAO");
        System.out.println("3 - COMPRA");
        System.out.println("4 - ACAO");
        System.out.println("5 - SAIR");
        int resposta = Integer.parseInt(teclado.nextLine());
        return resposta;
    }
}