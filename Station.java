public class Station{
    private String name;
    private String line;
    private boolean inService;
    protected Station prev;
    protected Station next;

    @Override
    public String toString() {
        String outputPrevStation = (prev == null) ? "none" : prev.getName();
        String outputnext = (next == null) ? "none" : next.getName();
        return "STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + outputPrevStation + ", next station: " + outputnext;
    }


    public Station getNextStation() { return this.next; }
    public Station getPrev() { return this.prev; }
    public boolean isAvailable() { return this.inService; }
    public String getName() { return this.name; }
    public String getLine() { return this.line; }

    public void addNext(Station next) { this.next = next; }
    public void addPrev(Station prev) { this.prev = prev; }

    // Connects two stations bidirectionally
    public void connect(Station s) {
        this.next = s;
        s.prev = this;
    }

    public void activateStation() { this.inService = true; }
    public void deactivateStation() { this.inService = false; }
    public void switchAvailable() { this.inService = !this.inService; }

    public void setName(String name) { this.name = name; }
    public void setLine(String line) { this.line = line; }
    public void setLine(String line) { this.line = line; }

    public boolean equals(Station other){
        return this.name.equals(other.getName()) && this.line.equals(other.getLine());
    }
}