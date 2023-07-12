package sistgerenciamento;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/* 
 * Testes Unitários
*/
public class TestUnitary {

    private ArrayList<Aluno> alunos;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Turma> turmas;  

    @Before
    public void setUp (){
        alunos = new ArrayList<>();
        disciplinas = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    /** 
     * Verifica se o aluno cadastrado é adicionado na lista e cadastro corretamente
    */
    @Test
    public void testeCadastrarAluno (){
        Aluno aluno = new Aluno("Gabriel", 19, 5596874);
        alunos.add(aluno);

        assertEquals(1, alunos.size());
    }

    /** 
     * Verifica se a turma é adicionada corretamente à lista de turmas e
     * se a primeira turma da lista é a mesma que foi adicionada.
    */
    @Test
    public void testeCadastrarTurma (){
        Turma turma = new Turma("T3");
        turmas.add(turma);

        assertEquals(1, turmas.size());
        assertEquals(turma, turmas.get(0));
    }

    /** 
     * Verifica se a disciplina é adicionada corretamente à lista de disciplinas e
     * se a primeira disciplina da lista é a mesma que foi adicionada.
    */
    @Test
    public void testeCadastrarDisciplina (){
        Disciplina disciplina = new Disciplina("Fudamentos de Programação", "32h");
        disciplinas.add(disciplina);

        assertEquals(1, disciplinas.size());
        assertEquals(disciplina, disciplinas.get(0));
    }

    /**
     * Teste para associar uma disciplina a uma turma.
     * Cria uma turma e uma disciplina, associa a turma à disciplina e verifica se a turma associada é a mesma.
    */
    @Test
    public void testeAssociarDisciplinaTurma (){
        Turma turma = new Turma("T6");
        turmas.add(turma);
        
        Disciplina disciplina = new Disciplina("Banco de Dados", "64h");
        disciplina.associarTurma(turma);

        assertEquals(turma, disciplina.getTurma());
    }
}
