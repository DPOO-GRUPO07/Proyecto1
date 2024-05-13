package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.BaseDatosInventario;
import controller.BaseDatosEmpresa;
import controller.BaseDatosGaleria;
import controller.ControllerCliente;

public class InterfazCliente {
	public static ControllerCliente elCliente;
	private static BaseDatosGaleria datosGaleria;
	public static void correrCliente(BaseDatosEmpresa datos, BaseDatosInventario datosInventario, BaseDatosGaleria datosGaleria) throws IOException
	{
		System.out.println("Bienvenido cliente");
		elCliente= new ControllerCliente();
		elCliente.setDatosGaleria(datosGaleria); // Creamos instancia del controlador y añadimos los datos
		// para trabajar
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1) {
					boolean continuar2 = LogIn();
					if (continuar2==false) {
						System.out.println("No se pudo inicar sesion");
					}
				    while (continuar2) 
					{
						try
						{
							mostrarMenu2();
							int opcion_seleccionada2 = Integer.parseInt(input("Ingresa una opcion "));
				            if (opcion_seleccionada == 1 && elCliente.getCliente() != null) {
				            	realizarCompra();
				            }
				            else if (opcion_seleccionada == 2){
					           cargarDatos();
					           System.out.println("Saliendo de la aplicación ...");
					           continuar = false;
				            }
				            else if (elCliente == null){
					            System.out.println("Para poder ejecutar esta opción primero debe iniciar sesión");
				            }
						}   
						catch (NumberFormatException e)
							{
								System.out.println("Debe seleccionar uno de los números de las opciones.");
						}
					}
				 }
				 else {
						System.out.println("Saliendo de la aplicación ...");
						continuar = false;
				  }
				}
				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}
		}
	}

	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;}
		public static void mostrarMenu()
		{
			System.out.println("\nOpciones de la aplicación\n");
			System.out.println("1. LogIn");
			System.out.println("2. Salir de la aplicacion");

	   }
		
		public static void mostrarMenu2()
		{
			System.out.println("\nMENU COMPRADOR");
			System.out.println("1. Realizar Compra por Valor fijo");
			System.out.println("2. Realizar Compra por medio de Subasta");
			System.out.println("3. Vender o subastar Pieza (Consignacion)");
			System.out.println("4. Ver piezas mi historial de piezas");
		}
		
		
		private static boolean LogIn() {
			boolean login=false;
			String usuario =input("Usuario ");
			String contrasena =input("Contraseña ");
			
			elCliente.logIn(usuario, contrasena);
			if(elCliente.getCliente().equals(null)) {
				System.out.println("Error ingresando sesión");
				
			}
			else {
				System.out.println("Ingresado correctamente");
				login=true;
			}
			return login;
		}
		
       public static void realizarCompra() {
    	   String nombrePieza=input("Titulo o nombre de la pieza: ");
    	   
    	   //SString userNameCliente= elCliente.getCliente();
	       //double cobro=elCliente.realizarCompra(nombrePieza);
       }
       
       public static void cargarDatos() throws IOException {
    	   elCliente.actualizarDatos();
       }

}

