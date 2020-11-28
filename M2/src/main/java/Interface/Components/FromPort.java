package Interface.Components;

public class FromPort implements PortsComponents {
    private int PortNum;

    public FromPort(int portNum) {
        PortNum = portNum;
    }

    public int getPortNum() {
        return PortNum;
    }
}
