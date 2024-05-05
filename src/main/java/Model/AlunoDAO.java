/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
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
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean removeAluno(String cpf) {
        StringBuilder remover = new StringBuilder();
        remover.append("delete from aluno where cpf = '").append(cpf).append("'");
        try {
            MySQLConnection db = MySQLConnection.getInstance();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            st.execute(remover.toString());
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean alterarAluno(AlunoBean aluno) {
        String sql = " update aluno" +
                     " set nome = '" + aluno.getNome()+"',"+
                     " sexo = '" + aluno.getSexo()+"'"+
                     " where cpf = '" + aluno.getCpf()+"'";
        try {
            MySQLConnection db = MySQLConnection.getInstance();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public AlunoBean consultarPorCpf(String cpf) {
        AlunoBean aluno = null;
        String sql = "select * from aluno where cpf = '" + cpf + "'";
        try {
            MySQLConnection db = MySQLConnection.getInstance();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                aluno = new AlunoBean(rs.getString("nome"), rs.getString("cpf"), rs.getString("sexo").charAt(0));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return aluno;
    }

    @Override
    public ArrayList<AlunoBean> getAlunos() {
        ArrayList<AlunoBean> alunos = new ArrayList<AlunoBean>();
        String sql = "select * from aluno";
        try {
            MySQLConnection db = MySQLConnection.getInstance();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                AlunoBean aluno = new AlunoBean(rs.getString("nome"), rs.getString("cpf"), rs.getString("sexo").charAt(0));
                alunos.add(aluno);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return alunos;
    }
    
}
