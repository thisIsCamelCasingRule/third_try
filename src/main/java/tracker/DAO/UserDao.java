package tracker.DAO;

import java.util.List;

public abstract interface UserDao<T> {
    public List<T> getAllUsers();
    public T getUser(String username);
    public void updateUser(T u);
    //public T getById(int id);
    public void deleteUser(T u);
    public void insertUser(T u);
}
