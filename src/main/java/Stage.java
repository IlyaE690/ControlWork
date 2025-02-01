public interface Stage {
    Stage next();
    Stage prev();
    void start();
    void stop();
    void reject() throws ConstructionException;
}
