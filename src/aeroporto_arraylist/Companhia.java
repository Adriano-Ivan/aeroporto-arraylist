package aeroporto_arraylist;

import java.util.ArrayList;

public class Companhia {

	private String nome;
	private String fone;
	private ArrayList<Voo> listVoos;
	private int qtdeVoos;
	
	public Companhia() {
		this.listVoos = new ArrayList<Voo>();
		this.qtdeVoos = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public int getQtdeVoos() {
		return qtdeVoos;
	}

	public void setQtdeVoos(int qtdeVoos) {
		this.qtdeVoos = qtdeVoos;
	}
	
	public Voo getVoo(int posicao) {
		if(this.getQtdeVoos() - 1 >= posicao && posicao >= 0) {
			return this.listVoos.get(posicao);
		} else {
			System.out.println("N�o h� v�o na posicao indicada.");
		}
		return null;
	}
	
	// N�o h� limita��o de v�os
	public void setVoo(Voo v) {
		this.setQtdeVoos(this.getQtdeVoos() + 1);
		this.listVoos.add(v);
	}
}
