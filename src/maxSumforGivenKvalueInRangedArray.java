import java.util.ArrayList;

public class maxSumforGivenKvalueInRangedArray {
	
	class Stockrange{
        int low;
        int high;
    } 
	public int maxProfit(ArrayList<Stockrange> strange,int k,int result, int low, int high) {
		if(low>=strange.size() || high>=strange.size() || k == 0) return 0;
		System.out.println(" k = "+k+" result = "+result+" low = "+low+" high = "+high);
		for(int i=high;i<strange.size();i++) {
			int val = strange.get(i).high - strange.get(low).low;
			System.out.println(" result = "+result+" val = "+val);
			result = Math.max(result, Math.max(val+maxProfit(strange, k-1, result, low+1, high+1),
					maxProfit(strange, k, result, low, i+1)));
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1,2,2};
		int []b = {4,7,9};
		int k=3;
		
		ArrayList<Stockrange> strange =  new ArrayList<>();
		for(int i=0;i<a.length;i++) {
			Stockrange st = new maxSumforGivenKvalueInRangedArray().new Stockrange();
			st.low = a[i];
			st.high = b[i];
			strange.add(st);
		}
		
		System.out.println(strange);
		System.out.println(new maxSumforGivenKvalueInRangedArray().maxProfit(strange, k, 0, 0, 0));

	}

}
