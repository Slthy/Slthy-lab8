import java.util.*;

public class TransferStation extends Station {

    public ArrayList<Station> otherStations = new ArrayList<>();

    public TransferStation(String line, String name) {
        super(line, name);
    }

    public void addTransfer(Station s) {
        if (!otherStations.contains(s)) {
            otherStations.add(s);
        }
    }

    // bidirectional link
    public void addTransferStationNext(Station next) { 
        addTransfer(next);
        next.prev = this; // link the other station back to this one
    }

    // bidirectional link
    public void addTransferStationPrev(Station prev) { 
        addTransfer(prev);
        prev.next = this; // link the other station back to this one
    }

    @Override
    public String toString() {
        String stationDetails = super.toString().replace("STATION", "TRANSFERSTATION");
        String output = stationDetails + "\n\tTransfers: \n";

        for (Station s : otherStations) {
            output += "\t" + s.toString() + "\n";
        }
        return output;
    }
}