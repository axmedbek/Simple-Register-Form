package com.photoSave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by axmedbek on 6/15/17.
 */
public class dbUtil {

    static final String Data_Server="com.mysql.jdbc.Driver";
    static final String URL="jdbc:mysql://localhost:3306/register";
    static final String USERNAME="root";
    static final String PASSWORD="root";

    public static Connection getConnection()
    {
        Connection conn = null;
        try {
            Class.forName(Data_Server);

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e)
        {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       /* finally {
            if(conn!=null)
            {
                try {
                    conn.close();
                }
                catch (Exception e){}
            }
        }*/

        return conn;
    }
}
