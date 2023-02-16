
import java.util.*;

public abstract class Persona {
	
	private static final int EDAD_MINIMA = 12;
	
	// Atributos
	private String dni;
	private String nombre;
	private int edad;
	private List<Mensaje> mensajes;
	
	// Constructor
	public Persona(String dni,String nombre,int edad) throws IESException {
		this.dni=dni;
		this.nombre = nombre;
		mensajes=new LinkedList<>();
		setEdad(edad);
	}

	// Métodos get y set
	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setEdad(int edad) throws IESException {
		if (edad < EDAD_MINIMA)
			throw new IESException("La edad minima es de" + EDAD_MINIMA);
		this.edad = edad;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	/**
	 * Método con el que enviamos un mensaje, utilizando el método add de la Interfaz collection
	 * @param message
	 * @param personaDestinatario
	 * @throws IESException
	 */
	public void enviarCorreo(String message, Persona personaDestinatario) throws IESException{
		
		Mensaje mensaje = new Mensaje(personaDestinatario, message);

		personaDestinatario.mensajes.add(mensaje);
	}
	
	/**
	 * Si no tiene ningún mensaje salta la excepción
	 * @return
	 * @throws IESException
	 */
	
	public String mostrarMensajes() throws IESException{
		if(mensajes.size() == 0){
			throw new IESException("No hay mensajes para mostrar");
		}
		Iterator<Mensaje> iterator = mensajes.iterator();
		StringBuilder mensajes = new StringBuilder();
		while (iterator.hasNext()){
			mensajes.append(iterator.next() + "\n");
		}
		return mensajes.toString();
	}
	
	/**
	 * 
	 * @param numeroMensaje De 1 en adelante
	 * @throws IESException 
	 */
	public void borrarMensaje( int numeroMensaje) throws IESException{
		mensajes.remove(numeroMensaje);
	}

	/**
	 * Este método se encarga de mostrar los mensajes del LinkedList mensajes, teniendo en cuenta el orden de los
	 * elementos por orden alfabético utilizando el .sort que implementa comparator de la Interfaz Comparable.
	 * @return
	 * @throws IESException
	 */
	public String mostrarMensajesOrdenados()throws IESException{
		if(mensajes.size() == 0){
			throw new IESException("No hay mensajes para mostrar");
		}
		/*
		Comparamos mensaje1 con mensaje2 teniendo en cuenta el remitente y el nombre con el método compareTo de la
		interfaz Comparable.
		El código comparator lo genera automáticamente al hacer un new Comparator<Mensaje>()
		 */
		mensajes.sort(new Comparator<Mensaje>() {
			@Override
			public int compare(Mensaje o1, Mensaje o2) {
				return o1.getTexto().compareTo(o2.getTexto());
			}
		});

		Iterator<Mensaje> iterator = mensajes.iterator();
		StringBuilder mensajes = new StringBuilder();
		while (iterator.hasNext()){
			mensajes.append(iterator.next() + "\n");
		}
		return mensajes.toString();
	}
	public String mostrarMensajesOrdenados2()throws IESException{
		if(mensajes.size() == 0){
			throw new IESException("No hay mensajes para mostrar");
		}

		/*
		 * Podemos sustituir la clase interna, compare por la siguiente expresión lambda
		 */
		mensajes.sort((o1, o2) -> o1.getTexto().compareTo(o2.getTexto()));

		Iterator<Mensaje> iterator = mensajes.iterator();
		StringBuilder mensajes = new StringBuilder();
		while (iterator.hasNext()){
			mensajes.append(iterator.next() + "\n");
		}
		return mensajes.toString();
	}

	/**
	 * Utilizando la interfaz comparable en la clase mensaje podemos ordenar también utilizando en el método compareTo
	 * @return
	 * @throws IESException
	 */
	public String mostrarMensajesOrdenados3()throws IESException{
		if(mensajes.size() == 0){
			throw new IESException("No hay mensajes para mostrar");
		}
		Collections.sort(mensajes);
		Iterator<Mensaje> iterator = mensajes.iterator();
		StringBuilder mensajes = new StringBuilder();
		while (iterator.hasNext()){
			mensajes.append(iterator.next() + "\n");
		}
		return mensajes.toString();
	}

	/**
	 * Método con el que buscamos un mensaje dentro del linkdlist recorriendo el linkedlist con un foreach.
	 * Si ese mensaje contiene el texto que es un string entonces devolveremos el mensaje como un string, si no
	 * devolvemos una excepción.
	 * @param texto
	 * @return
	 * @throws IESException
	 */
	public String buscarMensajesConTexto( String texto) throws IESException{
		StringBuilder msg = new StringBuilder();
		for(Mensaje mensaje: mensajes){
			if(mensaje.getTexto().contains(texto)){
				msg.append(mensaje);
				break;
			}
		}
		if(msg.toString().trim().isEmpty()){
			throw new IESException("No se encuentra el mensaje buscado: " + texto);
		}
		return msg.toString();
	}
}
