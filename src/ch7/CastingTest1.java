package ch7;

public class CastingTest1 {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		car = fe;
		//car.water(); -> 컴파일 에러 
		fe2 = (FireEngine)car; // 얘도 부모 -> 자식으로 형변환인데 왜 되는 것?
		fe2.water();
		fe2.drive();
	}

}

class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("drive, Brrr~");
	}
	
	void stop() {
		System.out.println("stop!!!");
	}
}
class FireEngine extends Car{
	void water() {
		System.out.println("water!!!");
	}
}