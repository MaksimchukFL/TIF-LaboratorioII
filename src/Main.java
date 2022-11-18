import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ArbolBinario juego = new ArbolBinario();

        /*
        Definimos las opciones:
        Cada arreglo de opciones, tiene una manera unívoca de llevarnos por la historia principal o por las
        alternativas
         */
        Opcion[] opcionNodo65 = {
                new Opcion("Evitar ingresar",false), new Opcion("Entrar a la tienda",true),
        };

        Opcion[] opcionNodo40 = {
                new Opcion("Continuar con tu camino",true), new Opcion("Ver si todavía está vivo",false),
                new Opcion("Escapar como sea",false)
        };

        //Todas las opciones son false
        Opcion[] opcionNodo38 = {
                new Opcion("Escapar como sea",false), new Opcion("Continuar tu camino",true),
                new Opcion("Volver sobre tus pasos",false)
        };

        Opcion[] opcionNodo55 = {
                new Opcion("Abrir la puerta",true), new Opcion("Mantenerla cerrada",false),
        };

        Opcion[] opcionNodo46 = {
                new Opcion("Recostarte en la cama",false), new Opcion("Recostarte y abrazarla",false),
                new Opcion("Descansar en el living",true)
        };

        //Todas las opciones son false
        Opcion[] opcionNodo44 = {
                new Opcion("Correr a donde puedas",false), new Opcion("Escapar sigilosamente",false),
                new Opcion("Buscar la salida mas cercana",false)
        };

        Opcion[] opcionNodo53 = {
                new Opcion("Confiar en ese palo de escoba",false), new Opcion("Tomar cuchillo",true),
        };

        Opcion[] opcionNodo51 = {
                new Opcion("Enfrentarlos",true), new Opcion("Enfrentarlos no puede ser buena opción",false),
        };

        //Todas las opciones son false
        Opcion[] opcionNodo48 = {
                new Opcion("Quedarte en silencio",false), new Opcion("Suplicar por tu vida",false),
                new Opcion("Recitar aquella plegaria que te enseñó mamá de pequeño",false)
        };


        /*
        Definimos la serie de nodos que vamos a utilizar, establecidos en base a la historia y euristica de nuestro
        arbol binario.
        Aplicamos distintos constructores de acuerdo al tipo de nodo que necesitamos construir
         */
        //Principal
        juego.insertar(new Nodo(65,Lectura.deFicheros("Nodo65"),opcionNodo65,true));
        juego.insertar(new Nodo(66,Lectura.deFicheros("Nodo66"),false));

        //Principal
        juego.insertar(new Nodo(40,Lectura.deFicheros("Nodo40"),opcionNodo40,true));
        juego.insertar(new Nodo(38,Lectura.deFicheros("Nodo38"),opcionNodo38,false));
        juego.insertar(new Nodo(37,Lectura.deFicheros("Nodo37"),false));

        //Principal
        juego.insertar(new Nodo(55,Lectura.deFicheros("Nodo55"),opcionNodo55,true));
        juego.insertar(new Nodo(56,Lectura.deFicheros("Nodo56"),false));

        //Principal
        juego.insertar(new Nodo(46,Lectura.deFicheros("Nodo46"),opcionNodo46,true));
        juego.insertar(new Nodo(44,Lectura.deFicheros("Nodo44"),opcionNodo44,false));
        juego.insertar(new Nodo(43,Lectura.deFicheros("Nodo43"),false));

        //Principal
        juego.insertar(new Nodo(53,Lectura.deFicheros("Nodo53"),opcionNodo53,true));
        juego.insertar(new Nodo(54,Lectura.deFicheros("Nodo54"),false));

        //Principal
        juego.insertar(new Nodo(51,Lectura.deFicheros("Nodo51"),opcionNodo51,true));
        juego.insertar(new Nodo(52,Lectura.deFicheros("Nodo52"),true));
        juego.insertar(new Nodo(48,Lectura.deFicheros("Nodo48"),opcionNodo48,false));
        juego.insertar(new Nodo(47,Lectura.deFicheros("Nodo47"),false));

        /*
        Este método utiliza una serie de métodos para el funcionamiento del juego y el menú principal desarrollado
         */
        ejecutarMenuPrincipal(juego);
    }

    public static void ejecutarMenuPrincipal(ArbolBinario juego) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int opcion = 0;
        Musica mainTheme = new Musica("MainTheme.wav");

        do{
            Musica.reproducirEnLoop(mainTheme);

            System.out.println("\nBEOD");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1) Jugar \n2) Escuchar SoundTrack \n3) Ver créditos \n4) Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = EvaluarIngreso.deEntero(opcion);
            System.out.println();

            switch (opcion){
                case 1: Musica.pausar(mainTheme);
                    boolean salir = false;

                    do{
                        if(opcion == 1) {
                            System.out.println();
                            empezarJuego(juego);
                        }
                        Musica.reproducir(mainTheme);

                        System.out.println("\n\n¿Volver a jugar? \n1) Volver a jugar \n2) Volver al menú principal");
                        System.out.print("Ingrese una opcion: ");
                        opcion = EvaluarIngreso.deEntero(opcion);

                        switch (opcion){
                            case 1: Musica.pausar(mainTheme);
                                juego.volverARaiz();
                                break;
                            case 2: salir = true;
                                break;
                            default: System.out.println("OPCION INGRESADA INVALIDA");
                                salir = false;
                                break;
                        }
                    }while(opcion == 1 || !salir);
                    Musica.pausar(mainTheme);
                    break;
                case 2: Musica.pausar(mainTheme);
                    escucharSoundTrack();
                    break;
                case 3: verCreditos();
                    break;
                case 4: System.out.println("¡Gracias vuelva prontos!");
                    break;
                default: System.out.println("OPCION INGRESADA INVALIDA");
                    break;
            }
        }while(opcion != 4);

        Musica.pausar(mainTheme);
    }

    public static void empezarJuego(ArbolBinario juego) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        boolean cierreInesperado = false;

        Musica mainTheme = new Musica("MainTheme.wav");
        Musica choice = new Musica("Choice.wav");
        Musica finalGame = new Musica("Final.wav");
        Musica level1 = new Musica("level1.wav");
        Musica level2 = new Musica("level2.wav");
        Musica shoot = new Musica("shoot.wav");

        System.out.println("La aventura comienza...");

        //Loop de la historia
        whilePrincipal:
        while (juego.getActual().getLlave() != 66 && juego.getActual().getLlave() != 37 && juego.getActual().getLlave() != 56 && juego.getActual().getLlave() != 43 && juego.getActual().getLlave() != 54 && juego.getActual().getLlave() != 47 && juego.getActual().getLlave() != 52){

            Musica.reproducir(mainTheme);
            System.out.println("\nEsperemos tomes una buena decision...");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n" + juego.getActual().getHistoria());
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Presione enter para continuar...");
            leer.nextLine();
            System.out.println("\n\n" + juego.getActual().lasOpcionesToString());
            if(juego.getActual().getLlave() == 38 || juego.getActual().getLlave() == 44 || juego.getActual().getLlave() == 48){
                Musica.reproducir(level1);
                Musica.resetearAudio(level1);
            }
            System.out.println("\n¿Cúal es su proximo movimiento?");
            System.out.print("Ingrese la opcion: ");
            opcion = EvaluarIngreso.deEntero(opcion);
            Musica.reproducir(choice);
            Musica.resetearAudio(choice);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Presione enter para continuar...");
            leer.nextLine();
            while(opcion < 1  ||  opcion > (juego.getActual().getOpciones().length)){
                System.out.println("\nOPCION INVALIDA");
                System.out.print("Ingrese nuevamente: ");
                opcion = EvaluarIngreso.deEntero(opcion);
                Musica.reproducir(choice);
                Musica.resetearAudio(choice);
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Presione enter para continuar...");
                leer.nextLine();
            }
            /*
            if(opcion == 0 ) {
                try {
                    Musica.reproducir(choice);
                    Musica.resetearAudio(choice);
                }catch (Exception e){
                    System.out.println("No se pudo reproducir el audio");
                }
                cierreInesperado = true;
                break whilePrincipal;
            }
            try {
                Musica.reproducir(choice);
                //juego.avanzar(opcion);
                Musica.resetearAudio(choice);
            }catch (Exception e){
                System.out.println("No se pudo reproducir el audio");
            }
             */
            juego.avanzar(opcion);
        }

        if(!cierreInesperado) {
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n" + juego.getActual().getHistoria());
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(juego.getActual().getLlave() == 52){
                Musica.pausar(mainTheme);
                Musica.reproducir(finalGame);
                System.out.println("¡Has llegado al fin de nuestro camino! Sobreviviste...Tal vez la suerte estuvo de tu lado\n");
                System.out.println("Presione enter para salir...");
                leer.nextLine();
                leer.nextLine();
                Musica.pausar(finalGame);
            }else if(juego.getActual().getLlave() == 43){
                System.out.println("Presione enter para continuar...");
                leer.nextLine();
                Musica.reproducir(shoot);
                System.out.println("¡Tus decisiones te han llevado a la muerte!\n");
                System.out.println("Presione enter para salir...");
                leer.nextLine();
                Musica.pausar(mainTheme);
            }else{
                System.out.println("Presione enter para continuar...");
                leer.nextLine();
                Musica.reproducir(level2);
                System.out.println("¡Tus decisiones te han llevado a la muerte!\n");
                System.out.println("Presione enter para salir...");
                leer.nextLine();
                Musica.pausar(mainTheme);
            }

            System.out.println("...De todas formas ¡Gracias por probar nuestro juego!");

            System.out.println("\n\033[0;1m\uD83C\uDD2F2022 Algunos derechos reservados. Grupo 1 | Laboratorio de Computación II - TUP FRRe\033[0;0m");

        }else{
            Musica.pausar(mainTheme);
            System.out.println("La sesión se cerró de manera inesperada");
        }

    }

    public static void escucharSoundTrack() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int opcion = 0;

        Scanner leer = new Scanner(System.in);

        Musica mainTheme = new Musica("MainTheme.wav");
        Musica finalGame = new Musica("Final.wav");

        do {
            System.out.println("2) Escuchar SoundTrack");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1) Main Theme\n2) Final \n3) Volver al menú principal");
            System.out.print("Ingrese su opcion: ");
            opcion = EvaluarIngreso.deEntero(opcion);
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("Reproduciendo Main Theme");
                    Musica.reproducir(mainTheme);
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Presione cualquier tecla para salir");
                    leer.nextLine();
                    Musica.pausar(mainTheme);
                    break;
                case 2:
                    System.out.println("Reproduciendo Final");
                    Musica.reproducir(finalGame);
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Presione cualquier tecla para salir");
                    leer.nextLine();
                    Musica.pausar(finalGame);
                    break;
                case 3: System.out.println("¡Gracias por escuchar nuestro SoundTrack tan variado!");
                    break;
                default:
                    System.out.println("OPCION INGRESADA INVALIDA");
                    break;
            }

        }while (opcion != 3);
    }

    public static void verCreditos(){
        System.out.println("3) Ver créditos");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\033[0;1m\033[4mHistoria:\033[0;0m\033[0m Guido Olivera, José Alegre");
        System.out.println("\033[0;1m\033[4mLógica de estructura y recorrido para el TAD ArbolBinario:\033[0;0m\033[0m Matias Barboza");
        System.out.println("\033[0;1m\033[4mCodificación:\033[0;0m\033[0m Franco Maksimchuk, Guido Olivera, José Alegre, Matias Barboza");
        System.out.println("\033[0;1m\033[4mMúsica y sonido:\033[0;0m\033[0m José Alegre");
        System.out.println("\033[0;1m\033[4mImplementación de música y sonido:\033[0;0m\033[0m José Alegre, Matias Barboza");
        System.out.println("Agradecimientos especiales a \033[0;1mAlejo Czombos\033[0;0m");
        System.out.println("\n\033[0;1m\uD83C\uDD2F2022 Algunos derechos reservados. Grupo 1 | Laboratorio de Computación II - TUP FRRe\033[0;0m");
    }
}