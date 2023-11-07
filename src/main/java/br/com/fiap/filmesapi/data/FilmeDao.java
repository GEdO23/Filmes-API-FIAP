package br.com.fiap.filmesapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.filmesapi.model.Filme;

public class FilmeDao {
	
	List<Filme> filmes = new ArrayList<>();
	
	public FilmeDao() {
		var filme1 = new Filme(
				1L, 
				"Lost", 
				"Todos morreram...", 
				"http..",
				4.0
			);
		var filme2 = new Filme(
				2L, 
				"Os outros", 
				"Todos brigam...", 
				"http..",
				5.0
			);
		var filme3 = new Filme(
				3L, 
				"Os outros 2", 
				"Todos brigam... de novo", 
				"http..",
				2.0
			);
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
	}

	public List<Filme> findAll() {
		System.out.println("Exibindo todos os filmes no banco de dados");
		return filmes;
	}

	public Filme findById(Long id) {
		System.out.println("Procurando filme por id");
		
		for(Filme filme : filmes) {
			if(filme.getId() == id) {
				System.out.println("Filme encontrado\nRetornando filme com o id " + filme.getId());
				return filme;
			}
		} 
		System.out.println("Filme não encontrado...");
		return null;
	}

	public void create(Filme filme) {
		System.out.println(
				"Adcionando novo filme:" +
				"\nID:" + filme.getId() +
				"\nTITULO:" + filme.getTitulo() +
				"\nSINOPSE:" + filme.getSinopse() +
				"\nPOSTER:" + filme.getPoster() +
				"\nNOTA:" + filme.getNota()
				);
		filmes.add(filme);
	}

	public void update(Long id, Filme filme) {
		filme.setId(id);
		Filme filmeEncontrado = findById(id);
		System.out.println(
				"Atualizando informações do filme:" +
				"\nID:" + filmeEncontrado.getId() +
				"\nTITULO:" + filmeEncontrado.getTitulo() +
				"\nSINOPSE:" + filmeEncontrado.getSinopse() +
				"\nPOSTER:" + filmeEncontrado.getPoster() +
				"\nNOTA:" + filmeEncontrado.getNota() +
				"\nPara:" +
				"\nID:" + filme.getId() +
				"\nTITULO:" + filme.getTitulo() +
				"\nSINOPSE:" + filme.getSinopse() +
				"\nPOSTER:" + filme.getPoster() +
				"\nNOTA:" + filme.getNota()
				);
		filmeEncontrado = filme;
	}

	public void delete(Filme filme) {
		System.out.println(
				"Removendo o filme:" +
				"\nID:" + filme.getId() +
				"\nTITULO:" + filme.getTitulo() +
				"\nSINOPSE:" + filme.getSinopse() +
				"\nPOSTER:" + filme.getPoster() +
				"\nNOTA:" + filme.getNota()
				);
		filmes.remove(filme);
	}

}
