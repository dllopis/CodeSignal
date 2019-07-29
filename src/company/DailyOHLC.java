package company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/*
 * When visualizing market data over a long period of time, it is often helpful to build an Open-high-low-close (OHLC) chart. However, to build an OHLC chart you first need to prepare some data. For each financial instrument consider each day when it was traded, and find the following prices the instrument had that day:

open price: the price of the first trade of the day;
high price: the highest trade of the day;
low price: the lowest trade of the day;
close price: the price of the last trade of the day.

Given a stream of trade data ordered by time, write a program to compute the OHLC by day and instrument (see output section for the format details).
If two trades happen to have equal timestamps, then their order is determined by the order of their timestamps in the timestamp array.

 * For
 	timestamp = [1450625399, 1450625400, 1450625500, 1450625550, 1451644200, 1451690100, 1451691000]
	
	instrument = ["HPQ", "HPQ", "HPQ", "HPQ", "AAPL", "HPQ", "GOOG"],
	side = ["sell", "buy", "buy", "sell", "buy", "buy", "buy"],
	price = [10, 20.3, 35.5, 8.65, 20, 10, 100.35], and
	size = [10, 1, 2, 3, 5, 1, 10]
	
	The output should be dailyOHLC(timestamp, instrument, side, price, size) = 
		[	
			["2015-12-20", "HPQ", "10.00", "35.50", "8.65", "8.65"],
		 	["2016-01-01", "AAPL", "20.00", "20.00", "20.00", "20.00"],
		 	["2016-01-01", "GOOG", "100.35", "100.35", "100.35", "100.35"],
		 	["2016-01-01", "HPQ", "10.00", "10.00", "10.00", "10.00"]	
	 	]
 */
public class DailyOHLC {
	
	/*
	 * My approach is to target all instruments within each unique date period.
	 * 1. Convert unix timestamp to a string ("yyyy-MM-dd")
	 * -This served as an end of day period action where I can then start to
	 * -calculate the OHLC and then re-initialize my treemap for the next day.
	 * 2. Implemented a Treemap to keep the instruments sorted lexigraphically by key
	 * -This resolved the issue of identical timestamps.
	 * 3. 
	 */
	String[][] dailyOHLC(int[] timestamp, String[] instrument, String[] side, double[] price, int[] size) {
		TreeMap<String,ArrayList<Double>> map = new TreeMap<>();
		ArrayList<ArrayList<String>> solution = new ArrayList<>();
	    
	    Date date = new java.util.Date((long)timestamp[0]*1000L);
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	    String formattedDate = sdf.format(date);
	    
	    // This controls the logic for end of day OHLC check
	    String currentTimestamp = formattedDate;
	    
	    for(int i = 0;i<timestamp.length;i++)   {
	    	date = new java.util.Date((long)timestamp[i]*1000L);
	    	formattedDate = sdf.format(date);
	    	ArrayList<Double> list = new ArrayList<>();
	    	
	    	// We are still on the same data, so keep adding to map
		    if(currentTimestamp.equals(formattedDate.substring(0,10)))	{
			    if(!map.containsKey(instrument[i]))	{
			    	list.add(price[i]);
			    	map.put(instrument[i], list);
			    }else	{
			    	map.get(instrument[i]).add(price[i]);
			    }
		    }else	{
		    	/* New date occurred:
		    	 * 1. Calculate OHLC
		    	 * 2. Update our timestamp
		    	 * 3. Re-initalize map for next day
		    	 * 4. Add our new data before continuing.*/
		    	calculateOHLC(map,currentTimestamp,solution);
		    	currentTimestamp = formattedDate;
		    	map = new TreeMap<>();
		    	list.add(price[i]);
		    	map.put(instrument[i], list);
		    }	    
    	}
	    calculateOHLC(map,currentTimestamp,solution);
		
	    return convertToArray(solution);
	}
	/*
	 * This method calculates OHLC
	 * 1. Iterates through each map entry of instruments and its list of data.
	 * 2. Calculates OHLC and stores in a temp list
	 * 3. Once down calculating instrument OHLC, stores list in a solutionArrayList of list
	 * 4. Moves on to next instrument(key) on map
	 */
	private void calculateOHLC(TreeMap<String,ArrayList<Double>> map, String date, ArrayList<ArrayList<String>> solutionList)	{
		for(Map.Entry<String,ArrayList<Double>> entry : map.entrySet())	{
			ArrayList<String> list = new ArrayList<>();
    		ArrayList<Double> value = entry.getValue();
    		
    		Double openPrice = value.get(0);
        	Double closePrice = value.get(value.size()-1);
        	Double highPrice = Double.MIN_VALUE;
        	Double lowPrice = Double.MAX_VALUE;
    		
    		for(int i1 = 0;i1<value.size();i1++)	{
    			if(value.get(i1) > highPrice)
    				highPrice = value.get(i1);
    			if(value.get(i1) < lowPrice)
    				lowPrice = value.get(i1);
    		}
    		list.add(date);
    		list.add(entry.getKey());
    		list.add(String.valueOf(String.format("%.2f", openPrice)));
    		list.add(String.valueOf(String.format("%.2f", highPrice)));
    		list.add(String.valueOf(String.format("%.2f", lowPrice)));
    		list.add(String.valueOf(String.format("%.2f", closePrice)));
    		solutionList.add(list);
    	}
	}
	/*
	 * Converts our solution Arraylist of list into the desired return type of String[][]
	 */
	private String[][] convertToArray(ArrayList<ArrayList<String>> a) {
		String[][] b = new String[a.size()][];
		for (int i = 0; i < a.size(); i++) {
			b[i] = new String[a.get(i).size()];
			for (int j = 0; j < a.get(i).size(); j++) {
				b[i][j] = a.get(i).get(j);
			}
		}
		return b;
	}
	public static void main(String[] args) {
		DailyOHLC dailyOHLC = new DailyOHLC();
		
		int[] timestamp = {1450625399, 1450625400, 1450625500, 1450625550, 1451644200, 1451690100, 1451691000};
		int[] size = {10, 1, 2, 3, 5, 1, 10};
		double[] price = {10, 20.3, 35.5, 8.65, 20, 10, 100.35};
		String[] instrument = {"HPQ", "HPQ", "HPQ", "HPQ", "AAPL", "HPQ", "GOOG"};
		String[] side = {"sell", "buy", "buy", "sell", "buy", "buy", "buy"};
		
		String[][] s = dailyOHLC.dailyOHLC(timestamp, instrument, side, price, size);
		
		for(int i = 0;i<s.length;i++)	{
			for(int j = 0;j<s[i].length;j++)	{
				System.out.print(s[i][j] + " ");
			}System.out.println("");
		}
	}
}