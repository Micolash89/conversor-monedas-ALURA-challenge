import entities.RecordConvesions;
import service.ApiRequestService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        opcion();
    }

    public static void menu() {
        linea();
        System.out.println("""
                Sea Bienvenido al Conversor de Monedas =]
                1) Dolar a Peso Argentino
                2) Peso Argentino a Dolar
                3) Dolar a Real Brasileño
                4) Real Brasileño a Dolar
                5) Dolar a Peso Colombiano
                6) Peso Colombiano a Dolar
                7) Dolar a Sol Peruano
                8) Sol Peruano a Dolar
                9) Historial de Conversiones
                10) Salir
                Elija una opción valida:
                """);
        linea();
    }

    public static void linea() {
        System.out.print("\n");
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void opcion() {
        Scanner scanner = new Scanner(System.in);
        Integer opc;
        Double valor;
        List<RecordConvesions> recordConvesionsList = new ArrayList<>();

        do {
            menu();
            opc = scanner.nextInt();

            if (opc > 0 && opc < 8) {
                System.out.println("Ingrese el valor a convertir");
                valor = scanner.nextDouble();
                scanner.nextLine();
            } else {
                valor = 0.0;
            }

            switch (opc) {
                case 1:
                    getConvesion("USD", "ARS", recordConvesionsList, valor);
                    break;

                case 2:
                    getConvesion("ARS", "USD", recordConvesionsList, valor);
                    break;

                case 3:
                    getConvesion("USD", "BRL", recordConvesionsList, valor);
                    break;

                case 4:
                    getConvesion("BRL", "USD", recordConvesionsList, valor);
                    break;

                case 5:
                    getConvesion("USD", "COP", recordConvesionsList, valor);
                    break;

                case 6:
                    getConvesion("COP", "USD", recordConvesionsList, valor);
                    break;
                case 7:
                    getConvesion("USD", "PEN", recordConvesionsList, valor);
                    break;

                case 8:
                    getConvesion("PEN", "USD", recordConvesionsList, valor);
                    break;

                case 9:
                    System.out.println("Historial de Conversiones");
                    recordConvesionsList.forEach(System.out::println);
                    break;

                case 10:
                    System.out.println("Salir");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (!opc.equals(10));

    }

    public static void getConvesion(String cadenaFrom, String cadenaTo, List<RecordConvesions> recordConvesionsList, Double valor) {
        ApiRequestService apiRequestService = new ApiRequestService();

        Double monedaApi = apiRequestService.conectUrl(cadenaFrom, cadenaTo);

        System.out.printf("el valor %.2f %s a %s es: $%.2f[%s]", valor, cadenaFrom, cadenaTo, monedaApi * valor, cadenaTo);

        recordConvesionsList.add(new RecordConvesions(cadenaFrom, cadenaTo, valor, monedaApi * valor));

    }

}