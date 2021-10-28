public class Investidor {
    long cpf;
    String nome;
    String login;
    String senha;

    public Investidor(String linha)
    {
        String[] linhaTratada = linha.split(";");
        cpf = Long.parseLong(linhaTratada[0].replace("-", ""));
        nome = linhaTratada[1];
        login = linhaTratada[2];
        senha = linhaTratada[3];
    }

    public boolean ehMenor(Investidor outro)
    {
        return (cpf < outro.cpf);
    }

    public boolean ehIgual(Investidor outro)
    {
        return (cpf == outro.cpf);
    }
}
