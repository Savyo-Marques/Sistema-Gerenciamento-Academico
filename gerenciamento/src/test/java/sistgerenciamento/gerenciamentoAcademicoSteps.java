package sistgerenciamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class gerenciamentoAcademicoSteps {
    private Disciplina matematica;
    private Disciplina historia;
    private Disciplina quimica;
    private Disciplina fisica;
    private Turma turmaA001;
    private Turma turmaB001;
    private Aluno joao;
    private Aluno maria;

    @Given("there is a subject named \"(.*)\" with a duration of \"(.*)\"")
    public void criarDisciplina(String nomeDisciplina, String duracao) {
        if (nomeDisciplina.equals("Matemática")) {
            matematica = new Disciplina(nomeDisciplina, duracao);
        } else if (nomeDisciplina.equals("História")) {
            historia = new Disciplina(nomeDisciplina, duracao);
        } else if (nomeDisciplina.equals("Química")) {
            quimica = new Disciplina(nomeDisciplina, duracao);
        } else if (nomeDisciplina.equals("Física")) {
            fisica = new Disciplina(nomeDisciplina, duracao);
        }
    }

    @Given("there is a class with code \"(.*)\"")
    public void criarTurmaA(String codigoTurma) {
        if (codigoTurma.equals("A001")) {
            turmaA001 = new Turma(codigoTurma);
        } else if (codigoTurma.equals("B001")) {
            turmaB001 = new Turma(codigoTurma);
        }
    }

    @Given("there is a student named \"(.*)\" with ID (\\d+)")
    public void criarAluno(String nomeAluno, int idAluno) {
        if (nomeAluno.equals("João")) {
            joao = new Aluno(nomeAluno, idAluno, 0);
        } else if (nomeAluno.equals("Maria")) {
            maria = new Aluno(nomeAluno, idAluno, 0);
        }
    }

    @When("I associate class \"(.*)\" to subject \"(.*)\"")
    public void associarTurmaADisciplina(String codigoTurma, String nomeDisciplina) {
        if (codigoTurma.equals("A001") && nomeDisciplina.equals("Matemática")) {
            matematica.associarTurma(turmaA001);
        }
    }

    @When("I enroll student \"(.*)\" in class \"(.*)\" ")
    public void matricularAlunoNaTurma(String nomeAluno, String codigoTurma) {
        if (nomeAluno.equals("João") && codigoTurma.equals("A001")) {
            turmaA001.matricularAluno(joao);
        }
    }

    @Then("student \"(.*)\" should be enrolled in class \"(.*)\" ")
    public void verificarMatriculaAlunoTurma(String nomeAluno, String codigoTurma) {
        if (nomeAluno.equals("João") && codigoTurma.equals("A001")) {
            ArrayList<Aluno> alunosMatriculados = turmaA001.listarAlunosMatriculados();
            assertTrue(alunosMatriculados.contains(joao));
        }
    }

    @When("I list the enrolled students in subject \"(.*)\" ")
    public void listarAlunosMatriculadosNaDisciplina(String nomeDisciplina) {
        if (nomeDisciplina.equals("História")) {
            turmaB001.matricularAluno(maria);
        }
    }
    
    @When("I get the subject name")
    public void getSubjectName() {
        // No action needed
    }

    @When("I get the subject workload")
    public void getSubjectWorkload() {
        // No action needed
    }

    @Then("subject \"(.*)\" should have class \"(.*)\" associated")
    public void verificarAssociacaoDisciplinaTurma(String nomeDisciplina, String codigoTurma) {
        if (nomeDisciplina.equals("Matemática") && codigoTurma.equals("A001")) {
            assertEquals(turmaA001, matematica.getTurma());
        }
    }

    @Then("I should get a list containing student \"(.*)\"")
    public void verificarListaAlunosMatriculados(String nomeAluno) {
        if (nomeAluno.equals("Maria")) {
            ArrayList<Aluno> alunosMatriculados = historia.listarAlunosMatriculados();
            assertTrue(alunosMatriculados.contains(maria));
        }
    }

    @Then("I should get the name \"(.*)\"")
    public void verificarNomeDisciplina(String nomeDisciplina) {
        if (nomeDisciplina.equals("Química")) {
            assertEquals(nomeDisciplina, quimica.getNome());
        }
    }

    @Then("I should get the workload \"(.*)\"")
    public void verificarCargaHorariaDisciplina(String cargaHoraria) {
        if (cargaHoraria.equals("60 horas")) {
            assertEquals(cargaHoraria, fisica.getCargaHoraria());
        }
    }
}