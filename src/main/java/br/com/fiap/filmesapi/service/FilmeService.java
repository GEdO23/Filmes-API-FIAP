package br.com.fiap.filmesapi.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.filmesapi.data.FilmeDao;
import br.com.fiap.filmesapi.model.Filme;

public class FilmeService {
	
	FilmeDao dao = new FilmeDao();

	public List<Filme> findAll() throws SQLException {
		return dao.findAll();
	}

	public Filme findById(Long id) throws SQLException {
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

	public boolean create(Filme filme) throws SQLException {
		if (!validar(filme)) return false;
		
		dao.create(filme);
		System.out.println("Filme adcionado com sucesso!");
		return true;
	}

	public boolean update(Long id, Filme filme) throws SQLException {
		if (!validar(filme)) return false;
		
		dao.update(id, filme);
		System.out.println("Filme atualizado com sucesso!");
		return true;
		
	}

	public void delete(Long id) throws SQLException {
		dao.delete(id);
		System.out.println("Filme removido com sucesso!");
	}
	
	
	
	
	
	
	
	
	
	
	

}
