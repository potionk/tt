import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UpperCaseCounterTest {
    private UpperCaseCounter upperCaseCounter=new UpperCaseCounter();

    @Test
    public void 널체크(){
        String str=null;
        int result=upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(result==0);
    }

    @Test
    public void 빈값체크(){
        String str="";
        int result=upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(result==0);
    }

    @Test
    public void 대문자_ABC(){
        String str="ABC";
        int result=upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result : "+result);
        //assertTrue(result==0);
        assertTrue(result==3);
        assertFalse(result==2);
    }

    @Test
    public void 대소문자_ABCdefghi(){
        String str="ABCdefghi";
        int result=upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result : "+result);
        assertTrue(result==3);
        //assertFalse(result==2);
        //assertTrue(result==0);
    }
    //public void getNumberOfUpperCaseCharactersInString() {
    //}
}