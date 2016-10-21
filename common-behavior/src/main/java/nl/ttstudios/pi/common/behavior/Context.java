package nl.ttstudios.pi.common.behavior;

public class Context {
    private BehaviorStrategy strategy;

    public Context(BehaviorStrategy strategy){
       this.strategy = strategy;
    }

    public int executeStrategy(String type){
       return strategy.execute(type);
    }
 }
