package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Command {
    private String commandName;
    private List<String> parameters;


    public Command(String name, List<String> paramsList){
        commandName = name;
        parameters = paramsList;
    }

}
