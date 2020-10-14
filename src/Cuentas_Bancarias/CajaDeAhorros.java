package Cuentas_Bancarias;

public class CajaDeAhorros extends Cuenta {
	
		private Double costoAdicional;
		private Integer cantidadDeExtracciones;
		private Integer limiteSinAdicional;
		
		
		
		public CajaDeAhorros() {
			super();
			this.limiteSinAdicional=5;
			this.cantidadDeExtracciones = 0;
			this.costoAdicional = 6.0;
		}
		
		public CajaDeAhorros(Double saldoInicial) {
			super(saldoInicial);
			this.limiteSinAdicional=5;
			this.cantidadDeExtracciones = 0;
			this.costoAdicional = 6.0;
		}
		
		
		
		public Double extraerDinero(Double importeARetirar){
			Double importeRetirado;
			if(importeARetirar<=super.getSaldo()){
				importeRetirado = super.extraerDinero(importeARetirar);
				this.cantidadDeExtracciones+=1;
			}
			else{
				importeRetirado = 0.0;
			}
			return importeRetirado;
		}
		
		
		public Double getSaldo() {
			Double saldoReal=0.0;
			if(this.cantidadDeExtracciones>5) {
				saldoReal=super.getSaldo()-this.costoAdicional;
			}else {
				saldoReal=super.getSaldo();
			}
			return saldoReal;
		}
}
