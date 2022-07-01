package com.JANA60.eventi.controller.main;

import java.util.Scanner;

import com.JANA60.eventi.model.entities.Event;

public class MainTest {

	public static final Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{
		/*
		 * 1. Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento
			con tutti i parametri.
			2. Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni
			vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo
			eventuali eccezioni.
			3. Stampare a video il numero di posti prenotati e quelli disponibili
			4. Chiedere all’utente se e quanti posti vuole disdire
			5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo
			eventuali eccezioni
			6. Stampare a video il numero di posti prenotati e quelli disponibili
		 */
		
		String cmd;
		boolean end=false;
		
		System.out.println("Inserire un nuovo evento.");
		
		_newEvent();
		
		
		
		
	}
	
	private static void _newEvent() {
		try
		{
			
			System.out.println("Inserire il titolo del nuovo evento");
			String title=keyboard.nextLine();
			
			System.out.println("Inserire la data del nuovo evento");
			String date=keyboard.nextLine();
			
			System.out.println("Inserire la capienza del luogo che ospiterà il nuovo evento");
			int maxSeats= Integer.parseInt(keyboard.nextLine());
			
			Event evento = new Event(title, date, maxSeats);
			System.out.println(evento.toString());

		}
		catch(Exception e)
		{
			System.out.println("Errore imprevisto: " + e.getMessage());
		}
		
		
		
	}

}
