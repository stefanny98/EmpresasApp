package com.tecsup.gestion.utils;

import java.util.ArrayList;
import java.util.List;

import com.tecsup.gestion.model.Paradero;

public class ParaderosFiltro {
	
	static List<String> latitudes;
	static List<String> longitudes;
	static List<String> nombres;
	
	public static void filtrar(List<Paradero> paraderos) {
		 latitudes = new ArrayList<String>();
		 longitudes = new ArrayList<String>();
		 nombres = new ArrayList<String>();
		for (int i=0; i < paraderos.size(); i++) {
			latitudes.add(String.valueOf(paraderos.get(i).getLatitud()));
			longitudes.add(String.valueOf(paraderos.get(i).getLongitud()));
			nombres.add("'"+paraderos.get(i).getNombre()+"'");
		}
			
	}

	public static List<String> getLatitudes() {
		return latitudes;
	}

	public static List<String> getLongitudes() {
		return longitudes;
	}

	public static List<String> getNombres() {
		return nombres;
	}

	
	
	

}
