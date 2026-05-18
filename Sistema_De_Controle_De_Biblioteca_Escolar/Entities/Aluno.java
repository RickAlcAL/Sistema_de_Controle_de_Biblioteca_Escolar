package Sistema_De_Controle_De_Biblioteca_Escolar.Entities;

import java.util.ArrayList;

public class Aluno {
    private String nomeAluno;
    private String matriculaAluno;
    private int idadeAluno;


    private static ArrayList<String> matriculasCadastradas = new ArrayList<>(); //Instanciando uma arraylist para manipulação de dados


    private int multasPendentes; //Declarando objetos de emprestimos e multas para manipular
    private int emprestimosAtivos;

    public Aluno(String nomeAluno, String matriculaAluno, int idadeAluno) { //Construtor que receberá os dados do usuario
        // Valida antes de tudo
        if (!verificacaoNomeAluno(nomeAluno)) {
            throw new IllegalArgumentException("Erro: Nome inválido.");
        }
        if (!verificadorMatriculaValida(matriculaAluno)) {
            throw new IllegalArgumentException("Erro: Matrícula inválida.");
        }

        this.nomeAluno = nomeAluno;
        this.matriculaAluno = matriculaAluno;
        this.idadeAluno = idadeAluno;
        this.multasPendentes = 0;
        this.emprestimosAtivos = 0;

        matriculasCadastradas.add(matriculaAluno);
    }

    public boolean verificadorMatriculaValida(String matriculaAluno) { //Verificador matriculas
        if (matriculaAluno == null || matriculaAluno.length() != 8) {
            System.out.println("Erro: Matrícula deve conter exatamente 8 dígitos.");
            return false;
        }

        for (int i = 0; i < matriculaAluno.length(); i++) {
            char verificador = matriculaAluno.charAt(i);

            if (Character.isLetter(verificador)) {
                System.out.println("Letra detectada na matrícula");
                return false;
            } else if (!Character.isDigit(verificador)) {
                System.out.println("Caractere Inválido na matrícula");
                return false;
            }
        }
        return true;
    }

    public boolean existeMatricula() {
        if (matriculasCadastradas.contains(this.matriculaAluno)) {
            System.out.println("Matrícula encontrada com sucesso!!! " + this.matriculaAluno);
            return true;
        }
        System.out.println("Matrícula: " + this.matriculaAluno + " não encontrada");
        return false;
    }

    public boolean verificacaoNomeAluno(String nomeAluno) {
        if (nomeAluno == null || nomeAluno.trim().isEmpty()) {
            return false;
        }

        for (char c : nomeAluno.toCharArray()) {
            if (Character.isDigit(c)) {
                System.out.println("Erro: Nome não pode conter números.");
                return false;
            }
        }
        return true;
    }

    public boolean verificadorMultasAluno() {
        boolean temMulta = false;

        if (this.multasPendentes > 0) {
            temMulta = true;
        }

        return temMulta;
    }

    //Getters obrigatorios para caso eu necessite encontrar algum dado
    public String getMatriculaAluno() {
        return matriculaAluno;
    }
    public String getNomeAluno() {
        return nomeAluno;
    }
    public int getIdadeAluno() {
        return idadeAluno;
    }
    public void setMultasPendentes(int multas) {
        this.multasPendentes = multas;
    }
}