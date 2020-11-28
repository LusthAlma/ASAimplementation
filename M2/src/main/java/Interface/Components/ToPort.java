package Interface.Components;

public class ToPort implements PortsComponents {
    private int PortNum;

    public ToPort(int portNum) {
        PortNum = portNum;
    }

    public int getPortNum() {
        return PortNum;
    }

    public void setPortNum(int portNum) {
        PortNum = portNum;
    }
}
