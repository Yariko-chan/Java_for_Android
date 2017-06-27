package patterns.abstract_factory;

/**
 * Created by user on 23.06.2017.
 */
public interface DataBase {

    public void openDB();
    public void closeDB();

    public void getList();
    // all methods for work with DB
}
