package Controller;

import service.DataBaseService;

import java.util.regex.Pattern;

public class DatabaseController {

    private DataBaseService dataBaseService = new DataBaseService();

    //
    public void executeMigration (){

        try{
            dataBaseService.executeMigration();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    //
    public void executeBackUp (String nameFile){
        Pattern pattern = Pattern.compile(",");
        try{

            dataBaseService.executeBackUp(nameFile);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
