package aeroporto_arraylist;

import java.util.ArrayList;

public class Voo {

	private int numeroVoo;
	private String destinoVoo;
	private String data;
	private ArrayList<Passageiro> listPassageiros;
	private int assentosLivres;
	private int nPassageiros;
	
	public Voo() {
		this.listPassageiros = new ArrayList<Passageiro>();
		assentosLivres = 20;
		nPassageiros = 0;
	}

	public int getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(int numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public String getDestinoVoo() {
		return destinoVoo;
	}

	public void setDestinoVoo(String destinoVoo) {
		this.destinoVoo = destinoVoo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getAssentosLivres() {
		return assentosLivres;
	}

	private void setAssentosLivres(int assentosLivres) {
		this.assentosLivres = assentosLivres;
	}

	public int getnPassageiros() {
		return nPassageiros;
	}

	public void setnPassageiros(int nPassageiros) {
		this.nPassageiros = nPassageiros;
	}
	
	public Passageiro getPassageiro(int posicao) {
		if(this.getnPassageiros() - 1 >= posicao && posicao >= 0) {
			return this.listPassageiros.get(posicao);
		} else {
			System.out.println("Não há passageiro na posicao indicada.");
		}
		return null;
	}
	
	public void setPassageiro(Passageiro passageiro) {
		if(this.getAssentosLivres() > 0) {
			this.listPassageiros.add(passageiro);
			this.setAssentosLivres(this.getAssentosLivres() - 1);
			this.setnPassageiros(this.getnPassageiros() + 1);
		} else {
			System.out.println("Não há assentos disponíveis.");
		}
	}
}
