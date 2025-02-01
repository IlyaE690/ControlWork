public class Finishing extends AStage {
    public Finishing(String startDate, String endDate, String description, double cost) throws ConstructionException {
        super(startDate, endDate, description, cost);
    }

    public void reject() throws ConstructionException {
        setStatus(StageStatus.REJECTED);
        System.out.println("Этап отделка забраковна");
        throw new ConstructionException("Возвращение на предыдущий этап");
    }
}
