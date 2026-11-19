
package br.escola.bibliohaydee.model;

import java.time.LocalDate;

public class Emprestimo {

    private static final int PRAZO_DIAS = 7;

    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoEfetiva;
    private String status;

    public Emprestimo(Livro livro, Usuario usuario) {

        this.livro = livro;
        this.usuario = usuario;

        this.dataEmprestimo = LocalDate.now();

        this.dataDevolucaoPrevista =
                dataEmprestimo.plusDays(PRAZO_DIAS);

        this.dataDevolucaoEfetiva = null;

        this.status = "ATIVO";
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Empréstimo{" +
                "livro=" + livro.getTitulo() +
                ", usuario=" + usuario.getNome() +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucaoPrevista=" + dataDevolucaoPrevista +
                ", dataDevolucaoEfetiva=" +
                (dataDevolucaoEfetiva == null
                        ? "Ainda não devolvido"
                        : dataDevolucaoEfetiva) +
                ", status='" + status + '\'' +
                '}';
    }
}
