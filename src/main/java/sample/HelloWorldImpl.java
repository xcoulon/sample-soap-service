package sample;
 
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
 
//Service Implementation
@WebService(endpointInterface = "sample.HelloWorld", serviceName="HelloWorld" )
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class HelloWorldImpl implements HelloWorld{
 
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
 
}