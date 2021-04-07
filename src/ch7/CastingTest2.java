package ch7;

public class CastingTest2 {

	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive();
		System.out.println(car instanceof FireEngine); //false
		fe = (FireEngine)car; //컴파일 - OK, 실행 시(런타임) 에러 발생  
		fe.drive();
		car2 = fe;                                       
		car2.drive();
	}

}

