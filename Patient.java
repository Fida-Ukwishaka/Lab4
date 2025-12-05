import java.util.ArrayList;
import java.util.Arrays;

public class Patient implements Recordable {
    private int id;
    private String name;
    private ArrayList<String> history = new ArrayList<>();

    public Patient(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Patient(){
        // for looping from file
    }

    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public ArrayList<String> getHistory(){
        return history;
    }

    public void addHistory(String entry){
        history.add(entry);
    }

    @Override
    public String serialize() {
        String joinedHistory = String.join(";", history);
        return id + "|" + name + "|" + joinedHistory;
    }

    @Override
    public void deserialize(String data){
        String[] parts = data.split("\\|");
        this.id = Integer.parseInt(parts[0]);
        this.name = parts[1];

        if (parts.length > 2 && !parts[2].isEmpty()){
            history = new ArrayList<>(Arrays.asList(parts[2].split(";")));
        }      
    }

    @Override
    public String toString(){
        return id + " - " + name + " (History entries: " + history.size() + ")";
    }
    
}
