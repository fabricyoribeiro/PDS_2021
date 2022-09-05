package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.BaseDeDados;
import model.CPFException;
import model.Cliente;
import model.ClienteException;
import model.Endereco;
import model.TipoErro;
import view.Mensagem;
import view.TelaMenu;

public class ClienteController implements ActionListener{
	
	private FormularioHandler formularioHandler;
	private TelaMenu telaMenu;



	public ClienteController(TelaMenu telaMenu) {
		this.formularioHandler = new FormularioHandler();
		this.telaMenu = telaMenu;

		control();
	}
	
	private void control() {
		telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getCadastrarButton().addActionListener(this);;
		telaMenu.getFormularioBuscarCliente().getBuscarClienteButton().addActionListener(this);
		telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getRemoverButton().addActionListener(this);
		telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getAtualizarButton().addActionListener(this);
		telaMenu.getFormularioCliente().getCpf().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getTelefoneF().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getEmail().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getNome().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getEnderecoPanel().getRuaF().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getEnderecoPanel().getNumeroF().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getEnderecoPanel().getBairroF().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getEnderecoPanel().getCidadeF().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getEnderecoPanel().getEstadoF().addCaretListener(formularioHandler);
		telaMenu.getFormularioCliente().getEnderecoPanel().getCepF().addCaretListener(formularioHandler);

	}
	
	
	private Cliente novoCliente() {
		Endereco endereco = new Endereco(telaMenu.getFormularioCliente().getEnderecoPanel().getRuaF().getText(), 
				telaMenu.getFormularioCliente().getEnderecoPanel().getNumeroF().getText(), 
				telaMenu.getFormularioCliente().getEnderecoPanel().getBairroF().getText(), 
				telaMenu.getFormularioCliente().getEnderecoPanel().getCidadeF().getText(), 
				telaMenu.getFormularioCliente().getEnderecoPanel().getEstadoF().getText(), 
				telaMenu.getFormularioCliente().getEnderecoPanel().getCepF().getText());

		return new Cliente(telaMenu.getFormularioCliente().getNome().getText(),
				telaMenu.getFormularioCliente().getCpf().getText(),
				telaMenu.getFormularioCliente().getRgField().getText(),
				endereco, 
				telaMenu.getFormularioCliente().getEmail().getText(), 
				telaMenu.getFormularioCliente().getTelefoneF().getText(), 
				Calendar.getInstance());
	}

	private boolean cadastrarCliente() {
		try {

			BaseDeDados.adicionarCliente(novoCliente());
			return true;

		} catch (ClienteException | CPFException e) {
			Mensagem.exibirMensagem(TipoErro.EXISTE_CLIENTE);
			e.printStackTrace();
		}
		return false;
	}

	private class FormularioHandler implements FocusListener, CaretListener{

		@Override
		public void caretUpdate(CaretEvent e) {
			if( !(telaMenu.getFormularioCliente().getCpf().getText().equals("   .   .   -  "))
					&& !(telaMenu.getFormularioCliente().getTelefoneF().getText().equals("(  )     -    "))
					&& telaMenu.getFormularioCliente().getEmail().getText().length()!=0
					&& telaMenu.getFormularioCliente().getEnderecoPanel().getRuaF().getText().length()!=0
					&& telaMenu.getFormularioCliente().getEnderecoPanel().getNumeroF().getText().length()!=0
					&& telaMenu.getFormularioCliente().getEnderecoPanel().getBairroF().getText().length()!=0
					&& telaMenu.getFormularioCliente().getEnderecoPanel().getCidadeF().getText().length()!=0
					&& telaMenu.getFormularioCliente().getEnderecoPanel().getEstadoF().getText().length()!=0
					&& !(telaMenu.getFormularioCliente().getEnderecoPanel().getCepF().getText().equals("     -   "))
					&& telaMenu.getFormularioCliente().getNome().getText().length()!=0) {
				telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getCadastrarButton().setEnabled(true);
			}else {
				telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getCadastrarButton().setEnabled(false);
			}

		}

		@Override
		public void focusGained(FocusEvent e) {

		}

