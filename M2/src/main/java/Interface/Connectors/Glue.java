package Interface.Connectors;

public class Glue {
    private InterfaceConnectors fromInterface;
    private InterfaceConnectors toInterface;

    public Glue() {
        fromInterface= new InterfaceConnectors();
        toInterface = new InterfaceConnectors();
    }

    public InterfaceConnectors getFromInterface() {
        return fromInterface;
    }

    public InterfaceConnectors getToInterface() {
        return toInterface;
    }


}
