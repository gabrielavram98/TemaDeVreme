package ro.mta.se.lab.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clasa Manager se ocupa cu preluarea datelor de intrare din fisier si stocarea lor organizata
 * pentru facilitarea uzului acestora in cadrul aplicatiei.
 * @author Avram Gabriel
 */
public class Manager {
    /**
     * Descrierea membrilor:
     * Cities este un vector de obiecte City in care se salveaza datele oraselor din fisierul de intrare.
     * countries este o lista cu numele tarilor din care fac parte orasele din fisierul de intrare.
     */
    private final ArrayList<City> Cities = new ArrayList<>();
    private final ArrayList<String> countries = new ArrayList<>();
    public Manager() {
        read_config_file();
    }

    /**
     * Aceasta functie citeste fisierul de intrare si creaza obiecte City pe care le introduce in lista.
     */
    public void read_config_file()  {
        File f;
        f = new File("src/main/java/ro/mta/se/lab/model/countries.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(f);
            while( scan.hasNext())
            {
                int id=Integer.parseInt(scan.next());

                String name=scan.next();

                float lat =Float.parseFloat(scan.next());
                float lng=Float.parseFloat(scan.next());
                String countryID=scan.next();

               String country = addCountry(countryID);
                Cities.add(new City(name,country,lat,lng,countryID));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Functia aceasta interogheaza lista de orase si le extrage pe cele care fac parte din tara data ca argument.
     * @param country reprezinta tara pe baza careia se extrag orasele corespunzatoare.
     *
     */
    public ArrayList<String> CitiesByCountry(String country)
    {
        ArrayList<String> cities= new ArrayList<>();

        for (City var:Cities)
        {
            if(var.compare(country)==1)
            {
                cities.add(var.getName());
            }


        }
        return cities;
    }

    /**
     * functia addCountry adauga in lista de tari o singura intrare pentru fiecare tara detectata in fisierul de intrare.
     * @param IdCountry
     * @return
     */
    public String addCountry(String IdCountry){
        String country;
        switch (IdCountry) {
            case "RO" -> {
                if (!countries.contains("Romania")) {
                    countries.add("Romania");


                }
                country = "Romania";
            }
            case "BG" -> {
                if (!countries.contains("Bulgaria")) {
                    countries.add("Bulgaria");
                }
                country = "Bulgaria";
            }
            case "GR" -> {
                if (!countries.contains("Grecia")) {
                    countries.add("Grecia");
                }
                country = "Grecia";
            }
            case "RU" -> {
                if (!countries.contains("Rusia")) {
                    countries.add("Rusia");
                }
                country = "Rusia";
            }
            case "GB" -> {
                if (!countries.contains("Marea Britanie")) {
                    countries.add("Marea Britanie");
                }
                country = "Marea Britanie";
            }
            case "NL" -> {
                if (!countries.contains("Olanda")) {
                    countries.add("Olanda");
                }
                country = "Olanda";
            }
            case "DE" -> {
                if (!countries.contains("Germania")) {
                    countries.add("Germania");
                }
                country = "Germania";
            }
            case "FR" -> {
                if (!countries.contains("Franta")) {
                    countries.add("Franta");
                }
                country = "Franta";
            }
            case "ES" -> {
                if (!countries.contains("Spania")) {
                    countries.add("Spania");
                }
                country = "Spania";
            }
            case "IT" -> {
                if (!countries.contains("Italia")) {
                    countries.add("Italia");
                }
                country = "Italia";
            }
            default -> country = "Not recognised";
        }
        return country;

    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    /**
     *
     * Aceasta functie retureaza o lista de orase care corespund tarii date ca parametru.
     * @return
     */
    public String getCityCountryID(String city){

        String id= "";
        for (City var: Cities)
        {
            if(var.getName().equals(city))
            {
                id=var.getCountryID();
            }

        }
        return id;
    }
}
