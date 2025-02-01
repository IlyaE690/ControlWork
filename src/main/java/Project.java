public class Project extends AStage {
    public Project(String startDate, String endDate, String description, double cost) throws ConstructionException {
        super(startDate, endDate, description, cost);
    }
    public void reject() throws ConstructionException {
        setStatus(StageStatus.REJECTED);
        System.out.println("Этап проект заблокирован");
        throw new ConstructionException("Стройка отменена");
    }
}
