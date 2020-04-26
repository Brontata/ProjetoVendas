/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author aluno
 */
public class FormatRpt {
    
    public static String formatCep(String valor) throws  ParseException{
        MaskFormatter mfCep = new MaskFormatter("#####-###");
        mfCep.setPlaceholderCharacter('_');
        mfCep.setValueContainsLiteralCharacters(false);
        mfCep.setValueClass(String.class);
        return mfCep.valueToString(valor);
    }
    
    public static String formatTelefone(String valor) throws ParseException{
    
        String retorno;
        
        MaskFormatter mfTel = new MaskFormatter("(##)#####-####");
        mfTel.setPlaceholderCharacter('_');
        mfTel.setValueContainsLiteralCharacters(false);
        mfTel.setValueClass(String.class);
        retorno = mfTel.valueToString(valor);
        
        return retorno;
        
    }
    
}
