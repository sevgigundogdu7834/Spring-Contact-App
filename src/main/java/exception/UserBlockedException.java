package exception;

public class UserBlockedException extends Exception {

    public UserBlockedException(){


    }

    public UserBlockedException(String strError){

        super(strError);
    }
}
