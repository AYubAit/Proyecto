package proyecto;

import java.io.*;
import java.util.Scanner;

public class Proyecto {
// El maxim de array o de alumnes que es poden inseri

    private static final int ALUMNES_MAX = 25;
// delarem el array
    private static ALumne[] array = new ALumne[ALUMNES_MAX];
    //inio dos variables que son locals
    private static int opcio, mostrar;
    // aquesta variable serveix per quna dimo la introduicio de un atecla per a continuar i tornar al menu principal
    private static String tecla = "sda";
    //Fitxer usat per persistir la informació
    private static File fitxer = new File("alumnes.db");
    //declaro un escaner per a tot el proyecte
    private static Scanner ent = new Scanner(System.in);

    /**
     * Aquest metode me serveix per al mode grafic me retorna
     *
     * @return els metodes de la clase ALumne
     */
    public static ALumne[] getArray() {
        return array;
    }

    public static void main(String[] args) {

        //EL DISENY TOP-DOWN
        //inicio les variables utilizan aquet metode..
         inicialitzarVariables();
        do {
            //utilizo aquet metode per a demana opcio
            demanarOpcio();
            //utilizo aquet metode per a tractar la opcio
            tractarOpcio();
            
        } while (!opcioFinal()); //poso la condicio 
        
        //utilizo aquet metode per a me guarde dades y apagar
        finalitzar();
    }

    /**
     * Aquest metode el faig servir en mode grafic que lo que fa es guarda les dades de array al fitxer declarat
     * No retorna res..
     */
    public static void metodeGuardarCambis() {
        
        
        ObjectOutputStream escriptura = null;
        try {
            escriptura = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fitxer)));

            for (int i = 0; i < array.length; i++) {
                if (array[i].isOmplit()) {
                    escriptura.writeObject(array[i]);
                }
            }
        } catch (Exception ex) {
            System.err.println("Error en guardar les dades!!");
        }
    }

    public static void finalitzar() {
        
       //declaro un object de Aquet tipus..
        ObjectOutputStream escriptura = null;
        try {
             //Obrim el fitxer
            escriptura = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fitxer)));
          //Recorrem l'array guardant els objectes vàlids al fitxer
            for (int i = 0; i < array.length; i++) {
            //Guardem al fitxer els pilots omplits
                if (array[i].isOmplit()) {
                    escriptura.writeObject(array[i]);
                }
            }
             
//Aquí podem avisar a l'usuari de que no s'han guardat les dades
        } catch (Exception ex) {
            System.err.println("Error en guardar les dades!!");
        } finally {
            try {
                if (escriptura != null) {
                     //Molt important tancar el fitxer d'escriptura
                    escriptura.close();
              
                }
                  //No  mostro res!
            } catch (IOException ex) {
            }

        }
        // tanco el scaner
        ent.close();
    }

    /**
     * Aquest metode  no retornar res .. sol inicia les variables i array
     */
    public static void inicialitzarVariables() {
        
        // inicialitzo la i a 0 
        int i = 0;
        //per si no caben els objectes del fitxer a l'array

        if (fitxer.exists()) {

            boolean acabar = false;
            //Obrim el fitxer per lectura
            ObjectInputStream lectura = null;
            try {
                lectura = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fitxer)));

                while (true) {
                    array[i] = (ALumne) lectura.readObject();
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                //aquí  si és per que al fitxer hi ha més alumnes que els que caben a l'array. 
                System.err.println("Atenció, no caben tots els objectes. Si continues pots perdre dades. Vols continuar?(S/N):");
                Scanner ent = new Scanner(System.in);
                char siNo = ' ';
                do {
                    //tractar les lletres majúscules
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'N') {
                    acabar = true;
                }

            } catch (IOException ex) {
                //significa que hem arribat al final del fitxer
            } catch (ClassNotFoundException ex) {
                //Aquí tampoc cal fer res ja que significa que el fitxer llegit no conté objectes de la classe Pilot
            } finally {
                try {
                    //tancar el fitxer de lectura
                    if (lectura != null) {
                        lectura.close();
                    }
                } catch (IOException ex) {

                }
                //Si hem decidit acabar parem l'execucuió
                if (acabar) {
                    System.exit(0);
                }
            }

        }
        int mostrar = 0;
        String tecla = " ";
        //Acabem d'omplir l'array en nous alumnes sense dades
        for (; i < array.length; i++) {
            array[i] = new ALumne();
            array[i].setOmplit(false);
        }

    }

    public static void demanarOpcio() {
        do {

            try {
                
                // Mostro text de demanar opcio
                System.out.println("------ MAXIMITZA  LA CONSOLA o TERMINAL ----");
                System.out.println("+-------------------------------------------------+");
                System.out.println("|     Alumnes v1.1                                |");
                System.out.println("|-------------------------------------------------|");
                System.out.println("|   0. Sortir                                     |");
                System.out.println("|   1. Afegir Alumne                              |");
                System.out.println("|   2. Editar Alumne                              |");
                System.out.println("|   3. Llistar Alumne                             |");
                System.out.println("|   4. Borrar Alumne                              |");
                System.out.println("|   5. About-me                                   |");
                System.out.println("|_________________________________________________|");
                System.out.print("-->>");
                // Demano la
                opcio = ent.nextInt();
                break;
             
                // si dona una exepcio de aquet tipus
            } catch (java.util.InputMismatchException a) {
                   // mostro lo seguent error  
                System.err.println(" !!!!!!!!!!!!!!!! ERROR !!!!!!!!!!!!!!");
                System.err.println(" NO HAS INTRODUIT LO QUE DEMANO!!");
            //Molt important posar el next per evitar bucle infinit
                ent.next();
                // opcional el continue...
                continue;

            }

        } while (true);

    }
