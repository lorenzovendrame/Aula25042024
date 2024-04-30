/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import DAO.MySQLConnection;
import Model.AlunoBean;
import Model.AlunoDAO;
import com.mysql.cj.MysqlConnection;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1072221113
 */
public class ProjetoTeste {
    
    public ProjetoTeste() {
    }
/*
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }*/

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testarConexao() throws SQLException{
        MySQLConnection db = MySQLConnection.getInstance();
        Connection con = db.getConnection();
        assertNotNull(con);
    }
    
    @Test
    public void adicionarAluno(){
        AlunoBean aluno = new AlunoBean();
        aluno.setNome("Marcelo Medeiros");
        aluno.setCpf("682.983.669-72");
        aluno.setSexo('M');
        AlunoDAO dao = new AlunoDAO();
        assertTrue(dao.cadastrarAluno(aluno));
    }
}
