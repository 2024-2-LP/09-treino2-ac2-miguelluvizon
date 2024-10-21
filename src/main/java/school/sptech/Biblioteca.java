package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarLivro(Livro livro){
        if (livro == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (livro.getTitulo()== null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (livro.getTitulo().isBlank()){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (livro.getAutor()== null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (livro.getAutor().isBlank()){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (livro.getDataPublicacao() == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

        livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo){
        if (titulo == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (titulo.isEmpty()) {
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (titulo.equals(" ")){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

        Integer encontrei = 0;

        for (int i = 0; i < livros.size(); i++) {
            if(titulo.equalsIgnoreCase(livros.get(i).getTitulo())){
                encontrei = 1;
                livros.remove(livros.get(i));
            }
        }
        if (encontrei == 0){
            throw new LivroNaoEncontradoException("nao encontrado");
        }
    }

    public Livro buscarLivroPorTitulo(String titulo){
        if (titulo == null){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (titulo.isEmpty()) {
            throw new ArgumentoInvalidoException("Argumento invalido");
        }
        if (titulo.equals(" ")){
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

        Integer encontrei = 0;
        Livro livroCerto = null;

        for (int i = 0; i < livros.size(); i++) {
            if(titulo.equalsIgnoreCase(livros.get(i).getTitulo())){
                encontrei = 1;
                livroCerto = livros.get(i);
            }
        }
        if (encontrei == 0){
            throw new LivroNaoEncontradoException("nao encontrado");
        }
        return livroCerto;
    }

    public Integer contarLivros(){
        Integer total = 0;
        for (int i = 0; i < livros.size(); i++) {
            total = total + 1;
        }
        return total;
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosAno = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                livrosAno.add(livro);
            }
        }
        return livrosAno;
    }


}
