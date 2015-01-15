package domain;

public class Naped {
String producent;
int ilosc_cylindrow;
String rodzaj;
public Naped(String producent, int ilosc_cylindrow, String rodzaj) {
	this.producent = producent;
	this.ilosc_cylindrow = ilosc_cylindrow;
	this.rodzaj = rodzaj;
}
public Naped(){
	
}
public String getProducent() {
	return producent;
}
public void setProducent(String producent) {
	this.producent = producent;
}
public int getIlosc_cylindrow() {
	return ilosc_cylindrow;
}
public void setIlosc_cylindrow(int ilosc_cylindrow) {
	this.ilosc_cylindrow = ilosc_cylindrow;
}
public String getRodzaj() {
	return rodzaj;
}
public void setRodzaj(String rodzaj) {
	this.rodzaj = rodzaj;
}
}
