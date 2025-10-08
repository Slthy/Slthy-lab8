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

    // FIX 1: Make addNext bidirectional
    public void addNext(Station next) {
        this.next = next;
        next.prev = this;
    }

    // FIX 2: Make addPrev bidirectional
    public void addPrev(Station prev) {
        this.prev = prev;
        prev.next = this;
    }

    // This method should also be bidirectional
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

    public int tripLength(Station destination){
        return 0;
    }
}