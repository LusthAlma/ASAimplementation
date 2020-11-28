package Interface.Liens;

import Interface.Components.FromPort;
import Interface.Components.ToPort;

public class BindingFrom implements Binding {
    private FromPort fromPortComponents;
    private Configuration.FromPort fromPortConfiguration;

    public BindingFrom(FromPort fromPortComponents, Configuration.FromPort fromPortConfiguration) {
        this.fromPortComponents = fromPortComponents;
        this.fromPortConfiguration = fromPortConfiguration;
    }

    public FromPort getFromPortComponents() {
        return fromPortComponents;
    }

    public Configuration.FromPort getFromPortConfiguration() {
        return fromPortConfiguration;
    }

    public void setFromPortConfiguration(Configuration.FromPort fromPortConfiguration) {
        this.fromPortConfiguration = fromPortConfiguration;
    }

    public void setFromPortComponents(FromPort fromPortComponents) {
        this.fromPortComponents = fromPortComponents;
    }
}
