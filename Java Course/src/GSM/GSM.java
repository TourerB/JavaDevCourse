package GSM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class GSM {
    public static void main(String[] args) throws IOException {


        // Заполняем массив исходных данных
        String inp[] = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

        // Создаем массив автомобилей
        Car car[] = new Car[inp.length];

        for (int i = 0; i < (inp.length); i++) {
            int index1 = inp[i].indexOf("C") + 1;
            int index2 = inp[i].indexOf("_", index1 + 1);
            int index3 = inp[i].indexOf("-", index2 + 1);
            int index4 = inp[i].indexOf("-", index3 + 1);

            /*System.out.println( "index1 = " + index1 +
                                " index2 = " + index2 +
                                " index3 = " + index3 +
                                " index4 = " + index4
                                 );*/

            String parseCode = inp[i].substring(index1, index2);
            //System.out.println("_" + parseCode + "_");
            int parseSign = Integer.parseInt(inp[i].substring(index2 + 1, index3));
            //System.out.println("_" + parseSign + "_");
            if (index4 > 0) {
                int parseMileage = Integer.parseInt(inp[i].substring(index3 + 1, index4));
                //System.out.println("_" + parseMileage + "_");
                String parseParam = inp[i].substring(index4 + 1);
                //System.out.println("_" + parseParam + "_");
                car[i] = new Car(parseCode, parseSign, parseMileage, parseParam);
            } else {
                int parseMileage = Integer.parseInt(inp[i].substring(index3 + 1));
                //System.out.println("_" + parseMileage + "_");
                car[i] = new Car(parseCode, parseSign, parseMileage);
            }
        }


            //System.out.println(car[i].toString());




            // Вывод информации о классе авто

            //Scanner scanner = new Scanner (System.in);
            System.out.println("Введите класс авто:");
           // int cl;
            //String a = "";
            /*System.out.println("a");
            if (scanner.hasNextLine()) {
                System.out.println("next");
                a = scanner.nextLine();
                System.out.println("Введено " + a);
                for (int j = 0; j < i; j++) {
                    if (car[i].code == a) {
                        System.out.println(car[i].toString());
                    }
                }
            } else {
                System.out.println("Выходим...");
                scanner.close();
            }*/
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String classAuto = reader.readLine();
            //System.out.println(classAuto);


            for (int j = 0; j < inp.length; j++) {
                if (car[j].code.equals(classAuto)) {
                    System.out.println(car[j].toString());
                }
            }

        HashMap<Integer, Double> fuel = new HashMap();
        fuel.put (100, 0.0);
        fuel.put (200, 0.0);
        fuel.put (300, 0.0);
        fuel.put (400, 0.0);
// Подсчет расхода


        double f100 = 0.0, f200 = 0.0, f300 = 0.0, f400 = 0.0, totalCost = 0.0;

        for (int i = 0; i < inp.length; i++) {
            if (car[i].code.equals("100")) {
                f100 = f100 + car[i].mileage * 12.5 / 100;
                fuel.put(100, f100);
                totalCost = totalCost + f100;
            }
            if (car[i].code.equals("200")) {
                f200 = f200 + car[i].mileage * 12.0 / 100;
                fuel.put(200, f200);
                totalCost = totalCost + f200;
            }
            if (car[i].code.equals("300")) {
                f300 = f300 + car[i].mileage * 11.5 / 100;
                fuel.put(300,  f300);
                totalCost = totalCost + f300;
            }
            if (car[i].code.equals("400")) {
                f400 = f400 + car[i].mileage * 20.0 / 100;
                fuel.put(400, f400);
                totalCost = totalCost + f400;
            }
        }



        System.out.println("Общие расходы на топливо составили: "+ totalCost);
        System.out.println("Расходы по классу 100: " + f100);
        System.out.println("Расходы по классу 200: " + f200);
        System.out.println("Расходы по классу 300: " + f300);
        System.out.println("Расходы по классу 400: " + f400);
        //System.out.println("Наибольшую стоимость расходов имеет класс "+   fuel.get(100));
//Необходимо достать ключ fuel  с макс и мин значениями.

/*
            String parseCode = inp[i].substring(inp[i].indexOf("C")+ 1 ,inp[i].indexOf("_"));
                int parseSign    = Integer.parseInt(inp[i].substring(inp[i].indexOf("_") + 1, inp[i].indexOf("-")));
                int parseMileage = Integer.parseInt(inp[i].substring(inp[i].indexOf("_") + 1, inp[i].indexOf("-")));
*/


            //car[i] = new Car (inp[i]);
                   /* inp[i].substring(inp[i].indexOf("C")+ 1 ,inp[i].indexOf("_")),
            Integer.parseInt(inp[i].substring(inp[i].indexOf("_") + 1, inp[i].indexOf("-"))),
            Integer.parseInt(inp[i].substring(inp[i].indexOf("-") + 1, inp[i].lastIndexOf("-")+1))
                    //inp[i]*/

            //System.out.println( car[i].code);   // Здесь необходимо распарсить массив исходных данных
            //System.out.println(car[i].toString());
        }

        ////


       /* String s = "C200_1-100-750";
        String code = s.substring(s.indexOf("C")+ 1 ,s.indexOf("_"));
        int sign = Integer.parseInt(s.substring(s.indexOf("_") + 1, s.indexOf("-")));
        int mileage = Integer.parseInt(s.substring(s.indexOf("-") + 1, s.lastIndexOf("-")));
        String param = s.substring(s.lastIndexOf("-")+1);
        System.out.println("lastIndexOf" + s.lastIndexOf("-"));
        System.out.println(s + "   _" + code + "_ _" + sign + "_ _" + mileage + "_ _" + param);
*/


    }
//}
