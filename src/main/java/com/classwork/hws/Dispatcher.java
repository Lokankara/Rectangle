package com.classwork.hws;

class CarWheel {
    double price;
    double weight;
    double speed;

    public CarWheel(double price, double weight, double speed)
    {
        this.price = price;
        this.weight = weight;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car: price = " + this.price + " weight = " + this.weight + " speed = " + this.speed;
    }
}

class Dispatcher
{
    public static void main(String[] args)
    {
        System.out.println(Controller.calculate("div", 7, 2));
        System.out.println(Controller.calculate("log10", 98, 2));
        System.out.println(Controller.calculate("log", Math.exp(1), 0));
        System.out.println(Controller.calculate("pow", 5, 2));

        CarWheel car = new CarWheel(11200.5, 999.4, 170);
        System.out.println(car);
        Controller.carMultiplier("price", car, 1.5);
        System.out.println(car);
        Controller.carMultiplier("weight", car, 1.5);
        System.out.println(car);
        Controller.carMultiplier("speed", car, 1.5);
        System.out.println(car);
    }
}

class Controller
{
    public static double calculate(String operation, double firstOperand, double secondOperand)
    {
        double result = 0;
        switch (operation) {
            case "div":
                result = firstOperand / secondOperand;
                break;
            case "log10":
                result = Math.log10(firstOperand + secondOperand);
                break;
            case "log":
                result = Math.log(firstOperand + secondOperand);
                break;
            case "pow":
                result = Math.pow(firstOperand, secondOperand);
                break;
            default:
                System.out.println("Invalid operation!!!");
                break;
        }
        return result;
    }

    public static void carMultiplier(String operation, CarWheel car, double multiplier)
    {
        switch (operation) {
            case "price":
                car.price *= multiplier;
                break;
            case "weight":
                car.weight *= multiplier;
                break;
            case "speed":
                car.speed *= multiplier;
                break;
            default:
                System.out.println("Invalid operation!!!");
                break;
        }
    }
}
