/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.MySQLConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1072221113
 */
public class AlunoDAO implements AlunoDAOInterface{

    @Override
    public boolean cadastrarAluno(AlunoBean aluno) {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into aluno values(");
            sql.append("'").append(aluno.getNome()).append("',");
            sql.append("'").append(aluno.getCpf()).append("',");
            sql.append("'").append(aluno.getSexo()).append("'");
            sql.append(")");
        try {
            MySQLConnection db = MySQLConnection.getInstance();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            st.execute(sql.toString());
            st.close();
            con.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean removeAluno(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean alterarAluno(AlunoBean aluno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AlunoBean consultarPorCpf(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AlunoBean> getAlunos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
