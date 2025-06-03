	************************************
 	Actividad #4 de Programacion en JAVA 
  	************************************

	*** Clase AddressBook.java *** 
	
 	Atributos:
		1) HashMap<String, String> contactos: almacena pares (número → nombre).
		2) String nombreArchivo: nombre del archivo CSV donde se guardan/cargan los contactos.
	
 	-> Método load():
	Abre el archivo (si existe) y lee línea por línea.
	Divide cada línea por la primera coma (String.split(",", 2)), asigna el primer elemento como número y el segundo como nombre, y los guarda en el HashMap.
	
 	-> Método save():
	Recorre todo el HashMap y escribe en el archivo cada entrada en formato CSV (numero,nombre), una entrada por línea.
	
 	-> Método list():
	Recorre el HashMap e imprime cada contacto con el formato solicitado.
	
 	-> Método create(String numero, String nombre):
	Inserta o actualiza el contacto en el HashMap.
	
 	-> Método delete(String numero):
	Intenta remover del HashMap. Informa si existía o no.

	*** Clase AgendaApp.java
	Crea una instancia de AddressBook indicando "contactos.csv" como nombre del archivo donde se guardarán los datos.
	Al arrancar, llama a agenda.load() para cargar contactos anteriores.
 
	-> Entra en un bucle con un menú que permite:
		1) Listar contactos (invocar agenda.list()).
		2) Crear un contacto (lee número y nombre desde teclado, luego agenda.create(...)).
		3) Eliminar un contacto (lee el número y llama a agenda.delete(...)).
		4) Guardar cambios y salir (agenda.save() y termina el bucle).
	
	Al elegir “4”, guarda en disco el estado actual de la agenda y sale de la aplicación.
