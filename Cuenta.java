import java.text.DecimalFormat;
import java.util.Scanner;

public class Cuenta {
	private int numeroDeCliente;
	private int numeroDePin;
	private double balanceCuentaCorr = 0;
	private double balanceCajaAhorr = 0;
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	public int setNumeroDeCliente(int numeroDeCliente) {
		this.numeroDeCliente = numeroDeCliente;
		return numeroDeCliente;
	}
	public int getNumeroDeCliente() {
		return numeroDeCliente;
	}
	public int setNumeroDePin(int numeroDePin) {
		this.numeroDePin = numeroDePin;
		return numeroDePin;
	}
	public int getNumeroDePin() {
		return numeroDePin;
	}
	public double getBalanceCuentaCorr() {
		return  balanceCuentaCorr;
	}
	public double getBalanceCajaAhorr() {
		return balanceCajaAhorr;
	}
	public double calcExtractCuentaCorr(double amount) {
		 balanceCuentaCorr = ( balanceCuentaCorr - amount);
		return  balanceCuentaCorr;
	}
	public double calcExtractCajaAhorr(double amount) {
		balanceCajaAhorr = (balanceCajaAhorr - amount);
		return balanceCajaAhorr;
	}
	public double calcDepositarCuentaCorr(double amount) {
		 balanceCuentaCorr = ( balanceCuentaCorr + amount);
		return  balanceCuentaCorr;
	}
	public double calcDepositarCajaAhorr(double amount) {
		balanceCajaAhorr = (balanceCajaAhorr + amount);
		return balanceCajaAhorr;
	}
	public void getExtractCuentaCorrInput() {
		System.out.println("Balance Cuenta Corriente: " + moneyFormat.format(balanceCuentaCorr));
		System.out.print("Dinero a extraer de Cuenta Corriente: ");
		double amount = input.nextDouble();
		if (( balanceCuentaCorr - amount) >= 0) {
			calcExtractCuentaCorr(amount);
			System.out.println("Nuevo Balance Cuenta Corriente: " + moneyFormat.format(balanceCuentaCorr));
		} else {
			System.out.println("Balance no puede ser negativo." + "\n");
		}
	}
	public void getExtractCajaAhorrInput() {
		System.out.println("Balance Caja Ahorro: " + moneyFormat.format(balanceCajaAhorr));
		System.out.println("Dinero a extrar de Caja Ahorro");
		double amount = input.nextDouble();
		if ((balanceCajaAhorr - amount) >= 0) {
			calcExtractCajaAhorr(amount);
			System.out.println("Nuevo Balance Caja Ahorro: " + moneyFormat.format(balanceCajaAhorr));
		} else {
			System.out.println("Balance no puede ser negativo. " + "\n");
		}

	}
	public void getDepositarCuentaCorrInput() {
		System.out.println("Balance Cuenta Corriente: " + moneyFormat.format( balanceCuentaCorr));
		System.out.println("Dinero a depositar en Cuenta Corriente: ");
		double amount = input.nextDouble();
		if (( balanceCuentaCorr + amount) >= 0) {
			calcDepositarCuentaCorr(amount);
			System.out.println("Nuevo Balance Cuenta Corriente: " + moneyFormat.format( balanceCuentaCorr));
		} else {
			System.out.println("Balance no puede ser negativo. " + "\n");
		}
	}
	public void getDepositarCajaAhorrInput() {
		System.out.println("Balance Caja de Ahorro: " + moneyFormat.format(balanceCajaAhorr));
		System.out.println("Dinero a depositar en Caja de Ahorro: ");
		double amount = input.nextDouble();
		if ((balanceCajaAhorr + amount) >= 0) {
			calcDepositarCajaAhorr(amount);
			System.out.println("Nuevo Balance Caja de Ahorro: " + moneyFormat.format(balanceCajaAhorr));
		} else {
			System.out.println("Balance no puede ser negativo. " + "\n");
		}
	}
}