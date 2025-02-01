import java.util.Random;

public class Construction1 implements Construction {
    private AStage currentStage;
    private AStage firstStage;

    public Construction1(AStage project) {
        this.currentStage = project;
        this.firstStage = project;
    }

    public void setNextStage(AStage nextStage) {
        this.currentStage.setNextStage(nextStage);
        nextStage.setPrevStage(this.currentStage);
        this.currentStage = nextStage;
    }
    public void startConstruction() throws ConstructionException {
        AStage stage = firstStage;
        while(stage != null) {
            try {
                stage.start();
                if (new Random().nextInt(100) < 10) { // 10 % шанс на брак
                    stage.reject();

                    if (stage instanceof Project) {
                        break;
                    }
                    stage = (AStage) stage.prev();
                    continue;
                }
                stage.stop();
                stage = (AStage) stage.next();
            }
            catch (ConstructionException e) {
                System.out.println("Исключение: " + e.getMessage());

                if(stage.prev() == null){
                    stage = firstStage;
                }else{
                    stage = (AStage) stage.prev();
                }
            }
        }
    }

    public boolean complete() {
        AStage stage = firstStage;
        while (stage != null){
            if (stage.getStatus() != StageStatus.COMPLETED){
                return false;
            }
            stage = (AStage) stage.next();
        }
        return true;
    }

}
