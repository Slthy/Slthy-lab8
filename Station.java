/*
Station s2 = new Station("green", "Square");
Station s3 = new Station("blue", "Plaza");
s1.addNext(s2);
expected = "STATION Museum: pink line, in service: true, previous station: none, next station: Square";
assertEquals(expected, s1.toString());
expected = "STATION Square: green line, in service: true, previous station: Museum, next station: none";
assertEquals(expected, s2.toString());

*/


public class Station{
    private String name;
    private String line;
    private boolean inService;
    protected Station previousStation;
    protected Station nextStation;

    @Override
    public String toString(){
        String outputPrevStation = (previousStation == null) ? "none" : previousStation.getName();
        String outputNextStation = (nextStation == null) ? "none" : nextStation.getName();
        return "STATION " + this.name + ": " + this.line + " line, in service " + this.inService + " , previous station: " + outputPrevStation + ", next station: " + outputNextStation;
    }

    public Station(String line, String name){
        setLine(line);
        setName(name);
        activateStation();
        previousStation = null;
        nextStation = null;
    }
    public Station(String line, String name, Station previousStation){
        setLine(line);
        setName(name);
        activateStation();
        addPrev(previousStation);
        nextStation = null;
    }

    public Station(String line, String name, Station previousStation, Station nextStation){
        setLine(line);
        setName(name);
        activateStation();
        addPrev(previousStation);
        addNext(nextStation);
    }

    public Station getNextStation(){
        return this.nextStation;
    }
    public Station getPreviousStation(){
        return this.previousStation;
    }

    public boolean isAvailable(){
        return this.inService;
    }

    public String getName(){
        return this.name;
    }

    public String getLine(){
        return this.line;
    }

    /*public void addNext(Station nextStation){
        this.nextStation = nextStation;
        nextStation.previousStation = this;
    }
    public void addPrev(Station previousStation){
        this.previousStation = previousStation;
        previousStation.nextStation = this;
    }*/
    public void addNext(Station nextStation){
        this.nextStation = nextStation;
    }
    public void addPrev(Station previousStation){
        this.previousStation = previousStation;
    }

    //connect: s1.s2 means s1 is prev and s2 is next

    public void connect(Station s){
        this.nextStation = nextStation;
        nextStation.previousStation = this;
    }
    public void activateStation(){
        this.inService = true;
    }
    public void deactivateStation(){
        this.inService = false;
    }
    public void switchAvailable() {
        this.inService = !this.inService;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setLine(String line){
        this.line = line;
    }

    public boolean equals(Station other){
        return this.name == other.getName() && this.line == other.getLine();
    }
}