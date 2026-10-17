import java.util.Scanner;

public class CentroMedico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ninos = 0;
        int adolescentes = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int totalPacientes = 0;

        double totalRecaudado = 0.0;
        double totalDescuentos = 0.0;

        String continuar;

        do {
            System.out.println("--- Registro de Paciente ---");

            // Solicitar y validar edad
            int edad;
            do {
                System.out.print("Ingrese la edad del paciente: ");
                edad = scanner.nextInt();
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa. Intente de nuevo.");
                }
            } while (edad < 0);

            // Clasificación por edad
            if (edad < 12) {
                ninos++;
                System.out.println("Categoría: Niño");
            } else if (edad <= 17) {
                adolescentes++;
                System.out.println("Categoría: Adolescente");
            } else if (edad <= 59) {
                adultos++;
                System.out.println("Categoría: Adulto");
            } else {
                adultosMayores++;
                System.out.println("Categoría: Adulto Mayor");
            }

            // Solicitar y validar costo de la consulta
            double costoConsulta;
            do {
                System.out.print("Ingrese el costo de la consulta: ");
                costoConsulta = scanner.nextDouble();
                if (costoConsulta <= 0) {
                    System.out.println("El costo debe ser mayor a cero. Intente de nuevo.");
                }
            } while (costoConsulta <= 0);

            // Aplicar descuento a adultos mayores (15%)
            double descuento = 0.0;
            if (edad >= 60) {
                descuento = costoConsulta * 0.15;
            }

            double totalAPagar = costoConsulta - descuento;

            // Acumuladores
            totalRecaudado += totalAPagar;
            totalDescuentos += descuento;
            totalPacientes++;

            System.out.printf("Descuento aplicado: $%.2f%n", descuento);
            System.out.printf("Total a pagar por la consulta: $%.2f%n", totalAPagar);

            // Control del ciclo
            System.out.print("\n¿Desea registrar otro paciente? (s/n): ");
            continuar = scanner.next();

        } while (continuar.equalsIgnoreCase("s"));

        // Reporte final
        System.out.println("\n================ RESUMEN DEL DÍA ================");
        System.out.println("Pacientes atendidos por categoría:");
        System.out.println("- Niños (menores de 12 años): " + ninos);
        System.out.println("- Adolescentes (12 a 17 años): " + adolescentes);
        System.out.println("- Adultos (18 a 59 años): " + adultos);
        System.out.println("- Adultos Mayores (60 años o más): " + adultosMayores);
        System.out.println("-------------------------------------------------");
        System.out.println("Total de pacientes atendidos: " + totalPacientes);
        System.out.printf("Total de dinero recaudado: $%.2f%n", totalRecaudado);
        System.out.printf("Total de descuentos otorgados: $%.2f%n", totalDescuentos);

        if (totalPacientes > 0) {
            double promedioPagado = totalRecaudado / totalPacientes;
            System.out.printf("Promedio pagado por paciente: $%.2f%n", promedioPagado);
        } else {
            System.out.println("No se registraron pacientes.");
        }

        scanner.close();
    }
}