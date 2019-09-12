package ort;

import ort.aux.Command;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Vector;

public class Console {
    private boolean shouldClose;
    private String path;
    private CommandFactory factory;
    private TreeMap<String, Command> commands;

    Console() {
        path = System.getProperty("user.dir");
        initialize();
    }

    public Console(String path) {
        this.path = path;
        initialize();
    }

    boolean getShouldClose() {
        return shouldClose;
    }

    private void initialize() {
        this.path = "/home/ortliebd/Desktop/testing/";
        commands = new TreeMap<>();
        shouldClose = false;
        factory = new CommandFactory();

        commands.put("ls", factory.getCommand("LS"));
        commands.put("mkdir", factory.getCommand("MKDIR"));
    }

    String execute(String input) {
        input = input.trim();
        Vector<String> vectorInput = new Vector<>(Arrays.asList(input.split(" ")));

        if (commands.get(vectorInput.firstElement()) != null) {
            String isValid = commands.get(vectorInput.firstElement()).validate(input);
            System.out.println(isValid);
            if (isValid.equals("OK")) {
                return commands.get(vectorInput.firstElement()).execute(path, vectorInput);
            } else {
                return "Wrong params";
            }
        } else {
            return "Invalid command";
        }
    }
}
