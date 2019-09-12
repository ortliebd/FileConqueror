package ort.aux;

import java.util.Arrays;
import java.util.Vector;

public abstract class Command {
    private String name;
    private Vector<String> params;
    private Vector<String> args;

    Command(String name, String[] params, String[] args) {
        this.name = name;
        this.params = new Vector<>(Arrays.asList(params));
        this.args = new Vector<>(Arrays.asList(args));
    }

    public abstract String validate(String input);

    public abstract String execute(String path, Vector<String> input);
}
