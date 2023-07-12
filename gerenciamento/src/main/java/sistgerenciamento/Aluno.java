package sistgerenciamento;

/**
 * Classe Aluno representa um aluno com nome, idade e número de matrícula.
 */
public class Aluno {
    private String nome;
    private int idade;
    private int matricula;

    /**
     * Construtor da classe Aluno.
     * @param nome O nome do aluno.
     * @param idade A idade do aluno.
     * @param matricula O número de matrícula do aluno.
     */
    public Aluno(String nome, int idade, int matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    /**
     * Obtém o nome do aluno.
     * @return O nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     * @param nome O nome do aluno.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a idade do aluno.
     * @return A idade do aluno.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do aluno.
     * @param idade A idade do aluno.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Obtém o número de matrícula do aluno.
     * @return O número de matrícula do aluno.
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Define o número de matrícula do aluno.
     * @param matricula O número de matrícula do aluno.
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
