
package repositories;

import java.util.List;
import domain.*;

public interface IMotorRepository extends IRepository<Motor> {
	public List<Motor> pokaz_marke(String marka);
	public List<Motor> pokaz_model(String model);
    public List<Motor> pokaz_przebieg(int przebieg);
    public List<Motor> pokaz_naped(Naped naped);
}
