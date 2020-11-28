package Interface.Connectors;

import java.util.ArrayList;

public class Connectors {
    private Glue glue;
    private InterfaceConnectors fromInterface;
    private InterfaceConnectors toInterface;

    public Connectors() {
        fromInterface= new InterfaceConnectors();
        toInterface = new InterfaceConnectors();
        glue = new Glue();
    }

    public Glue getGlue() {
        return glue;
    }

    public InterfaceConnectors getFromInterface() {
        return fromInterface;
    }

    public InterfaceConnectors getToInterface() {
        return toInterface;
    }
}
