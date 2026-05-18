package Sistema_De_Controle_De_Biblioteca_Escolar.Entities;

import java.time.LocalDate;

public class Emprestimos {
    private Aluno aluno;
    private Livros livro;
    private boolean devolvido;


    public Emprestimos(Aluno aluno, Livros livro) {


        if (aluno == null || livro == null) {
            throw new IllegalArgumentException("Erro: Aluno ou Livro inválidos para empréstimo.");
        }


        if (!validarEmprestimo(aluno, livro)) {
            throw new IllegalStateException("Não foi possível realizar o empréstimo.");
        }

        this.aluno = aluno;
        this.livro = livro;
        this.devolvido = false; // Começa como não devolvido


        int estoqueAtual = livro.getQuantidadeLivro();
        livro.setQuantidadeLivro(estoqueAtual - 1);

        System.out.println("Empréstimo realizado com sucesso para " + aluno.getNomeAluno());
    }


    private boolean validarEmprestimo(Aluno aluno, Livros livro) {


        if (aluno.verificadorMultasAluno()) {
            System.out.println("Erro: O aluno " + aluno.getNomeAluno() + " possui multas pendentes.");
            return false;
        }


        if (livro.getQuantidadeLivro() <= 0) {
            System.out.println("Erro: O livro '" + livro.getNomeLivro() + "' está esgotado no momento.");
            return false;
        }

        return true;
    }


    public void registrarDevolucao() {
        if (this.devolvido) {
            System.out.println("Este livro já foi devolvido anteriormente.");
            return;
        }

        this.devolvido = true;


        int estoqueAtual = livro.getQuantidadeLivro();
        livro.setQuantidadeLivro(estoqueAtual + 1);

        System.out.println("Devolução do livro '" + livro.getNomeLivro() + "' registrada com sucesso!");
    }

    // Getters para relatórios do sistema
    public Aluno getAluno() {
        return aluno;
    }
    public Livros getLivro() {
        return livro;
    }
    public boolean isDevolvido() {
        return devolvido;
    }
}
