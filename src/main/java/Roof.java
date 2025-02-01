public class Roof extends AStage {
    public Roof(String startDate, String endDate, String description, double cost) throws ConstructionException {
        super(startDate, endDate, description, cost);
    }

    public void reject() throws ConstructionException {
        setStatus(StageStatus.REJECTED);
        System.out.println("Этап крыша забракован");
        throw new ConstructionException("Возрвращение на предыдущий этап");
    }
}
