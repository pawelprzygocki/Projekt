package domain;
public class Motor extends Auto {
private Naped naped;

public Motor(String marka, String model, int przebieg, Naped naped) {
super(marka, model, przebieg);
this.naped = naped;
}
public Motor(){
}
public Naped getNaped() {
return naped;
}

public void setNaped(Naped naped) {
this.naped = naped;
}
}