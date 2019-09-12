package ort.aux;

import java.io.File;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Pattern;

public class Ls extends Command {
    public Ls() {
        super("ls",
                new String[]{"\"-valid\", \"-hidden\", \"-dirs\", \"-files\", \"-full\", \"sortasc\", \"sortdesc\""},
                new String[]{""}
        );
    }

    public Ls(String name, String[] params, String[] args) {
        super(name, params, args);
    }

    @Override
    public String validate(String input) {
        String regex = "ls(\\s*(-valid|-hidden|-dirs|-files|-full|-sortasc|-sortdesc))*";
        boolean isValid = Pattern.matches(regex, input);
        return isValid ? "OK" : "Entrada invalida";
    }

    @Override
    public String execute(String path, Vector<String> input) {
        File file = new File(path);
        File[] raw = file.listFiles();
        TreeSet<String> result = new TreeSet<>();
        String fileProperties = "";

        assert raw != null;
        for (File f : raw) {
            if (input.size() <= 1 && !f.isHidden()) {
                fileProperties = f.getName();
            }
            if (input.contains("-valid") && !f.isHidden()) {
                fileProperties = f.getName();
            }
            if (input.contains("-hidden") && f.isHidden()) {
                fileProperties = f.getName();
            }
            if (input.contains("-dirs") && f.isDirectory()) {
                fileProperties = f.getName();
            }
            if (input.contains("-files") && f.isFile()) {
                fileProperties = f.getName();
            }
            if (input.contains("-full")) {
                fileProperties = fileProperties.concat(" " + f.canExecute() + " " + f.canRead() + " " + f.canWrite() +
                        " " + f.lastModified() + " " + f.length());
            }
            if (fileProperties.length() != 0)
                result.add(fileProperties);
        }
        return result.toString();
    }
}
