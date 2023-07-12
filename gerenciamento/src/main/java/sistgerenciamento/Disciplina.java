package sistgerenciamento;

import java.util.ArrayList;

/**
 * Classe Disciplina representa uma disciplina com um nome e uma turma associada.
 */
public class Disciplina {
    private String nome;
    private Turma turma;
    private String cargaHoraria;

    /**
     * Construtor da classe Disciplina.
     * @param nome O nome da disciplina.
     */
    public Disciplina(String nome, String cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * Associa uma turma à disciplina.
     * @param turma A turma a ser associada à disciplina.
     */
    public void associarTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * Retorna a turma associada à disciplina.
     * @return A turma associada à disciplina.
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * Retorna o nome da disciplina.
     * @return O nome da disciplina.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Retorna a carga horaria da disciplina
     * @return a carga horaria da disciplina
     */
    public String getCargaHoraria(){
        return cargaHoraria;
    }

    /**
     * Retorna a lista de alunos matriculados na turma da disciplina.
     * @return A lista de alunos matriculados na turma da discipla.
     */
    public ArrayList<Aluno> listarAlunosMatriculados() {
        if (turma != null) {
            return turma.listarAlunosMatriculados();
        } else {
            return new ArrayList<>(); // Retorna uma lista vazia se a disciplina não estiver associada a uma turma.
        }
    }
}

