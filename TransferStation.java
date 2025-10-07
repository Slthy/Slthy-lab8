import java.util.*;

public class TransferStation extends Station{

    public ArrayList<Station> otherStations = new ArrayList<>();
    public TransferStation(String line, String name){
        super(line, name);
    }

    public void addTransferStationNext(Station next){
        next.prev = this;
    }
    public void addTransferStationPrev(Station prev){
        prev.next = this;
    }

    @Override
    public String toString(){
        String output = "TRANSFER" + super.toString() + "\n\tTransfers: \n";
        otherStations.forEach(s -> output += "\t" + s.toString() + "\n");
        return output;
    }
}