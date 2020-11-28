package Interface.Liens;

import Interface.Components.FromPort;
import Interface.Connectors.ToRole;

public class AttachementToFrom implements Attachement{
    private ToRole toRole;
    private FromPort fromPort;

    public AttachementToFrom(ToRole toRole, FromPort fromPort) {
        this.toRole = toRole;
        this.fromPort = fromPort;
    }

    public ToRole getToRole() {
        return toRole;
    }

    public FromPort getFromPort() {
        return fromPort;
    }

    public void setToRole(ToRole toRole) {
        this.toRole = toRole;
    }

    public void setFromPort(FromPort fromPort) {
        this.fromPort = fromPort;
    }
}
