package Cuentas_Bancarias;

public class CuentaCorriente extends Cuenta {
			
		private Double sobregiro;
		private Double comision;
		private Double deudas;
		
		
		
		public CuentaCorriente(){
			sobregiro = 150.0D;
			comision = 0.05;
			deudas=0.0;
		}
		
		public CuentaCorriente(Double saldoInicial){
			super(saldoInicial);
			sobregiro = 150.0D;
			comision = 0.05;
		}
		
		
		
		public Double extraerDinero(Double importeARetirar){
			Double importeRetirado;
			if(importeARetirar<=super.getSaldo()){
				importeRetirado = super.extraerDinero(importeARetirar);
			}
			else if(importeARetirar<=(super.getSaldo() + this.sobregiro)){
				sobregiro -= (importeARetirar - super.getSaldo());
				deudas+=(importeARetirar - super.getSaldo());
				super.extraerDinero(super.getSaldo());
				importeRetirado = importeARetirar;
			}
			else{
				importeRetirado = 0.0;
			}
			return importeRetirado;
		}
		
		
		public Double getSobregiro() {
			return sobregiro;
		}
		
		public Double getDeudas() {
			Double deudaReal  = 0.0;
			deudaReal = deudas + (deudas *this.comision);
			return deudaReal;
		}
}
