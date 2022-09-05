package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.BaseDeDados;
import model.Cliente;
import model.Endereco;
import model.Festa;
import model.FestaException;
import model.Tema;
import model.TemaException;
import model.TipoErro;
import view.Mensagem;
import view.TelaMenu;

public class FestaController implements ActionListener{
	
	private FormularioHandler formularioHandler;
	private TelaMenu telaMenu;



	public FestaController(TelaMenu telaMenu) {
		this.formularioHandler = new FormularioHandler();
		this.telaMenu = telaMenu;

		control();
	}
	
	private void control() {
		telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getCadastrarButton().addActionListener(this);
		telaMenu.getBuscarFestaPanel().getBuscarFestaButton().addActionListener(this);
		telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getRemoverButton().addActionListener(this);
		telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getAtualizarButton().addActionListener(this);
	}
	private class FormularioHandler implements FocusListener, CaretListener{

		@Override
		public void caretUpdate(CaretEvent e) {
			
		}

		@Override
		public void focusGained(FocusEvent e) {

		}

		@Override
		public void focusLost(FocusEvent e) {



		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getCadastrarButton()) {
			try {
				if(BaseDeDados.buscarCliente(telaMenu.getFestaPanel().getClienteT().getText()) != null)
					cadastrarFesta();
				else
					Mensagem.exibirMensagem("O CPF informado não foi encontrado");
			} catch (TemaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getRemoverButton()){
			try {
				BaseDeDados.removerFesta(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()));
				Mensagem.exibirMensagem("Festa removida com sucesso!");
				telaMenu.getFestaPanel().setVisible(false);
				telaMenu.getFestaPanel().getEnderecoPanel().setVisible(false);
			} catch (FestaException e1) {
				Mensagem.exibirMensagem(TipoErro.NAO_EXISTE_FESTA);
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getAtualizarButton()) {
			try {
				atualizarFesta();
				Mensagem.exibirMensagem("Festa atualizado com sucesso");
			} catch (FestaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==telaMenu.getBuscarFestaPanel().getBuscarFestaButton()) {
			if((BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText())!=null)) {
				
				telaMenu.getFestaPanel().getCadastroL().setText("BUSCA REALIZADA");
				telaMenu.getFestaPanel().getClienteT().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getCliente().getCpf());
				telaMenu.getFestaPanel().getTemaT().setSelectedIndex(BaseDeDados.getTemas().indexOf(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getTema() ) );

				telaMenu.getFestaPanel().getDataFestaF().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getDataFesta().getCalendarType());
				telaMenu.getFestaPanel().getHoraInicioT().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getHoraInicio());
				telaMenu.getFestaPanel().getHoraFimT().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getHoraFim());
				telaMenu.getFestaPanel().getValorEntradaT().setText(String.valueOf(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getValorEntrada()));
				
