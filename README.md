Sample Web Service that can be deployed on OpenShift.
The trick is to include a WEB-INF/jboss-web.xml to force the deployment context to "/ws" instead of ROOT, otherwise, the endpoint won't be reachable.
(well, we could use "/", but using "/ws" avoid possible collision with local servers which may also have a local web app deployed at /)

Also, pay *very much* attention to the .openshift/config/standalone.xml, some customization is required to get proper
SOAPBinding:

    <subsystem xmlns="urn:jboss:domain:webservices:1.1">
      <modify-wsdl-address>true</modify-wsdl-address>
      <wsdl-host>${env.OPENSHIFT_GEAR_DNS}</wsdl-host>
      <wsdl-port>80</wsdl-port>
      <endpoint-config name="Standard-Endpoint-Config"/>
      <endpoint-config name="Recording-Endpoint-Config">
          <pre-handler-chain name="recording-handlers" protocol-bindings="##SOAP11_HTTP ##SOAP11_HTTP_MTOM ##SOAP12_HTTP ##SOAP12_HTTP_MTOM">
              <handler name="RecordingHandler" class="org.jboss.ws.common.invocation.RecordingServerHandler"/>
          </pre-handler-chain>
      </endpoint-config>
    </subsystem>