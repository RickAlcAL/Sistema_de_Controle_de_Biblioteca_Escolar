package Sistema_De_Controle_De_Biblioteca_Escolar.Applications;

import Sistema_De_Controle_De_Biblioteca_Escolar.Entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {
        // Instanciando as classes como consulta
        Scanner sc = new Scanner(System.in);
        ArrayList<Aluno> bancoAlunos = new ArrayList<>();
        ArrayList<Livros> bancoLivros = new ArrayList<>();
        ArrayList<Emprestimos> bancoEmprestimos = new ArrayList<>();

        //Adicionando valores
        Escola escola = new Escola("Escola Tecnica Central", "EC12", "Av. Principal, 100");
        bancoAlunos.add(new Aluno("Joao Silva", "12345678", 16));
        bancoLivros.add(new Livros("97885", "Java: Como Programar", 3));
        //Instanciando o menu
        MenuUsuario menu = new MenuUsuario(escola, bancoAlunos, bancoLivros, bancoEmprestimos);

        menu.iniciar();
    }
}
