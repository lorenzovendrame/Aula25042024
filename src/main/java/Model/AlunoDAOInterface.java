/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author 1072221113
 */
public interface AlunoDAOInterface {
    public boolean cadastrarAluno(AlunoBean aluno);
    public boolean removeAluno(String cpf);
    public boolean alterarAluno(AlunoBean aluno);
    public AlunoBean consultarPorCpf(String cpf);
    ArrayList<AlunoBean> getAlunos();

}
