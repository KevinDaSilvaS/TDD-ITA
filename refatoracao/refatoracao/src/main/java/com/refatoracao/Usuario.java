package com.refatoracao;

import java.util.Iterator;
import java.util.LinkedList;

public class Usuario implements Comparable<Object> {
	public Usuario(String nome) {
		setNome(nome);
		_livros = new LinkedList<Livro>();
	}

	public void anexaLivroAoUsuario(Livro livro) {
		if (livro != null)
			_livros.add(livro);
	}

	public void desanexaLivroDoUsuario(Livro livro) {
			_livros.remove(livro);
	}

	public void exibe() {
		System.out.println("\t\t" + "Nome: " + "\t\t" + getNome());
		this.exibeLivrosUsuario();
	}

	private void exibeLivrosUsuario() {
		System.out.println("\t\t" + "\\//Livros emprestados:");
		if (_livros.size() <= 0) {
			System.out.println("\t\t" + "---> Nenhum livro emprestado");
			System.out.println("\t\t" + "\\///\\///\\///");
			System.out.println();
			return;
		} 

		Iterator<Livro> iter = _livros.iterator();
		while (iter.hasNext() == true) {
			Livro livro = (Livro) iter.next();
			System.out.println("\t\t\t" + livro.getNrCatalogo() + " " + livro);
		}
	}

	@Override
	public boolean equals(Object obj) {
		return this.compareTo(obj) == 0;
	}

	//@Override
	public int compareTo(Object obj) {
		Usuario usuario = (Usuario) obj;
		String nome = usuario.getNome();
		return _nome.compareTo(nome);
	}

	@Override
	public int hashCode() {
		return _nome.hashCode();
	}

	@Override
	public String toString() {
		return "\"" + getNome() + "\"";
	}

	public String getNome() {
		return _nome;
	}

	protected void setNome(String _nome) {
		this._nome = _nome;
	}

	public LinkedList<Livro> getLivros() {
		return _livros;
	}

	private String _nome;
	private LinkedList<Livro> _livros;
}
