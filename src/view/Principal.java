package view;

import java.io.IOException;

import controller.ArquivosController;

public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArquivosController controller = new ArquivosController();
		
		controller.verificaDirTemp();
		
		controller.insereCadastro("teste", 3, "Daniel", "daniel@docket.com.br");
		
		controller.imprimeCadastro("teste", 2);
	}

}
