package com.JANA60.eventi.model.entities;

public class Speaker {
	
	/*
	 * l’oratore, a sua volta, è caratterizzato da:
	● nome
	● cognome
	● titolo
	 */

	//attributes
	private String name, surname, title;

	//constructors
	
	public Speaker(String name, String surname, String title) throws Exception {
		super();
		
		boolean validParameters=true;
		String eMessage= "I dati inseriti per l'oratore non sono validi.";
		
		try {
			hasValidName(name);
		}catch (NullPointerException npe){
			validParameters=false;
			eMessage+= "\n" + npe.getMessage();
		}
		try {
			hasValidSurname(surname);
		}catch (NullPointerException npe){
			validParameters=false;
			eMessage+= "\n" + npe.getMessage();
		}
		try {
			hasValidTitle(title);
		}catch (NullPointerException npe){
			validParameters=false;
			eMessage+= "\n" + npe.getMessage();
		}
		
		if(validParameters)
		{
			this.name = name;
			this.surname = surname;
			this.title = title;
		}
		else
		{
			throw new Exception(eMessage);

		}
	}


	
	//getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		hasValidName(name);

		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		hasValidSurname(surname);

		this.surname = surname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		hasValidTitle(title);

		this.title = title;
	}
	
	//validation methods
	
	private void hasValidTitle(String title) {
		if(title.isBlank() || title==null)
			throw new NullPointerException("L'oratore deve necessariamente avere un titolo");		
	}

	private void hasValidSurname(String surname) {
		if(surname.isBlank() || surname==null)
			throw new NullPointerException("L'oratore deve necessariamente avere un cognome");		
	}

	private void hasValidName(String name) {
		if(name.isBlank() || name==null)
			throw new NullPointerException("L'oratore deve necessariamente avere un nome");		
	}
	
	
}
