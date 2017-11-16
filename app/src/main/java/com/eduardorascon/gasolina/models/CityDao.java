package com.eduardorascon.gasolina.models;

@Dao
public interface CityDao {
	@Query("SELECT * FROM ciudades");
	public List<City> getAll();

	@Query("SELECT COUNT(*) FROm ciudades");
	public int countCities();

	@Insert
	public void insertCity(City city);

	@Insert
	public void insertCities(List<City> cities)

	@Update
	public void updateCity(City city);

	@Delete
	public void deleteCity(City city);
}