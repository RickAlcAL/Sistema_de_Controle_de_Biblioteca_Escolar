package Sistema_De_Controle_De_Biblioteca_Escolar.Entities;

public class Escola {
    private String nomeDaEscola;
    private String idDaEscola;
    private String localDaEscola;

    public Escola (String nomeDaEscola, String idDaEscola, String localDaEscola){ //Construtor com dados da escola


        if (!verificadorIdEscolar(idDaEscola)) {
            throw new IllegalArgumentException("Não foi possível cadastrar a escola: ID inválido.");
        }


        if (nomeDaEscola == null || nomeDaEscola.trim().isEmpty() ||
                localDaEscola == null || localDaEscola.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e local da escola são obrigatórios.");
        }

        this.nomeDaEscola = nomeDaEscola;
        this.idDaEscola = idDaEscola;
        this.localDaEscola = localDaEscola;
    }

    public boolean verificadorIdEscolar (String idDaEscola) {
        int contadorNumeros = 0;
        int contadorLetras = 0;

        if (idDaEscola == null || idDaEscola.length() != 4) {
            System.out.println("Erro: O ID deve ter exatamente 4 caracteres (ex: AB12)");
            return false;
        }

        for (int i = 0; i < idDaEscola.length(); i++) {
            char c = idDaEscola.charAt(i);

            if (Character.isDigit(c)) {
                contadorNumeros++;
            } else if (Character.isLetter(c)) {
                contadorLetras++;
            } else {
                System.out.println("Erro: Caractere inválido detectado: " + c);
                return false;
            }
        }

        if (contadorLetras == 2 && contadorNumeros == 2) {
            System.out.println("ID escolar verificado com sucesso: " + idDaEscola);
            return true;
        } else {
            System.out.println("Erro: O ID deve conter exatamente 2 letras e 2 números.");
            return false;
        }
    }
    //Geterrs para relatorio
    public String getNomeDaEscola() {
        return nomeDaEscola;
    }
    public String getIdDaEscola() {
        return idDaEscola;
    }
    public String getLocalDaEscola() {
        return localDaEscola;
    }
}