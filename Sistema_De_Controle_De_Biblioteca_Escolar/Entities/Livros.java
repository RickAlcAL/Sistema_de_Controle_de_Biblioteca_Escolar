package Sistema_De_Controle_De_Biblioteca_Escolar.Entities;

public class Livros {
    private String ISBN;
    private String nomeLivro;
    private int quantidadeLivro;

    public Livros (String ISBN, String nomeLivro, int quantidadeLivro) { //Construtor para recebimeno dos dados
        this.ISBN = ISBN;
        this.nomeLivro = nomeLivro;
        this.quantidadeLivro = quantidadeLivro;

        if (!verificadorEstoqueLivro()) {
            throw new IllegalArgumentException("Não foi possível registrar o livro: dados inválidos.");
        }
    }

    public boolean verificadorEstoqueLivro () {

        if (ISBN == null || !ISBN.matches("\\d{8}")) {
            System.out.println("Erro: O ISBN deve conter exatamente 8 números e nenhuma letra.");
            return false;
        }
        if (ISBN.length() != 8) {
            System.out.println("Erro: O ISBN deve ter exatamente 8 caracteres.");
            return false;
        }

        for (int i = 0; i < ISBN.length(); i++) {
            if (!Character.isDigit(ISBN.charAt(i))) {
                System.out.println("Erro: O ISBN deve conter apenas números (letras ou símbolos detectados).");
                return false;
            }
        }
        if (ISBN.trim().isEmpty()) {
            System.out.println("Erro: ISBN não encontrado ou inválido.");
            return false;
        }

        if (nomeLivro == null || nomeLivro.trim().isEmpty()){
            System.out.println("Erro: Nome do livro não existe ou está inválido.");
            return false;
        }

        if (quantidadeLivro < 0) {
            System.out.println("Erro: A quantidade no estoque não pode ser negativa.");
            return false;
        }

        return true;
    }

    //Getters para relatorios
    public String getISBN() {
        return ISBN;
    }
    public String getNomeLivro() {
        return nomeLivro;
    }
    public int getQuantidadeLivro() {
        return quantidadeLivro;
    }

    public void setQuantidadeLivro(int quantidadeLivro) {
        if (quantidadeLivro >= 0) {
            this.quantidadeLivro = quantidadeLivro;
        }
    }
}