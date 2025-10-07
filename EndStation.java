public class EndStation extends Station{

    public EndStation(String line, String name){
        super(line, name);
    }

    public void makeEnd(){
        if (this.next == null) this.next = this.prev; 
        else this.prev = this.next;
    }

    @Override
    public String toString(){
        return "END" + super.toString();
    }
}