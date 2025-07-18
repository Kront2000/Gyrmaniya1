package Exeptions;

public class DaoExeption extends RuntimeException{
    public DaoExeption(String massage){
        super(massage);
    }
}
