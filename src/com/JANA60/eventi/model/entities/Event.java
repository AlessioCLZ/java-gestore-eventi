package com.JANA60.eventi.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
	/*
	 * La consegna è di creare una classe Evento che abbia le seguenti proprietà:
		● titolo
		● data
		● numero di posti totali (cioè la capienza della location)
		● numero di posti prenotati
		Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel
		costruttore, tranne posti prenotati che va inizializzato a 0.
		Inserire il controllo che la data non sia già passata e che il numero di posti totali sia un
		numero positivo. In caso contrario sollevare opportune eccezioni.
		Aggiungere metodi getter e setter in modo che:
		● titolo sia in lettura e in scrittura
		● data sia in lettura e scrittura
		● numero di posti totali sia solo in lettura
		● numero di posti prenotati sia solo in lettura
		Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
		1. prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha più
		posti disponibili deve sollevare un’eccezione.
		2. disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono
		prenotazioni deve sollevare un’eccezione.
		3. l’override del metodo toString() in modo che venga restituita una stringa
		contenente: data formattata - titolo
		Aggiungere eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.
	 */
	
	//class properties
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	
	//properties
	
	private String title, date;
	private int maxSeats, reservedSeats;
	LocalDate dateFromString;
	
	//contructors
	
	public Event(String title, String date, int maxSeats) throws Exception {
		super();
		
		boolean validParameters=true;
		String eMessage= "I dati inseriti non sono validi."; //messaggio di errore instanziato nel costruttore

		try{		//tento di vedere se il titolo è valido
			hasValidTitle(title);
		}catch (NullPointerException npe){
			validParameters=false;
			eMessage+= "\n" + npe.getMessage();
		}
		
		try{
			hasValidMaxSeats(maxSeats);
		}catch (Exception e){
			validParameters=false;
			eMessage+= "\n" + e.getMessage();
		}
		
		try {
			hasValidDate(date);
		}catch (Exception e){
			validParameters=false;
			eMessage+= "\n" + e.getMessage();
		}
		
		if (validParameters) {
		this.title = title;
		this.date = date;
		this.maxSeats = maxSeats; 
		this.reservedSeats=0;
		}
		else
		{
			throw new Exception(eMessage);
		}
	}


	//getters and setters
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		hasValidTitle(title);
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) throws Exception {
		hasValidDate(date);
		this.date = date;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}
	
	public LocalDate getFormattedDate()
	{
		return dateFromString = LocalDate.parse(date, dateFormatter); //utilizzo un parse, in tal modo l'utente da tastiera può inserire la data direttamente da stringa

	}
	//validity methods
	
	private void hasValidTitle(String title) {
		
		if(title.isBlank() || title==null)
			throw new NullPointerException("L'evento deve necessariamente avere un titolo");	
		
	}
	
	private void hasValidMaxSeats(int maxSeats) throws Exception{
		
		if(maxSeats<=0)
			throw new Exception ("La sala per eventi non può avere un numero di sedute nullo o negativo");
		
	}
	
	private void hasValidDate(String date) throws Exception {
		
		getFormattedDate();
		
		if(dateFromString.isBefore(LocalDate.now()))
			throw new Exception ("Un evento non può essere organizzato nel passato.");
			
	}
	
	//class methods
	
	public void bookSeats(int numberOfSeats) throws Exception {
		
		try {
			hasValidDate(this.date);
		} catch (Exception e) {
			throw new Exception ("Non è possibile prenotare posti ad un evento già avvenuto");
		}
		
		if((reservedSeats+numberOfSeats)>maxSeats)
		{
			throw new Exception ("Non ci sono abbastanza posti disponibili.");
		}
		else
		{
			reservedSeats+=numberOfSeats;
			System.out.println("Il numero di posti richiesti è stato prenotato.");
		}
	}
	
	public void cancelSeats(int numberOfSeats) throws Exception{
		
		try {
			hasValidDate(this.date);
		} catch (Exception e) {
			throw new Exception ("Non è possibile disdire posti ad un evento già avvenuto");
		}
		
		
		if(reservedSeats<numberOfSeats)
		{
			throw new Exception ("Non ci sono abbastanza posti prenotati.");
		}
		else
		{
			reservedSeats-=numberOfSeats;
			System.out.println("Il numero di posti inserito è stato disdetto.");
		}
	}

	public String toString()
	{
		return "L'evento "+title+" organizzato in data "+date+" ha una capienza massima di " +maxSeats+ " posti e al momento " +reservedSeats+ " sono prenotati";
	}

}
