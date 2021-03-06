package br.com.scandura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new ArrayList<Aula>();
    private Collection<Aluno> alunos = new HashSet<>();
    private Map<Integer, Aluno> mapaMatriculaParaAluno = new HashMap<>();

    public Curso(String nome, String instrutor){
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public String getInstrutor() {
        return instrutor;
    }

    public String getNome() {
        return nome;
    }

    public void adiciona(Aula aula){
        this.aulas.add(aula);
    }

    public int getTempoTotal(){
        int tempoTotal = 0;
        for (Aula aula : aulas) {
            tempoTotal += aula.getTempo();
        }
        return tempoTotal;
    }

    public Collection<Aluno> getAlunos(){
        return Collections.unmodifiableCollection(alunos);
    }

    public void matricular(Aluno aluno){
        this.alunos.add(aluno);
        this.mapaMatriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
    }

    public boolean estamatriculado(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public Aluno buscaMatricula(int numero){
        Aluno alunoMatriculado = mapaMatriculaParaAluno.get(numero);
        if(alunoMatriculado != null){
            return alunoMatriculado;
        }
        throw new NoSuchElementException("Não existe aluno matriculado com esse número");
    }

}
