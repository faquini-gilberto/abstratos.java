package entidades;

public class PessoaFisica extends Pessoa{

	private Double despMedica;
	
	public PessoaFisica() {
		super();
	}


	public PessoaFisica(String nome, Double rendaAnual, Double despMedica) {
		super(nome, rendaAnual);
		this.despMedica = despMedica;
	}






	public Double getDespMedica() {
		return despMedica;
	}


	public void setDespMedica(Double despMedica) {
		this.despMedica = despMedica;
	}


	@Override
	public double calculoImposto() {
		double imposto;
		
		if (getRendaAnual() < 20000.00) {
			imposto = getRendaAnual() * 0.15;
		}
		else {
			imposto = getRendaAnual() * 0.25;
		}
		return imposto -= despMedica * 0.5;
	}

}
