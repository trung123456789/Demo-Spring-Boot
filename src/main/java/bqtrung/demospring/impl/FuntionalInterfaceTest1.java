package bqtrung.demospring.impl;

@FunctionalInterface
public interface FuntionalInterfaceTest1 {
	// Functional Interface only one Abstract method and must be one method :)
	public void sayHello(String helloMessage);
	
	// Functional Interface can contain many method of java.lang.Object class and scope must be public
    int hashCode(); 
    String toString();
    boolean equals(Object obj);
}