package controller;

import model.Retangulo;

public class Main {
	
	
	private static Retangulo retangulo = new Retangulo();
	private static float resultado;
	private static float resultado1;
	private static float resultado2;
	
	
	public static void main(String args[]) {
		
		retangulo.setAltura(3);
		retangulo.setLargura(4);
		
		resultado = retangulo.Area();
		resultado1 = retangulo.Perimetro();
		resultado2 = retangulo.Diagonal();
		
		System.out.println("ÁREA: " + resultado);
		System.out.println("PERIMETRO: " + resultado1);
		System.out.println("DIAGONAL: " + resultado2);
		
	}	
}
