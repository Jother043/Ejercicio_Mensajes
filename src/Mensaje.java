
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje  {
	private Persona remitente;
	private String texto;
	private LocalDateTime hora;
	
	public Mensaje(Persona remitente, String texto) {
		super();
		this.remitente = remitente;
		this.texto = texto;
		hora=LocalDateTime.now();
	}

	public Persona getRemitente() {
		return remitente;
	}


	public String getTexto() {
		return texto;
	}


	public LocalDateTime getHora() {
		return hora;
	}

	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-uuuu hh:mm");
		return "Mensaje De: " + remitente.getNombre() + " Texto: " + texto + ", Fecha " + df.format( hora );
	}

	
	
	
	
	
	
	
	
	
}
