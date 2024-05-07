package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.BaseDatosEmpresa;
import controller.BaseDatosGaleria;
import controller.BaseDatosInventario;
import controller.ControllerAdministrador;
import controller.ControllerEmpleado;
import model.Empleado;


public class InterfazAdministrador {
	public static ControllerAdministrador elAdministrador;
	public static ControllerAdministrador laPieza;
	public static void correrAdministrador(BaseDatosEmpresa datos, BaseDatosInventario datosInventario, BaseDatosGaleria datosGaleria) throws Exception
	{
		System.out.println("Bienvenido Administrador");
		elAdministrador = new ControllerAdministrador();
		elAdministrador.setDatosEmpresa(datos); // Creamos instancia del controlador y añadimos los datos
		
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
							if (opcion_seleccionada2 == 1) {
								
								String titulo=input("Ingrese el Titulo del la Pieza");
								int ano=Integer.parseInt(input("Ingrese el año de creacion"));
								String lugar=input("Ingrese el lugar de creacion");
								String propietario=input("Ingrese el nombre del propietario de la pieza, si no tiene puede colocar N/A");
								int valorFijo=Integer.parseInt(input("Ingrese el valor fijo"));
								String tipo=input("Ingrese el Tipo de pieza");
								
							}
							else if (opcion_seleccionada2 == 2) {
								String userName= input("Ingrese el usuario del comprador");
								String namePieza = input("Ingrese el Titulo de la pieza");
								if (elAdministrador.ConfirmarVenta(userName, namePieza)) {
									System.out.println("La venta del Comprador "+ userName + " fue aceptada");
								}
								else {
									System.out.println("La confirmacion no fue aceptada");
								}
							}
							else if (opcion_seleccionada2 ==3) {
								String userName= input("Ingrese el nombre de usuario del cliente que va entrar a la Subasta");
								boolean estadoVerificacion = elAdministrador.verificarComprador(userName);
								if (estadoVerificacion==true) {
									System.out.println("El usuario "+ userName + " fue verificado exitosamente");
								}
								else {
									System.out.println("El usuario no esta registrado en el sistema no se puede VERIFICAR");
								}
							}
							else if (opcion_seleccionada2 == 4) {
								
							}
							else if (opcion_seleccionada2 == 5) {
								String usuario=input("");
								
						    }
						}
						catch (NumberFormatException e)
						{
							System.out.println("Debe seleccionar uno de los números de las opciones.");
						}

					}
				}
				else if (opcion_seleccionada == 2)
				{
					//cargarDatos();
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (elAdministrador == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe iniciar sesión");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
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
			System.out.println("\nMENU ADMINISTRADOR");
			System.out.println("1. Registrar Pieza en el Inventario");
			System.out.println("2. Confirmar Venta");
			System.out.println("3. Verificar comprador");
			System.out.println("4. Crear subasta");
			System.out.println("5. Modificar estado de la Pieza");
			
		}
		
		
		
		public static void mostrarMenu3()
		{
			System.out.println("\nOpciones de la aplicación\n");
			System.out.println("1. Ajustar maximo de compras para el cliente");
			System.out.println("2. Salir de la aplicacion");
		}
		
		private static boolean LogIn() {
			
			boolean login=false;
			String usuario = input("Usuario: ");
			String contrasena = input("contraseña: ");
			
			elAdministrador.LogIn(usuario, contrasena);
			if(elAdministrador.getAdministrador().equals(null)) {
				System.out.println("Error ingresando sesión");
				
			}
			else {
				System.out.println("Ingresado correctamente");
				login=true;
			}
			return login;
		}

  
  public static void cargarDatos() throws IOException {
	  elAdministrador.actualizarDatos();
  }


}
