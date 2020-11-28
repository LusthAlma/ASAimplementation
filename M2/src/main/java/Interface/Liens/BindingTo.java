package Interface.Liens;

import Interface.Components.ToPort;

public class BindingTo implements Binding {
    private ToPort toPortComponents;
    private Configuration.ToPort toPortConfiguration;

    public BindingTo(ToPort toPortComponents, Configuration.ToPort toPortConfiguration) {
        this.toPortComponents = toPortComponents;
        this.toPortConfiguration = toPortConfiguration;
    }

    public ToPort getToPortComponents() {
        return toPortComponents;
    }

    public Configuration.ToPort getToPortConfiguration() {
        return toPortConfiguration;
    }

    public void setToPortConfiguration(Configuration.ToPort toPortConfiguration) {
        this.toPortConfiguration = toPortConfiguration;
    }

    public void setToPortComponents(ToPort toPortComponents) {
        this.toPortComponents = toPortComponents;
    }
}
