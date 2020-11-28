package Configuration;

public class FromPort implements PortsConfiguration {
    private int PortNum;

    public FromPort(int portNum) {
        PortNum = portNum;
    }

    public int getPortNum() {
        return PortNum;
    }
}
