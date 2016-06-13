package Dao;

import java.util.List;
import Model.Guitar;

public interface GuitarDao {

	public void save(Guitar guitar);

	public void delete(Integer id);

	public List<Guitar> findAll();

}
