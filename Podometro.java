/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona (hombre o mujer)
 * ha dado en una semana. 
 * 
 * @author    - Sara Larra�eta - 
 * 
 */
public class Podometro {
    /** CONSTANTES */
    private final char HOMBRE ='H';
    private final char MUJER ='M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO =7;
    /**ATRIBUTOS O VARIABLES DE INSTANCIA*/
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinDeSemana;
    private int tiempo;
    private int caminatasNoche;
    
    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca = queMarca;
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;
        if (sexo == HOMBRE) {
            longitudZancada = Math.ceil (altura * ZANCADA_HOMBRE);
        } else
        {
            longitudZancada = Math.floor (altura * ZANCADA_MUJER);
        }
    }

    /**
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFina � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin) {
        String diaDeLaSemana ="";
        switch (dia) {
            case 1 :
            case 2 : 
            case 3 : 
            case 4: 
            case 5 : diaDeLaSemana = "LABORABLE" 
            totalPasosLaborables = pasos * numDiaLaborable;
            break;
            case 6 : diaDeLaSemana = "SABADO";
            break;
            case 7 : diaDeLaSemana = "DOMINGO";
            break;
        }
        tiempo = horaFin - horaInicio;
        if(diaDeLaSemana == "LABORABLE"){
           
        }
        
        if ( horaInicio > 2100 ) {
            caminatasNoche++;
        }
        if (diaDeLaSemana == "LABORABLE"){
        
        }
    }

    /**
     * Mostramos en pantalla la siguiente informaci�n acerca de nuestro podometro con el m�-
     * todo system.out.println y nos servimos de un if para mostrar cu�ndo es mujer de cu�ndo
     * es hombre.
     */
    public void printConfiguracion() {
        System.out.println("Configuraci�n del pod�metro" +
            "\n***************************");
        System.out.println("Altura : " + altura / 100 + " mtos");
        if( sexo == MUJER){
            System.out.println("Sexo : MUJER");
        }
        else
        {
            System.out.println("Sexo : HOMBRE");
        }
        System.out.println("Longitud zancada : " + longitudZancada / 100 + " mtos" );
    }

    /**Mostramos la siguiente informaci�n en printEstad�sticas, junto con el texto mostramos 
     * los valores de las variables y los atributos se�alados.
     */
    public void printEstad�sticas() {
        System.out.println("Estadisticas" +
            "\n***************************");
        System.out.println("Distancia recorrida toda la semana : "+ totalDistanciaSemana +
            "\nDistancia recorrida fin de semana : " + totalDistanciaFinDeSemana ); 
        System.out.println("\nN�Pasos d�as laborables : " + totalPasosLaborables + "\nN�Pasos S�BADO : " 
            + totalPasosSabado + "\nN�Pasos DOMINGO : " + totalPasosDomingo );
        System.out.println("\nN� caminatas realizadas a partir de las 21h : " + caminatasNoche);
        System.out.println("\nTiempo total caminando a la semana" + tiempo );
        System.out.println("\nDia/s con m�s pasos caminados : ");
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        if ( totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo){
            return "LABORABLES";
        }
        else if(totalPasosSabado > totalPasosDomingo && totalPasosSabado > totalPasosLaborables){
            return "S�BADO";
        }else {
            return "DOMINGO";
        }
    }

    /**
     * Tal y como nos dice el ejercicio hemos restablecido todos los valores y marca lo hemos 
     * dejado como estaba.
     */    
    public void reset(){
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }
}
