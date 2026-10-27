import lp2g09.biblioteca.*;

public class GeraTeste {

    // Cria CPF válido
    private static String cpfValido(String base) {
        int d1 = digito(base, 10);
        int d2 = digito(base + d1, 11);
        return base + d1 + d2;
    }

    private static int digito(String s, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < s.length(); i++) {
            soma += (s.charAt(i) - '0') * (pesoInicial - i);
        }
        int resto = (soma * 10) % 11;
        return resto == 10 ? 0 : resto;
    }

    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();

        String[] nomes       = {"Ana", "Bruno", "Carla", "Diego", "Elisa"};
        String[] sobrenomes  = {"Silva", "Souza", "Lima", "Costa", "Alves"};
        String[] bases       = {"123456789", "234567891", "345678912", "456789123", "567891234"};
        String[] titulos     = {"Livro Um", "Livro Dois", "Livro Tres", "Livro Quatro", "Livro Cinco"};
        Categoria[] cats     = Categoria.values();

        try {
            for (int i = 0; i < 5; i++) {
                // Usuario(nome, sobrenome, dia, mes, ano, CPF, endereco)
                Usuario u = new Usuario(nomes[i], sobrenomes[i],
                        10 + i, 1 + i, 1990 + i,
                        cpfValido(bases[i]), "Rua " + (i + 1));
                bib.cadastraUsuario(u);

                // Livro(codigo, titulo, categoria, copias, emprestados)
                // emprestados = 0 so every copy can be borrowed and returned in tests
                // Copies vary: book 1 has a single copy, which makes "no copy available" easy to test
                Livro l = new Livro(i + 1, titulos[i], cats[i % cats.length], i + 1, 0);
                bib.cadastraLivro(l);
            }

            bib.salvaUsuarios("usuarios.dat");
            bib.salvaLivros("livros.dat");
            System.out.println("Salvo em usuarios.dat e livros.dat");
            System.out.println(bib.imprimeUsuarios());
            System.out.println(bib.imprimeLivros());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}