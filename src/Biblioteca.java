import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Biblioteca() {
        autores.add(new Autor(1, "Marco Aurélio", LocalDate.of(121, 4, 26)));
        autores.add(new Autor(2, "William Shakespeare", LocalDate.of(1564, 4, 23)));
        autores.add(new Autor(3, "Franz Kafka", LocalDate.of(1883, 7, 3)));

        livros.add(new Livro(1, "Meditações",    autores.get(0), true, LocalDate.of(180, 1, 1),  LocalDate.of(180, 12, 31)));
        livros.add(new Livro(2, "Hamlet",        autores.get(1), true, LocalDate.of(1603, 1, 1), LocalDate.of(1603, 12, 31)));
        livros.add(new Livro(3, "A Metamorfose", autores.get(2), true, LocalDate.of(1915, 1, 1), LocalDate.of(1915, 12, 31)));
    }

    public void listarDisponiveis() {
        System.out.println(" ");
        if(!livros.isEmpty()) {
            for(Livro l : livros)
                if(l.isDisponivel())
                    System.out.println("ID: " + l.getId() + " Nome: " + l.getTitulo() + " está disponível.");
        }
        else // encerrar programa
            System.out.println("Não há nenhum livro cadastrado.");
    }

    public void realizarEmprestimo(String livro) {
        System.out.println(" ");
        boolean isNumeric = livro.matches("[0-9]+"), achou = false;
        if(isNumeric) {
            int id = Integer.parseInt(livro);
            for(Livro l : livros) {
                if(l.getId() == id) {
                    if(l.isDisponivel()) {
                        System.out.println("ID: " + l.getId() + " Nome: " + l.getTitulo() + ". Empréstimo realizado com sucesso, boa leitura!");
                        l.setDisponivel(false);
                    }
                    else {
                        System.out.println("O livro não está disponível.");
                    }
                    achou = true;
                }
            }
        }
        else {
            for(Livro l : livros) {
                if(l.getTitulo().equalsIgnoreCase(livro)) {
                    if(l.isDisponivel()) {
                        System.out.println("ID: " + l.getId() + " Nome: " + l.getTitulo() + ". Empréstimo realizado com sucesso, boa leitura!");
                        l.setDisponivel(false);
                    }
                    else {
                        System.out.println("O livro não está disponível.");
                    }
                    achou = true;
                }
            }
        }
        if(!achou) {
            System.out.println("Livro não encontrado na biblioteca.");
        }
    }

    public void listarClientes() {
        System.out.println(" ");
        if(!clientes.isEmpty()) {
            for(Cliente c : clientes) {
                System.out.println("ID: " + c.getId() + " Nome: " + c.getNome());
            }
        }
        else
            System.out.println("Não há nenhum cliente cadastrado.");
    }

    public void cadastrarLivro(int id, String titulo, Autor autor, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        // já entra disponível
        System.out.println(" ");
        livros.add(new Livro(id, titulo, autor, true, dataCadastro, dataAtualizacao));
        System.out.println("Livro cadastrado com sucesso.");
    }

    public void cadastrarCliente(int id, String nome, String email) {
        System.out.println(" ");
        clientes.add(new Cliente(id, nome, email));
        System.out.println("Cliente cadastrado com sucesso.");
    }
}
