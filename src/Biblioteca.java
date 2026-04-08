import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {
        autores.add(new Autor(1, "Marco Aurélio", LocalDate.of(121, 4, 26)));
        autores.add(new Autor(2, "William Shakespeare", LocalDate.of(1564, 4, 23)));
        autores.add(new Autor(3, "Franz Kafka", LocalDate.of(1883, 7, 3)));

        livros.add(new Livro(1, "Meditações",    autores.get(0), false, LocalDate.of(180, 1, 1),  LocalDate.of(180, 12, 31)));
        livros.add(new Livro(2, "Hamlet",        autores.get(1), true, LocalDate.of(1603, 1, 1), LocalDate.of(1603, 12, 31)));
        livros.add(new Livro(3, "A Metamorfose", autores.get(2), true, LocalDate.of(1915, 1, 1), LocalDate.of(1915, 12, 31)));
    }

    public void listarDisponiveis() {
        for(Livro l : livros)
            if(l.isDisponivel())
                System.out.println("ID: " + l.getId() + " Nome: " + l.getTitulo() + " está disponível.");
    }
}
