package Interface.Liens;

import Interface.Components.ToPort;
import Interface.Connectors.FromRole;

public class AttachementFromTo implements Attachement {
    private FromRole fromRole;
    private ToPort toPort;

    public AttachementFromTo(FromRole fromRole, ToPort toPort) {
        this.fromRole = fromRole;
        this.toPort = toPort;
    }

    public FromRole getFromRole() {
        return fromRole;
    }

    public ToPort getToPort() {
        return toPort;
    }

    public void setFromRole(FromRole fromRole) {
        this.fromRole = fromRole;
    }

    public void setToPort(ToPort toPort) {
        this.toPort = toPort;
    }
}
