import java.util.Scanner;

public class Investidor {
    long cpf;
    String nome;
    String login;
    String senha;
    ListaDinamicaCompra compras;

    public Investidor(String linha)
    {
        String[] linhaTratada = linha.split(";");
        cpf = Long.parseLong(linhaTratada[0].replace("-", ""));
        nome = linhaTratada[1];
        login = linhaTratada[2];
        senha = linhaTratada[3];
        compras = new ListaDinamicaCompra();
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
        System.out.println("NOME: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("LOGIN: " + this.login);
        System.out.println("SENHA: " + this.senha);
    }
}
