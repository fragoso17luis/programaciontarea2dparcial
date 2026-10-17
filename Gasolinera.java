import java.util.Scanner;

public class Gasolinera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCargas = 0;
        int cargasConDescuento = 0;
        double totalLitros = 0.0;
        double importeSinDescuento = 0.0;
        double totalCobrado = 0.0;

        String continuar;

        do {
            System.out.println("--- Registro de Carga de Combustible ---");

            // Validar que los litros sean mayores que cero
            double litros;
            do {
                System.out.print("Ingrese los litros cargados: ");
                litros = scanner.nextDouble();
                if (litros <= 0) {
                    System.out.println("Error: Los litros deben ser mayores que cero.");
                }
            } while (litros <= 0);

            // Validar que el precio por litro sea mayor que cero
            double precioPorLitro;
            do {
                System.out.print("Ingrese el precio por litro: ");
                precioPorLitro = scanner.nextDouble();
                if (precioPorLitro <= 0) {
                    System.out.println("Error: El precio debe ser mayor que cero.");
                }
            } while (precioPorLitro <= 0);

            // Cálculo del importe base
            double importeBase = litros * precioPorLitro;
            double descuento = 0.0;

            // Descuento del 5% si la carga es de 40 litros o más
            if (litros >= 40) {
                descuento = importeBase * 0.05;
                cargasConDescuento++;
            }

            double importeFinal = importeBase - descuento;

            // Acumuladores
            totalCargas++;
            totalLitros += litros;
            importeSinDescuento += importeBase;
            totalCobrado += importeFinal;

            System.out.printf("Importe sin descuento: $%.2f%n", importeBase);
            System.out.printf("Descuento aplicado (5%%): $%.2f%n", descuento);
            System.out.printf("Total cobrado por esta carga: $%.2f%n", importeFinal);

            System.out.print("\n¿Desea registrar otra carga? (s/n): ");
            continuar = scanner.next();

        } while (continuar.equalsIgnoreCase("s"));

        // Reporte Final
        System.out.println("\n================ RESUMEN DE VENTAS ================");
        System.out.println("Número de cargas registradas: " + totalCargas);
        System.out.println("Cargas que recibieron descuento: " + cargasConDescuento);
        System.out.printf("Total de litros vendidos: %.2f L%n", totalLitros);
        System.out.printf("Importe total antes de descuentos: $%.2f%n", importeSinDescuento);
        System.out.printf("Total cobrado final: $%.2f%n", totalCobrado);

        if (totalCargas > 0) {
            double promedioPorCarga = totalCobrado / totalCargas;
            System.out.printf("Importe promedio por carga: $%.2f%n", promedioPorCarga);
        } else {
            System.out.println("No se registraron cargas.");
        }

        scanner.close();
    }
}