				telaMenu.getFestaPanel().getEnderecoPanel().getRuaF().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getEndereco().getRua());
				telaMenu.getFestaPanel().getEnderecoPanel().getBairroF().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getEndereco().getBairro());
				telaMenu.getFestaPanel().getEnderecoPanel().getNumeroF().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getEndereco().getNumero());
				telaMenu.getFestaPanel().getEnderecoPanel().getCidadeF().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getEndereco().getCidade());
				telaMenu.getFestaPanel().getEnderecoPanel().getEstadoF().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getEndereco().getEstado());
				telaMenu.getFestaPanel().getEnderecoPanel().getCepF().setText(BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText()).getEndereco().getCep());

				
				telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getCadastrarButton().setVisible(false);
				telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getAtualizarButton().setVisible(true);
				telaMenu.getFestaPanel().getEnderecoPanel().getButtonPanel().getRemoverButton().setVisible(true);
				telaMenu.getFormularioBuscarCliente().setVisible(false);
				telaMenu.getBuscarFestaPanel().setVisible(false);
				telaMenu.getFormularioCliente().setVisible(false);
				telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
				telaMenu.getBuscarTemaPanel().setVisible(false);
				telaMenu.getTemaPanel().setVisible(false);
				telaMenu.getFestaPanel().setVisible(true);
				telaMenu.getFestaPanel().getEnderecoPanel().setVisible(true);
				
			}else {
				Mensagem.exibirMensagem(TipoErro.NAO_EXISTE_FESTA);
			}
		}
		
	}
	private Festa newFesta() {
		Endereco endereco =new Endereco(telaMenu.getFestaPanel().getEnderecoPanel().getRuaF().getText(), telaMenu.getFestaPanel().getEnderecoPanel().getNumeroF().getText(), telaMenu.getFestaPanel().getEnderecoPanel().getBairroF().getText(), telaMenu.getFestaPanel().getEnderecoPanel().getCidadeF().getText(), telaMenu.getFestaPanel().getEnderecoPanel().getEstadoF().getText(), telaMenu.getFestaPanel().getEnderecoPanel().getCepF().getText());
		
		int  dia, mes, ano;
		StringTokenizer st;

		Calendar dataFesta = Calendar.getInstance();

		st = new StringTokenizer(telaMenu.getFestaPanel().getDataFestaF().getText(), "/");
		dia = Integer.parseInt(st.nextToken());
		mes = Integer.parseInt(st.nextToken());
		ano = Integer.parseInt(st.nextToken());

		dataFesta.set(ano, mes -1, dia);

		Tema tema = BaseDeDados.buscarTema(telaMenu.getFestaPanel().getTemaT().getSelectedItem().toString());
		
		Cliente cliente = BaseDeDados.buscarCliente(telaMenu.getFestaPanel().getClienteT().getText());
		
		return new Festa(cliente, 
				tema, endereco, dataFesta,
				telaMenu.getFestaPanel().getHoraInicioT().getText(), 
				telaMenu.getFestaPanel().getHoraFimT().getText(),
				Float.parseFloat(telaMenu.getFestaPanel().getValorEntradaT().getText()));
		
	}
	
	private boolean atualizarFesta() throws FestaException {
		Festa festaOld = BaseDeDados.buscarFesta(telaMenu.getBuscarFestaPanel().getCpf().getText());
		Festa festaNew = newFesta();

		try {
			BaseDeDados.atualizarFesta(festaOld, festaNew);
		} catch (FestaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(festaOld.getCliente());
		System.out.println(festaNew.getCliente());
		return false;
	}
	private boolean cadastrarFesta() throws TemaException {
		try {
			Festa festa = novaFesta();
			if(festa!=null) {
				System.out.println("Add");
				BaseDeDados.adicionarFesta(festa);
				System.out.println(BaseDeDados.getFestas());				
			}

		} catch (FestaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private Festa novaFesta() throws TemaException {
		Endereco endereco = new Endereco(telaMenu.getFestaPanel().getEnderecoPanel().getRua().getText(),
				telaMenu.getFestaPanel().getEnderecoPanel().getNumeroF().getText(),
				telaMenu.getFestaPanel().getEnderecoPanel().getBairroF().getText(),
				telaMenu.getFestaPanel().getEnderecoPanel().getCidadeF().getText(),
				telaMenu.getFestaPanel().getEnderecoPanel().getEstadoF().getText(),
				telaMenu.getFestaPanel().getEnderecoPanel().getCepF().getText());

		int  dia, mes, ano;
		StringTokenizer st;

		Calendar dataFesta = Calendar.getInstance();

		st = new StringTokenizer(telaMenu.getFestaPanel().getDataFestaF().getText(), "/");
		dia = Integer.parseInt(st.nextToken());
		mes = Integer.parseInt(st.nextToken());
		ano = Integer.parseInt(st.nextToken());

		dataFesta.set(ano, mes -1, dia);

		Tema tema= BaseDeDados.buscarTema(telaMenu.getFestaPanel().getTemaT().getSelectedItem().toString().toUpperCase());
		if(tema==null) {
			Mensagem.exibirMensagem("Tema nao encontrado, informe um tema existente");
			return null;
		}

		return new Festa(BaseDeDados.buscarCliente(telaMenu.getFestaPanel().getClienteT().getText()), 
				tema,
				endereco,
				dataFesta,
				telaMenu.getFestaPanel().getHoraInicioT().getText(),
				telaMenu.getFestaPanel().getHoraFimT().getText(),
				Float.parseFloat(telaMenu.getFestaPanel().getValorEntradaT().getText()));
	}



}
