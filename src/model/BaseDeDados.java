package model;

import java.util.ArrayList;

import methods.Validador;
import view.Mensagem;

public class BaseDeDados {
	
	private static ArrayList<Cliente> clientes;
	private static ArrayList<Festa> festas;
	private static ArrayList<Tema> temas;
	
	public static void inicializarBaseDeDados() {
		clientes = new ArrayList<Cliente>();
		festas = new ArrayList<Festa>();
		temas = new ArrayList<Tema>();
		System.out.println("Base iniciada!");
	}

	public static Cliente buscarCliente(String cpf) 
	{
		for (Cliente cliente_1 : clientes) {
			if (cliente_1.getCpf().equals(cpf)) {
				return cliente_1;
			}
		}
		return null;
	}
	public static Festa buscarFesta(Festa festa){
		for (Festa festa_1 : festas) {
			if (festa_1.equals(festa)) {
				return festa_1;
			}
		}
		return null;
	}
	public static Festa buscarFesta(String cpf){
		for (Festa festa_1 : festas) {
			if (festa_1.getCliente().getCpf().equals(cpf)) {
				return festa_1;
			}
		}
		return null;
	}
	
	public static Tema buscarTema(Tema tema){
		for (Tema tema_1 : temas) {
			if (tema_1.equals(tema)) {
				return tema_1;
			}
		}
		return null;
	}
	
	public static Tema buscarTema(String nome)
	{
		for (Tema tema_1 : temas) {
			if (tema_1.getNome().equals(nome)) {
				return tema_1;
			}		
		}
		return null;
	}
	
	public static Cliente buscarCliente(Cliente cliente) throws ClienteException {
		for (Cliente cliente_1 : clientes) {
			if (cliente_1.equals(cliente)) {
				return cliente_1;
			}
		}
		throw new ClienteException(TipoErro.NAO_EXISTE_CLIENTE);
	}
	
	public static boolean isCliente(Cliente cliente) {
		return clientes.contains(buscarCliente(cliente.getCpf()));
			
	}
	public static boolean isFesta(Festa festa) {
		return festas.contains(buscarFesta(festa));
			
	}
	public static boolean isTema(Tema tema) {
		return temas.contains(buscarTema(tema));
			
	}
	public static boolean adicionarCliente(Cliente cliente) throws ClienteException, CPFException {
		if (cliente == null) {
	 		throw new ClienteException(TipoErro.NULL_CLIENTE);
		} else if (!isCliente(cliente)) {
			if (Validador.validarCPF(cliente.getCpf())) {
				Mensagem.exibirMensagem("Cliente adicionado com sucesso");
				return clientes.add(cliente);
			}
		}
			return false;
	}
	public static boolean adicionarFesta(Festa festa) throws FestaException {
		if (festa == null) {
			throw new FestaException(TipoErro.NULL_FESTA);
		} else if (!isFesta(festa)) {
				Mensagem.exibirMensagem("Festa adicionada com sucesso");
				return festas.add(festa);
			} else {
				throw new FestaException(TipoErro.EXISTE_FESTA);
			}
	}
	
	public static boolean adicionarTema(Tema tema) throws TemaException {
		if (tema == null) {
			throw new TemaException(TipoErro.NULL_TEMA); 
		} else if (buscarTema(tema.getNome()) == null) {
				Mensagem.exibirMensagem("Tema adicionado com sucesso");
				return temas.add(tema);
			} else {
				
				throw new TemaException(TipoErro.EXISTE_TEMA);
			}
	}
		
	public static boolean atualizarCliente(Cliente ClienteOld, Cliente ClienteNew) throws ClienteException{
		if(ClienteOld!=null && ClienteNew!=null) {
			if (isCliente(ClienteNew)) {
				clientes.set(clientes.indexOf(buscarCliente(ClienteOld.getCpf())), ClienteNew);
				Mensagem.exibirMensagem("Cliente atualizado com sucesso");
		        return true;
			}else {
				throw new ClienteException(TipoErro.NAO_EXISTE_CLIENTE);
			}	
		}else {
			throw new ClienteException(TipoErro.NULL_CLIENTE);
		}
	}
	public static boolean atualizarFesta(Festa festaOld, Festa festaNew) throws FestaException{
		if(festaOld!=null && festaNew!=null) {
			if (!isFesta(festaNew)) {
				festas.set(festas.indexOf(buscarFesta(festaOld)), festaNew);
				return true;
			}else {
				throw new FestaException(TipoErro.EXISTE_FESTA);
			}
		}else {
			throw new FestaException(TipoErro.NULL_FESTA);
		}
	}
	
	public static boolean atualizarTema(Tema temaOld, Tema temaNew) throws TemaException{
		if(temaOld!=null && temaNew!=null) {
			if (!isTema(temaNew)) {
				temas.set(temas.indexOf(buscarTema(temaOld.getNome())), temaNew);
				return true;
			}else {
				throw new TemaException(TipoErro.EXISTE_TEMA); 
			}
		}else {
			System.out.println(temaNew.getNome());
			System.out.println(temaOld.getNome());
			throw new TemaException(TipoErro.NULL_FESTA);
		}
	}
	public static boolean removerCliente(Cliente cliente) throws ClienteException {
		if (cliente != null) {
			if(isCliente(cliente)) {
				return clientes.remove(cliente);
			}
		}
		throw new ClienteException(TipoErro.NAO_EXISTE_CLIENTE);
	}
	public static boolean removerFesta(Festa festa) throws FestaException {
		if (festa != null) {
			if(isFesta(festa)) {
				return festas.remove(festa);
			}
		}
		throw new FestaException(TipoErro.NAO_EXISTE_FESTA);
	}
	
	public static boolean removerTema(Tema tema) throws TemaException {
		if (tema != null) {
			if(isTema(tema)) {
				return temas.remove(tema);
			}
		}
		throw new TemaException(TipoErro.NAO_EXISTE_TEMA); 
	}

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static ArrayList<Festa> getFestas() {
		return festas;
	}
	
	public static ArrayList<Tema> getTemas() {
		return temas;
	}
	
}
