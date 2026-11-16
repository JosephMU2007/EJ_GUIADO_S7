import java.util.ArrayList;
public class Proyecto {
    private String nombre;
    private ArrayList<Desarrollador> desarrolladores;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.desarrolladores = new ArrayList<>(); // Inicialización de la colección dinámica
    }

    public void agregarDesarrollador(Desarrollador desarrollador) {
        if (desarrollador != null) {
            desarrolladores.add(desarrollador);
        }
    }

    public Desarrollador buscarDesarrollador(String identificacion) {
        for (Desarrollador d : desarrolladores) {
            if (d.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return d;
            }
        }
        return null; // Retorna null si no lo encuentra[cite: 3]
    }

    public boolean eliminarDesarrollador(String identificacion) {
        Desarrollador d = buscarDesarrollador(identificacion);
        if (d != null) {
            desarrolladores.remove(d);
            return true;
        }
        return false;
    }

    public double calcularTotalHoras() {
        double total = 0;
        for (Desarrollador d : desarrolladores) {
            total += d.getHorasAsignadas();
        }
        return total;
    }

    public String mostrarEquipo() {
        if (desarrolladores.isEmpty()) {
            return "El proyecto no tiene desarrolladores asignados.";
        }
        String resultado = "Proyecto: " + nombre + "\nEquipo de desarrolladores:\n";
        for (Desarrollador d : desarrolladores) {
            resultado += "- " + d.mostrarInformacion() + "\n";
        }
        return resultado;
    }

    // Desafío adicional: Retorna el desarrollador con mayor cantidad de horas asignadas[cite: 3]
    public Desarrollador obtenerMayorCarga() {
        if (desarrolladores.isEmpty()) {
            return null;
        }
        Desarrollador mayor = desarrolladores.get(0);
        for (Desarrollador d : desarrolladores) {
            if (d.getHorasAsignadas() > mayor.getHorasAsignadas()) {
                mayor = d;
            }
        }
        return mayor;
    }
}
