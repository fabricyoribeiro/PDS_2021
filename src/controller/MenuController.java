package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.BaseDeDados;
import model.Cliente;
import view.MainScreen;
import view.TelaMenu;

public class MenuController implements ActionListener, CaretListener{
	
	//private MainScreen tela;
	private TelaMenu telaMenu;
	private SairHandler sairHandler;

	public MenuController(TelaMenu telaMenu) {
		this.telaMenu = telaMenu;
		sairHandler = new SairHandler();
		
		control();
	}
	
	private void control() {
		telaMenu.getClienteMenuItemCadastrar().addActionListener(this);
		telaMenu.getTemaMenuItem().addActionListener(this);
		telaMenu.getExitMenuItemCadastrar().addActionListener(this);
		telaMenu.getClienteMenuItemBuscar().addActionListener(this);
		telaMenu.getFestaMenuItemCadastrar().addActionListener(this);
		telaMenu.getTemaMenuitemBuscar().addActionListener(this);
		telaMenu.getSairMenuItem().addMouseListener(sairHandler);
		
		telaMenu.getFestaMenuItemBuscar().addActionListener(this);
	}	

	@Override
	public void caretUpdate(CaretEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==telaMenu.getFormularioCliente().getEnderecoButton()) {
			telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(true);
			telaMenu.getFormularioCliente().getCadastrarButton().setVisible(false);
		
		}
		if(e.getSource()==telaMenu.getClienteMenuItemCadastrar()) {
			telaMenu.getFormularioCliente().getCadastroL().setText("CADASTRAR CLIENTE");
			telaMenu.getFormularioCliente().getCpf().setEnabled(true);
			telaMenu.getFestaPanel().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getAtualizarButton().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getRemoverButton().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getCadastrarButton().setVisible(true);
			telaMenu.getTemaPanel().setVisible(false);
			telaMenu.getFormularioBuscarCliente().setVisible(false);
			telaMenu.getBuscarTemaPanel().setVisible(false);
			telaMenu.getFormularioCliente().setVisible(true);
			telaMenu.getBuscarFestaPanel().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(true);
			
			limparCampos();
		}
		if(e.getSource()==telaMenu.getTemaMenuitemBuscar()) {
			telaMenu.getFormularioCliente().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
			telaMenu.getFestaPanel().setVisible(false);
			telaMenu.getFormularioBuscarCliente().setVisible(false);
			telaMenu.getTemaPanel().setVisible(false);
			telaMenu.getBuscarFestaPanel().setVisible(false);
			telaMenu.getBuscarTemaPanel().setVisible(true);
		}
		
		if(e.getSource()==telaMenu.getTemaMenuItem()) {
			telaMenu.getTemaPanel().getTemaLabel().setText("CADASTRAR TEMA");
			telaMenu.getTemaPanel().getNomeF().setText("");
			telaMenu.getTemaPanel().getValorF().setText("");
			telaMenu.getTemaPanel().getCorF().setText("");
			telaMenu.getFormularioCliente().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
			telaMenu.getFestaPanel().setVisible(false);
			telaMenu.getFormularioBuscarCliente().setVisible(false);
			telaMenu.getBuscarTemaPanel().setVisible(false);
			telaMenu.getTemaPanel().getButtonPanel().getCadastrarButton().setVisible(true);
			telaMenu.getTemaPanel().getButtonPanel().getRemoverButton().setVisible(false);
			telaMenu.getTemaPanel().getButtonPanel().getAtualizarButton().setVisible(false);
			telaMenu.getBuscarFestaPanel().setVisible(false);
			telaMenu.getTemaPanel().setVisible(true);
		}
		
		//ZANELLI
		if(e.getSource()==telaMenu.getExitMenuItemCadastrar()) {
			telaMenu.getFormularioCliente().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
			telaMenu.getTemaPanel().setVisible(false);
			telaMenu.getBuscarFestaPanel().setVisible(false);

			//FALTA IMPLEMENTAR A FESTA PARA COMPLETAR ESSE IF
		}
		
		//ZANELLI
		if(e.getSource()==telaMenu.getClienteMenuItemBuscar()) {
			telaMenu.getFormularioCliente().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
			telaMenu.getTemaPanel().setVisible(false);
			telaMenu.getFestaPanel().setVisible(false);
			telaMenu.getBuscarTemaPanel().setVisible(false);
			telaMenu.getBuscarFestaPanel().setVisible(false);
			telaMenu.getFormularioBuscarCliente().getBuscarClienteLabel().setText("BUSCAR CLIENTE");			
			telaMenu.getFormularioBuscarCliente().setVisible(true);
		}
		
		if(e.getSource()==telaMenu.getFestaMenuItemCadastrar()) {
			telaMenu.getFormularioCliente().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
			telaMenu.getFormularioBuscarCliente().setVisible(false);
			telaMenu.getBuscarTemaPanel().setVisible(false);
			telaMenu.getTemaPanel().setVisible(false);
			telaMenu.getBuscarFestaPanel().setVisible(false);
			
			telaMenu.getFestaPanel().getTemas().removeAllElements();
			telaMenu.getFestaPanel().getTemas().addAll(BaseDeDados.getTemas());
			
			telaMenu.getFestaPanel().setVisible(true);
			
		}

		if(e.getSource()==telaMenu.getFestaMenuItemBuscar()) {
			telaMenu.getFormularioCliente().setVisible(false);
			telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
			telaMenu.getFormularioBuscarCliente().setVisible(false);
			telaMenu.getBuscarTemaPanel().setVisible(false);
			telaMenu.getTemaPanel().setVisible(false);
			telaMenu.getFestaPanel().setVisible(false);
			
			telaMenu.getFestaPanel().getTemas().removeAllElements();
			telaMenu.getFestaPanel().getTemas().addAll(BaseDeDados.getTemas());
			
			telaMenu.getBuscarFestaPanel().setVisible(true);
		}
	}
	
	private void limparCampos() {
		telaMenu.getFormularioCliente().getNome().setText("");
		telaMenu.getFormularioCliente().getCpf().setText("");
		telaMenu.getFormularioCliente().getEmail().setText("");
		telaMenu.getFormularioCliente().getTelefoneF().setText("");
		telaMenu.getFormularioCliente().getRgField().setText("");
		
		telaMenu.getFormularioCliente().getEnderecoPanel().getRuaF().setText("");
		telaMenu.getFormularioCliente().getEnderecoPanel().getNumeroF().setText("");
		telaMenu.getFormularioCliente().getEnderecoPanel().getBairroF().setText("");
		telaMenu.getFormularioCliente().getEnderecoPanel().getCidadeF().setText("");
		telaMenu.getFormularioCliente().getEnderecoPanel().getEstadoF().setText("");
		telaMenu.getFormularioCliente().getEnderecoPanel().getCepF().setText("");
	}
	
	private class SairHandler extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==telaMenu.getSairMenuItem()) {
				sair();
			}
		}
		
	}
	
	private void sair() {
		Object[] options = {"Sim", "Não"};
		int opcao = JOptionPane.showOptionDialog(null, "Deseja sair?", "Fechar sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (opcao == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}

}
