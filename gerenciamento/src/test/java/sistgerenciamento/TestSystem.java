package sistgerenciamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import java.util.ArrayList;

public class TestSystem {
    
    /**
     * Verifica o cadastrado de alunos, turmas  e disciplinas,
     * simulando a entrada do usuário.
     */
    @Test
    public void testeCadastrar (){
        // Simula a entrada do usuário
        String input = "João\n" + "20\n" + "2021001\n"
        + "Maria\n" + "22\n" + "2021002\n"
        + "Pedro\n" + "21\n" + "2021003\n"
        + "T8\n" + "T9\n" + "T10\n" + "T11\n"
        + "Fisica\n" + "64h\n" + "Matematica\n"
        + "32h\n" + "Calculo\n" + "64h\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Salva o System.in original
        InputStream originalIn = System.in;

        // Redireciona o System.in para o InputStream simulado
        System.setIn(in);

        ArrayList<Aluno> alunos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Aluno aluno = Sistema.cadastrarAluno();
            alunos.add(aluno);
        }

        ArrayList<Turma> turmas = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            Turma turma = Sistema.criarTurma();
            turmas.add(turma);
        }

        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Disciplina disciplina = Sistema.criarDisciplina();
            disciplinas.add(disciplina);
        }

        // Restaura o System.in original
        System.setIn(originalIn);

        // Verifica se os alunos foram cadastrados corretamente
        assertEquals("João", alunos.get(0).getNome());
        assertEquals(20, alunos.get(0).getIdade());
        assertEquals(2021001, alunos.get(0).getMatricula());

        assertEquals("Maria", alunos.get(1).getNome());
        assertEquals(22, alunos.get(1).getIdade());
        assertEquals(2021002, alunos.get(1).getMatricula());

        assertEquals("Pedro", alunos.get(2).getNome());
        assertEquals(21, alunos.get(2).getIdade());
        assertEquals(2021003, alunos.get(2).getMatricula());

        //Verifica se as turmas foram cadastradas corretemente
        assertEquals("T8", turmas.get(0).getCodigo());
        assertEquals("T9", turmas.get(1).getCodigo());
        assertEquals("T10", turmas.get(2).getCodigo());
        assertEquals("T11", turmas.get(3).getCodigo());

        //Verifica se as disciplinas foram casdastrasdas corretamente
        assertEquals("Fisica", disciplinas.get(0).getNome());
        assertEquals("64h", disciplinas.get(0).getCargaHoraria());

        assertEquals("Matematica", disciplinas.get(1).getNome());
        assertEquals("32h", disciplinas.get(1).getCargaHoraria());
 
        assertEquals("Calculo", disciplinas.get(2).getNome());
        assertEquals("64h", disciplinas.get(2).getCargaHoraria());    
    }

    /**
     * Verifica se as operações de matricula dos alunos, associaçao da turma a uma disciplina,
     * listagem dos alunos de uma turma e de uma disciplina, é realizada corretamente.
     */
    @Test
    public void testeAssociacaoMatriculaListagem (){
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        Aluno aluno1 = new Aluno("Aluno1", 20, 1001);
        alunos.add(aluno1);

        Aluno aluno2 = new Aluno("Aluno2", 22, 1002);
        alunos.add(aluno2);

        Turma turma1 = new Turma("Turma1");
        turmas.add(turma1);

        Turma turma2 = new Turma("Turma2");
        turmas.add(turma2);

        Disciplina disciplina1 = new Disciplina("Disciplina1", "60 horas");
        disciplinas.add(disciplina1);

        Disciplina disciplina2 = new Disciplina("Disciplina2", "50 horas");
        disciplinas.add(disciplina2);

        // Matricular alunos em turmas
        turma1.matricularAluno(aluno1);
        turma2.matricularAluno(aluno2);

        // Associar turmas a disciplinas
        disciplina1.associarTurma(turma1);
        disciplina2.associarTurma(turma2);

        // Verificar se os alunos foram matriculados corretamente nas turmas
        ArrayList<Aluno> alunosMatriculadosTurma1 = turma1.listarAlunosMatriculados();
        assertEquals(1, alunosMatriculadosTurma1.size());
        assertTrue(alunosMatriculadosTurma1.contains(aluno1));

        ArrayList<Aluno> alunosMatriculadosTurma2 = turma2.listarAlunosMatriculados();
        assertEquals(1, alunosMatriculadosTurma2.size());
        assertTrue(alunosMatriculadosTurma2.contains(aluno2));

        // Verificar se as disciplinas estão corretamente associadas às turmas
        assertEquals(turma1, disciplina1.getTurma());
        assertEquals(turma2, disciplina2.getTurma());

        // Verificar se os alunos estão corretamente matriculados nas disciplinas
        ArrayList<Aluno> alunosMatriculadosDisciplina1 = disciplina1.listarAlunosMatriculados();
        assertEquals(1, alunosMatriculadosDisciplina1.size());
        assertTrue(alunosMatriculadosDisciplina1.contains(aluno1));

        ArrayList<Aluno> alunosMatriculadosDisciplina2 = disciplina2.listarAlunosMatriculados();
        assertEquals(1, alunosMatriculadosDisciplina2.size());
        assertTrue(alunosMatriculadosDisciplina2.contains(aluno2));
    }
}