package patterns.abstract_factory;

/**
 * Created by user on 23.06.2017.
 */
public class MySQLFactory implements MyFactory {
    @Override
    public DataBase getDataBase() {
        MySQLDB db = new MySQLDB();
        return db;
    }
}
