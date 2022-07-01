package com.JANA60.eventi.model.entities;

public class Convention extends Event{

	/*Creare una classe Conferenza che estende Evento, che ha anche gli attributi
	● argomento
	● oratore
	l’oratore, a sua volta, è caratterizzato da:
	● nome
	● cognome
	● titolo
	Modificare il metodo main in modo che al momento della creazione dell’evento venga
	richiesto se è una conferenza, e in tal caso valorizzare tutti i parametri.
	Quando si stampano i dettagli della Conferenza, oltre a data e titolo, devono apparire anche
	le informazioni sull’oratore e sull’argomento.
	*/
	
	private String topic;
	private Speaker speaker;
	
	public Convention(String title, String date, int maxSeats, String topic, Speaker speaker) throws Exception {
		super(title, date, maxSeats);
		
		boolean validParameters=true;
		String eMessage= "I dati inseriti per l'oratore non sono validi.";
		
		try
		{
			hasValidTopic(topic);
		}
		catch (NullPointerException npe){
			validParameters=false;
			eMessage+= "\n" + npe.getMessage();
		}
		
		if(validParameters)
		{
			this.speaker=speaker;
			this.topic=topic;
		}
		else
		{
			throw new Exception(eMessage);
		}
	}

	private void hasValidTopic(String topic) {
		if(topic.isBlank() || topic==null)
			throw new NullPointerException("La conferenza deve necessariamente avere un argomento");			
	}
	
	@Override
	public String toString()
	{
		String res= super.toString();
		res+= "\nL'evento sarà una conferenza con argomento: "+topic+".\nL'oratore della conferenza sarà: " +speaker.getTitle()+" " +speaker.getName()+" "+speaker.getSurname()+".";
		return res;
		
	}

}
