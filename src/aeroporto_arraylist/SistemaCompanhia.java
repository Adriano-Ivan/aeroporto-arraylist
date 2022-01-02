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
			System.out.println("[3] Cadastrar v�o");
			System.out.println("[4] Listar v�os");
			System.out.println("[5] Cadastrar passageiro");
			System.out.println("[6] Listar passageiros em um determinado v�o");
			System.out.println("[7] Exibir a quantidade de assentos livres em um determinado v�o");
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
			System.out.println("QUANTIDADE DE V�OS: " + listCompanhias.get(i).getQtdeVoos());
			System.out.println("----------------------");
		}
	}
	
	public void cadastrarVoo() {
		try {
			System.out.println("O v�o � de qual companhia ? (Digite o n�mero)");
			this.listarCompanhias();
			System.out.println("\nN�MERO: ");
			int nVoo = Integer.parseInt(reader.readLine());
			
			if(nVoo < this.getNumeroCompanhias() && nVoo >= 0) {
				Voo voo = new Voo();
				System.out.println("N�MERO DO V�O:");
				voo.setNumeroVoo(Integer.parseInt(reader.readLine()));
				System.out.println("DESTINO DO V�O");
				voo.setDestinoVoo(reader.readLine());
				System.out.println("A DATA DO V�O");
				voo.setData(reader.readLine());
				
				listCompanhias.get(nVoo).setVoo(voo);
				System.out.println("V�O CADASTRADO !");
			} else {
				System.out.println("Valor inv�lido.");
			}
		} catch(Exception e) {
			System.out.println("ERRO.");
		}
	}
	
	public void listarVoos(String forma, int indice) {
		System.out.println("V�OS");
		System.out.println("------------------------");
		
		if(forma.equals("tudo")) {
			for(int i = 0; i < this.getNumeroCompanhias(); i++) {
				System.out.println("------------------------");
				System.out.println("COMPANHIA " + i);
				for(int l = 0; l < this.listCompanhias.get(i).getQtdeVoos(); l++) {
					System.out.println("------------------------");
					System.out.println("N�MERO DO V�O: " + listCompanhias.get(i).getVoo(l).getNumeroVoo());
					System.out.println("DESTINO DO V�O: " + listCompanhias.get(i).getVoo(l).getDestinoVoo());
					System.out.println("N�MERO DO V�O:" + listCompanhias.get(i).getVoo(l).getData());
					System.out.println("QUANTIDADE DE PASSAGEIROS: " + listCompanhias.get(i).getVoo(l).getnPassageiros());
					System.out.println("------------------------");
				}
			}
		} else if(forma.equals("particular")) {
			for(int l = 0; l < this.listCompanhias.get(indice).getQtdeVoos(); l++) {
				System.out.println("V�O " + l);
				System.out.println("------------------------");
				System.out.println("N�MERO DO V�O: " + this.listCompanhias.get(indice).getVoo(l).getNumeroVoo());
				System.out.println("DESTINO DO V�O: " + this.listCompanhias.get(indice).getVoo(l).getDestinoVoo());
				System.out.println("N�MERO DO V�O:" + this.listCompanhias.get(indice).getVoo(l).getData());
				System.out.println("QUANTIDADE DE PASSAGEIROS: " + this.listCompanhias.get(indice).getVoo(l).getnPassageiros());
				System.out.println("------------------------");
			}
		}
	}
	
	public void cadastrarPassageiro() {
		try {
			System.out.println("Qual companhia a�rea o passageiro escolheu ? (Digite o primeiro n�mero)");
			this.listarCompanhias();
			System.out.println("\nN�MERO: ");
			int cVoo = Integer.parseInt(reader.readLine());
			
			System.out.println("Qual v�o ? (Digite o primeiro n�mero)");
			this.listarVoos("particular", cVoo);
			System.out.println("\nN�MERO: ");
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
				System.out.println("Valor inv�lido.");
			}
		} catch(Exception e) {
			System.out.println("ERRO.");
		}
	}
	
	public void listarPassageiros() {
		try {
			System.out.println("De qual companhia � o v�o ? (Digite o primeiro n�mero)");
			this.listarCompanhias();
			System.out.println("\nN�MERO: ");
			int c = Integer.parseInt(reader.readLine());
			
			System.out.println("Qual v�o ? (Digite o primeiro n�mero)");
			this.listarVoos("particular", c);
			System.out.println("\nN�MERO: ");
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
			System.out.println("QUAL COMPANHIA ? (Digite o primeiro n�mero)");
			this.listarCompanhias();
			System.out.println("\nN�MERO: ");
			int c = Integer.parseInt(reader.readLine());
			
			System.out.println("QUAL V�O ? (Digite o primeiro n�mero)");
			this.listarVoos("particular", c);
			System.out.println("\nN�MERO: ");
			int v = Integer.parseInt(reader.readLine());
			
			System.out.println("O v�o " + v + ", da companhia " + c + ", tem " + listCompanhias.get(c).getVoo(v).getAssentosLivres() + " assentos livres");
		} catch(Exception e) {
			System.out.println("ERRO.");
		}
	}
}
