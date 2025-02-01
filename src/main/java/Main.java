public class Main {
    public static void main(String[] args) {
        int totalConstructions = 1000;
        int count = 0;
        for (int i = 0; i < totalConstructions; i++) {
            try {

                AStage project = new Project("01.01.2024", "10.01.2024", "Разработка проекта", 50000);
                AStage foundation = new Foundation("11.01.2024", "20.01.2024", "Заливка фундамента", 70000);
                AStage walls = new Walls("21.01.2024", "10.02.2024", "Возведение стен", 150000);
                AStage roof = new Roof("11.02.2024", "20.02.2024", "Покрытие крыши", 100000);
                AStage finishing = new Finishing("21.02.2024", "28.02.2024", "Отделка", 100000);

                Construction1 construction = new Construction1(project);
                construction.setNextStage(foundation);
                construction.setNextStage(walls);
                construction.setNextStage(roof);
                construction.setNextStage(finishing);
                construction.startConstruction();
                if (construction.complete()){
                    count++; //счетчик удачных
                }
            } catch (ConstructionException e) {
                System.out.println("Стройка прервана " + e.getMessage());
            }
        }
        double s = (double) (count / totalConstructions);
        System.out.println("Вероятность успешного завершения строительства: " + s);
    }
}