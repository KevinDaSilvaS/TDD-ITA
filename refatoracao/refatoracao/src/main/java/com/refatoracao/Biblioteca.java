package com.refatoracao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Biblioteca {

	public Biblioteca(String nome) {
		_nome = nome;
		_repositorioLivros = new TreeSet<Livro>();
		_usuarios = new HashSet<Usuario>();
	}

	public void adicionaLivroCatalogo(Livro livro)
	throws AdicionarLivroInexistenteException {
		if (livro == null) {
			throw new AdicionarLivroInexistenteException(
			"--->N�o pode adicionar livro inexistente!");
		}

		livro.setNrCatalogo(this.getNrUnico());
		_repositorioLivros.add(livro);
				
	}

	public void registraUsuario(String nome)
	throws UsuarioJaRegistradoException, UsuarioComNomeVazioException,
	UsuarioInexistenteException {

		validateName(nome);
		Usuario usuario = new Usuario(nome);

		if (_usuarios.contains(usuario)) {
			throw new UsuarioJaRegistradoException("--->J� existe usu�rio com o nome \""
			+ nome + "\"! Use outro nome!");
		}	
		_usuarios.add(usuario);
	}

	public void validateName(String nome) 
	throws UsuarioInexistenteException, UsuarioComNomeVazioException {

		if (nome == null) {
			throw new UsuarioInexistenteException("--->N�o pode registrar usuario inexistente!");
		}
		
		if (nome.isEmpty()) {
			throw new UsuarioComNomeVazioException("--->N�o pode registrar usuario com nome vazio!");
		}

	}

	public void emprestaLivro(Livro livro, Usuario usuario)
	throws LivroIndisponivelParaEmprestimoException, LivroOuUsuarioNulosException {
		validateEmprestimoLivro(livro, usuario);

		if (livro.getUsuario() == null) {
			usuario.anexaLivroAoUsuario(livro);
			livro.anexaUsuarioAoLivro(usuario);
		} else
			throw new LivroIndisponivelParaEmprestimoException(
			"--->Livro " + livro
			+ " indispon�vel para empr�stimo!");
		
	}

	public void validateEmprestimoLivro(Livro livro, Usuario usuario)
	throws LivroOuUsuarioNulosException {
			
		if ((livro == null) && (usuario == null))
			throw new LivroOuUsuarioNulosException(
			"--->Livro e Usu�rio inexistentes!");

		if (livro == null) {
			throw new LivroOuUsuarioNulosException(
			"--->N�o pode emprestar livro inexistente!");
		}
		
		if (usuario == null) {
			throw new LivroOuUsuarioNulosException(
			"--->N�o pode emprestar livro a Usu�rio inexistente!");
		} 
	}

	public void devolveLivro(Livro livro)
	throws DevolveLivroNuloParaEmprestimoException, 
	DevolveLivroDisponivelParaEmprestimoException {

		if (validateDevolucaoLivro(livro)) {
			Usuario usuario = livro.getUsuario();
			validateDevolucaoLivroUsuario(usuario, livro);
		}	
	}

	public boolean validateDevolucaoLivro(Livro livro)
	throws DevolveLivroNuloParaEmprestimoException {
		if (livro == null) {
			throw new DevolveLivroNuloParaEmprestimoException(
			"--->N�o pode emprestar livro inexistente!");
		} 	
		return true;
	}

	public void validateDevolucaoLivroUsuario(Usuario usuario, Livro livro)
	throws DevolveLivroDisponivelParaEmprestimoException{
		if (usuario == null) {
			throw new DevolveLivroDisponivelParaEmprestimoException(
			"---> Tentou devolver livro " + livro
			+ " que est� dispon�vel para empr�stimo!");
		}
		usuario.desanexaLivroDoUsuario(livro);
		livro.desanexaUsuarioDoLivro();
	}

	public Livro buscaLivroPorNrCatalogo(int nrUnico) {
		Livro livroAchado = null;
		Iterator<Livro> iter = _repositorioLivros.iterator();

		while ((iter.hasNext() == true) && (livroAchado == null)) {
			Livro livro = (Livro) iter.next();
			int oNrUnico = livro.getNrCatalogo();
			if (oNrUnico == nrUnico)
				livroAchado = livro;
		}
		return livroAchado;
	}

	public Livro buscaLivroPorTituloAutor(String titulo, String autor)
	throws TituloOuAutorVazioException, TituloOuAutorNuloException {
		Livro livroAchado = null;
		validateBusca(titulo, autor);

		Iterator<Livro> iter = _repositorioLivros.iterator();
		while ((iter.hasNext() == true) && (livroAchado == null)) {
			Livro livro = (Livro) iter.next();
			String oTitulo = livro.getTitulo();
			String oAutor = livro.getAutor();

			if ((oTitulo.equals(titulo)) && (oAutor.equals(autor))) {
				livroAchado = livro;
			}
		}
		return livroAchado;
	}

	public boolean validateBusca(String titulo, String autor)
	throws TituloOuAutorVazioException, TituloOuAutorNuloException {

		if ((titulo == null) || (autor == null)) {
			throw new TituloOuAutorNuloException(
			"--->Nome do titulo e/ou do autor �(s�o) nulo(s)<<<");
		} 

		if (titulo.isEmpty() || autor.isEmpty()) {
			throw new TituloOuAutorVazioException(
			"--->Nome do titulo e/ou do autor �(s�o) vazio(s)<<<");
		}

		return true;
	}

	public Usuario buscaUsuarioPorNome(String nome)
	throws BuscaUsuarioComNomeVazioException,
	BuscaUsuarioComNomeNuloException {
		Usuario usuarioAchado = null;
		validateBuscaPorNome(nome);

		Iterator<Usuario> iter = _usuarios.iterator();
		while ((iter.hasNext() == true) && (usuarioAchado == null)) {
			Usuario usuario = (Usuario) iter.next();
			String oNome = usuario.getNome();
			if (oNome == nome) {
				usuarioAchado = usuario;
			}
		}
		return usuarioAchado;
	}

	public void validateBuscaPorNome(String nome)
	throws BuscaUsuarioComNomeVazioException,
	BuscaUsuarioComNomeNuloException {
		Usuario usuarioAchado = null;
		if ((nome == null)) {
			throw new BuscaUsuarioComNomeNuloException(
			"--->Nome do usu�rio � nulo<<<");
		}

		if (nome.isEmpty()) {
			throw new BuscaUsuarioComNomeVazioException(
			"--->Nome do usu�rio � vazio<<<");
		}
	}

	public void exibeLivrosDisponiveis() {
		System.out.println("Biblioteca: " + _nome);
		System.out.println(">>>Livros Dispon�veis para Empr�stimo<<<");

		if (_repositorioLivros.size() <= 0) {
			System.out.println("---> Nenhum livro no reposit�rio");
			System.out.println("<<< Livros Dispon�veis >>>");
			System.out.println();
			return;
		}

		getTitles();	
	}

	public void getTitles(){
		Iterator<Livro> iter = _repositorioLivros.iterator();
		while (iter.hasNext() == true) {
			Livro livro = (Livro) iter.next();
			if (livro.getUsuario() == null) {
				livro.exibe();
			}
		}
	}

	public void exibeLivrosEmprestados() {
		System.out.println("Biblioteca: " + _nome);
		System.out.println(">>>Livros Emprestados<<<");
		if (_repositorioLivros.size() <= 0) {
			System.out.println("---> Nenhum livro no reposit�rio");
			System.out.println("<<< Livros Emprestados >>>");
			System.out.println();
			return;
		}

		getTitles();
			
	}

	public void exibeUsuarios() {
		System.out.println("Biblioteca: " + _nome);
		System.out.println(">>>Usu�rios da Biblioteca<<<");
		if (_usuarios.size() <= 0) {
			System.out.println("---> Nenhum usu�rio na Biblioteca");
			System.out.println("<<< Usu�rios >>>");
			System.out.println();
		}

		getUsers();
	}

	public void getUsers(){
		Iterator<Usuario> iter = _usuarios.iterator();
		while (iter.hasNext() == true) {
			Usuario usuario = (Usuario) iter.next();
			usuario.exibe();
		}
	}

	private int getNrUnico() {
		// Assumo que cada livro recebe um nrUnico diferente
		return _nrUnico = _nrUnico + 1;
	}

	public int sizeRepositorioLivros() {
		return _repositorioLivros.size();
	}

	public int sizeUsuarios() {
		return _usuarios.size();
	}

	private String _nome;
	private int _nrUnico = 0; // _nrUnico > zero!
	private TreeSet<Livro> _repositorioLivros;
	private HashSet<Usuario> _usuarios;
}
