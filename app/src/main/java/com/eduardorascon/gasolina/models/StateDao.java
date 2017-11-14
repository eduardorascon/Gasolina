package com.eduardorascon.gasolina.models;

@Dao
public interface StateDao {
	@Query("SELECT * FROM estados");
	List<State> getAll();

	@Query("SELECT COUNT(*) FROM estados");
	int countStates();

	@Delete
	void delete(State state);
}
