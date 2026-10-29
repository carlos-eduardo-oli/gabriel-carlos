package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Usuario buscarUsuario(List<Usuario> usuarios, String matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                return usuario;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        System.out.print("Definir o limite? (S/N): ");
        String definirLimite = scanner.nextLine();

        Usuario usuario;

        if (definirLimite.equalsIgnoreCase("S")) {

            System.out.print("Digite o limite de empréstimos: ");
            int limite = Integer.parseInt(scanner.nextLine());

            usuario = new Usuario(
                    "Carlos",
                    "001",
                    "ALUNO",
                    limite
            );

        } else {

            usuario = new Usuario(
                    "Carlos",
                    "001",
                    "ALUNO"
            );
        }

        usuarios.add(usuario);
        System.out.print("Digite a matrícula do usuário: ");
        String matricula = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(usuarios, matricula);

        if (usuarioEncontrado != null) {
            System.out.println("Usuário localizado: " + usuarioEncontrado.getNome());

            System.out.println("1 - Alterar nome");
            System.out.println("2 - Alterar limite");

            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();

                if (usuarioEncontrado.setNome(novoNome)) {
                    System.out.println("Nome atualizado com sucesso.");
                } else {
                    System.out.println("Nome inválido. Nenhuma alteração feita.");
                }

            } else if (opcao == 2) {
                System.out.print("Digite o novo limite: ");
                int novoLimite = Integer.parseInt(scanner.nextLine());

                if (usuarioEncontrado.setLimiteEmprestimos(novoLimite)) {
                    System.out.println("Limite atualizado com sucesso.");
                } else {
                    System.out.println("Limite inválido. Nenhuma alteração feita.");
                }

            } else {
                System.out.println("Opção inválida. Nenhuma alteração feita.");
            }
        } else {
            System.out.println("Usuário não localizado. Nenhuma alteração feita.");
        }
        Autor autor = new Autor();

        System.out.println("Usuário cadastrado: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite: " + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: " + usuario.getEmprestimosAtivos());
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileiro");
        autor.setAnoNascimento(1839);

        if (autor.getNome() != null && !autor.getNome().trim().isEmpty()) {
            autores.add(autor);
        } else {
            System.out.println("Nome do autor inválido.");
        }

        if (autores.contains(autor)) {

            Livro livro = new Livro(
                    "Dom Casmurro",
                    "978-85-01-00001-1",
                    autor,
                    1899,
                    "Romance"
            );
            Livro livro2 = new Livro(
                    "O Alienista",
                    "978-85-01-00002-2",
                    autor,
                    1882
            );

            livros.add(livro);
            livros.add(livro2);

        } else {
            System.out.println("É necessário cadastrar um autor antes de criar o livro.");
        }

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