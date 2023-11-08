package br.com.fiap.filmesapi.data;

import java.sql.SQLException;
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
		
		filmes.add(filme1);
		filmes.add(filme2);
	}

	public List<Filme> findAll() throws SQLException {
		System.out.println("Obtendo conexão com banco de dados");
		var con = ConnectionFactory.getConnection();
		
		System.out.println("Selecionando todos os dados do banco de dados");
		var rs = con.createStatement().executeQuery("SELECT * FROM DB_FILMES");
		
		System.out.println("Fechando a conexão");
		con.close();

		System.out.println("Retornando filmes");
		return filmes;
	}

	public Filme findById(Long id) throws SQLException {
		System.out.println("Obtendo conexão com banco de dados");
		var con = ConnectionFactory.getConnection();
		
		System.out.println("Selecionando dados de filme que possui id "+ id +" do banco de dados");
		var rs = con.prepareStatement("SELECT * FROM DB_FILMES WHERE ID=?");
		
		rs.setLong(1, id);
		
		System.out.println("Fechando a conexão");
		con.close();
		
		System.out.println("Procurando filme por id");
		
		for(Filme filme : filmes) {
			if(id == filme.getId()) {
				System.out.println("Filme encontrado\nRetornando filme com o id " + filme.getId());
				return filme;
			}
		}
		
		System.out.println("Filme não encontrado...");
		return null;
	}

	public void create(Filme filme) throws SQLException {
		System.out.println("Obtendo conexão com banco de dados");
		var con = ConnectionFactory.getConnection();
		
		System.out.println("Criando novo filme");
		var rs = con.prepareStatement("INSERT INTO DB_FILMES VALUES (?, ?, ?, ?, ?)");
		
		rs.setLong(1, filme.getId());
		rs.setString(2, filme.getTitulo());
		rs.setString(3, filme.getSinopse());
		rs.setString(4, filme.getPoster());
		rs.setDouble(5, filme.getNota());
		
		System.out.println(
				"Adcionando novo filme:" +
				"\nID:" + filme.getId() +
				"\nTITULO:" + filme.getTitulo() +
				"\nSINOPSE:" + filme.getSinopse() +
				"\nPOSTER:" + filme.getPoster() +
				"\nNOTA:" + filme.getNota()
				);
		
		System.out.println("Fechando a conexão");
		con.close();
		
		filmes.add(filme);
	}

	public void update(Long id, Filme filme) throws SQLException {
		System.out.println("Obtendo conexão com banco de dados");
		var con = ConnectionFactory.getConnection();
		
		System.out.println("Atualizando filme cujo id é " + id);
		var rs = con.prepareStatement("UPDATE DB_FILMES SET TITULO=?, SINOPSE=?, POSTER=?, NOTA=? WHERE ID=?");
		
		rs.setString(1, filme.getTitulo());
		rs.setString(2, filme.getSinopse());
		rs.setString(3, filme.getPoster());
		rs.setDouble(4, filme.getNota());
		rs.setLong(5, filme.getId());
		
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
		
		System.out.println("Fechando a conexão");
		con.close();
	}

	public void delete(Long id) throws SQLException {
		System.out.println("Obtendo conexão com banco de dados");
		var con = ConnectionFactory.getConnection();
		
		System.out.println("Deletando filme que possui id " + id);
		var rs = con.prepareStatement("DELETE DB_FILMES WHERE ID=?");
		
		rs.setLong(1, id);
		
		var filme = findById(id);
		
		System.out.println(
				"Removendo o filme:" +
				"\nID:" + filme.getId() +
				"\nTITULO:" + filme.getTitulo() +
				"\nSINOPSE:" + filme.getSinopse() +
				"\nPOSTER:" + filme.getPoster() +
				"\nNOTA:" + filme.getNota()
				);
		filmes.remove(filme);
		
		System.out.println("Fechando a conexão");
		con.close();
	}

}
