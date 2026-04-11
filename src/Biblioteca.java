import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoIdLivro = 4, proximoIdCliente = 1, proximoIdEmprestimo = 1;

    public int getProximoIdLivro() {
        return proximoIdLivro;
    }

    public void setProximoIdLivro(int proximoIdLivro) {
        this.proximoIdLivro = proximoIdLivro;
    }

    public int getProximoIdCliente() {
        return proximoIdCliente;
    }

    public void setProximoIdCliente(int proximoIdCliente) {
        this.proximoIdCliente = proximoIdCliente;
    }

    public int getProximoIdEmprestimo() {
        return proximoIdEmprestimo;
    }

    public void setProximoIdEmprestimo(int proximoIdEmprestimo) {
        this.proximoIdEmprestimo = proximoIdEmprestimo;
    }

    public Biblioteca() {
        autores.add(new Autor(1, "Marco Aurélio", LocalDate.of(121, 4, 26)));
        autores.add(new Autor(2, "William Shakespeare", LocalDate.of(1564, 4, 23)));
        autores.add(new Autor(3, "Franz Kafka", LocalDate.of(1883, 7, 3)));
        livros.add(new Livro(1, "Meditações", autores.get(0), true, LocalDate.now(), LocalDate.now()));
        livros.add(new Livro(2, "Hamlet", autores.get(1), true, LocalDate.now(), LocalDate.now()));
        livros.add(new Livro(3, "A Metamorfose", autores.get(2), true, LocalDate.now(), LocalDate.now()));
    }

    public void listarLivros() {
        if(!livros.isEmpty()) {
            for(Livro l : livros)
                if(l.isDisponivel()) {
                    System.out.println("ID: " + l.getId() + " Nome: " + l.getTitulo() + " Autor: " + l.getAutor().getNome() +" está disponível.");
                } else {
                    System.out.println("ID: " + l.getId() + " Nome: " + l.getTitulo() + " Autor: " + l.getAutor().getNome() +" não está disponível.");
                }
            System.out.println(" ");
        }
        else
            System.out.println("Não há nenhum livro cadastrado.");
    }

    public boolean realizarEmprestimo(String nome, String livro) {
        System.out.println(" ");
        boolean isNumeric = livro.matches("[0-9]+");
        if(isNumeric) {
            int idLivro = Integer.parseInt(livro);
            for(Livro l : livros) {
                if(l.getId() == idLivro) {
                    if(l.isDisponivel()) {
                        l.setDisponivel(false);
                        l.setDataAtualizacao(LocalDate.now());
                        Emprestimo emprestimo = new Emprestimo(proximoIdEmprestimo, l, nome, LocalDate.now(), null);
                        emprestimos.add(emprestimo);
                        proximoIdEmprestimo++;
                        System.out.println("ID: " + l.getId() + " Nome: " + l.getTitulo() + ". Empréstimo realizado com sucesso, boa leitura!");
                        System.out.println(" ");
                        return true;
                    } else {
                        System.out.println("O livro não está disponível.");
                        System.out.println(" ");
                        return false;
                    }
                }
            }
        } else {
            for(Livro l : livros) {
                if(l.getTitulo().equalsIgnoreCase(livro)) {
                    if(l.isDisponivel()) {
                        l.setDisponivel(false);
                        l.setDataAtualizacao(LocalDate.now());
                        Emprestimo emprestimo = new Emprestimo(proximoIdEmprestimo, l, nome, LocalDate.now(), null);
                        emprestimos.add(emprestimo);
                        proximoIdEmprestimo++;
                        System.out.println("ID: " + l.getId() + " Nome: " + l.getTitulo() + ". Empréstimo realizado com sucesso, boa leitura!");
                        System.out.println(" ");
                        return true;
                    } else {
                        System.out.println("O livro não está disponível.");
                        System.out.println(" ");
                        return false;
                    }
                }
            }
        }

        System.out.println("Livro não encontrado na biblioteca.");
        return false;
    }

    public void listarClientes() {

        if(!clientes.isEmpty()) {
            for(Cliente c : clientes) {
                System.out.println("ID: " + c.getId() + " Nome: " + c.getNome());
            }
        }
        else
            System.out.println("Não há nenhum cliente cadastrado.");
        System.out.println(" ");
    }

    public void cadastrarLivro(String titulo, Autor autor) {
        // já entra disponível
        System.out.println(" ");
        LocalDate atual = LocalDate.now();
        livros.add(new Livro(proximoIdLivro, titulo, autor, true, atual, atual));
        System.out.println("Livro cadastrado com sucesso.");
        proximoIdLivro++;
    }

    public void cadastrarCliente(String nome, String email) {
        System.out.println(" ");
        clientes.add(new Cliente(proximoIdCliente, nome, email));
        System.out.println("Cliente cadastrado com sucesso.");
        proximoIdCliente++;
    }

    public Autor buscarAutor(String pessoa) {
        for(Autor a : autores) {
            if(a.getNome().equalsIgnoreCase(pessoa)) {
                return a;
            }
        }
        return null;
    }

    public boolean buscaLivro(int id) {
        for(Livro l : livros) {
            if(l.getId() == id)
                return true;
        }
        return false;
    }

    public Cliente buscaCliente(int id) {
        for(Cliente c : clientes) {
            if(c.getId() == id)
                return c;
        }
        return null;
    }
}
