package com.JANA60.eventi.controller.main;

import java.util.ArrayList;
import java.util.List;

import com.JANA60.eventi.model.entities.Convention;
import com.JANA60.eventi.model.entities.Event;
import com.JANA60.eventi.model.entities.Speaker;

public class EventProgramm {

	public static void main(String[] args) throws Exception {
		/*
		 * Creare una classe ProgrammEventi con metodo main in cui creare una lista di eventi di test
			(non è necessario usare lo Scanner).
			Stampare la lista degli eventi ordinati per data e a parità di data ordinati per titolo.
			Creare altre due liste: prossimiEventi ed eventiFuturi, in cui inserire rispettivamente gli eventi
			che avverranno entro un mese e quelli in cui la data è successiva a un mese da oggi.
		 */
		Speaker speaker1= new Speaker("Alessio", "Calzetti", "Dott.");		
		Event evento1= new Event("Come programmare", "10/08/2022", 24);
		Event conferenza1= new Convention("Lezioni soft ", "10/08/2022", 35, "Proattività", speaker1);
		Event evento2= new Event("Linguistica generale", "09/09/2023", 400);
		Event conferenza2= new Convention("Dialetti in italia ", "10/07/2022", 230, "Romanesco", speaker1);

		List<Event> events= new ArrayList<Event>();
		
		events.add(evento1);
		events.add(evento2);
		events.add(conferenza1);
		events.add(conferenza2);
		
		
		System.out.println(events);
		
		
		

		
		
	}

}
