package com.mycompany.aula25042024;

import DAO.MySQLConnection;
import Helper.Teste;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1072221113
 */
public class Aula25042024 {

    public static void main(String[] args) {
        Teste.testeCPF();
        try {
            MySQLConnection mysql = MySQLConnection.getInstance();
            Connection con = mysql.getConnection();
            Statement st = con.createStatement();
            st.execute("INSERT INTO aluno values('Marcelo','123.456.789-10','M')");
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Aula25042024.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
