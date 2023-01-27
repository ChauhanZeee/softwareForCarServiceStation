package org.example;
import java.util.*;
import static org.example.CarType.HATCHBACK;

class Service {
    private String code;
    private String name;
    private HashMap<CarType,Integer> prices;

    public Service(String code, String name, Integer priceHatchback, Integer priceSedan, Integer priceSUV) {
        this.code = code;
        this.name = name;
        this.prices = new HashMap<>();
        this.prices.put(HATCHBACK,priceHatchback);
        this.prices.put(CarType.SEDAN,priceSedan);
        this.prices.put(CarType.SUV,priceSUV);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice(CarType carType) {
        return this.prices.get(carType);
    }
}
class ServiceStation {
    private Map<String, Service> services;

    public ServiceStation() {
        services = new HashMap<>();
        services.put("BS01", new Service("BS01", "Basic Service", 2000, 4000, 5000));
        services.put("EF01", new Service("EF01", "Engine Fixing", 5000, 8000, 10000));
        services.put("CF01", new Service("CF01", "Clutch Fixing", 2000, 4000, 6000));
        services.put("BF01", new Service("BF01", "Break Fixing", 1000, 1500, 2500));
        services.put("GF01", new Service("GF01", "Gear Fixing", 3000, 6000, 8000));
    }

    public Service getService(String code) {
        return services.get(code);
    }

    public void printBill(CarType carType, List<String> serviceCodes) {
        double bill = 0;
        for (String code : serviceCodes) {
            Service service = getService(code);
            bill += service.getPrice(carType);
            System.out.println(service.getName()+" : "+service.getPrice(carType));
        }
        System.out.println("Total Bill : " + bill);
    }
}

enum CarType {
    HATCHBACK, SEDAN, SUV
}
public class Car {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        ServiceStation station = new ServiceStation();
        ArrayList<String> serviceCodes = new ArrayList<String>();

        System.out.println("Enter car type : ");
        System.out.println("for Sedan type --> SD");
        System.out.println("for Suv type --> SUV");
        System.out.println("for HATCHBACK type --> HB");
        String str = sc.next();
        if(str.equals("HB")){
            CarType HB = CarType.HATCHBACK;
        }else if(str.equals("SD")){
            CarType SD = CarType.SEDAN;
        }else if(str.equals("SUV")){
            CarType SUV = CarType.SUV;
        }

        System.out.println("How many service you take : ");
        int n = sc.nextInt();
        System.out.println("Enter all service code :");
        for(int i=0; i<n; i++){
            String str1 = sc.next();
            serviceCodes.add(str1);
        }

        station.printBill(CarType.valueOf((str)), serviceCodes);
    }
}
