package ort;

import ort.aux.Command;
import ort.aux.Ls;
import ort.aux.Mkdir;

class CommandFactory {
    Command getCommand(String commandType) {
        if (commandType.equals("LS"))
            return new Ls();
        if (commandType.equals("MKDIR"))
            return new Mkdir();
        return null;
    }
}
