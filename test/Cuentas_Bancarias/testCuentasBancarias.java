package Cuentas_Bancarias;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCuentasBancarias {

	@Test
	public void queSePuedaCrearCuentas() {
		
		CuentaSueldo c1 = new CuentaSueldo();
		CajaDeAhorros c2 = new CajaDeAhorros();
		CuentaCorriente c3 = new CuentaCorriente();
		
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);
		
	}
	
	@Test
	public void queSePuedaDepositarEnLasCuentas() {
		
		CuentaSueldo c1 = new CuentaSueldo();
		CajaDeAhorros c2 = new CajaDeAhorros();
		CuentaCorriente c3 = new CuentaCorriente();
		
		Double v1 = 200.0D;
		Double v2= 200.0D;
		Double v3 = 200.0D;
		
		c1.depositarDinero(200.0D);
		c2.depositarDinero(200.0D);
		c3.depositarDinero(200.0D);
		
		assertEquals(v1, c1.getSaldo());
		assertEquals(v2, c2.getSaldo());
		assertEquals(v3, c3.getSaldo());
		
	}
	
	@Test
	public void queMePermitaObtenerCreditoDelSobreGiroDeLaCuentaCorriente() {
		/*EL sobregiro es de $150.0 y la comision es el 0.05 de la extraccion*/
		
		CuentaCorriente c3 = new CuentaCorriente();
		
		c3.depositarDinero(100.0D);
		c3.extraerDinero(200.0D);
		
		Double saldoTotal = 0.0;
		assertEquals(saldoTotal, c3.getSaldo()); /*me queda saldo 0 ya que extraje todo*/
		
		Double sobregiroRestante  = 50.0;
		assertEquals(sobregiroRestante, c3.getSobregiro()); /*lo que me queda del sobregiro (credito)*/
		
		Double deudaTotal = 105.0;
		assertEquals(deudaTotal, c3.getDeudas()); /*se le agrega el 0.05 de comsion a la extraccion del sobregiro*/
				
	}
	
	@Test
	public void queMePermitaVerElSaldoConElRecargoDeExtraccionDeLaCajaDeAhorros() {
		/* El recargo se aplica luego de la 5ta. extraccion*/
		
		CajaDeAhorros c2 = new CajaDeAhorros();

		c2.depositarDinero(700.0);
		
		c2.extraerDinero(100.0);
		c2.extraerDinero(100.0);
		c2.extraerDinero(100.0);
		c2.extraerDinero(100.0);
		c2.extraerDinero(100.0);
		c2.extraerDinero(100.0); /*es la sexta extraccion por lo tanto se le agrega el costo adicional*/
		
		Double ve = 94.0;
		assertEquals (ve, c2.getSaldo());
	}
}
