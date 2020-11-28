package Configuration;

public class ToPort implements PortsConfiguration {
    private int PortNum;

    public ToPort(int portNum) {
        PortNum = portNum;
    }

    public int getPortNum() {
        return PortNum;
    }
}