		@Override
		public void focusLost(FocusEvent e) {



		}

	}
	private boolean verificarCampos() {
		if(telaMenu.getFormularioCliente().getEnderecoPanel().getRuaF().getText().length() == 0
				|| telaMenu.getFormularioCliente().getEnderecoPanel().getNumeroF().getText().length() == 0
				|| telaMenu.getFormularioCliente().getEnderecoPanel().getBairroF().getText().length() == 0
				|| telaMenu.getFormularioCliente().getEnderecoPanel().getCidadeF().getText().length() == 0
				|| telaMenu.getFormularioCliente().getEnderecoPanel().getEstadoF().getText().length() == 0
				|| telaMenu.getFormularioCliente().getEnderecoPanel().getCepF().getText().length() == 0

				|| telaMenu.getFormularioCliente().getNome().getText().length() == 0
				|| telaMenu.getFormularioCliente().getCpf().getText().length() == 0
				|| telaMenu.getFormularioCliente().getTelefoneF().getText().length() == 0) {
			Mensagem.exibirMensagem("Preencha todos os campos");
			return false;
		}
		return true;
	}
	public void limparCampos() {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==telaMenu.getFormularioBuscarCliente().getBuscarClienteButton()) { 

			if(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()) != null) { 
				//	Mensagem.exibirMensagem("Cliente está cadastrado");
				telaMenu.getFormularioCliente().getCpf().setEnabled(false);
				telaMenu.getFormularioBuscarCliente().setVisible(false);
				telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getAtualizarButton().setVisible(true);
				telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getRemoverButton().setVisible(true);
				telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getCadastrarButton().setVisible(false);
				telaMenu.getFormularioCliente().setVisible(true);
				telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(true);
				telaMenu.getFormularioCliente().getCadastrarButton().setVisible(false);
				telaMenu.getFormularioCliente().getCadastroL().setText("BUSCA REALIZADA");
				telaMenu.getFormularioCliente().getNome().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getNome());
				telaMenu.getFormularioCliente().getCpf().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getCpf());
				telaMenu.getFormularioCliente().getRgField().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getRg());
				telaMenu.getFormularioCliente().getEmail().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getEmail());
				telaMenu.getFormularioCliente().getTelefoneF().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getTelefone());
				telaMenu.getFormularioCliente().getEnderecoPanel().getRuaF().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getEndereco().getRua());
				telaMenu.getFormularioCliente().getEnderecoPanel().getBairroF().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getEndereco().getBairro());
				telaMenu.getFormularioCliente().getEnderecoPanel().getNumeroF().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getEndereco().getNumero());
				telaMenu.getFormularioCliente().getEnderecoPanel().getCidadeF().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getEndereco().getCidade());
				telaMenu.getFormularioCliente().getEnderecoPanel().getEstadoF().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getEndereco().getEstado());
				telaMenu.getFormularioCliente().getEnderecoPanel().getCepF().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).getEndereco().getCep());
				
				//adicionar panel de possui cadastro quando for relizada a busca
				//telaMenu.getFormularioCliente().getDescontoField().setEnabled(true);
				telaMenu.getFormularioCliente().getDescontoLabel().setVisible(true);
				telaMenu.getFormularioCliente().getDescontoField().setVisible(true);

				telaMenu.getFormularioCliente().getDescontoField().setText(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()).isPossuiDesconto());
				
			}else {
				Mensagem.exibirMensagem(TipoErro.NAO_EXISTE_CLIENTE);
			}

		}
		if(e.getSource()==telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getCadastrarButton() 
				|| e.getSource()==telaMenu.getFormularioCliente().getCadastrarButton()) {
			if(verificarCampos()) {
				cadastrarCliente();
				limparCampos();
			}
		}
		if(e.getSource()==telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getRemoverButton()) {
			try {
				BaseDeDados.removerCliente(BaseDeDados.buscarCliente(telaMenu.getFormularioBuscarCliente().getCpf().getText()));
				Mensagem.exibirMensagem("Cliente removido com sucesso!");
				telaMenu.getFormularioCliente().setVisible(false);
				telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
			} catch (ClienteException e1) {
				Mensagem.exibirMensagem(TipoErro.NAO_EXISTE_CLIENTE);
				e1.printStackTrace();
			}
		}
		if(e.getSource()==telaMenu.getFormularioCliente().getEnderecoPanel().getButtonPanel().getAtualizarButton()) {
			Cliente clienteOld = BaseDeDados.buscarCliente(telaMenu.getFormularioCliente().getCpf().getText());
			Cliente clienteNew = novoCliente();

			try {
				BaseDeDados.atualizarCliente(clienteOld, clienteNew);
			} catch (ClienteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		

		
	}



}
