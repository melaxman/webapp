package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDAO {
    public Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String uname = "root";
        String pwd = "";
        String url = "jdbc:mysql://localhost:3306/laxman";
        Connection cn = DriverManager.getConnection(url, uname, pwd);
        return cn;
    }

    public boolean  insert(User user) {
        try {
            Connection cn = connect();
            PreparedStatement st = cn.prepareStatement("INSERT INTO student VALUES (?, ?)");
            st.setString(1, user.getEmail());
            st.setString(2, user.getPass());
            int i = st.executeUpdate();
            if(i>0){
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

}
