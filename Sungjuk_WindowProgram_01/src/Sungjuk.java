

public class Sungjuk{
	static String tot(String kor, String eng, String math)
	{
		int kor2 = Integer.parseInt(kor);
		int eng2 = Integer.parseInt(eng);
		int math2 = Integer.parseInt(math);
		String tot = Integer.toString(kor2 + eng2 + math2);
		return tot;
	}
	
	static String avg(String tot)
	{
		int tot2 = Integer.parseInt(tot);
		String avg = Double.toString(Math.round(((double) tot2 / 3 * 10) / 10));
		return avg;
	}
	
	static String grade(String avg)
	{	
		String grade;
		switch ((int)Double.parseDouble(avg) / 10) {
			case 10:
			case 9:
				grade = "��";
				break;
			case 8:
				grade = "��";
				break;
			case 7:
				grade = "��";
				break;
			case 6:
				grade = "��";
				break;
			default:
				grade = "��";
				break;
		}
		return grade;
	}
}