package ch7;

public class Instanceof {
	
	public static void main(String[] args) {
		Car c = new FireEngine(); //new Car 또는 null 이면 FireEngine으로 형변환 불가
		FireEngine fe = new FireEngine();
		
		if(c instanceof FireEngine) {
			fe = (FireEngine)c;
			fe.doWork(c);
		}else {
			System.out.println("FireEngine으로 형변환할 수 없습니다.");
		}
	}
	
}
