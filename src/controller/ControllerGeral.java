package controller;

import view.TelaMenu;

public class ControllerGeral {

	private MenuController menuController;
	private TemaController temaController;
	private ClienteController clienteController;
	private FestaController festaController;
	private TelaMenu telaMenu;
	
	public ControllerGeral() {
		this.telaMenu = new TelaMenu();
		this.menuController = new MenuController(telaMenu);
		this.clienteController = new ClienteController(telaMenu);
		this.temaController =new TemaController(telaMenu);
		this.festaController = new FestaController(telaMenu);
	}
}
