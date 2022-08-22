
/**
 *
 * This class is for import the .jar
 *
 * @author Rizky Nakami Afif
 */
package com.example.assignment1;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

    public class Assignment1 extends Application {
        /**
         * This file is for webscraping data from github and divide it into certain condition
         * @param Rizky Nakami Afif
         * @param Indonesia
         */
        private final String myString = "List-of-Supervisors-(A211)";
        private Document doc;






        public static void main(String[] args) {
            launch(args);
        }


        @Override
        public void start(Stage stage) throws Exception {

            int i = 0;
            int malay = 0;
            int indi = 0;
            int chi=0;
            int tSPV =0;
            final String githubLink = "https://github.com/socuum/STIX3912/wiki/List-of-Supervisors-(A211)";
            String[] ticker = new String[200];
            String[] name = new String[200];
            String[] matric = new String[200];
            String[] supervisor = new String[200];
            try {

                final Document document = Jsoup.connect(githubLink).get();
                for (Element row : document.select("table tr"))
                    if (row.select("td:nth-of-type(1)").text().equals("")) {
                        continue;
                    } else {
                        ticker[i] =
                                row.select("td:nth-of-type(1)").text();
                        matric[i] =
                                row.select("td:nth-of-type(2)").text();
                        name[i] =
                                row.select("td:nth-of-type(3)").text();
                        supervisor[i] =
                                row.select("td:nth-of-type(4)").text();
                        System.out.println(ticker[i] + " " + matric[i] + " " + name[i] + " " + supervisor[i]);
                        i++;
                    }

                for (int x = 0; x < i; x++) {

                    if (name[x].contains("BIN")==true||name[x].contains("BINTI")==true){
                        malay++;


                    }
                    else if (name[x].contains("A/P")==true||name[x].contains("A/L")==true){
                        indi++;


                    }
                    else {
                        chi++;

                    }





                }
                System.out.println("Malay Student List:");
                for (int x = 0; x < i; x++) {

                    if (name[x].contains("BIN")==true||name[x].contains("BINTI")==true){
                        System.out.println(name[x]);
                    }
                }
                System.out.println("Indian Student List:");
                for (int x = 0; x < i; x++) {

                    if (name[x].contains("A/P")==true||name[x].contains("A/L")==true){
                        System.out.println(name[x]);
                    }
                }
                System.out.println("Chineses Student List:");
                for (int x = 0; x < i; x++) {

                    if (name[x].contains("A/P")!=true&&name[x].contains("A/L")!=true&&name[x].contains("BIN")!=true&&name[x].contains("BINTI")!=true){
                        System.out.println(name[x]);
                    }
                }

                ThreadMalay malaysian = new ThreadMalay(malay,indi,chi,i);
                System.out.println("Supervisor List:");

                for (int x = 0; x < i; x++) {
                    if (supervisor[x].equals(supervisor[x+1] )==true
                            &&supervisor[x].equals(supervisor[x + 2] )!=true&&supervisor[x].equals(supervisor[x + 3] )!=true) {


                        System.out.println(supervisor[x]);
                        tSPV++;


                    }

                }
                ThreadSPV spvs = new ThreadSPV(tSPV);
                secondcount seken = new secondcount();





            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }