//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    boolean encerrar = false;

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
}
