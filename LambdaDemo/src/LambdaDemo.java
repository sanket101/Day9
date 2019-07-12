interface I{
	public void abc();
}

interface J{
	public void xyz(String msg);
}

interface K{
	public int add(int a, int b);
}

public class LambdaDemo {

	public static void main(String[] args) throws Exception {
		
		//Anonymous Inner Class for implementing method : A Bit Secured than traditional way
		//A separate class file for this anonymous class is created hence it can as well be instantiated by other!
		
		I i1 = new I() {
			
			public void abc() {
				System.out.println("From inner annoymous class");
			}
		};
		
		i1.abc();
		
		//Java Reflection API : load the inner anonymous class. Hence not secured...
		Class c1 = Class.forName("LambdaDemo$1");
		Object obj = c1.newInstance();
		System.out.println(obj);
		
		//Using Lambda Function : No .class file is generated
		I i2 = () -> System.out.println("From Lambda Function..");
		i2.abc();
		
		J j1 = (msg) -> System.out.println("Got Message : " + msg);
		j1.xyz("Leadership meet");
		
		K k1 = (a,b) -> a+b;
		int res = k1.add(10, 20);
		System.out.println("Result : " + res);
	}

}
