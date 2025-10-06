import java.util.*;

public class TransferStation extends Station{

    private ArrayList<Station> al = new ArrayList<>();
    public TransferStation(String line, String name){
        super(line, name);
    }

    public void addTransferStationNext(Station next){
        next.previousStation = this;
        al.add(next);
    }
    public void addTransferStationPrev(Station prev){
        prev.nextStation = this;
        al.add(prev);
    }

    @Override
    public String toString(){
        String output = "TRANSFER" + super.toString() + "\n\tTransfers: \n";
        al.forEach(s -> output += "\t" + s.toString() + "\n");
        return output;
    }
}