package com.mycompany.aula25042024;

import DAO.MySQLConnection;
import Helper.RegraHelper;
import Helper.Teste;
import Model.AlunoBean;
import Model.AlunoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author 1072221113
 */
public class Aula25042024 {

    public static void main(String[] args) {
        menu();
        /*Teste.testeCPF();
        try {
            MySQLConnection mysql = MySQLConnection.getInstance();
            Connection con = mysql.getConnection();
            Statement st = con.createStatement();
            st.execute("INSERT INTO aluno values('Marcelo','123.456.789-10','M')");
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Aula25042024.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public static void cadastrar(){
        String nome = JOptionPane.showInputDialog(null, "Nome: ");
        String cpf = "";
        do{
            cpf = JOptionPane.showInputDialog(null, "CPF: ");
        } while(!RegraHelper.validarCPF(cpf));
        String sexo = JOptionPane.showInputDialog(null, "Sexo: ");
        AlunoBean aluno = new AlunoBean(nome, cpf, sexo.charAt(0));
        AlunoDAO alunodao = new AlunoDAO();
        alunodao.cadastrarAluno(aluno);
    }   
    
    public static void remover(){
        String cpf = JOptionPane.showInputDialog("CPF");
        AlunoDAO alunodao = new AlunoDAO();
        if (alunodao.removeAluno(cpf)){
            JOptionPane.showMessageDialog(null, "Aluno Removido", "Remover aluno", JOptionPane.WARNING_MESSAGE,null);
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não foi removido", "Remover aluno", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    /*public static void alterar(){
        String nome = JOptionPane.showInputDialog(null, "Novo nome:");
        String cpf = "";
        do{
            cpf = JOptionPane.showInputDialog(null, "CPF");
        } while (!RegraHelper.validarCPF(cpf));
        String sexo = JOptionPane.showInputDialog(null, "Novo Sexo");
        AlunoBean aluno = new AlunoBean(nome, cpf, sexo.charAt(0));
        AlunoDAO alunodao = new AlunoDAO();
        if (alunodao.alterarAluno(aluno)){
            JOptionPane.showMessageDialog(null, "Aluno Alterado", "Alterar aluno", JOptionPane.WARNING_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não foi alterado", "Alterar aluno", JOptionPane.ERROR_MESSAGE, null);
        }
    }*/
    
    public static void alterar(){
        String cpf = JOptionPane.showInputDialog("CPF: ");
        AlunoDAO alunodao = new AlunoDAO();
        AlunoBean aluno = alunodao.consultarPorCpf(cpf);
        if (aluno == null) {
            JOptionPane.showMessageDialog(null, "CPF Inexistente!");
            return;
        }
        String nome = JOptionPane.showInputDialog("Novo nome: ", aluno.getNome());
        String sexo = JOptionPane.showInputDialog("Novo sexo: ", aluno.getSexo());
        aluno.setNome(nome);
        aluno.setSexo(sexo.charAt(0));
        if (alunodao.alterarAluno(aluno)) {
            JOptionPane.showMessageDialog(null, "Aluno Alterado!");
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não foi alterado!");
        }
    }
    
    public static void listar(){
        String dados = "";
        AlunoDAO alunodao = new AlunoDAO();
        ArrayList<AlunoBean> todos = alunodao.getAlunos();
        if (todos == null || todos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Sem Registros");
        } else {
            for(int i = 0; i < todos.size(); i++){
                AlunoBean aluno = todos.get(i);
                dados = dados +
                        "\nNome: "+aluno.getNome()+
                        "\nCPF: "+aluno.getCpf()+
                        "\nSexo: "+aluno.getSexo();
            }
            JTextArea jta = new JTextArea();
            jta.setColumns(30);
            jta.setText(dados);
            JOptionPane.showMessageDialog(null, jta);
        }
    }
    
    public static void menu(){
        String opcoes = "1 - Cadastrar\n2 - Remover\n3 - Alterar\n4 - Listar\n5 - Sair";
        int op = 0;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(opcoes));
            switch (op) {
                case 1:cadastrar();break;
                case 2:remover();break;
                case 3:alterar();break;
                case 4:listar();break;
            }
        } while (op != 5);
    }
}
