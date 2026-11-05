
package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Usuario buscarUsuario(ArrayList<Usuario> usuarios, String matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                return usuario;
            }
        }
        return null;
    }

    private static void carregarAcervo(ArrayList<Autor> autores, ArrayList<Livro> livros) {

        Autor machado = new Autor();
        machado.setNome("Machado de Assis");
        machado.setNacionalidade("Brasileiro");
        machado.setAnoNascimento(1839);

        Autor graciliano = new Autor();
        graciliano.setNome("Graciliano Ramos");

        Autor aluisio = new Autor();
        aluisio.setNome("Aluísio Azevedo");

        Autor jorge = new Autor();
        jorge.setNome("Jorge Amado");

        autores.add(machado);
        autores.add(graciliano);
        autores.add(aluisio);
        autores.add(jorge);

        livros.add(new Livro("Dom Casmurro", "001", machado, 1899, "Romance"));
        livros.add(new Livro("Memórias Póstumas de Brás Cubas", "002", machado, 1881, "Romance"));
        livros.add(new Livro("Quincas Borba", "003", machado, 1891, "Romance"));
        livros.add(new Livro("Vidas Secas", "004", graciliano, 1938, "Romance"));
        livros.add(new Livro("O Cortiço", "005", aluisio, 1890, "Romance"));
        livros.add(new Livro("Capitães da Areia", "006", jorge, 1937, "Romance"));
    }

    // RF-006: pesquisa por parte do título.
    private static void pesquisarPorTitulo(ArrayList<Livro> livros, Scanner scanner) {

        System.out.print("Digite parte do título: ");
        String termo = scanner.nextLine();

        if (termo.trim().isEmpty()) {
            System.out.println("Problema: o título pesquisado não pode ser vazio.");
            return;
        }

        termo = termo.trim().toLowerCase();

        boolean encontrou = false;

        for (Livro livro : livros) {

            String titulo = livro.getTitulo().trim().toLowerCase();

            if (titulo.contains(termo)) {
                System.out.println("Livro encontrado: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor().getNome());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não há resultados para essa pesquisa.");
        }
    }

    private static void pesquisarPorAutor(ArrayList<Livro> livros, Scanner scanner) {

        System.out.print("Digite o nome ou sobrenome do autor: ");
        String termo = scanner.nextLine();

        if (termo.trim().isEmpty()) {
            System.out.println("Problema: o nome do autor não pode ser vazio.");
            return;
        }

        termo = termo.trim().toLowerCase();

        boolean encontrou = false;

        for (Livro livro : livros) {

            String nomeAutor = livro.getAutor().getNome().trim().toLowerCase();

            boolean corresponde = nomeAutor.equals(termo);

            String[] partesNome = nomeAutor.split("\\s+");

            for (String parte : partesNome) {
                if (parte.equals(termo)) {
                    corresponde = true;
                }
            }

            if (corresponde) {
                System.out.println("Livro encontrado: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor().getNome());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Autor não encontrado.");
        }
    }

    private static void gerarRelatorio(ArrayList<Livro> livros) {

        StringBuilder relatorio = new StringBuilder();

        relatorio.append("\n===== RELATÓRIO DO ACERVO =====\n");

        if (livros.isEmpty()) {

            relatorio.append("Não há livros cadastrados no acervo.\n");

        } else {

            int numero = 1;

            for (Livro livro : livros) {

                relatorio.append("\nLivro ").append(numero).append("\n");
                relatorio.append("Título: ").append(livro.getTitulo()).append("\n");
                relatorio.append("Autor: ").append(livro.getAutor().getNome()).append("\n");
                relatorio.append("Ano: ").append(livro.getAnoPublicacao()).append("\n");
                relatorio.append("Disponível: ").append(livro.isDisponivel()).append("\n");

                numero++;
            }

            relatorio.append("\nTotal de livros: ").append(livros.size()).append("\n");
        }

        System.out.println(relatorio.toString());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        System.out.print("Definir o limite? (S/N): ");
        String definirLimite = scanner.nextLine();

        Usuario usuario;

        if (definirLimite.equalsIgnoreCase("S")) {

            System.out.print("Digite o limite de empréstimos: ");
            int limite = Integer.parseInt(scanner.nextLine());

            usuario = new Usuario("Carlos", "001", "ALUNO", limite);

        } else {

            usuario = new Usuario("Carlos", "001", "ALUNO");
        }

        usuarios.add(usuario);

        System.out.print("Digite a matrícula do usuário: ");
        String matricula = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(usuarios, matricula);

        if (usuarioEncontrado != null) {

            System.out.println("Usuário localizado: " + usuarioEncontrado.getNome());

            System.out.println("1 - Alterar nome");
            System.out.println("2 - Alterar limite");

            System.out.print("Escolha uma opção (ou 0 para continuar): ");
            int opcaoUsuario = Integer.parseInt(scanner.nextLine());

            if (opcaoUsuario == 1) {

                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();

                if (usuarioEncontrado.setNome(novoNome)) {
                    System.out.println("Nome atualizado com sucesso.");
                } else {
                    System.out.println("Nome inválido. Nenhuma alteração feita.");
                }

            } else if (opcaoUsuario == 2) {

                System.out.print("Digite o novo limite: ");
                int novoLimite = Integer.parseInt(scanner.nextLine());

                if (usuarioEncontrado.setLimiteEmprestimos(novoLimite)) {
                    System.out.println("Limite atualizado com sucesso.");
                } else {
                    System.out.println("Limite inválido. Nenhuma alteração feita.");
                }
            }

        } else {
            System.out.println("Usuário não localizado. Nenhuma alteração feita.");
        }

        System.out.println("\nUsuário cadastrado: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite: " + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: " + usuario.getEmprestimosAtivos());

        carregarAcervo(autores, livros);

        int opcao;

        do {

            System.out.println("\n========== BIBLIHAYDEE ==========");
            System.out.println("1 - Pesquisar livro por título");
            System.out.println("2 - Pesquisar livro por autor");
            System.out.println("3 - Gerar relatório do acervo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:
                    pesquisarPorTitulo(livros, scanner);
                    break;

                case 2:
                    pesquisarPorAutor(livros, scanner);
                    break;

                case 3:
                    gerarRelatorio(livros);
                    break;

                case 0:
                    System.out.println("Encerrando o BiblioHaydee.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
