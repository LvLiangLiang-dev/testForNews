package messPass;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2018-10-09 上午11:13
 */
public class TableNameHive {
    static volatile String tablename = "";
    private static String tableNameStore = "";
    //    private static String tableNameStore =
    //            "default,students;default,person;default,default__person_person_index__;default,test_external;";

    private void judge() {
        if (!tablename.equals(tableNameStore)) {
            tableNameStore = tablename;
        }
    }

    public void settablename(String name) throws InterruptedException {
        this.tablename = name;
    }

    public String gettablename() throws InterruptedException {
        String temp;
        judge();
        temp = tableNameStore;
        return temp;
    }
}
