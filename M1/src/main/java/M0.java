import Configuration.Configuration;
import Interface.Components.FromPort;
import Interface.Components.ToPort;
import Interface.Connectors.FromRole;
import Interface.Connectors.ToRole;
import Interface.Liens.AttachementFromTo;
import Interface.Liens.AttachementToFrom;
import Interface.Liens.BindingFrom;
import Interface.Liens.Liens;
import Server.*;
import Configuration.FromPortConfig;

import Interface.Ports.Ports;

public class M0 {
    public static void main (String[] args){
        ClientServerConfig myConfigurationClientServer = new ClientServerConfig();

        Client myClient = new Client();
        ToPort send_request = new ToPort("Send_Request");
        myClient.getInterCompoFrom().getPortsList().add(send_request);

        Server myServer = new Server(new Configuration());
        FromPort receive_request = new FromPort("Receive_Request");
        myServer.getInterCompoFrom().getPortsList().add(receive_request);
        FromPortConfig from_external_socket_config = new FromPortConfig("External Socket");
        myServer.getConfig().getInterConfig().getPortsConfig().add(from_external_socket_config);


        RPC rpcConnector = new RPC();
        FromRole caller1 = new FromRole("Caller");
        rpcConnector.getGlue().getFromInterface().getRolesList().add(caller1);
        ToRole called1 = new ToRole("Called");
        rpcConnector.getGlue().getToInterface().getRolesList().add(called1);

        Liens clientToRpc = new AttachementFromTo(send_request,caller1);
        Liens rpcToClient = new AttachementToFrom(called1, receive_request);

        myConfigurationClientServer.getLinkLists().add(clientToRpc);
        myConfigurationClientServer.getLinkLists().add(rpcToClient);


        myConfigurationClientServer.getComponentsList().add(myClient);
        myConfigurationClientServer.getComponentsList().add(myServer);
        myConfigurationClientServer.getConnectorsList().add(rpcConnector);

        Connection_Manager myConnectionManager = new Connection_Manager();

        ToPort db_query = new ToPort("db_query");
        ToPort security_check = new ToPort("security_check");
        FromPort from_external_socket_cm= new FromPort("External_Socket");

        myConnectionManager.getInterCompoFrom().getPortsList().add(from_external_socket_cm);
        myConnectionManager.getInterCompoTo().getPortsList().add(db_query);
        myConnectionManager.getInterCompoTo().getPortsList().add(security_check);

        Database myDatabase = new Database();

        FromPort security_management = new FromPort("security_management");
        FromPort query_interogation = new FromPort("query interogation");

        myDatabase.getInterCompoFrom().getPortsList().add(security_management);
        myDatabase.getInterCompoFrom().getPortsList().add(query_interogation);


        Security_Manager mySecurityMangager = new Security_Manager();

        ToPort check_query = new ToPort("check query");
        FromPort security_authentification = new FromPort("Security Authentification");

        mySecurityMangager.getInterCompoTo().getPortsList().add(check_query);
        mySecurityMangager.getInterCompoFrom().getPortsList().add(security_authentification);


        RPC rpcConnectionManagerDatabase = new RPC();

        FromRole caller2 = new FromRole("Caller");
        rpcConnector.getGlue().getFromInterface().getRolesList().add(caller2);

        ToRole called2 = new ToRole("Called");
        rpcConnector.getGlue().getToInterface().getRolesList().add(called2);


        RPC rpcConnectionManagerSecurityManager = new RPC();

        FromRole caller3 = new FromRole("Caller");
        rpcConnector.getGlue().getFromInterface().getRolesList().add(caller3);

        ToRole called3 = new ToRole("Called");
        rpcConnector.getGlue().getToInterface().getRolesList().add(called3);


        RPC rpcSecurityManagerDatabase = new RPC();

        FromRole caller4 = new FromRole("Caller");
        rpcConnector.getGlue().getFromInterface().getRolesList().add(caller4);

        ToRole called4 = new ToRole("Called");
        rpcConnector.getGlue().getToInterface().getRolesList().add(called4);


        myServer.getConfig().getComponentsList().add(myConnectionManager);
        myServer.getConfig().getComponentsList().add(myDatabase);
        myServer.getConfig().getComponentsList().add(mySecurityMangager);

        myServer.getConfig().getConnectorsList().add(rpcConnectionManagerDatabase);
        myServer.getConfig().getConnectorsList().add(rpcConnectionManagerSecurityManager);
        myServer.getConfig().getConnectorsList().add(rpcSecurityManagerDatabase);

        Liens cm_to_sm_rpc = new AttachementFromTo(security_check,caller3);
        Liens rpc_cm_to_sm = new AttachementToFrom(called3,security_authentification);

        Liens cm_to_db_rpc = new AttachementFromTo(db_query,caller2);
        Liens rpc_cm_to_db = new AttachementToFrom(called2,query_interogation);

        Liens sm_to_db_rpc = new AttachementFromTo(check_query,caller4);
        Liens rpc_sm_to_db = new AttachementToFrom(called4,security_management);

        Liens external_socket_binding = new BindingFrom(from_external_socket_cm,from_external_socket_config);

        myServer.getConfig().getLinkLists().add(cm_to_sm_rpc);
        myServer.getConfig().getLinkLists().add(rpc_cm_to_sm);
        myServer.getConfig().getLinkLists().add(cm_to_db_rpc);
        myServer.getConfig().getLinkLists().add(rpc_cm_to_db);
        myServer.getConfig().getLinkLists().add(sm_to_db_rpc);
        myServer.getConfig().getLinkLists().add(rpc_sm_to_db);

        myConfigurationClientServer.getLinkLists().add(external_socket_binding);

        System.out.println("M0 architecture implemented");








    }

}

