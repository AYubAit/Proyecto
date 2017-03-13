package proyecto;

import java.util.Scanner;

public class Proyecto {

    private static final int ALUMNES_MAX = 2;
    private static ALumne[] array = new ALumne[ALUMNES_MAX];

    public static void main(String[] args) {

        // aki sol les variables del programa no del alumne
        int opcio, mostrar;
        String tecla = "sda";

       

        Scanner ent = new Scanner(System.in);

        ALumne p = null;
        for (int i = 0; i < array.length; i++) {
            array[i] = new ALumne();
            array[i].setOmplit(false);

        }

        do {

            System.out.println("\n  Introduix una dels seguents Opcions:\n \n 1. Afegir Alumne \n 2. Editar Alumne \n 3. Llistar  \n 4. Borrar Alumne  \n 5. About \n 6. Sortir\n\n\n");
            opcio = ent.nextInt();

            switch (opcio) {
                case 1:

                    int i;
                    for (i = 0; i < array.length && array[i].isOmplit(); i++);

                    System.out.println("HAS ESCOLLIT LA OPCIO DE AFEGIR ALUMNE\n\n");
                    System.out.println("___________________________________________");
                    System.out.println("___________________________________________");
                    if (i < array.length) {

                        System.out.print("Introdueix Nom de Alumne: \n");
                        array[i].setNom(ent.skip("[\r\n]*").nextLine());

                        System.out.print("Introdueix Nom de Cicle:\n ");
                        array[i].setNomCicle(ent.skip("[\r\n]*").nextLine());

                        System.out.print("Introdueix Numero de moduls Aprovats: \n");
                        array[i].setMp(ent.nextInt());

                        System.out.print("Introdueix la Nota mes alta de moduls Aprovats: \n");
                        array[i].setNota1(ent.nextDouble());

                        System.out.print("Introdueix Numero del Moduls Suspesos: \n");

                        array[i].setMs(ent.nextInt());

                        System.out.print("Introdueix la Nota mes Baixa de moduls Suspesos :\n");
                        array[i].setNota2(ent.nextDouble());

                        System.out.println("\n");
                        System.out.println("___________________________________________");
                        System.out.println("___________________________________________");

                        array[i].setOmplit(true);
                    } else {
                        System.out.println("Ja tens Dades Introduides\n");
                        System.out.println("Vols Mostrar o Llistar Les Dades Guardades?( 1.Si o 2.No ):\n");
                        mostrar = ent.nextInt();
                        switch (mostrar) {
                            case 1:
                                System.out.println("-------------------------------------------------------------------");
                                System.out.println("| Nom Alumne: " + (array[i].getNom()));
                                System.out.println("| Nom Curs: " + (array[i].getNomCicle()));
                                System.out.format(" | Numero de moduls Aprovats:  %s   i la nota Més alta: %s", array[i].getMp(), array[i].getNota1());
                                System.out.format(" | Numero de moduls Suspesos:  %s   i la nota Més alta: %s", array[i].getMs(), array[i].getNota2());
                                System.out.println("-------------------------------------------------------------------");
                                break;
                            default:
                                break;
                        }
                    }
                    System.out.println("Introdueix una Tecla per continuar.....");
                    tecla = ent.skip("[\r\n]*").nextLine();

                    break;
                case 2:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE EDITAR\n\n");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("| Nom Alumne: " + (array[i].getNom()));
                    System.out.println("| Introduix El Nom Editat: ");
                    array[i].setNom(ent.skip("[\r\n]*").nextLine());
                    System.out.println("| Nom Curs: " + (array[i].getNomCicle()));
                    System.out.print("  | Introdueix Nom de Cicle Editat:\n ");
                    array[i].setNomCicle(ent.skip("[\r\n]*").nextLine());
                    System.out.format(" | Numero de moduls Aprovats:  %s   i la nota Més alta: %s  \n", array[i].getMp(), array[i].getNota1());
                    System.out.print(" |Introdueix Numero de moduls Aprovats:  i la nota més Alta \n");
                    array[i].setMp(ent.nextInt());          array[i].setNota1(ent.nextDouble());
                        
                        
                    System.out.format(" | Numero de moduls Suspesos:  %s   i la nota Més alta: %s",array[i].getMs(), array[i].getNota2());
                    System.out.print(" | Introdueix Numero de moduls Supesos:  i la nota més baixa \n");
                    array[i].setMs(ent.nextInt());          array[i].setNota2(ent.nextDouble());
                    System.out.println("Introdueix una Tecla per continuar.....");
                    tecla = ent.skip("[\r\n]*").nextLine();

                    break;
                case 3:
                    
                    
                    array[i].setTotm(array[i].getMp()+array[i].getMs());

                    System.out.println("HAS ESCOLLIT LA OPCIO DE LLISTAR\n\n");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("|  Nom Alumne: " + (array[i].getNom()));
                    System.out.println("| Nom Curs: " + (array[i].getNomCicle()));
                    System.out.format(" | Numero de moduls Aprovats:  %s   i la nota Més alta: %s", array[i].getMp(), array[i].getNota1());
                    System.out.format(" | Numero de moduls Suspesos:  %s   i la nota Més alta: %s\n", array[i].getMs(), array[i].getNota2());

                    if (array[i].getNota1() > array[i].getNota2() && array[i].getMp()> array[i].getMs()) {
                        array[i].setEstat(true);
                        System.out.println("Estat Aprovat!!");
                    } else {
                        array[i].setEstat(false);
                        System.out.println("Estat Suspes!!");
                    }
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Introdueix una Tecla per continuar.....");

                    tecla = ent.skip("[\r\n]*").next();

                    break;
                case 4:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE BORRAR\n\n\n");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("-------------- Ojo Esteu Segur de Borrar Tots els Registres? 1-Si o 2-No");
                    System.out.println("intodueix una opcio:");
                    mostrar = ent.nextInt();
                    switch (mostrar) {
                        case 1:
                            array[i].setOmplit(false);
                          
                            System.out.println("----------------------------------");
                            System.out.println("| Nom Alumne: Borrat!! ");
                            System.out.println("| Nom Curs: Borrat!! ");
                            System.out.println("| Moduls aprovats i Nota: Borrats!! ");
                            System.out.println("| Moduls suspesos  i nota : Borrats!! ");
                            System.out.println("---------------Dades borrrades 100%!! ");
                            System.out.println("Introdueix una Tecla per continuar.....");
                            tecla = ent.skip("[\r\n]*").next();
                            break;
                        default:
                            break;
                    }

                    break;
                case 5:
                    System.out.println("----------------About------------------");
                    System.out.println("Aquest Programa Es Creat Per:\n");
                    System.out.println("Ayoub Ait \n Curs: 2016 - 2017 \n Cicle: 1r - Administració de Sistemes Informatics de Xarxes ");
                    System.out.println("___________________________________________");
                    System.out.println("Introdueix una Tecla per continuar.....");
                    tecla = ent.skip("[\r\n]*").next();
                    break;
                case 6:
                    System.out.println("\n\n-------HAS ESCOLLIT LA OPCIO DE SORTIR------");

                    break;
                default:
                    System.out.println(" !!! Perfavor Introdueix una de les OPCIONS !!!\n\n  ");
            }

        } while (opcio != 6);
    }

}
