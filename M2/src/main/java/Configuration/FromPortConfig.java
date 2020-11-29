package Configuration;

public class FromPortConfig implements PortsConfiguration {
    private String portName;

    public FromPortConfig(String portName) {
        this.portName = portName;
    }

    public String getPortNum() {
        return portName;
    }
}
