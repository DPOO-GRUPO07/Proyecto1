package view;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controller.BaseDatosEmpresa;

//Importacion de las clases que modifican los datos, ubicadas en el model:
//import controller.BaseDatos;

import view.InterfazCliente;
public class Interfaz {
	//private static BaseDatosInventario datosInventario;
    //private static BaseDatosSubastas datosCompraSubastas;
	private static BaseDatosEmpresa datosEmpresa;
	public void ejecutarInterfaz() throws Exception
	{
		System.out.println("Casa de Ventas y Subastas");

		boolean continuar = true;
		//cargarDatosInventario();
		//cargarDatosSubasta();
		cargarDatosEmpresa();
		while (continuar)
		{
			try
			{
				mostrarMenu();
				
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					InterfazCliente.correrCliente(datosEmpresa);
				else if (opcion_seleccionada == 2 && datosEmpresa != null)
					InterfazEmpleado.correrEmpleado(datosEmpresa);
				else if (opcion_seleccionada == 3 && datosEmpresa != null)
					InterfazAdministrador.correrAdministrador(datosEmpresa);
					
				else if (opcion_seleccionada == 4)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
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

		public void mostrarMenu()
		{
			System.out.println("\n## Bienvenido a la Casa de Subastas ##\n");

			System.out.println("1. Ingresar como Cliente");
			System.out.println("2. Ingresar como Empleado");
			System.out.println("3. Ingresar como Administrador");
			System.out.println("4. Salir de la Aplicacion");


	}
		public String input(String mensaje)
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
			return null;
		}
		public static BaseDatosEmpresa cargarDatosEmpresa() {
			//System.out.println("Cargando datos: ");


			try
			{
				datosEmpresa = new BaseDatosEmpresa();
				//datosCompraSubasta = new PersistenciaCompraSubasta();
				datosEmpresa.descargarDatosEmpresa();
				//System.out.println("Se actualizaron los datos");
				return datosEmpresa;
			}
			catch (FileNotFoundException e)
			{
				System.out.println("ERROR: el archivo indicado no se encontró.");
				return null;
			}
				
			catch (IOException e)
			{
				System.out.println("ERROR: hubo un problema leyendo el archivo.");
				System.out.println(e.getMessage());
				return null;
			}
			
		}
  public static void main(String[] args) throws Exception {
	  Interfaz consola = new Interfaz();
	  consola.ejecutarInterfaz();
  }
}

