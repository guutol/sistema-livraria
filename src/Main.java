public void opcoes1() {
    System.out.println("[A] Cadastrar livro");
    System.out.println("[B] Cadastrar cliente");
    System.out.println("[C] Realizar empréstimo");
    System.out.println("[D] Listar livros");
    System.out.println("[E] Listar clientes cadastrados");
    System.out.println("[F] Para sair");
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    String resposta, partes[];
    Autor pessoa;

    boolean encerrar = false;
    try {
        opcoes1();
        while(!encerrar) {
            String opcao = scanner.nextLine();
            System.out.println(" ");
            switch (opcao.toUpperCase()) {
                case "A":
                    System.out.println("Digite as informações do livro, como: título e autor");
                    resposta = scanner.nextLine();
                    partes = resposta.split(",");
                    pessoa = biblioteca.buscarAutor(partes[1].trim());
                    if(pessoa != null) {
                        biblioteca.cadastrarLivro(partes[0].trim(), pessoa);
                    }
                    else {
                        System.out.println(" ");
                        System.out.println("Autor não identificado.");
                    }

                    System.out.println(" ");
                    opcoes1();
                    break;

                case "B":
                    System.out.println("Digite suas informações, como: nome e e-mail");
                    resposta = scanner.nextLine();
                    partes = resposta.split(",");
                    biblioteca.cadastrarCliente(partes[0].trim(), partes[1].trim());
                    System.out.println(" ");
                    opcoes1();
                    break;

                case "C":
                    System.out.println("Digite seu nome e o livro");
                    resposta = scanner.nextLine();
                    partes = resposta.split(",");
                    if(biblioteca.realizarEmprestimo(partes[0].trim(), partes[1].trim()))
                        System.out.println("Empréstimo realizado com sucesso");
                    else
                        System.out.println("Houve um erro ao realizar empréstimo");
                    opcoes1();
                    break;

                case "D":
                    biblioteca.listarLivros();
                    opcoes1();
                    break;

                case "E":
                    biblioteca.listarClientes();
                    opcoes1();
                    break;

                case "F":
                    encerrar = true;
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    System.out.println(" ");
                    opcoes1();
            }
        }

    } catch (Exception e) {
        System.out.println("Ocorreu um erro: " + e.getMessage());;
    }

    /*
    try {
        System.out.println("Deseja ver a lista de livros disponíveis?");
        String resposta = scanner.nextLine();
        while (resposta.equalsIgnoreCase("sim") && !encerrar) {
            biblioteca.listarDisponiveis();
            System.out.println(" ");
            System.out.println("Deseja realizar empréstimo de algum livro?");
            resposta = scanner.nextLine();
            if(resposta.equalsIgnoreCase("sim")) {
                System.out.println(" ");
                System.out.println("Digite o ID ou nome do livro para realizar o empréstimo:");
                resposta = scanner.nextLine();
                biblioteca.realizarEmprestimo(resposta);
            }
            else {
                System.out.println(" ");
                System.out.println("Ok, tenha um bom dia.");
                encerrar = true;
            }
            if(!encerrar) {
                System.out.println(" ");
                System.out.println("Deseja ver a lista de livros disponíveis novamente?");
                resposta = scanner.nextLine();
            }
        }
    } catch (Exception e) {
        System.out.println("Ocorreu um erro: " + e.getMessage());;
    }
     */
}
