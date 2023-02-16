

public class Principal {

	public static void main(String[] args) {
		
		
		try {
			Profesor profesor1=new Profesor("11", "Pepe", 30);
			Profesor profesor3=new Profesor("13", "Amalia", 30);
			Profesor profesor2=new Profesor("12", "Pepa", 32);
			
			profesor1.enviarCorreo("Buenas buenas", profesor2);
			profesor1.enviarCorreo("Adios", profesor2);
			profesor3.enviarCorreo("Hola como estas", profesor2);
			profesor3.enviarCorreo("Calle baja", profesor2);
			System.out.println(profesor2.mostrarMensajes());
			System.out.println("1. Ordenado lista por orden alfabético de mensajes...");
			System.out.println(profesor2.mostrarMensajesOrdenados());
			System.out.println("2. Ordenado lista por orden alfabético de mensajes...");
			System.out.println(profesor2.mostrarMensajesOrdenados2());
			System.out.println("3. Ordenado lista por orden alfabético de mensajes...");
			System.out.println(profesor2.mostrarMensajesOrdenados3());

			System.out.println("El mensaje buscado es : " + profesor2.buscarMensajesConTexto(" "));
		} catch (IESException e) {
			System.err.println(e.getMessage());
		}
	}

}
