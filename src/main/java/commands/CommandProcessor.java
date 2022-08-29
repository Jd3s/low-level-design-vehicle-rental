package commands;

import exception.InvalidInputException;
import model.Command;
import util.CommandParserUtil;

import java.io.*;

public class CommandProcessor {

    CommandExecutorFactory commandExecutorFactory;

    public CommandProcessor(CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
    }



    public void processCommand(final Command command){
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidInputException("Not a valid command");
        }
    }

    public void start(String fileName) throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            return;
        }

        String input = reader.readLine();

        while (input != null) {
            final Command command =  CommandParserUtil.parse(input);
            processCommand(command);
            input = reader.readLine();
        }
    }
}
