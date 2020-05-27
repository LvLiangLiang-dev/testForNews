import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 * 加快建表速度，工具
 *
 * @author lvliangliang
 * @create 2019-02-25 下午4:44
 */
public class SqlHelp {

    public static void main(String[] args) {
        String sql = "select * from testml.test3;";
        String url = "jdbc:mysql://localhost:3306/testml";
        String password ="root";
        String name = "root";
        String filename = "/Users/lvliangliang/mycode/testfornews/testForNews/result.txt";
        executSqlAndSave2(sql,url,password,name,filename);
    }

    public static void test() {
        String path = "/Users/lvliangliang/Downloads/yuan_train_a.txt";


        File file1 = new File(path);
        int flag = 0;
        List<String> list = new ArrayList<String>();
        List<String> listy = new ArrayList<String>();
        List<String> listx1 = new ArrayList<String>();
        List<String> listx2 = new ArrayList<String>();
        try {
            String encoding = "GBK";
            if (file1.isFile() && file1.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file1), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                    flag++;
                    lineTxt = "";
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("flag:" + flag);
        for (int i = 0; i < flag; i++) {
            String[] split = list.get(i).split(" ");
            listy.add(split[0]);
            listx1.add(split[1].split(":")[1]);
            listx2.add(split[2].split(":")[1]);
            System.out.println(listy.get(i) + " " + listx1.get(i) + " " + listx2.get(i));
        }
        String sql ="";
        for (int i=0;i<flag;i++){
            sql ="insert into test2(y,x1,x2) values (";
            sql+="'";
            sql+=listy.get(i);
            sql+="'";
            sql+=",";
            sql+="'";
            sql+=listx1.get(i);
            sql+="'";
            sql+=",";
            sql+="'";
            sql+=listx2.get(i);
            sql+="'";
            sql +=");";
            System.out.println(sql);
//            insertSql(sql);
            sql ="";
        }



    }

    public static void test1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://172.17.0.1:3306";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            Statement stat = conn.createStatement();
            stat.executeUpdate("create database testml");
            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static void test2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testml";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            Statement stat = conn.createStatement();
            conn = DriverManager.getConnection(url, "root", "root");
            stat = conn.createStatement();
            String sqlstr = "";
            sqlstr = "create table test3(";
            sqlstr += "y VARCHAR(100) NOT NULL,";
            for (int i = 0; i < 2; i++) {
                if (i < 1) {
                    sqlstr += "x" + i + " INT NOT NULL,";
                } else {
                    sqlstr += "x" + i + " INT NOT NULL";
                }
            }
            sqlstr += ");";
            System.out.println(sqlstr);
            stat.execute(sqlstr);
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertSql(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testml";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            Statement stat = conn.createStatement();
            System.out.println(sql);
            stat.executeUpdate(sql);
            //关闭数据库
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getRandomNumber(int left, int right) {
        return (int) (left + Math.random() * (right - 1 + 1));
    }


    public static void executSqlAndSave2(String sql, String url, String password, String name, String filename) {
        File file = new File(filename);
        ResultSet resultSet = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }


            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, name, password);
            Statement stat = conn.createStatement();
            resultSet = stat.executeQuery(sql);



            int columnCount = resultSet.getMetaData().getColumnCount();
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();
            StringBuffer stringBuffer = new StringBuffer();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String column = "";
            while (resultSet.next()) {
                for (int i = 1; i < columnCount; i++) {
                    column = resultSet.getMetaData().getColumnName(i);
                    if ("y".equals(column)) {
                        stringBuffer.append(resultSet.getString(i));
                        stringBuffer.append(" ");
                    }else if("id".equals(column)){
                        stringBuffer =stringBuffer;
                    }else {
                        stringBuffer.append(column.substring(1,column.length()));
                        stringBuffer.append(":");
                        stringBuffer.append(resultSet.getString(i));
                        stringBuffer.append(" ");
                    }
                }
                String temp = stringBuffer.toString().substring(0,stringBuffer.toString().length()-1);
                System.out.println(temp);
                bw.write(temp);
                bw.write("\n");
                stringBuffer.setLength(0);
            }
            bw.close();
            resultSet.close();
            stat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}