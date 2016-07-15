package persist;

import java.util.ArrayList;

public interface IGenericDAO {

	Boolean create(Object object);
	Object read(Object pk);
	Boolean update(Object object);
	Boolean delete(Object pk);
	ArrayList<Object> readAll();
	
}
