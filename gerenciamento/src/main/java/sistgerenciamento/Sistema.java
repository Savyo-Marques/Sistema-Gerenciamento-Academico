package sistgerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Sistema representa o sistema de gerenciamento de alunos.
 */
public class Sistema {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Solicita ao usuário as informações do aluno e cria um objeto Aluno.
     * @return O objeto Aluno criado.
     */
    public static Aluno cadastrarAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scanner.nextLine().trim();

        System.out.println("Digite a idade do aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o número de matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        return new Aluno(nome, idade, matricula);
    }

    /**
     * Solicita ao usuário o código da turma e cria um objeto Turma.
     * @return O objeto Turma criado.
     */
    public static Turma criarTurma() {
        System.out.println("Digite o código da turma: ");
        String codigo = scanner.nextLine().trim();

        return new Turma(codigo);
    }

    /**
     * Solicita ao usuário as informações da disciplina e cria um objeto Disciplina.
     * @return O objeto Disciplina criado.
     */
    public static Disciplina criarDisciplina() {
        System.out.println("Digite o nome da disciplina: ");
        String nome = scanner.nextLine().trim();

        System.out.println("Digite a carga horária da disciplina: ");
        String cargaHoraria = scanner.nextLine().trim();
        
        return new Disciplina(nome, cargaHoraria);
    }

    /**
     * Solicita ao usuário o número de matrícula do aluno e o código da turma para matricular o aluno na turma correspondente.
     * @param alunos Lista de objetos Aluno disponíveis para matrícula.
     * @param turmas Lista de objetos Turma disponíveis para matrícula.
     * @return true se o aluno for matriculado com sucesso, false caso contrário.
     */
    public static boolean matricularAluno(ArrayList<Aluno> alunos, ArrayList<Turma> turmas) {
        System.out.println("Digite o número de matrícula do aluno: ");
        int matricula = scanner.nextInt();
        Aluno aluno = null;
        for (Aluno a : alunos) {
            if (a.getMatricula() == matricula) {
                aluno = a;
                break;
            }
        }

        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return false;
        }

        System.out.println("Digite o código da turma: ");
        String codigo = scanner.nextLine().trim();
        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) {
                turma = t;
                break;
            }
        }

        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return false;
        }
        
        turma.matricularAluno(aluno);
        System.out.println("Aluno matriculado com sucesso!");
        return true;
    }

    /**
     * Solicita ao usuário o nome da disciplina e o código da turma para associar a disciplina à turma correspondente.
     * @param disciplinas Lista de objetos Disciplina disponíveis para associação.
     * @param turmas Lista de objetos Turma disponíveis para associação.
     * @return true se a disciplina for associada à turma com sucesso, false caso contrário.
     */
    public static boolean associarDisciplina(ArrayList<Disciplina> disciplinas, ArrayList<Turma> turmas) {
        System.out.println("Digite o nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine().trim();
        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getNome().equals(nomeDisciplina)) {
                disciplina = d;
                break;
            }
        }
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return false;
        }
        System.out.println("Digite o código da turma: ");
        String codigoTurma = scanner.nextLine().trim();
        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigoTurma)) {
                turma = t;
                break;
            }
        }
        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return false;
        }
        disciplina.associarTurma(turma);
        System.out.println("Disciplina associada à turma com sucesso!");
        return true;
    }

    /**
     * Solicita ao usuário o código da turma e exibe a lista de alunos matriculados na turma.
     * @param turmas Lista de objetos Turma disponíveis para consulta.
     * @return true se a lista de alunos matriculados for exibida com sucesso, false caso contrário.
     */
    public static boolean listarAlunosTurma(ArrayList<Turma> turmas) {
        System.out.println("Digite o código da turma: ");
        String codigo = scanner.nextLine().trim();
        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) {
                turma = t;
                break;
            }
        }
        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return false;
        }
        ArrayList<Aluno> alunosMatriculados = turma.listarAlunosMatriculados();
        System.out.println("Alunos matriculados na turma:");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
        }
        return true;
    }

    /**
     * Solicita ao usuário o nome da disciplina e exibe a lista de alunos matriculados na turma da disciplina.
     * @param disciplinas Lista de objetos Disciplina disponíveis para consulta.
     * @return true se a lista de alunos matriculados for exibida com sucesso, false caso contrário.
     */
    public static boolean listarAlunosDisciplina(ArrayList<Disciplina> disciplinas) {
        System.out.println("Digite o nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine().trim();
        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getNome().equals(nomeDisciplina)) {
                disciplina = d;
                break;
            }
        }
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return false;
        }
        ArrayList<Aluno> alunosMatriculados = disciplina.listarAlunosMatriculados();
        System.out.println("Alunos matriculados na disciplina:");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
        }
        return true;
    }
}