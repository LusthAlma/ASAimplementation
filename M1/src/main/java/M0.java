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

        // ************* INSTANCIATION DE LA PARTIE CLIENT/SERVER - M1 ********************

        // création de la configuration qui englobe le client et le serveur dans le modèle m1
        ClientServerConfig myConfigurationClientServer = new ClientServerConfig();

        //création du client qui est un composant ainsi que d'un port send_request dans son interface fournis pour se connecter au serveur

        Client myClient = new Client();
        ToPort send_request = new ToPort("Send_Request");
        myClient.getInterCompoFrom().getPortsList().add(send_request);

        /*Création du serveur qui est aussi un composant avec un port receive_request dans l'interface requis pour recevoir les requêtes
        du Client. Le Serveur possède une configuration qui va permettre de décrire les composants qui le compose. Enfin, la configuration
        du serveur possède un port requis external_socket qui fera le lien avec le connection_manager via un lien binding
         */

        Server myServer = new Server(new Configuration());
        FromPort receive_request = new FromPort("Receive_Request");
        myServer.getInterCompoFrom().getPortsList().add(receive_request);
        FromPortConfig from_external_socket_config = new FromPortConfig("External Socket");
        myServer.getConfig().getInterConfig().getPortsConfig().add(from_external_socket_config);

        /*
        Création du RPC qui est un connecteur et qui permet de faire le lien entre client et server via un role caller côté interface requis
        qui est relié au client via un lien, et un role called dans l'interface fournis qui est relié au serveur.
        Les interfaces sont contenues dans l'attribue glue du connecteur afin qu'elles soient accessible par la glue et par le connecteur.
         */

        RPC rpcConnector = new RPC();
        FromRole caller1 = new FromRole("Caller");
        rpcConnector.getGlue().getFromInterface().getRolesList().add(caller1);
        ToRole called1 = new ToRole("Called");
        rpcConnector.getGlue().getToInterface().getRolesList().add(called1);

        /*
        Création des liens d'attachements entre le client et le rpc et entre le rpc et le serveur. Puis ajout des liens créées à la configuration
        globale client/serveur car nous avons décidés d'inclure les liens dans la configuration pour qu'ils soient accessibles et qu'un composant
        puisse via ses ports retrouver à quels autres éléments il est connecté.

         */

        Liens clientToRpc = new AttachementFromTo(send_request,caller1);
        Liens rpcToClient = new AttachementToFrom(called1, receive_request);

        myConfigurationClientServer.getLinkLists().add(clientToRpc);
        myConfigurationClientServer.getLinkLists().add(rpcToClient);

        // Ajout du client, du rpc et du serveur à la configuration globale

        myConfigurationClientServer.getComponentsList().add(myClient);
        myConfigurationClientServer.getComponentsList().add(myServer);
        myConfigurationClientServer.getConnectorsList().add(rpcConnector);

        // ************ FIN DE L'INSTANCIATION DU MODELE M1 **************

        // ************ INTANCIATION DU SERVEUR QUI EST COMPOSITE, MODELE M1_SERVER ****************

        /*
        Création du premier composant du serveur, le Connection Manager. Il possède deux ports fournis qui permettent de faire la liaison
        avec les composants Database et Security Manager via des RPC. Il possède également un port fournis external_socket qui est relié
        à la configuration du Server via un lien binding pour rediriger les requêtes des clients vers le serveur directement au composant
        Connection Manager
         */
        Connection_Manager myConnectionManager = new Connection_Manager();
        ToPort db_query = new ToPort("db_query");
        ToPort security_check = new ToPort("security_check");
        FromPort from_external_socket_cm= new FromPort("External_Socket");

        myConnectionManager.getInterCompoFrom().getPortsList().add(from_external_socket_cm);
        myConnectionManager.getInterCompoTo().getPortsList().add(db_query);
        myConnectionManager.getInterCompoTo().getPortsList().add(security_check);

        /*
        Création du deuxième composant du serveur : Database. Il possède deux ports requis afin de communiquer avec les deux autres composants
        Connection Manager et Security Manager via les rpc. Query Interogation est le port qui sera relié à Connection Manager via db_query
        et security management est le port from qui sera relié au port to queck_query de Security Manager.
         */
        Database myDatabase = new Database();

        FromPort security_management = new FromPort("security_management");
        FromPort query_interogation = new FromPort("query interogation");

        myDatabase.getInterCompoFrom().getPortsList().add(security_management);
        myDatabase.getInterCompoFrom().getPortsList().add(query_interogation);

        /*
        Création du composant Security Manager avec également deux ports, l'un requis pour se connecter avec le port to de connection manager.
        Ce port permettra de gérer la gestion de la sécurité des connexions aux serveurs. L'autre est un port fournis pour se connecter au port
        requis security_management de la database.
         */

        Security_Manager mySecurityMangager = new Security_Manager();

        ToPort check_query = new ToPort("check query");
        FromPort security_authentification = new FromPort("Security Authentification");

        mySecurityMangager.getInterCompoTo().getPortsList().add(check_query);
        mySecurityMangager.getInterCompoFrom().getPortsList().add(security_authentification);

        /*
        Création des trois RPC permettant la connection entre les 3 composants du serveur.
        Chaque RPC a un role requis caller connecté au port fournis d'un composant via un attachement et un role fournis qui est connecté
        au port requis d'un autre composant via un autre lien d'attachement
         */
        RPC rpcConnectionManagerDatabase = new RPC();

        FromRole caller2 = new FromRole("Caller");
        rpcConnectionManagerDatabase.getGlue().getFromInterface().getRolesList().add(caller2);

        ToRole called2 = new ToRole("Called");
        rpcConnectionManagerDatabase.getGlue().getToInterface().getRolesList().add(called2);


        RPC rpcConnectionManagerSecurityManager = new RPC();

        FromRole caller3 = new FromRole("Caller");
        rpcConnectionManagerSecurityManager.getGlue().getFromInterface().getRolesList().add(caller3);

        ToRole called3 = new ToRole("Called");
        rpcConnectionManagerSecurityManager.getGlue().getToInterface().getRolesList().add(called3);


        RPC rpcSecurityManagerDatabase = new RPC();

        FromRole caller4 = new FromRole("Caller");
        rpcSecurityManagerDatabase.getGlue().getFromInterface().getRolesList().add(caller4);

        ToRole called4 = new ToRole("Called");
        rpcSecurityManagerDatabase.getGlue().getToInterface().getRolesList().add(called4);

        // Ajout des trois composants et des trois connecteurs RPC à la configuration du serveur

        myServer.getConfig().getComponentsList().add(myConnectionManager);
        myServer.getConfig().getComponentsList().add(myDatabase);
        myServer.getConfig().getComponentsList().add(mySecurityMangager);

        myServer.getConfig().getConnectorsList().add(rpcConnectionManagerDatabase);
        myServer.getConfig().getConnectorsList().add(rpcConnectionManagerSecurityManager);
        myServer.getConfig().getConnectorsList().add(rpcSecurityManagerDatabase);

        /*
        Création des 6 liens d'attachements entre les 3 composants via les roles des 3 rpc.
        Création du lien binding entre le port requis (From) de la configuration du serveur et le port requis de Connection Manager
         */

        Liens cm_to_sm_rpc = new AttachementFromTo(security_check,caller3);
        Liens rpc_cm_to_sm = new AttachementToFrom(called3,security_authentification);

        Liens cm_to_db_rpc = new AttachementFromTo(db_query,caller2);
        Liens rpc_cm_to_db = new AttachementToFrom(called2,query_interogation);

        Liens sm_to_db_rpc = new AttachementFromTo(check_query,caller4);
        Liens rpc_sm_to_db = new AttachementToFrom(called4,security_management);

        Liens external_socket_binding = new BindingFrom(from_external_socket_cm,from_external_socket_config);

        // Ajout des liens dans la configuration du serveur

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

