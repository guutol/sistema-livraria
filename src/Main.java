//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();

    try {
        System.out.println("Deseja ver a lista de livros disponíveis?");
        String resposta = scanner.nextLine();
        while (resposta.equalsIgnoreCase("sim")) {
            biblioteca.listarDisponiveis();
            System.out.println(" ");
            System.out.println("Deseja ver a lista de livros disponíveis novamente?");
            resposta = scanner.nextLine();
        }
    } catch (Exception e) {
        System.out.println("Ocorreu um erro: " + e.getMessage());;
    }
}
