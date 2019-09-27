package peopleMoverDB.dao;

import java.util.List;

import peopleMoverDB.model.Favorite;

public interface FavoriteDAO {

	//CRUD operations
    
    //Create
	public int save(Favorite fav);
	//Read
	public Favorite getFavorite(String token,String StopId, String RouteId);
	//Update
	public int update(Favorite fav);
	//Delete
	public int deleteFavorite(String token,String StopId, String RouteId);
	//GET ALL
	public List<Favorite> getAll();
	public List<Favorite> getAll(String token);
}
