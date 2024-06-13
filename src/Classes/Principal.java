package Classes;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;

        int opcao;
        do {
            System.out.println("MENU:");
            System.out.println("(1) criar uma loja");
            System.out.println("(2) criar um produto");
            System.out.println("(3) sair");
            System.out.print("Escolha uma opção: ");
            String entrada = scanner.nextLine();
            
            try {
                opcao = Integer.parseInt(entrada); 
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    loja = criarLoja(scanner);
                    System.out.println("Loja criada com sucesso.");
                    break;
                case 2:
                    produto = criarProduto(scanner);
                    System.out.println("Produto criado com sucesso.");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }

            // Verifica se os objetos foram criados corretamente
            if (loja != null && produto != null) {
                // Verifica se o produto está vencido na data de 20/10/2023
                Data dataLimite = new Data(20, 10, 2023);
                if (produto.estaVencido(dataLimite)) {
                    System.out.println("PRODUTO VENCIDO");
                } else {
                    System.out.println("PRODUTO NÃO VENCIDO");
                }

                // Imprime as informações da loja criada
                System.out.println("Informações da Loja:");
                System.out.println(loja);
                System.out.println("produtos:");
                System.out.println(produto);
                

                // Resetar os objetos para evitar reimpressões desnecessárias
                loja = null;
                produto = null;
            }

        } while (opcao != 3);
    }

    private static Loja criarLoja(Scanner scanner) {
        System.out.print("Digite o nome da loja: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a quantidade de funcionários: ");
        int quantidadeFuncionarios = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o salário base dos funcionários: ");
        double salarioBaseFuncionario = Double.parseDouble(scanner.nextLine());
        System.out.print("Digite o nome da rua do endereço da loja: ");
        String nomeDaRua = scanner.nextLine();
        System.out.print("Digite a cidade do endereço da loja: ");
        String cidade = scanner.nextLine();
        System.out.print("Digite o estado do endereço da loja: ");
        String estado = scanner.nextLine();
        System.out.print("Digite o país do endereço da loja: ");
        String pais = scanner.nextLine();
        System.out.print("Digite o CEP do endereço da loja: ");
        String cep = scanner.nextLine();
        System.out.print("Digite o número do endereço da loja: ");
        String numero = scanner.nextLine();
        System.out.print("Digite o complemento do endereço da loja: ");
        String complemento = scanner.nextLine();
    
        Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);
        System.out.print("Digite a data de fundação da loja (dia/mês/ano): ");
        String[] partesData = scanner.nextLine().split("/");
        int diaFundacao = Integer.parseInt(partesData[0]);
        int mesFundacao = Integer.parseInt(partesData[1]);
        int anoFundacao = Integer.parseInt(partesData[2]);
        Data dataFundacao = new Data(diaFundacao, mesFundacao, anoFundacao);
    
        System.out.print("Digite a quantidade máxima de produtos: ");
        int quantidadeMaximaProdutos = Integer.parseInt(scanner.nextLine());
    
        return new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaximaProdutos);
    }
    

    private static Produto criarProduto(Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Digite a data de validade do produto (dia/mês/ano): ");
        String[] partesData = scanner.nextLine().split("/");
        int diaValidade = Integer.parseInt(partesData[0]);
        int mesValidade = Integer.parseInt(partesData[1]);
        int anoValidade = Integer.parseInt(partesData[2]);
        Data dataValidade = new Data(diaValidade, mesValidade, anoValidade);

        return new Produto(nome, preco, dataValidade);
    }
}
