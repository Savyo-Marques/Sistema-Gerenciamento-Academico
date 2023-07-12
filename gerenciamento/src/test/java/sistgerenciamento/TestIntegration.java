package sistgerenciamento;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.ArrayList;

public class TestIntegration{

    /**
     * Verifica a integração entre as classes Aluno e Turma.
    */
    @Test
    public void testeCadastroAlunoCriacaoTurmaMatricula (){
        Aluno aluno1 = new Aluno("Gabriel", 19, 5596874);
        Aluno aluno2 = new Aluno("Jose", 21, 894752);
        Aluno aluno3 = new Aluno("Joao", 20, 754521);

        Turma turma = new Turma("T6");

        turma.matricularAluno(aluno3);
        turma.matricularAluno(aluno2);
        turma.matricularAluno(aluno1);

        //Verifica se o valor retornado é o esperado.
        assertTrue(turma.listarAlunosMatriculados().contains(aluno1));
        assertTrue(turma.listarAlunosMatriculados().contains(aluno2));
        assertTrue(turma.listarAlunosMatriculados().contains(aluno3));
    }

    /** 
     * Verifica a integração entre as classes Disciplina, Turma e Aluno.
    */
    @Test
    public void testeDisciplinaAlunoTurma (){
        Aluno aluno1 = new Aluno("Gabriel", 19, 5596874);
        Aluno aluno2 = new Aluno("Jose", 21, 894752);
        Aluno aluno3 = new Aluno("Joao", 20, 754521);

        Turma turma = new Turma("T6");

        Disciplina disciplina = new Disciplina("Matematica Basica", "32h");

        turma.matricularAluno(aluno1);
        turma.matricularAluno(aluno2);
        turma.matricularAluno(aluno3);

        disciplina.associarTurma(turma);
        
        //Verifica se o valor retornado é o esperado.
        assertTrue(disciplina.listarAlunosMatriculados().contains(aluno1));
        assertTrue(disciplina.listarAlunosMatriculados().contains(aluno2));
        assertTrue(disciplina.listarAlunosMatriculados().contains(aluno3));
    }

    /** 
     * Verifica a integração entre as classes Turma, Aluno e Sistema.
    */
    @Test
    public void testeSistemaAlunoTurma (){
        // Simula a entrada do usuário
        String entradaUsuario = "T6\nJoao\n20\n202325\n";
            
        InputStream inputStream = new ByteArrayInputStream(entradaUsuario.getBytes());
        System.setIn(inputStream);

        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        
        Turma turma = Sistema.criarTurma();
        turmas.add(turma);
        Aluno aluno = Sistema.cadastrarAluno();
        alunos.add(aluno);

        assertEquals("T6", turma.getCodigo());
        assertEquals("Joao", aluno.getNome());
        assertEquals(20, aluno.getIdade());
        assertEquals(202325, aluno.getMatricula());
    }
}