package Interface.Components;

public class FromService implements Services {
    private String serviceName;

    public FromService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
