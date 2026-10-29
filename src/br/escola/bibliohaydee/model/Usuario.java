package br.escola.bibliohaydee.model;

public class Usuario {

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;

    public static final int LIMITE_PADRAO = 3;

    public Usuario(String nomeCadastro, String matriculaCadastro,
                   String tipoCadastro, Integer limiteCadastro) {

        if (nomeCadastro == null || nomeCadastro.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário inválido.");
        }

        if (!"ALUNO".equals(tipoCadastro) && !"PROFESSOR".equals(tipoCadastro)) {
            throw new IllegalArgumentException("Tipo de usuário inválido.");
        }

        nome = nomeCadastro;
        matricula = matriculaCadastro;
        tipo = tipoCadastro;
        limiteEmprestimos = limiteCadastro;
        emprestimosAtivos = 0;
    }

    public Usuario(String nome, String matricula, String tipo) {
        this(nome, matricula, tipo, LIMITE_PADRAO);
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public boolean setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        this.nome = nome.trim();
        return true;
    }

    public boolean setLimiteEmprestimos(int limiteEmprestimos) {
        if (limiteEmprestimos < 1) {
            return false;
        }

        this.limiteEmprestimos = limiteEmprestimos;
        return true;
    }
}