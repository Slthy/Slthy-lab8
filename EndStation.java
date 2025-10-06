public class EndStation extends Station{

    public EndStation(String line, String name){
        super(line, name);
    }

    public void makeEnd(){
        if(getNextStation() != null && getPreviousStation() == null) addPrev(getNextStation());
        if(getNextStation() == null && getPreviousStation() != null) addNext(getPreviousStation());
    }

    @Override
    public String toString(){
        return "END" + super.toString();
    }
}