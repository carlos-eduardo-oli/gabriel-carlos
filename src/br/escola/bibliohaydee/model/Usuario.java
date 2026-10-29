
package br.escola.bibliohaydee.model;

public class Usuario {

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;
    public Usuario(String nomeCadastro, String matriculaCadastro, String tipoCadastro, Integer limiteCadastro) {

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
    }public String getNome() {
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
}
