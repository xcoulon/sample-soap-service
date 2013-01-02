package sample;
 
import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "sample.HelloWorld", serviceName="Hello" )
public class HelloWorldImpl implements HelloWorld{
 
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
 
}