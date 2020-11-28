package Interface.Connectors;

public class FromRole implements Roles {
    private String roleName;

    public FromRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
