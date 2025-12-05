public interface Recordable{
    //convert object to one line of text for saving
    String serialize();

    //Build the object back from one line of text
    void deserialize(String data);

}