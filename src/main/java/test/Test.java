package test;

public class Test {
	protected void choosePlatform(String platForm) {
		switch(platForm) {
		case "Android": AndroidFlows.test();
		break;
		case "iOS":  IosFlows.test();
		break;
		//		case "web":  monthString = "January";
		//        break;
		}
	}
	public static void main(String[] args) {
		Test no = new Test();
		no.choosePlatform("Android");
	}
}