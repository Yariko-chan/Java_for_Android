package patterns.abstract_factory;

/**
 * Created by user on 23.06.2017.
 */
public class SQLiteFactory implements MyFactory {
    @Override
    public DataBase getDataBase() {
        SQLiteDB db = new SQLiteDB();
        return db;
    }
}
