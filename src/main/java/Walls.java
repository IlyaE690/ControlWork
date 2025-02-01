public class Walls extends AStage {
    public Walls(String startDate, String endDate, String description, double cost) throws ConstructionException {
        super(startDate, endDate, description, cost);
    }

    public void reject() throws ConstructionException {
        setStatus(StageStatus.REJECTED);
        System.out.println("Этап стены был забракован");
        throw new ConstructionException("Возвращение к предыдущему этапу");

    }
}
