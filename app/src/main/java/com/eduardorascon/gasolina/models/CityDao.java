package com.eduardorascon.gasolina.models;

@Dao
public interface CityDao {
	@Query("SELECT * FROM ciudades");
	List<City> getAll();

	@Query("SELECT COUNT(*) FROm ciudades");

	@Delete
	void delete(City city);
}