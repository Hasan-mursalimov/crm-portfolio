package ru.crm.portfolio.crmportfolioexample.exempions;

public class DuplicateRecordException extends Exception {
    private static final long serialVersionUID = 5847447237114893790L;

    public DuplicateRecordException(String message){
        super(message);
    }
}
