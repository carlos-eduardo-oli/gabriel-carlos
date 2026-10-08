package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();

        Autor autor = new Autor();

        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileiro");
        autor.setAnoNascimento(1839);

        autores.add(autor);

        Livro livro = new Livro(
                "Dom Casmurro",
                "978-85-01-00001-1",
                autor,
                1899,
                "Romance"
        );

        livros.add(livro);

        // COLOQUE AQUI
        System.out.println("\n===== ACERVO =====");

        if (livros.isEmpty()) {
            System.out.println("O acervo está vazio.");
        } else {
            for (Livro l : livros) {
                System.out.println("Título: " + l.getTitulo());
                System.out.println("ISBN: " + l.getIsbn());
                System.out.println("Autor: " + l.getAutor().getNome());
                System.out.println("Ano: " + l.getAnoPublicacao());
                System.out.println("Gênero: " + l.getGenero());
                System.out.println("Disponível: " + l.isDisponivel());
                System.out.println("----------------------");
            }
        }

    }

}