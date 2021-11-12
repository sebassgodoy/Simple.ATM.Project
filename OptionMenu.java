import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
public class OptionMenu extends Cuenta {
  Scanner menuInput = new Scanner(System.in);
DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.0");
HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

public void getIniciar() throws IOException {
	int x = 1;
	do {
		try {
			data.put(100897, 54826);
			data.put(240872, 12345);
			
			System.out.println("Bienvenid@ al Projecto Simple ATM!");
			System.out.println("Ingrese su Numero de Cliente: ");
			setNumeroDeCliente(menuInput.nextInt());
			
			System.out.println("Ingrese su Numero de PIN: ");
			setNumeroDePin(menuInput.nextInt());
		}catch (Exception e) {
			System.out.println("\n" + "Caracter(es) Invalido(s). Solo Numeros" + "\n");
			x = 2;
		}
		int cn = getNumeroDeCliente();
		int pn = getNumeroDePin();
		if (data.containsKey(cn) && data.get(cn) == pn) {
			getTipoDeCuenta();
		}else
			System.out.println("\n" + "Numero de Cliente o Numero PIN Inexistente" + "\n");
	    }while (x==1);
	     
		}

    public void getTipoDeCuenta() {
		System.out.println("Seleccione su tipo de cuenta al que quiera acceder: ");
		System.out.println(" 1 - Cuenta Corriente");
		System.out.println(" 2 - Caja de ahorro");
		System.out.println(" 3 - Salir");
		int selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			getCuentaCorr();
			break;
		case 2:
			getCajaAhorr();
			break;
		case 3:
			System.out.println("Gracias por usar SimpleATM, Adios. \n");
			break;
		default:
			System.out.println("\n" + "Eleccion Incorrecta." + "\n");
			getTipoDeCuenta();
		}
	}
public void getCuentaCorr() {
	System.out.println("Cuenta Corriente: ");
	System.out.println(" 1 - Ver Balance");
	System.out.println(" 2 - Extraer Fondos");
	System.out.println(" 3 - Depositar Fondos");
	System.out.println(" 4 - Volver a Tipo de Cuenta");
	System.out.println(" 5 - Salir");
	System.out.println("Eleccion: ");
	int selection = menuInput.nextInt();
	switch(selection) {
	case 1:
		System.out.println("Balance Cuenta Corriente: " + moneyFormat.format(getBalanceCuentaCorr()));
		getCuentaCorr();
		break;
	case 2:
		getExtractCuentaCorrInput();
		getCuentaCorr();
		break;
	case 3:
		getDepositarCuentaCorrInput();
		getCuentaCorr();
		break;
	case 4:
		getTipoDeCuenta();
		break;
	case 5:
		System.out.println("Gracias por usar SimpleATM, Adios. ");
		break;
	default:
		System.out.println("\n" + "Eleccion Incorrecta." + "\n");
		getCuentaCorr();
	}
}
public void getCajaAhorr() {
		System.out.println("Caja de Ahorro: ");
		System.out.println(" 1 - Ver Balance");
		System.out.println(" 2 - Extraer Fondos");
		System.out.println(" 3 - Depositar Fondo");
		System.out.println(" 4 - Volver a Tipo de Cuenta");
		System.out.println(" 5 - Salir");
		System.out.println("Eleccion: \"");
		int selection = menuInput.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Balance Caja de Ahorro: " + moneyFormat.format(getBalanceCajaAhorr()));
			getCajaAhorr();
			break;
		case 2:
			getExtractCajaAhorrInput();
			getCajaAhorr();
			break;
		case 3:
			getDepositarCajaAhorrInput();
			getCajaAhorr();
			break;
		case 4:
			getTipoDeCuenta();
			break;
		case 5:
			System.out.println("Gracias por usar SimpleATM, Adios.");
			break;
		default:
			System.out.println("\n" + "Eleccion Invalida." + "\n");
			getCajaAhorr();
		}
}
}