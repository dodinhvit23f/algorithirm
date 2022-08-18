package com.algorithm.sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestAlgorithm {
    
    private ISortAlgorithm<Integer> algorithm;
    private boolean asc;
    private int number;
    private List<Integer> list = new ArrayList<Integer>(0);
  
    
    public TestAlgorithm(ISortAlgorithm<Integer> algorithm,int number, boolean asc){
        this.algorithm = algorithm;
        this.number = number;
        this.asc = asc;
    }
    
    public void test(){
        Integer[] array = new Integer[0];
        /*Integer[] array =  {1,333,444,555,666,777,888,999,111,222,123,124,125,126,127,128,129,130,3,4,5,6,7,8,9,29,28,27,26,25,24,23,22,8,7,6,5,4,3,2,11,12,
            13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29,30,18,17,16,15,14,13,12,31,32,33,34,35,101,102,103,104,105,106,107,108,109,110,112,113,114,115,116,
            117,118,119,120,121,122,123,124,125};*/
       
        Random random = new Random();
        
        if(list.size() == 0){
            for (int i = 0; i < number; i++){
                list.add(Integer.valueOf(Math.abs(random.nextInt())));
            }
        }
      
        
        array = list.toArray(array);
        
        algorithm.sort(array, asc);
    }
    
    public void saveResult() {
    	File file = new File("result.csv");
    	if(!file.exists()) {
    		try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	if(file.exists()  && file.canWrite()) {
    		
    		StringBuilder builder = new StringBuilder();
    		for (Integer number : list){
    			builder.append(number.toString());
    			builder.append(",");
    		}
    		
    		builder.setCharAt(builder.length() - 1, '\n');
    		
    		try {
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))) ;
				PrintWriter pw = new PrintWriter(writer);
				pw.write(String.format("%s,%s", algorithm.getClass().getName(),builder.toString()));
				pw.close();
			} catch (FileNotFoundException e) {
	
				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
    		
    	}
    }
}
