import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void iniciar() {

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE PRODUTOS ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar por id");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    remover();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrar() {

        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(id, nome, preco);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private void listar() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    private void buscar() {

        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();

        for (Produto p : produtos) {
            if (p.getId() == id) {
                System.out.println("Produto encontrado:");
                System.out.println(p);
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private void remover() {

        System.out.print("Digite o ID para remover: ");
        int id = scanner.nextInt();

        produtos.removeIf(p -> p.getId() == id);

        System.out.println("Se existia, foi removido.");
    }
}
