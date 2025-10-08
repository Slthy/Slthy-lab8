import java.util.*;

public class Station {
    private String name;
    private String line;
    private boolean inService;
    protected Station prev;
    protected Station next;

    public Station(String line, String name) {
        setLine(line);
        setName(name);
        activateStation();
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        String outputPrevStation = (prev == null) ? "none" : prev.getName();
        String outputNext = (next == null) ? "none" : next.getName();
        return "STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + outputPrevStation + ", next station: " + outputNext;
    }

    public Station getNextStation() { return this.next; }
    public Station getPrev() { return this.prev; }
    public boolean isAvailable() { return this.inService; }
    public String getName() { return this.name; }
    public String getLine() { return this.line; }

    public void addNext(Station next) {
        this.next = next;
        next.prev = this;
    }

    public void addPrev(Station prev) {
        this.prev = prev;
        prev.next = this;
    }

    public void connect(Station s) {
        this.next = s;
        s.prev = this;
    }

    public void activateStation() { this.inService = true; }
    public void deactivateStation() { this.inService = false; }
    public void switchAvailable() { this.inService = !this.inService; }

    public void setName(String name) { this.name = name; }
    public void setLine(String line) { this.line = line; }

    public boolean equals(Station other) {
        return this.name.equals(other.getName()) && this.line.equals(other.getLine());
    }

    public int tripLength(Station dest) {
        return tripLength(dest, 0, new ArrayList<>()); 
    }

    private int tripLength(Station dest, int steps, ArrayList<Station> visited) {
        visited.add(this);
        if (this.equals(dest)) return steps;
        
        if (this instanceof TransferStation){
            TransferStation t = (TransferStation) this;
            for (Station s : t.otherStations){
                visited.add(s);
                if (s.next != null) {
                    if(!visited.contains(s.next)) return s.next.tripLength(dest, ++steps, visited);
                }
            }
        }
        if (this.next != null) {
            if(!visited.contains(this.next)) return this.next.tripLength(dest, ++steps, visited);

        }
        
        return -1; // not found
    }
}