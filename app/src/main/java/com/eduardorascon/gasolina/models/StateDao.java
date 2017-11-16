package com.eduardorascon.gasolina.models;

@Dao
public interface StateDao {
	@Query("SELECT * FROM estados");
	public List<State> getAll();

	@Query("SELECT COUNT(*) FROM estados");
	public int countStates();

	@Insert
	public void insertState(State state);

	@Insert
	public void insertStates(List<State> states);

	@Update
	public void updateState(State state);

	@Delete
	public void deleteState(State state);
}