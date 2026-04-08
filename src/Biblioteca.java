import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    private Biblioteca() {
        autores.add(new Autor(1, "Marco Aurélio", new Date(26, 4, 1900)));
        autores.add(new Autor(2, "William Shakespeare", new Date(23, 4, 1900)));
        autores.add(new Autor(3, "Franz Kafka", new Date(3, 7, 1900)));

        livros.add(new Livro(1, "Meditações", autores.get(0), true, new Date(1, 1, 1900), new Date(2, 2, 1900)));
        livros.add(new Livro(1, "Hamlet", autores.get(1), true, new Date(1, 1, 1900), new Date(2, 2, 1900)));
        livros.add(new Livro(1, "A Metamorfose", autores.get(2), true, new Date(1, 1, 1900), new Date(2, 2, 1900)));
    }
}
