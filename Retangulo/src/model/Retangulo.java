package model;

public class Retangulo {
	
	private float largura;
	private float altura;
	
	public Retangulo() {}
	public Retangulo(float largura, float altura) {
		this.largura = largura;
		this.altura = altura;
	}
	
	public float getLargura() {
		return largura;
	}
	
	public void setLargura(float largura) {
		this.largura = largura;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	public float Area() {
		return largura*altura;
	}
	
	public float Perimetro() {
		return (2*(largura + altura));
	}
	public float Diagonal() {
		
		return (float) Math.sqrt((largura*largura) + (altura*altura));
	}
	
	
	
	
}
