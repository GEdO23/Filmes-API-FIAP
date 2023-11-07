package br.com.fiap.filmesapi.service;

import java.util.List;

import br.com.fiap.filmesapi.data.FilmeDao;
import br.com.fiap.filmesapi.model.Filme;

public class FilmeService {
	
	FilmeDao dao = new FilmeDao();

	public List<Filme> findAll() {
		return dao.findAll();
	}

	public Filme findById(Long id) {
		return dao.findById(id);
	}
	
	private boolean validar(Filme filme) {
		if (filme.getTitulo().isEmpty()) return false;
		if (filme.getNota() < 0 || filme.getNota() > 5) return false;
		if (filme.getSinopse().length() < 10) return false;
		if (!filme.getPoster().startsWith("http")) return false;
		
		System.out.println("Dados validados com sucesso");
		return true;
	}

	public boolean create(Filme filme) {
		if (!validar(filme)) return false;
		
		dao.create(filme);
		System.out.println("Filme adcionado com sucesso!");
		return true;
	}

	public boolean update(Long id, Filme filme) {
		if (!validar(filme)) return false;
		
		dao.update(id, filme);
		System.out.println("Filme atualizado com sucesso!");
		return true;
		
	}

	public void delete(Filme filme) {
		dao.delete(filme);
		System.out.println("Filme removido com sucesso!");
	}
	
	
	
	
	
	
	
	
	
	
	

}
