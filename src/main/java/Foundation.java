public class Foundation extends AStage {
    public Foundation(String startDate, String endDate, String description, double cost) throws ConstructionException {
        super(startDate, endDate, description, cost);
    }

    public void reject() throws ConstructionException {
        setStatus(StageStatus.REJECTED);
        System.out.println("Этап фундамент забракован");
        throw new ConstructionException("Возвращение к предыдущему этапу");
    }
}
