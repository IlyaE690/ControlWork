import java.util.regex.Pattern;

abstract class AStage implements Stage {
    private String startDate;
    private String endDate;
    private String description;
    private double cost;
    private StageStatus status;
    private AStage nextStage;
    private AStage prevStage;
    private static final String dateFormat = "^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(19|20)\\d\\d$";

    public abstract void reject() throws ConstructionException;

    // метод для проверки формата даты
    private boolean isValidDate(String date) {
        return Pattern.matches(dateFormat, date);
    }

    public AStage(String startDate, String endDate, String description, double cost) throws ConstructionException {

        if (!isValidDate(startDate)) {
            throw new ConstructionException("Неверный формат даты начала: " + startDate);
        }
        if (!isValidDate(endDate)) {
            throw new ConstructionException("Неверный формат даты окончания: " + endDate);
        }

        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.cost = cost;
        this.status = StageStatus.PLANNED;
        this.nextStage = null;
        this.prevStage = null;
    }


    public String getStartDate(){
        return startDate;
    }
    public String getEndDate(){
        return endDate;
    }
    public String getDescription(){
        return description;
    }
    public double getCost(){
        return cost;
    }
    public StageStatus getStatus() {
        return status;
    }

    public void setStatus(StageStatus status){
        this.status = status;
    }



    public void start() {
        this.status = StageStatus.IN_PROGRESS;
        System.out.println("Этап начался: " + this.getClass().getSimpleName());
    }


    public void stop() {
        this.status = StageStatus.COMPLETED;
        System.out.println("Этап завершился: " + this.getClass().getSimpleName());
    }


    public void setNextStage(AStage nextStage) {
        this.nextStage = nextStage;
    }

    public void setPrevStage(AStage prevStage) {
        this.prevStage = prevStage;
    }


    public AStage next() {
        return nextStage;
    }


    public AStage prev() {
        return prevStage;
    }

}