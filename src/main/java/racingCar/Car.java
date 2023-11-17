package racingCar;

import java.util.List;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private String carName;
    private int forwardCount;

    public Car(String carName){
        checkCarName(carName);
        this.carName = carName;
        this.forwardCount = 0;
    }

    public Car(String carName, int forwardCount){
        checkCarName(carName);
        this.carName = carName;
        this.forwardCount = forwardCount;
    }

    private void checkCarName(String carName){
        if(carName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    public String getCarName(){
        return carName;
    }

    public int getForwardCount(){
        return forwardCount;
    }

    public void addForward(int forwardCount){
        this.forwardCount += forwardCount;
    }

    public List<String> addMaxForwardCar(int maxForwardCount, List<String> winners){
        if(forwardCount == maxForwardCount)
            winners.add(carName);

        return winners;
    }

    public void printCar(){
        ResultView.printNamedCar(carName, forwardCount);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", forwardCount=" + forwardCount +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (forwardCount != car.forwardCount) return false;
        return carName != null ? carName.equals(car.carName) : car.carName == null;
    }

    @Override
    public int hashCode() {
        int result = carName != null ? carName.hashCode() : 0;
        result = 31 * result + forwardCount;
        return result;
    }
}
