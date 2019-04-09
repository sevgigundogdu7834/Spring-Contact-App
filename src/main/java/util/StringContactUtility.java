package util;

public class StringContactUtility {

    public static String toCommaSeperatedString(Object[] items){

        StringBuilder stringBuilder=new StringBuilder();

        for(Object item:items){

            stringBuilder.append(item).append(",");
        }

        if(stringBuilder.length()>0){

            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        return stringBuilder.toString();
    }


}
