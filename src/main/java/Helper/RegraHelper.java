/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

/**
 *
 * @author 1072221113
 */
public class RegraHelper {
    public static boolean validarCPF(String cpf){
        
        int[] cpfArray = new int[(cpf.length()-2)]; //Pegar os primeiros 9 dígitos do CPF
        for (int i = 0; i < cpfArray.length; i++) {
            cpfArray[i] = Integer.parseInt(cpf.substring(i,i+1));
        } //Popular "cpfArray" com os 9 primeiros dígitos do CPF
        
        int DV1 = 0;
        for (int i = 0; i < cpfArray.length; i++){
            DV1 += (cpfArray[i] * (10-i));
        }
        DV1 = 11 - (DV1 % 11);
        
        int DV2 = 0;
        for (int i = 0; i < cpfArray.length; i++){
            DV2 += cpfArray[i] * (11-i);
        }
        DV2 = 11 - ((DV2 + (DV1*2)) % 11);
        
        return (DV1 == Character.getNumericValue(cpf.charAt(9)) &&
                DV2 == Character.getNumericValue(cpf.charAt(10)));
    }
}
