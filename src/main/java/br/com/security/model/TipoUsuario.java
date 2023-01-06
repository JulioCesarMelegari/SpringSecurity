package br.com.security.model;

public enum TipoUsuario {
	
	ADMINISTRADOR("administrador"),
	USUARIO("usuario"),
	ENTREGADOR("entregador");
	
	private String descrição;

	private TipoUsuario(String descrição) {
		this.descrição = descrição;
	}

	public String getDescrição() {
		return descrição;
	}	

}
