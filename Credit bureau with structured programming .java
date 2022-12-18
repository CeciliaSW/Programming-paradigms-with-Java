package com.company; //Paquete de código.
import java.util.Scanner; //Importa la capacidad de leer variables.

/*
• Problema 2: El banco "Bandido de peluche" desea calcular para cada uno de sus 6 clientes su saldo actual, su pago mínimo y su pago para no generar intereses. Además, quiere calcular el monto de lo que ganó por concepto interés con los clientes morosos.
              Los datos que se conocen de cada cliente son: número de cuenta, nombre, saldo anterior, monto de las compras que realizó y pago que depositó en el corte anterior.
              Para calcular el pago mínimo se considera 15% del saldo actual, y el pago para no generar intereses corresponde a 85% del saldo actual, considerando que el saldo actual debe incluir 12% de los intereses causados por no realizar el pago mínimo y $200 de multa por el mismo motivo.
              Imprimir un reporte con los datos y resultados.
*/



public class Main { //Clase del código.

    public static void main(String[] args) { //Método general que sirve para llamar a otros y ejecutar el código.
        String[]Nombres=new String[6]; //Arreglo unidimensional para guardar los nombres de los 6 clientes
        double[][]Cliente=new double[6][4]; //Arreglo bidimensional para guardar 4 datos (Número de cuenta, Saldo anterior, Monto de compras y Depósito anterior) sobre los 6 clientes
        double[][]Saldo=new double[6][4]; //Arreglo bidimensional para guardar 4 datos (Saldo actual, Pago mínimo, Pago para no generar impuestos e intereses por no generar el pago mínimo) sobre el saldo de los 6 clientes
        double morosos; //Variable usada para calcular las ganancias generadas por clientes morosos
        obtenernombres(Nombres); //Se invoca el método para obtener los nombres de los 6 clientes
        obtenerdatos(Cliente,Nombres); //Se invoca el método para obtener los datos sobre los 6 clientes
        morosos=calcularsaldo(Saldo,Cliente); //Se invoca el método para calcular el saldo de los 6 clientes, así como las ganancias por los clientes morosos
        imprimir(Cliente,Saldo,Nombres,morosos); //Se invoca el método para imprimir todos los datos almacenados
    }
    public static void obtenernombres(String[]Nombres) //No regresa nada.
    {
        Scanner entrada=new Scanner(System.in); //Sirve para nombrar al objeto que leerá las variables.
        for (int i=0;i<Nombres.length;i++) //Realizará el ciclo hasta obtener los nombres de los 6 clientes
        {
            System.out.println("Introduzca el nombre del cliente número " + (i+1)); //Comando para imprimir.
            Nombres[i]=entrada.next(); //Almacena el nombre de cada cliente.
        }
    }
    public static void obtenerdatos(double[][]Cliente,String[]Nombres) //No regresa nada.
    {
        Scanner entrada=new Scanner(System.in); //Sirve para nombrar al objeto que leerá las variables.
        for (int i=0;i<Cliente.length;i++) //Realizará el ciclo hasta obtener los datos de los 6 clientes
        {
            System.out.println("\nIntroduzca los datos de " + Nombres[i]); //Comando para imprimir.
            System.out.println("Número de cuenta: "); //Comando para imprimir.
            Cliente[i][0]=entrada.nextInt(); //Almacena el número de cuenta
            System.out.println("Saldo anterior: "); //Comando para imprimir.
            Cliente[i][1]=entrada.nextInt(); //Almacena el saldo anterior
            System.out.println("Monto de las compras que realizó: "); //Comando para imprimir.
            Cliente[i][2]=entrada.nextInt(); //Almacena el monto de compras
            System.out.println("Depósito del corte anterior: "); //Comando para imprimir.
            Cliente[i][3]=entrada.nextInt(); //Almacena el depósito anterior
        }
    }
    public static double calcularsaldo(double[][]Saldo,double[][]Cliente) //Regresa un valor.
    {
        double morosos=0; //Variable de acumulado.
        for (int i=0;i<Saldo.length;i++) //Realizará el ciclo hasta calcular el saldo de los 6 clientes
        {
            Saldo[i][0]=(Cliente[i][1]+Cliente[i][2]-Cliente[i][3]); //Saldo actual = Saldo anterior + Monto de Compras - Depósito Anterior
            Saldo[i][1]=(0.15*Saldo[i][0]); //Pago mínimo = 15% del Saldo actual
            if (Saldo[i][0]<=0) //Condicional para calcular el pago para no generar impuestos
                Saldo[i][2]=0; //Si no se debe nada.
            else
                Saldo[i][2]=((0.85*(Saldo[i][0]*1.12))+200); //Si aún se debe algo. Pago PNGI = 85% del Saldo actual + 12% por impuestos + multa de 200 pesos.
            Saldo[i][3]=(Saldo[i][0]*0.12); //Intereses por no realizar pago mínimo = 12% del Saldo actual.
            morosos+=Saldo[i][3]; //Calcula las ganancias generadas por clientes morosos al añadir los valores de los intereses de los 6 clientes.
        }
        return morosos; //Regresa las ganancias generadas por clientes morosos.
    }
    public static void imprimir(double[][]Cliente,double[][]Saldo,String[]Nombres,double morosos) //No regresa nada
    {
        System.out.println("\nNo. de Cuenta\tNombre\tSaldo Anterior\tMonto Compras\tDepósito Anterior\tSaldo Actual\tPago Mínimo\t\tPago PNGI\tGanancia"); //Comando para imprimir.
        for (int i=0;i<Cliente.length;i++) //Realizará el ciclo por cada uno de los 6 clientes.
        {
            System.out.println("\t" + (int)Cliente[i][0] + "\t\t\t" + Nombres[i] + "\t\t$" + Cliente[i][1] + "\t\t\t$" + Cliente[i][2] + "\t\t\t$" + Cliente[i][3] + "\t\t\t$" + Saldo[i][0] + "\t\t\t$" + Saldo[i][1] + "\t\t\t$" + (float)Saldo[i][2] + "\t\t$" + Saldo[i][3]); //Comando para imprimir todos los datos en el mismo orden que está listado arriba.
        } ///t es un tabulador para ajustar el formato de tabla.
        System.out.println("\nEl total de ingresos generados por los morosos es de: $" + morosos); //Comando para imprimir las ganancias generadas por los clientes morosos.
    }
}
//Las llaves abren y cierras fragmentos de código, como la clase, métodos y ciclos.
