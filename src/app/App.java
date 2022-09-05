package app;

import java.util.Calendar;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.ControllerGeral;
import controller.MenuController;
import model.BaseDeDados;
import model.CPFException;
import model.Cliente;
import model.ClienteException;
import model.Endereco;
import model.Festa;
import model.FestaException;
import model.Tema;
import model.TemaException;
import view.EnderecoPanel;
import view.TelaMenu;

public class App {
	public static void main(String[] args) throws TemaException, FestaException {
		Endereco endereco = new Endereco("rua das flores", "1","barroso", "Serra Talhada","PE","44456670");
		Calendar data = Calendar.getInstance();
		data.set(2021, 8, 5);
		Cliente cliente1 = new Cliente("edu","381.647.600-72", "0011100011",endereco, "edu@gmail", "88888888", data);
		Tema tema = new Tema("FANTASIA", 22, "Azul");
		Festa festa = new Festa(cliente1, tema, endereco, Calendar.getInstance(), "18:00", "5:00", 33);
		
		BaseDeDados.inicializarBaseDeDados();
		
		try {
			BaseDeDados.adicionarCliente(cliente1);
			BaseDeDados.adicionarTema(tema);
			BaseDeDados.adicionarFesta(festa);
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CPFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDeDados.getClientes();
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		new ControllerGeral();
		
	}

}