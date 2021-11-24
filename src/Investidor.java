import java.util.Scanner;

public class Investidor {
    long cpf;
    String nome;
    String login;
    String senha;
    ListaDinamica compras;

    public Investidor(String linha)
    {
        String[] linhaTratada = linha.split(";");
        cpf = Long.parseLong(linhaTratada[0].replace("-", ""));
        nome = linhaTratada[1];
        login = linhaTratada[2];
        senha = linhaTratada[3];
        compras = new ListaDinamica();
    }

    public boolean ehMenor(Investidor outro)
    {
        return (cpf < outro.cpf);
    }

    public boolean ehIgual(Investidor outro)
    {
        return (cpf == outro.cpf);
    }

    public void imprimir()
    {
        Scanner sc = new Scanner(System.in);
        int escolha;
        System.out.println("Nome: " + this.nome + "\nCPF: " + this.cpf + "\nLogin: " + this.login + "\nSenha: " + this.senha);
        System.out.println("--------------------------");
        System.out.println("IMPRIMIR COMPRAS?");
        System.out.println("1.Sim");
        System.out.println("1.Não");
        escolha = Integer.parseInt(sc.nextLine());
        switch(escolha)
        {
            case 1:
            System.out.println(this.compras.imprimir());
            case 2:
            break;
            default:
            System.out.println("ESCOLHA NÃO ENCONTRADA");
        }
        sc.close();
    }
}
