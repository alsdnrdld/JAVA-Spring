package com.fastcampus.ch3;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

class Car{
    String color;
    int oil;
    Engine engine;
    Door[] doors;

    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}
class Engine{}
class Door{}




public class SpringDiTest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
        Car car = ac.getBean("car" , Car.class); // 이름으로 객제 정보 불러오는 것 ,뒤에 타입 정보를 주면 형변환 안해도 된다.
        Car car2 = (Car)ac.getBean(Car.class); // type으로 객체 정보를 불러오는 것
        Engine engine = (Engine)ac.getBean("engine");
        Door door = (Door)ac.getBean("door");

//        car.setColor("red");
//        car.setOil(100);
//        car.setEngine(engine);
//        car.setDoors(new Door[]{ac.getBean("door",Door.class),(Door)ac.getBean("door")});
        System.out.println("car = "+ car);

    }
}
