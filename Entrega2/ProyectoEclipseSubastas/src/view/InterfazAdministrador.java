package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.BaseDatosEmpresa;
import controller.ControllerAdministrador;
import controller.ControllerEmpleado;
import model.Empleado;


public class InterfazAdministrador {
	public static ControllerAdministrador elAdministrador;
	public static void correrAdministrador(BaseDatosEmpresa datos) throws Exception
	{
		System.out.println("Bienvenido Administrador");
		elAdministrador= new ControllerAdministrador();
		elAdministrador.setDatos(datos); // Creamos instancia del controlador y añadimos los datos
		// para trabajar
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1) {
					LogIn();
				    boolean continuar2 = true;
					while (continuar2) 
					{
						try
						{
							mostrarMenu2();
							int opcion_seleccionada2 = Integer.parseInt(input("Ingresa una opcion "));
							if (opcion_seleccionada2 == 1) {
								
								String placa=input("Ingrese el Titulo del la Pieza");
								String marca=input("Ingrese el año de creacion");
								String modelo=input("Ingrese el lugar de creacion");
								String color=input("Ingrese el Tipo de pieza");
								String transmision=input("Ingrese el nombre del propietario de la pieza, si no tiene puede colocar N/A");
								
							}
							else if (opcion_seleccionada2 == 2) {
								String id=input("Ingrese el usuario del comprador");
							}
							else if (opcion_seleccionada2 == 3) {
								String id=input("Ingrese el documento de identidad del empleado");
								String nombre=input("Ingrese el nombre del empleado");
								String usuario=input("Asigne un nombre de usuario para el ingreso del empleado");
								String contrasena=input("Asigne un password para la contrasena del usuario");
								String email=input("Ingrese el email del empleado");
								String sede = input ("Ingrese la sede a la que pertece el empleado");
								String crearLineaEmpleado = ControllerAdministrador.crearLineaEmpleado(id, nombre, usuario, contrasena, email, sede);
								ControllerAdministrador.agregarLineaEmpleados("data/empleados.txt", crearLineaEmpleado);
								
								//String sede=input("Ingrese la sede a la que pertenece el empleado");
								//Empleado empleado = new Empleado(id,nombre,usuario,contrasena,email);
								//String lineaEliminar= ControllerAdministrador.agregarEmpleado(empleado);
								//ControllerAdministrador.agregarEmpleado(id, nombre, usuario, contrasena, email, sede);
							}
							else if (opcion_seleccionada2 == 4) {
								String usuario=input("Ingresa el usuario del empleado a eliminar");
								ControllerAdministrador.eliminarLineaEmpleados("data/empleados.txt", usuario);
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
			System.out.println("2. Registrar Pieza Vendida");
			System.out.println("3. Habilitar comprador");
			System.out.println("4. Modificar estado de la Pieza");
			
		}
		
		public static void LogIn() {
			
			String usuario = input("Usuario ");
			String contrasena = input("contraseña ");
			
			
			elAdministrador.LogIn(usuario, contrasena);
			if(elAdministrador.getAdministrador().equals(null)) {
				System.out.println("Error ingresando sesión");
				
			}
			else {
				System.out.println("Ingresado correctamente");	
			}
		}

  
  public static void cargarDatos() throws IOException {
	  elAdministrador.actualizarDatos();
  }


}
