package Sistema_De_Controle_De_Biblioteca_Escolar.Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUsuario {
    //Instanciação dos objetos em ArrayList para manipulação de dados com index
        private ArrayList<Aluno> listaAlunos;
        private ArrayList<Livros> listaLivros;
        private ArrayList<Emprestimos> listaEmprestimos;
        private Escola escolaAtual;
        private Scanner sc;

        //Construtor para receber o total de dados que serão manipulados e verificados em perspectivas classes
        public MenuUsuario(Escola escola, ArrayList<Aluno> alunos, ArrayList<Livros> livros, ArrayList<Emprestimos> emprestimos) {
            this.escolaAtual = escola;
            this.listaAlunos = alunos;
            this.listaLivros = livros;
            this.listaEmprestimos = emprestimos;
            this.sc = new Scanner(System.in);
        }

        public void iniciar() {
            int opcao = -1;

            System.out.println("=================================================");
            System.out.println("  BEM-VINDO AO SISTEMA DA " + escolaAtual.getNomeDaEscola().toUpperCase());
            System.out.println("=================================================");

            while (opcao != 0) {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("1 - Cadastrar Aluno");
                System.out.println("2 - Cadastrar Livro");
                System.out.println("3 - Realizar Empréstimo");
                System.out.println("4 - Registrar Devolução");
                System.out.println("5 - Listar Livros no Estoque");
                System.out.println("0 - Sair do Sistema");
                System.out.print("Escolha uma opção: ");

                try {
                    opcao = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, digite apenas números.");
                    continue;
                }

                switch (opcao) {
                    case 1:
                        cadastrarAluno();
                        break;
                    case 2:
                        cadastrarLivro();
                        break;
                    case 3:
                        realizarEmprestimo();
                        break;
                    case 4:
                        registrarDevolucao();
                        break;
                    case 5:
                        listarEstoque();
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema... Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
            sc.close();
        }

        private void cadastrarAluno() {
            System.out.println("\n--- CADASTRO DE ALUNO ---");
            System.out.print("Nome do Aluno: ");
            String nome = sc.nextLine();
            System.out.print("Matrícula (8 dígitos numéricos): ");
            String matricula = sc.nextLine();
            System.out.print("Idade: ");
            int idade = Integer.parseInt(sc.nextLine());

            try {
                Aluno novoAluno = new Aluno(nome, matricula, idade);
                listaAlunos.add(novoAluno);
                System.out.println("Aluno cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " O cadastro foi cancelado.");
            }
        }

        private void cadastrarLivro() {
            System.out.println("\n--- CADASTRO DE LIVRO ---");
            System.out.print("ISBN do Livro: ");
            String isbn = sc.nextLine();
            System.out.print("Título do Livro: ");
            String titulo = sc.nextLine();
            System.out.print("Quantidade em Estoque: ");
            int qtd = Integer.parseInt(sc.nextLine());

            try {
                Livros novoLivro = new Livros(isbn, titulo, qtd);
                listaLivros.add(novoLivro);
                System.out.println("Livro cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " O cadastro foi cancelado.");
            }
        }

        private void realizarEmprestimo() {
            System.out.println("\n--- NOVO EMPRÉSTIMO ---");
            System.out.print("Digite a matrícula do Aluno: ");
            String matricula = sc.nextLine();

            Aluno alunoEncontrado = null;
            for (Aluno a : listaAlunos) {
                if (a.getMatriculaAluno().equals(matricula)) {
                    alunoEncontrado = a;
                    break;
                }
            }

            if (alunoEncontrado == null) {
                System.out.println("Aluno não encontrado no sistema.");
                return;
            }

            System.out.print("Digite o ISBN do livro desejado: ");
            String isbn = sc.nextLine();

            Livros livroEncontrado = null;
            for (Livros l : listaLivros) {
                if (l.getISBN().equals(isbn)) {
                    livroEncontrado = l;
                    break;
                }
            }

            if (livroEncontrado == null) {
                System.out.println("Livro não encontrado no estoque.");
                return;
            }

            try {
                Emprestimos novoEmprestimo = new Emprestimos(alunoEncontrado, livroEncontrado);
                listaEmprestimos.add(novoEmprestimo);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private void registrarDevolucao() {
            System.out.println("\n--- DEVOLUÇÃO DE LIVRO ---");
            System.out.print("Digite a matrícula do Aluno: ");
            String matricula = sc.nextLine();
            System.out.print("Digite o ISBN do livro: ");
            String isbn = sc.nextLine();

            Emprestimos emprestimoAtivo = null;
            for (Emprestimos emp : listaEmprestimos) {
                if (emp.getAluno().getMatriculaAluno().equals(matricula) &&
                        emp.getLivro().getISBN().equals(isbn) && !emp.isDevolvido()) {
                    emprestimoAtivo = emp;
                    break;
                }
            }

            if (emprestimoAtivo != null) {
                emprestimoAtivo.registrarDevolucao();
            } else {
                System.out.println("Nenhum empréstimo ativo correspondente foi encontrado.");
            }
        }

        private void listarEstoque() {
            System.out.println("\n--- LIVROS DISPONÍVEIS ---");
            if (listaLivros.isEmpty()) {
                System.out.println("Nenhum livro cadastrado.");
                return;
            }
            for (Livros l : listaLivros) {
                System.out.println("Título: " + l.getNomeLivro() + " | ISBN: " + l.getISBN() + " | Qtd: " + l.getQuantidadeLivro());
            }
        }
}
