package Cuentas_Bancarias;

public class Cliente {
	
	private String idCliente;
	private Cuenta cuenta;
	private CuentaSueldo cuentaSueldo;
	private CuentaCorriente cuentaCorriente;
	private CajaDeAhorros cajaDeAhorros;
	
	
	public Cliente(String idCliente) {
		this.idCliente = idCliente;
		cuenta = new Cuenta();
		cuentaSueldo = new CuentaSueldo();
		cajaDeAhorros = new CajaDeAhorros();
		cuentaCorriente = new CuentaCorriente();
	}
	
	public Double ObtenerSaldoTotal() {
		return cuenta.consultarSaldo();
	}
	
	public void depositar(Double importe) {
		Double saldo = cuenta.getSaldo();
		Double saldoTotal  = cuenta.consultarSaldo();
		saldoTotal = saldo + importe;
	}

}
