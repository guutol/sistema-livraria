public void opcoes1() {
    System.out.println("[A] Cadastrar livro");
    System.out.println("[B] Cadastrar cliente");
    System.out.println("[C] Realizar empréstimo");
    System.out.println("[D] Listar livros disponíveis");
    System.out.println("[E] Listrar clientes cadastrados");
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    boolean encerrar = false;
    try {
        opcoes1();
        String opcao = scanner.nextLine();
        System.out.println("");
        switch (opcao) {
            case 1:
                System.out.println("Digite as informações do livro, como: id, título e autor");
                String resposta = scanner.nextLine();
                String[] partes = resposta.split(",");
                biblioteca.cadastrarLivro();
                break;
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
