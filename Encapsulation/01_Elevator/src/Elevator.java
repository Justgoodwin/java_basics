public class Elevator {

    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator (int minFloor, int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }
    public void moveDown(){
        currentFloor = currentFloor >= minFloor && currentFloor <= maxFloor ? currentFloor -1 : currentFloor;
    }
    public void moveUp(){
        currentFloor = currentFloor >= minFloor && currentFloor <= maxFloor ? currentFloor +1 : currentFloor;
    }
    public void move(int pointedFloor){
        if (pointedFloor >= minFloor && pointedFloor <= maxFloor){
            if (currentFloor < pointedFloor){
                while (currentFloor != pointedFloor){
                    moveUp();
                    System.out.println(currentFloor);
                }
            }
            if (currentFloor > pointedFloor){
                while (currentFloor != pointedFloor){
                    moveDown();
                    System.out.println(currentFloor);
                }
            }
        }else{
            System.out.println("Несуществующий этаж");
        }
    }
}
