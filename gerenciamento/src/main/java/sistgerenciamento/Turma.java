package sistgerenciamento;

import java.util.ArrayList;

/**
 * Classe Turma representa uma turma com um código e uma lista de alunos matriculados.
 */
public class Turma {
    private String codigo;
    private ArrayList<Aluno> alunosMatriculados;

    /**
     * Construtor da classe Turma.
     * @param codigo O código da turma.
     */
    public Turma(String codigo) {
        this.codigo = codigo;
        this.alunosMatriculados = new ArrayList<>();
    }

    /**
     * Matricula um aluno na turma.
     * @param aluno O objeto Aluno a ser matriculado na turma.
     */
    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

   /**
     * Obtém o código da turma.
     * @return O código da turma.
     */
    public String getCodigo (){
        return codigo;
    }

    /**
     * Retorna a lista de alunos matriculados na turma.
     * @return A lista de alunos matriculados na turma.
     */
    public ArrayList<Aluno> listarAlunosMatriculados() {
        return alunosMatriculados;
    }
}
