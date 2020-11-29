package Interface.Components;

public class FromPort implements PortsComponents {
    private String portName;

    public FromPort(String portName) {
        this.portName = portName;
    }

    public String getPortNum() {
        return portName;
    }
}
