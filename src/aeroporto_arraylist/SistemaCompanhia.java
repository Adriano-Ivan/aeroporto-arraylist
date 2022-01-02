package aeroporto_arraylist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SistemaCompanhia {

	private ArrayList<Companhia> listCompanhias;
	private BufferedReader reader;
	private int numeroCompanhias;
	
	public SistemaCompanhia() throws Exception {
		this.listCompanhias = new ArrayList<Companhia>();
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.numeroCompanhias = 0;
		this.menu();
	}
	
	private void setNumeroCompanhias(int numero) {
		this.numeroCompanhias = numero;
	}
	
	private int getNumeroCompanhias() {
		return this.numeroCompanhias;
	}
	
	public void menu() throws Exception{
		String opcao = "";
		while(!opcao.equals("8")){
			System.out.println("\n-------------------------");
			System.out.println("[1] Cadastrar nova companhia");
			System.out.println("[2] Listar companhias");
			System.out.println("[3] Cadastrar vôo");
			System.out.println("[4] Listar vôos");
			System.out.println("[5] Cadastrar passageiro");
			System.out.println("[6] Listar passageiros em um determinado vôo");
			System.out.println("[7] Exibir a quantidade de assentos livres em um determinado vôo");
			opcao = this.reader.readLine();
			
			if(opcao.equals("1")){
				this.cadastrarCompanhia();
			}else if(opcao.equals("2")){
				this.listarCompanhias();
			}else if(opcao.equals("3")){
				this.cadastrarVoo();
			}else if(opcao.equals("4")){
				this.listarVoos("tudo",0);
			} else if(opcao.equals("5")){
				this.cadastrarPassageiro();
			} else if(opcao.equals("6")){
				this.listarPassageiros();
			} else if(opcao.equals("7")){
				this.mostrarNumeroDeAssentos();
			} else if(opcao.equals("8")){
				System.out.println("Encerrando...");
			}else {
				System.out.println("Opcao invalida...");
			}
		}
	}
	
	private void cadastrarCompanhia() throws Exception{
		Companhia companhia = new Companhia();
		System.out.println("Digite o nome da companhia:");
		companhia.setNome(this.reader.readLine());
		System.out.println("Digite o telefone da companhia: ");
		companhia.setFone(this.reader.readLine());
		this.listCompanhias.add(companhia);
		this.setNumeroCompanhias(this.getNumeroCompanhias() + 1);
	}
	
	private void listarCompanhias() {
		System.out.println("COMPANHIAS");
		System.out.println("-----------------------");
		for(int i = 0; i < this.getNumeroCompanhias(); i++) {
			System.out.println("----------------------");
			System.out.println("COMPANHIA " + i);
			System.out.println("NOME: " + listCompanhias.get(i).getNome());
			System.out.println("TELEFONE: " + listCompanhias.get(i).getFone());
			System.out.println("QUANTIDADE DE VÔOS: " + listCompanhias.get(i).getQtdeVoos());
			System.out.println("----------------------");
		}
	}
	
	public void cadastrarVoo() {
		try {
			System.out.println("O vôo é de qual companhia ? (Digite o número)");
			this.listarCompanhias();
			System.out.println("\nNÚMERO: ");
			int nVoo = Integer.parseInt(reader.readLine());
			
			if(nVoo < this.getNumeroCompanhias() && nVoo >= 0) {
				Voo voo = new Voo();
				System.out.println("NÚMERO DO VÔO:");
				voo.setNumeroVoo(Integer.parseInt(reader.readLine()));
				System.out.println("DESTINO DO VÔO");
				voo.setDestinoVoo(reader.readLine());
				System.out.println("A DATA DO VÔO");
				voo.setData(reader.readLine());
				
				listCompanhias.get(nVoo).setVoo(voo);
				System.out.println("VÔO CADASTRADO !");
			} else {
				System.out.println("Valor inválido.");
			}
		} catch(Exception e) {
			System.out.println("ERRO.");
		}
	}
	
	public void listarVoos(String forma, int indice) {
		System.out.println("VÔOS");
		System.out.println("------------------------");
		
		if(forma.equals("tudo")) {
			for(int i = 0; i < this.getNumeroCompanhias(); i++) {
				System.out.println("------------------------");
				System.out.println("COMPANHIA " + i);
				for(int l = 0; l < this.listCompanhias.get(i).getQtdeVoos(); l++) {
					System.out.println("------------------------");
					System.out.println("NÚMERO DO VÔO: " + listCompanhias.get(i).getVoo(l).getNumeroVoo());
					System.out.println("DESTINO DO VÔO: " + listCompanhias.get(i).getVoo(l).getDestinoVoo());
					System.out.println("NÚMERO DO VÔO:" + listCompanhias.get(i).getVoo(l).getData());
					System.out.println("QUANTIDADE DE PASSAGEIROS: " + listCompanhias.get(i).getVoo(l).getnPassageiros());
					System.out.println("------------------------");
				}
			}
		} else if(forma.equals("particular")) {
			for(int l = 0; l < this.listCompanhias.get(indice).getQtdeVoos(); l++) {
				System.out.println("VÔO " + l);
				System.out.println("------------------------");
				System.out.println("NÚMERO DO VÔO: " + this.listCompanhias.get(indice).getVoo(l).getNumeroVoo());
				System.out.println("DESTINO DO VÔO: " + this.listCompanhias.get(indice).getVoo(l).getDestinoVoo());
				System.out.println("NÚMERO DO VÔO:" + this.listCompanhias.get(indice).getVoo(l).getData());
				System.out.println("QUANTIDADE DE PASSAGEIROS: " + this.listCompanhias.get(indice).getVoo(l).getnPassageiros());
				System.out.println("------------------------");
			}
		}
	}
	
	public void cadastrarPassageiro() {
		try {
			System.out.println("Qual companhia aérea o passageiro escolheu ? (Digite o primeiro número)");
			this.listarCompanhias();
			System.out.println("\nNÚMERO: ");
			int cVoo = Integer.parseInt(reader.readLine());
			
			System.out.println("Qual vôo ? (Digite o primeiro número)");
			this.listarVoos("particular", cVoo);
			System.out.println("\nNÚMERO: ");
			int nVoo = Integer.parseInt(reader.readLine());
			
			if(cVoo < this.getNumeroCompanhias() && cVoo >= 0 && nVoo < this.listCompanhias.get(cVoo).getQtdeVoos() && nVoo >= 0) {
				Passageiro p = new Passageiro();
				System.out.println("NOME DO PASSAGEIRO: ");
				p.setNome(reader.readLine());
				System.out.println("ID DA PASSAGEM: ");
				p.setIdPassagem(reader.readLine());
				System.out.println("PASSAPORTE: ");
				p.setPassaporte(reader.readLine());
				System.out.println("CPF: ");
				p.setCpf(reader.readLine());
				
				this.listCompanhias.get(cVoo).getVoo(nVoo).setPassageiro(p);
				System.out.println("PASSAGEIRO CADASTRADO !");
			} else {
				System.out.println("Valor inválido.");
			}
		} catch(Exception e) {
			System.out.println("ERRO.");
		}
	}
	
	public void listarPassageiros() {
		try {
			System.out.println("De qual companhia é o vôo ? (Digite o primeiro número)");
			this.listarCompanhias();
			System.out.println("\nNÚMERO: ");
			int c = Integer.parseInt(reader.readLine());
			
			System.out.println("Qual vôo ? (Digite o primeiro número)");
			this.listarVoos("particular", c);
			System.out.println("\nNÚMERO: ");
			int v = Integer.parseInt(reader.readLine());
			
			for(int i = 0; i < listCompanhias.get(c).getVoo(v).getnPassageiros(); i++) {
				Passageiro aux = listCompanhias.get(c).getVoo(v).getPassageiro(i);
				System.out.println("------------------");
				System.out.println("PASSAGEIRO " + i);
				System.out.println("NOME: " + aux.getNome());
				System.out.println("ID DA PASSAGEM: " + aux.getIdPassagem());
				System.out.println("PASSAPORTE: " + aux.getPassaporte());
				System.out.println("CPF: " + aux.getCpf());
				System.out.println("------------------");
			}
		} catch(Exception e) {
			System.out.println("ERRO.");
		}
	}
	
	private void mostrarNumeroDeAssentos() {
		try {
			System.out.println("QUAL COMPANHIA ? (Digite o primeiro número)");
			this.listarCompanhias();
			System.out.println("\nNÚMERO: ");
			int c = Integer.parseInt(reader.readLine());
			
			System.out.println("QUAL VÔO ? (Digite o primeiro número)");
			this.listarVoos("particular", c);
			System.out.println("\nNÚMERO: ");
			int v = Integer.parseInt(reader.readLine());
			
			System.out.println("O vôo " + v + ", da companhia " + c + ", tem " + listCompanhias.get(c).getVoo(v).getAssentosLivres() + " assentos livres");
		} catch(Exception e) {
			System.out.println("ERRO.");
		}
	}
}
