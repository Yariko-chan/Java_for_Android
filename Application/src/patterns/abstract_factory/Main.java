package patterns.abstract_factory;

/**
 * Created by user on 23.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        MyFactory f;
        DataBase db = null;

        if(true /* sdlite*/) {
            f = new SQLiteFactory();
        } else { /*MySQL*/
            f = new MySQLFactory();
        }
        db  = f.getDataBase();
        db.openDB();
        db.getList();
        db.closeDB();
    }
}
