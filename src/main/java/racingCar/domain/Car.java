package racingCar.domain;

import java.util.List;
import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    public static final int FORWARD_BOUNDARY_VALUE = 3;

    private String carName;
    private Forward forward;

    public Car(String carName){
        checkCarName(carName);
        this.carName = carName;
        this.forward = new Forward(0);
    }

    public Car(String carName, int forwardCount){
        checkCarName(carName);
        this.carName = carName;
        this.forward = new Forward(forwardCount);
    }

    public Car(int forwardCount) {
        this.forward = new Forward(forwardCount);
    }

    public String getCarName(){
        return carName;
    }

    public int getForwardCount() { return forward.forwardCount(); }

    private void checkCarName(String carName){
        if(carName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    public void moveCar(int randomNumber){
        if(randomNumber > FORWARD_BOUNDARY_VALUE) {
            forward.addForwardCount();
        }
    }

    public int returnMaxCount(int maxForwardCount) {
        return forward.returnMaxCount(maxForwardCount);
    }

    public List<String> addMaxForwardCar(int maxForwardCount, List<String> winners){
        if(forward.matchMaxForwardCount(maxForwardCount)) {
            winners.add(carName);
        }

        return winners;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", forwardCount=" + forward +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getCarName(), car.getCarName()) && Objects.equals(forward, car.forward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName(), forward);
    }
}