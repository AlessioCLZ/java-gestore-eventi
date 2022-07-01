package com.JANA60.eventi.controller.main;

import java.util.Scanner;

import com.JANA60.eventi.model.entities.Event;

public class MainTest {

	public static final Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws Exception 
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
		Event evento = null;
		
		System.out.println("Inserire un nuovo evento.");
		
		
		try
		{
			
			System.out.println("Inserire il titolo del nuovo evento");
			String title=keyboard.nextLine();
			
			System.out.println("Inserire la data del nuovo evento");
			String date=keyboard.nextLine();
			
			System.out.println("Inserire la capienza del luogo che ospiterà il nuovo evento");
			int maxSeats= Integer.parseInt(keyboard.nextLine());
			
			evento = new Event(title, date, maxSeats);
			System.out.println(evento.toString());

		}
		catch(Exception e)
		{
			System.out.println("Errore imprevisto: " + e.getMessage());
		}		
		
		do
		{
			System.out.println("Vuole prenotare o disdire posti all'evento?");
			cmd=keyboard.nextLine();
			
			switch(cmd.toLowerCase())
			{
				case "prenotare":
				{
					System.out.println("Quanti posti vuole prenotare?");
					int book = Integer.parseInt(keyboard.nextLine());
					evento.bookSeats(book);
				}
				break;
				case "disdire":
				{
					System.out.println("Quanti posti vuole disdire?");
					int cancel = Integer.parseInt(keyboard.nextLine());
					evento.cancelSeats(cancel);
				}
				break;
				case "no":
					end=true;
				break;
				default:
					System.out.println("Comando non valido. Inserire 'prenotare' per prenotare, 'disdire' per disdire o 'no' per uscire");
			}
		}while(!end);
		
		System.out.println(evento.toString());
		
		
	}
	
	

}
