import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager<T extends Recordable> {
    
    // Loading objects from a file
    public ArrayList<T> load(String filename, T emptyObject){
        ArrayList<T> list = new ArrayList<>();

        try (Scanner sc = new Scanner (new File(filename))){
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                @SuppressWarnings("unchecked")
                T obj = (T) emptyObject.getClass().getDeclaredConstructor().newInstance();
                obj.deserialize(line);
                list.add(obj);
            }
        }
        catch(Exception e){
            System.out.println("Could not load: " + e.getMessage());
        }
        return list;
    }

    // Saving objects to a file
    public void save(String filename, ArrayList<T> list) {
        try (FileWriter fw = new FileWriter(filename)) {
            for (T item : list) {
                fw.write(item.serialize() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Could not save: " + e.getMessage());
        }
    }
}
