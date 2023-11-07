package br.com.fiap.filmesapi.model;

public class Filme {
	private Long id;
	private String titulo;
	private String sinopse;
	private String poster;
	private Double nota;
	
	public Filme() {}
	
	public Filme(Long id, String titulo, String sinopse, String poster, Double nota) {
		this.id = id;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.poster = poster;
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public String getPoster() {
		return poster;
	}

	public Double getNota() {
		return nota;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
}
