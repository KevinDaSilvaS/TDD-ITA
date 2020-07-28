package com.points;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Armazenamento {
    private File myObj = new File("C:"+ File.separator + 
    "Users" + File.separator + "user" + File.separator + 
    "Documents" + File.separator + "TDD" + File.separator + 
    "points" + File.separator + "points" + File.separator + "data.txt");

    private List<String> lista;

	public String add(String user, int amount, String type) {
        try {
            FileWriter myWriter = new FileWriter("data.txt", true);
            myWriter.write(user + " " + amount + " " + type + "\n");
            myWriter.close();
            return("o usuario "+ user +" recebeu "+ 
            amount +" pontos do tipo " + type);

        } catch (IOException e) {
            e.printStackTrace();
            return ("An error occurred.");
        
        }
	}

	public List<String> searchUser(String user) {
        List<String> lista = this.search(0, user, 0);
        return lista;
    }

    public List<String> searchPoint(String point) {
        List<String> lista = this.search(2, point, 1);

        return lista;
    }

    public List<String> processList(String line, List<String> lista){

        String[] parts = line.split(" ");

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(parts[0])) {
                return lista;
            }
        }
        lista.add(parts[0]);
        return lista;
    }

    public List<String> validateSearchUser(String line, int pos, 
    String compare, List<String> lista){

        String[] parts = line.split(" ");

        if (parts[pos].equals(compare)){
            System.out.println(line.toString());
            lista.add(line.toString());
        }

        return lista;
    }
    
    public List<String> search(int pos, String compare, int method){
        lista = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(myObj)); 
                
            String st; 
            while ((st = br.readLine()) != null){
                if (method == 0) {
                    lista = validateSearchUser(st, pos, compare,  lista);
                }
                if (method == 1) {
                    lista = processList(st, lista);
                }
            }
            br.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

}
