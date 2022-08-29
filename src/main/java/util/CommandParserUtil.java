package util;

import exception.InvalidInputException;
import model.Command;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class CommandParserUtil {

    private static final String DELIMITER = " ";

    public static Command parse(String input) {

        if(input == null || input.isBlank())
            throw new InvalidInputException("Not a valid command");

        List<String> inputList = new ArrayList<>(Arrays.asList(input.trim().split(DELIMITER)));

        String commandName = inputList.get(0);
        inputList.remove(0);
        Command command = new Command(commandName, inputList);
        return command;
    }
}
