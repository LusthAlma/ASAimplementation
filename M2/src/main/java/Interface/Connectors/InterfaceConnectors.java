package Interface.Connectors;

import java.util.ArrayList;

public class InterfaceConnectors {
    private ArrayList<Roles> rolesList;

    public InterfaceConnectors() {
        this.rolesList = new ArrayList<>();
    }

    public ArrayList<Roles> getRolesList() {
        return rolesList;
    }
}
