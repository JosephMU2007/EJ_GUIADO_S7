//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
void main() {
    Scanner sc = new Scanner(System.in);

    // Creamos el proyecto
    Proyecto proyecto = new Proyecto("Sistema de Gestión Empresarial");

    int opcion;
    do {
        System.out.println("\n** GESTIÓN DE PROYECTO Y DESARROLLADORES **");
        System.out.println("1. Agregar desarrollador");
        System.out.println("2. Listar equipo de desarrolladores");
        System.out.println("3. Buscar desarrollador por identificación");
        System.out.println("4. Eliminar desarrollador por identificación");
        System.out.println("5. Calcular total de horas asignadas");
        System.out.println("6. Ver desarrollador con mayor carga (Desafío)");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");

        opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                System.out.print("Ingrese identificación: ");
                String id = sc.nextLine();
                System.out.print("Ingrese nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese especialidad: ");
                String especialidad = sc.nextLine();
                System.out.print("Ingrese horas asignadas: ");
                double horas = Double.parseDouble(sc.nextLine());

                Desarrollador nuevoDev = new Desarrollador(id, nombre, especialidad, horas);
                proyecto.agregarDesarrollador(nuevoDev);
                System.out.println("¡Desarrollador agregado con éxito al proyecto!");
                break;

            case 2:
                System.out.println("\n=== EQUIPO ACTUAL ===");
                System.out.println(proyecto.mostrarEquipo());
                break;

            case 3:
                System.out.print("Ingrese la identificación a buscar: ");
                String idBusqueda = sc.nextLine();
                Desarrollador encontrado = proyecto.buscarDesarrollador(idBusqueda);
                if (encontrado != null) {
                    System.out.println("¡Encontrado!: " + encontrado.mostrarInformacion());
                } else {
                    System.out.println("No se encontró ningún desarrollador con esa identificación (retornó null).");
                }
                break;

            case 4:
                System.out.print("Ingrese la identificación del desarrollador a eliminar: ");
                String idEliminar = sc.nextLine();
                boolean eliminado = proyecto.eliminarDesarrollador(idEliminar);
                if (eliminado) {
                    System.out.println("¡Desarrollador eliminado con éxito del proyecto!");
                } else {
                    System.out.println("No se pudo eliminar. El desarrollador no existe en el proyecto.");
                }
                break;

            case 5:
                System.out.println("\nTotal de horas asignadas al proyecto: " + proyecto.calcularTotalHoras() + " hrs");
                break;

            case 6:
                Desarrollador mayorCarga = proyecto.obtenerMayorCarga();
                if (mayorCarga != null) {
                    System.out.println("\nDesarrollador con mayor carga: " + mayorCarga.mostrarInformacion());
                } else {
                    System.out.println("\nNo hay desarrolladores registrados en el proyecto.");
                }
                break;

            case 7:
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;

            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    } while (opcion != 7);

    sc.close();

}
