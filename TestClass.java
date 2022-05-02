import java.text.DecimalFormat;
import java.util.Scanner;

public class TestClass {
    /*public static void test01(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de pacientes que desea conocer: ");
        int (int)size = sc.nextInt();
        arraySet person = new arraySet((int)size);
        for (int i = 0; i < (int)size; i++){
            System.out.println(arraySet.person[i]); //En la variable estática person[n] viene la información de cada persona [n] generada
        }                                        //aleatoriamente, entonces solo utilizamos el ciclo para mostrar cada elemento del array person
        person.PromWeights();
    }*/

    public static void test02(){
        DecimalFormat formato = new DecimalFormat("###,###");
        while (true){
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Ingrese el número de pacientes que desea conocer: ");
                double size = sc.nextDouble();
                if  ((int)size > 0){
                    System.out.println("");
                    arraySet ppl = new arraySet((int)size);

                    String[] sex = ppl.getSex();
                    String[] nationality = ppl.getNationality();
                    String[] name = ppl.getPerson();
                    int[] age = ppl.getAge();
                    double[] weight = ppl.getWeight();
                    double[] height = ppl.getHeight();
                    String[] blood = ppl.getBlood();

                    Person[] persona = new Person[(int)size];
                    for (int i = 0; i < (int)size; i++){
                        persona[i] = new Person(sex[i], nationality[i], name[i], age[i], weight[i], height[i], blood[i]);
                        System.out.println(formato.format(i+1)+" - " +persona[i].getName()+ " - Residencia (" +persona[i].getNationality()+ ") - Sexo (" +persona[i].getSex()+ ") - Edad (" +persona[i].getAge()+ " años) - Peso (" +arraySet.round(persona[i].getWeight())+ " Kg) - Estatura (" +arraySet.round(persona[i].getHeight())+ " M) - G.S.RH ("+persona[i].getBlood()+ ")");
                    }
                    if ((int)size == 1){
                        System.out.println("Solo evaluaste un paciente no hay promedios que mostrar");
                        if (ppl.getmCount() > 0) System.out.println(" - Entre los pacientes evaluados solo hay un hombre.");
                        if (ppl.getfCount() > 0) System.out.println(" - Entre los pacientes evaluados solo hay una mujer.");
                        System.out.println("\033[0;32m¡Proceso terminado con éxito!");
                        break;
                    }else{
                        System.out.println("");
                        System.out.println(" - El promedio de edades de los " +formato.format((int)size)+ " pacientes evaluados es " +ppl.PromAges()+ " años");
                        if (arraySet.round(ppl.PromWeights())%1 == 0){
                            System.out.println(" - El promedio de pesos de los " +formato.format((int)size)+ " pacientes evaluados es " +(int)ppl.PromWeights()+ " Kg");
                        }else{
                            System.out.println(" - El promedio de pesos de los " +formato.format((int)size)+ " pacientes evaluados es " +arraySet.round(ppl.PromWeights())+ " Kg");
                        }
                        System.out.println(" - El promedio de estaturas de los " +formato.format((int)size)+ " pacientes evaluados es " +arraySet.round(ppl.PromHeight())+ " M");

                        if (ppl.getmCount() > 0 && ppl.getfCount() > 0){
                            if (ppl.getmCount() == 1 && ppl.getfCount() == 1) System.out.println(" - Entre los pacientes evaluados solo hay un hombre y una mujer.");
                            else if (ppl.getmCount() == 1) System.out.println(" - Entre los pacientes evaluados solo hay un hombre y " +formato.format(ppl.getfCount())+ " (" +arraySet.round(ppl.getfPercentaje())+ "%) mujeres.");
                            else if (ppl.getfCount() == 1) System.out.println(" - Entre los pacientes evaluados hay " +formato.format(ppl.getmCount())+ " (" +arraySet.round(ppl.getmPercentaje())+ "%) hombres y solo una mujer.");
                            else System.out.println(" - Entre los pacientes evaluados hay " +formato.format(ppl.getmCount())+ " (" +arraySet.round(ppl.getmPercentaje())+ "%) hombres y " +formato.format(ppl.getfCount())+ " (" +arraySet.round(ppl.getfPercentaje())+ "%) mujeres.");
                        }else if (ppl.getmCount() > 0){
                            if (ppl.getmCount() == 1) System.out.println(" - Entre los pacientes evaluados solo hay un hombre.");
                            else System.out.println(" - Entre los pacientes evaluados hay " +formato.format(ppl.getmCount())+ " hombres.");
                        }else if (ppl.getfCount() > 0){
                            if (ppl.getfCount() == 1) System.out.println(" - Entre los pacientes evaluados solo hay una mujer.");
                            else System.out.println(" - Entre los pacientes evaluados hay " +formato.format(ppl.getfCount())+ " mujeres.");
                        }
                        if ((int)size >= 100){
                            if ((int)size >= 20000){
                                if ((int)size >= 100000){
                                    System.out.println("");
                                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                                    System.out.println("ADVERTENCIA su muestra es superior a los 100,000 pacientes");
                                    System.out.println("este proceso de recolección tardará mucho.");
                                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                                    System.out.print("¿Desea continuar? Si es así dijite (1) de lo contrario (0): ");
                                    int prompt = sc.nextInt();
                                    if (prompt == 1){
                                        System.out.println("");
                                        System.out.println("-----------------------------------------------------------------------------------");
                                        System.out.println("Su muestra de pacientes es de " +formato.format((int)size)+ " deberá esperar a la recolección de datos...");
                                        System.out.println("-----------------------------------------------------------------------------------");
                                        double percentage = ppl.getPercentage();
                                        System.out.println(" - En su mayoría (" +formato.format(ppl.getTimes())+ ") pacientes viven en " +ppl.getCountry()+ ",");
                                        System.out.println("   esto equivale a un " +arraySet.round(percentage)+ "% de "+formato.format((int)size)+ " pacientes evaluados.");
                                    }else{
                                        System.out.println("No se mostrará recolección de datos.");
                                    }
                                }else if ((int)size < 100000){
                                    System.out.println("");
                                    System.out.println("----------------------------------------------------------------------------------------");
                                    System.out.println("Su muestra de pacientes es superior a 20,000 deberá esperar a la recolección de datos...");
                                    System.out.println("----------------------------------------------------------------------------------------");
                                    double percentage = ppl.getPercentage();
                                    System.out.println(" - En su mayoría (" +formato.format(ppl.getTimes())+ ") pacientes viven en " +ppl.getCountry()+ ",");
                                    System.out.println("   esto equivale a un " +arraySet.round(percentage)+ "% de "+formato.format((int)size)+ " pacientes evaluados.");
                                }
                            }else if ((int)size < 20000){
                                double percentage = ppl.getPercentage();
                                System.out.println(" - En su mayoría (" +formato.format(ppl.getTimes())+ ") pacientes viven en " +ppl.getCountry()+ ",");
                                System.out.println("   esto equivale a un " +arraySet.round(percentage)+ "% de "+formato.format((int)size)+ " pacientes evaluados.");
                            }
                        }else System.out.println("Su muestra es menor a 100 pacientes no se mostrará recolección de datos.");
                        System.out.println("\033[0;32m¡Proceso terminado con éxito!");
                        break;
                    }
                }else{
                    System.out.println("\033[0;31mIngrese una cantidad válida de pacientes.\033[0m\n");
                }
            } catch (Exception a){
                System.out.println("\033[0;31mNo ingrese caracteres inválidos, sólo números. Ejemplo: " +(int)((Math.random()*45)+5)+ "\033[0m");
                continue;
            }
        }
    }

    /*public static void test03(){
        Scanner sc = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("###,###");
        System.out.print("Ingrese el número de pacientes que desea conocer: ");
        int size = sc.nextInt();
        if  ((int)size > 0){
            System.out.println("");
            arraySet ppl = new arraySet((int)size);

            String[] sex = ppl.getSex();
            String[] name = ppl.getPerson();
            int[] age = ppl.getAge();
            double[] weight = ppl.getWeight();
            double[] height = ppl.getHeight();
            String[] blood = ppl.getBlood();

            Person[] persona = new Person[(int)size];
            for (int i = 0; i < (int)size; i++){
                //persona[i] = new Person(sex[i], name[i], age[i], weight[i], height[i], blood[i]);
                System.out.println(formato.format(i+1)+" - " +persona[i].getName()+ " - Sexo(" +persona[i].getSex()+ ") - Edad(" +persona[i].getAge()+ " años) - Peso(" +arraySet.round(persona[i].getWeight())+ " Kg) - Estatura(" +arraySet.round(persona[i].getHeight())+ " M) - G.S.RH("+persona[i].getBlood()+ ")");
            }
            if ((int)size == 1){
                System.out.println("Solo evaluaste un paciente no hay promedios que mostrar");
            }else{
                System.out.println("");
                System.out.println("El promedio de edades de los " +formato.format((int)size)+ " pacientes evaluados es " +ppl.PromAges()+ " años");
                if (arraySet.round(ppl.PromWeights())%1 == 0){
                    System.out.println("El promedio de pesos de los " +formato.format((int)size)+ " pacientes evaluados es " +(int)ppl.PromWeights()+ " Kg");
                }else{
                    System.out.println("El promedio de pesos de los " +formato.format((int)size)+ " pacientes evaluados es " +arraySet.round(ppl.PromWeights())+ " Kg");
                }

                if (arraySet.round(ppl.PromHeight())%1 == 0){
                    System.out.println("El promedio de estaturas de los " +formato.format((int)size)+ " pacientes evaluados es " +(int)ppl.PromHeight()+ " M");
                }else{
                    System.out.println("El promedio de estaturas de los " +formato.format((int)size)+ " pacientes evaluados es " +arraySet.round(ppl.PromHeight())+ " M");
                }
            }
        }else{
            System.out.println("Ingrese una cantidad válida de pacientes\n");
        }
    }*/
}