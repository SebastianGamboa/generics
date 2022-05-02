package generics.functional_interface;

@FunctionalInterface
public interface GreetingMessage {
    
    public abstract void greet(String name);
}