/**
 * Aquet metode se encargar de tractar la opcio eligida del menu 
 * no retorrna res.. dins conte metodes 
 */
    public static void tractarOpcio() {
        //amb el shitch tracto la opcio
        switch (opcio) {
            case 0:
                // per apar i finalitzar 
                finalitzar();
                System.out.println("Has Sortit!!!!");
                break;
            case 1:
                // per afegir un nou alumne 
                introduirALumne();
                break;
            case 2:
                
               // per modificar un alumne exsisten
                modificarALumne();
                break;
            case 3:
                
                //per a llista el alumne que estan al array
                llistarAlumne();

                break;
            case 4:
                
                //borrar un alumne
                borrarAlumne();
                break;
            case 5:
                //informacio de que a programat 
                aboutAlumne();
                break;
            default:
                
                // si no es ninguna opcio deles anterior surt aquet msj i tornar a pregunta
                System.out.println("\nOpció incorrecta!!");
        }

    }
/**
 * Aquest metode comprova si opcio elegida per usuari es igual a 0 i gracies a aquest  metode en fa el bucle de diseny top-down
 * @return  i retorna true o false
 */
    public static boolean opcioFinal() {
        return opcio == 0;
    }
/**
 * Aquest metode no retorna res .. 
 * aquest metode  afegeix un alumne al array..
 */
    public static void introduirALumne() {
        
        ////Primer recorrem l'array fins trobar una casella no omplida o arribar al seu final
        int i;
        for (i = 0; i < array.length && array[i].isOmplit(); i++);

        System.out.println("HAS ESCOLLIT LA OPCIO DE AFEGIR ALUMNE\n");
        System.out.println("___________________________________________");
        System.out.println("___________________________________________");
        
        
        //Si no hem arribat al final és per que hem trobat una casella buida (no omplida)
        if (i < array.length) {
            
            // Demano el Nom
            System.out.println("Introdueix Nom de Alumne:");
            System.out.print("-->> ");
            array[i].setNom(ent.skip("[\r\n]*").nextLine());
            
            //Demano el No de cicle
            System.out.println("Introdueix Nom de Cicle: ");
            System.out.print("-->> ");
            array[i].setNomCicle(ent.nextLine());

            //Tracto les excepcions
            do {

                try {
                    //demano moduls aprovats
                    System.out.println("Introdueix Numero de moduls Aprovats (de 0 - 13 moduls):");
                    System.out.print("-->> ");
                    array[i].setMp(ent.nextInt());
                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();

                    /* System.out.println("Si despres de aquet messatge java no te tornar a posar el NUMERO DE MODULS APROVAT "
                            + "axio significa que ha saltat el bucle per poder tornar a posar ");*/
                }
                    // condicio de 0-13 moduls
            } while (array[i].getMp() < 0 || array[i].getMp() > 13);

            
            //Tracto les excepcions
            do {
                try {
                    //demano nota1
                    System.out.println("Introdueix la Nota mes alta de moduls Aprovats:(De 5-10)");
                    System.out.print("-->> ");
                    array[i].setNota1(ent.nextDouble());

                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();
                }
            } while (array[i].getNota1() < 5 || array[i].getNota1() > 10);
            
            //Tracto les excepcions
            do {
                try {
                    //demano moduls suspesos 
                    System.out.println("Introdueix Numero del Moduls Suspesos (max-13 moduls):");
                    System.out.print("-->> ");
                    array[i].setMs(ent.nextInt());

                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();
                }
            } while (array[i].getMs() < 0 || array[i].getMs() > 13);
            
            //Tracto les excepcions
            do {

                try {
                    //si a introduit 0 no fa falta demana la nota2
                    if (array[i].getMs() == 0) {

                    } else {
                        System.out.println("Introdueix la Nota mes Baixa de moduls Suspesos: (De 0 - 4)");
                        System.out.print("-->> ");
                        array[i].setNota2(ent.nextDouble());
                    }

                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();
                }
            } while (array[i].getNota2() < 0 || array[i].getNota2() >= 5);

            System.out.println("___________________________________________");

            //poso array que esta omplit
            array[i].setOmplit(true);

        } else {
            // si la no hi ha lloc per a demanar mes alumne hi havors
            
            
            do {

                try {
                    // si la no hi ha lloc per a demanar mes alumne hi havors
                    System.out.println("Ja tens Dades Introduides i no cabem mes borra i torna per poder afegir");
                    System.out.println("Vols Mostrar o Llistar Les Dades Guardades?( 1(Si)/2(No) ):");
                    System.out.print("-->> ");
                    mostrar = ent.nextInt();
                    break;
                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();
                    continue;
                }
            } while (true);
             // si lusuari vols mostrar els alumnes hi ha guardats...
            switch (mostrar) {
                case 1:
                    
                    //for per Mostar el contigunt de array que hi han
                    for (i = 0; i < array.length; i++) {

                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("| Nom Alumne: " + (array[i].getNom()));
                        System.out.println("| Nom Curs: " + (array[i].getNomCicle()));
                        System.out.format("| Numero de moduls Aprovats:  %s   i la nota Més alta: %s \n ", array[i].getMp(), array[i].getNota1());
                        System.out.format("| Numero de moduls Suspesos:  %s   i la nota Més alta: %s", array[i].getMs(), array[i].getNota2());
                        System.out.println("-------------------------------------------------------------------");
                    }

                    break;
                default:
                    break;
            }
        }
        
        
        //per tornar al menu principal
        System.err.println("Introdueix  Tecla i 'Enter' per tornar al MENU PRINCIPAL...");
        System.out.print("-->> ");
        tecla = ent.skip("[\r\n]*").nextLine();

    }
