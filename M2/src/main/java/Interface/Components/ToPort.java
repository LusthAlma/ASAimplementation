package Interface.Components;

public class ToPort implements PortsComponents {
    private String portName;

    public ToPort(String portName) {
        this.portName = portName;
    }

    public String getPortNum() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }
}
