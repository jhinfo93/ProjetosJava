package Model;

import java.util.ArrayList;

public class Listas {

	private static ArrayList<Empresa> empresa;

	public static ArrayList<Empresa> getEmpresa() {
		if (empresa == null) {
			empresa = new ArrayList<Empresa>();
		}
		return empresa;
	}

}
