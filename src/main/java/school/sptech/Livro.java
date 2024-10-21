package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Livro() {
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacaos=" + avaliacoes +
                '}';
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) {
        if (descricao.isBlank()) {
            throw new ArgumentoInvalidoException("Argumento inválido");
        }
        if (descricao == null) {
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

        if (qtdEstrelas < 0.0 || qtdEstrelas > 5.0) {
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

        Avaliacao adicionar = new Avaliacao();
        adicionar.setDescricao(descricao);
        adicionar.setQtdEstrelas(qtdEstrelas);
        avaliacoes.add(adicionar);
    }

    public Double calcularMediaAvaliacoes(){
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        Double media = 0.0;
        Double total = 0.0;

        for (Avaliacao avaliacao : avaliacoes) {
            total = total + avaliacao.getQtdEstrelas();
        }
        media = total/ avaliacoes.size();
        return media;
    }



}