/**
 * aquest metode  no retotna res ..
 * se encarega de modificar un alumne escollit
 */
    public static void modificarALumne() {
        
        System.out.println("HAS ESCOLLIT LA OPCIO DE EDITAR\n");

        //nova variable per sabe r si lusuari vol modificar o no 
        char siNo = 'N';
        int cont = 1, i;
        
        //si llistem  un per un cada alumne y hi havors li preguntem si el vol borrarr
        for (i = 0; i < array.length && siNo != 'S' && siNo != 'F'; i++) {
            if (array[i].isOmplit()) {
                System.err.format("\n-Alumne %d:\n", cont++);
                System.out.println(array[i].toString());
                System.err.println("------------------------------------------------------");
                do {
                    System.out.print("Vols modificar Aquest Alumne(S/N) ?:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                } while (siNo != 'S' && siNo != 'N');
            }
            if (siNo == 'S') {
                break;
            }

        }
        // si diu que si hi havors
        if (siNo == 'S') {
                    
            //le demano les modificacions
            //demano nom modificat
            System.out.println("-------------------------------------------------------------------");
            System.out.println("| Nom Alumne: " + (array[i].getNom()));
            System.out.println("| Introduix El Nom Editat: ");
            System.out.print("-->>");            
            array[i].setNom(ent.skip("[\r\n]*").nextLine());                   
            
            //demano nom cicle
            System.out.println("| Nom Curs: " + (array[i].getNomCicle()));
            System.out.print("| Introdueix Nom de Cicle Editat:\n ");
            System.out.print(" -->>");
            array[i].setNomCicle(ent.skip("[\r\n]*").nextLine());

            
            // poso les excepcion que calguen...
            do {
                try {
                    
                    //demano moduls aprovat
                    System.out.format("| Numero de moduls Aprovats:  %s \n-->>", array[i].getMp());
                    array[i].setMp(ent.nextInt());

                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();
                }
            } while (array[i].getMp() < 0 || array[i].getMp() > 13);
            
            
            
            
             // poso les excepcion que calguen...
                    do {
                try {
                    System.out.print("| i la nota més Alta de " + array[i].getMp());
                    System.out.print(" -->>");
                    array[i].setNota1(ent.nextDouble());
                    break;
                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();
                }
            } while (array[i].getNota1() < 5 || array[i].getNota1() > 10);

            System.out.format("| Numero de moduls Suspesos:  %s   i la nota Més baixa: %s", array[i].getMs(), array[i].getNota2());

            do {
                try {
                    System.out.print("| Introdueix Numero de moduls Supesos: \n-->>");
                    array[i].setMs(ent.nextInt());

                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();
                }
            } while (array[i].getMs() < 0 || array[i].getMs() > 13);

            do {
                try {
                    System.out.println("i la nota més baixa:\n-->> ");
                    array[i].setNota2(ent.nextDouble());
                    System.out.println("S'han Aplicat el cambis correctament...");
                    break;
                } catch (java.util.InputMismatchException a) {
                    System.err.println("OJOOOOO!!! NO HAS INTRODUIT LO QUE DEMANO!!");
                    ent.next();
                }
            } while (array[i].getNota2() < 0 || array[i].getNota2() >= 5);

        } else {
            System.err.println("No hay Dades per Modificar... si vols introdueix-les primer");
        }

        System.err.println("Introdueix  Tecla i 'Enter' per tornar al MENU PRINCIPAL.....\n-->>");
        tecla = ent.skip("[\r\n]*").nextLine();

    }
/**
 * Aquest medote no retornar res 
 * el metode mostra tot  el array complet de alumne
 */
    public static void llistarAlumne() {
        
     ////Primer recorrem l'array fins trobar una casella no omplida o arribar al seu final
        int i;
        for (i = 0; i < array.length && array[i].isOmplit(); i++) {
            array[i].setTotm(array[i].getMp() + array[i].getMs());

            System.out.println("HAS ESCOLLIT LA OPCIO DE LLISTAR\n");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("|  Nom Alumne: " + (array[i].getNom()));
            System.out.println("| Nom Curs: " + (array[i].getNomCicle()));
            System.out.format("| Numero de moduls Aprovats:  %s   i la nota Més alta: %s\n", array[i].getMp(), array[i].getNota1());

            System.out.format("| Numero de moduls Suspesos:  %s   i la nota Més alta: %s\n", array[i].getMs(), array[i].getNota2());

            if (array[i].getNota1() > array[i].getNota2() && array[i].getMp() > array[i].getMs()) {
                array[i].setEstat(true);
                System.out.println("¡¡¡¡Estat Aprovat!!");
            } else {
                array[i].setEstat(false);
                System.out.println("¡¡¡¡Estat Suspes!!");
            }
        }
        System.err.println("------------------------------------------------------");
        System.err.print("Introdueix  Tecla i 'Enter' per tornar al MENU PRINCIPAL.....\n");
        System.out.print("-->>");
        tecla = ent.skip("[\r\n]*").next();
    }
/**
 * Aquest medote no retornar res 
 * el metode borrar un alumne determinat en  el array complet de alumne
 */
    public static void borrarAlumne() {
       // guardo la classe o bojecte dins de p per simmplificar la cosa
        ALumne p = null;

        char siNo = 'N';
        int i;
        
        //recorrem array un per un i preguntem si volem borrar
        for (i = 0; i < array.length && siNo != 'F'; i++) {
            p = array[i];
            
            //mirem si esta ple o no 
            if (p.isOmplit()) {
                //si esta preguntem si vol borrar
                System.out.println(p);
                do {
                    System.err.println("\nVols borrar el Alumne(S/N)??:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                } while (siNo != 'S' && siNo != 'N' && siNo != 'F');
            }
            if (siNo == 'S') {
                break;
            }
        }
        // si diu que si vol borrar cambiem la variable omplit a false 
        if (siNo == 'S') {
            p.setOmplit(false);
            System.err.println("Pilot borrat correctament....");

        } else {
            System.err.println("\nNo s'ha borrat cap Alumne...\n ");
        }

    }
/**
 * Aquest metode  no torna res .. si no mostra la informacio del programa
 */
    public static void aboutAlumne() {

        System.out.println("-----------------------------About:-------------------------");
        System.out.println("|                       ALumnes version 1.1                |");
        System.out.println("|                  Autor de  Programa :                    |");
        System.out.println("|        [[[[[ Ayoub Ait ]]]]]- Curs: 2016 - 2017          |");
        System.out.println("|    1r - Administració de Sistemes Informatics de Xarxes  |");
        System.out.println("-----------------------------------------------------------");
        System.out.println("___________________________________________________________");
        System.out.println("|                                                          |");
        System.out.println("|    [[[[[[[© 2017 - Tots els drets reservats]]]]]]]       |");
        System.out.println("|__________________________________________________________|");
        System.err.println("Introdueix una Tecla i 'Enter' per continuar....");
        System.out.println("");
        System.out.print("-->>");
        tecla = ent.skip("[\r\n]*").next();

    }

}
