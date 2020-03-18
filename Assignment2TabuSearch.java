import java.util.LinkedList;
import java.util.Queue;

public class Assignment2TabuSearch {
	
	
	
	public static void main(String [] Args){
		
		

		int [] a = {6,5,3,7,8,10,2,9,4,1};//initial sequence
	
		
		int [] pj = {8,5,4,8,4,4,7,3,5,3};	//processing times
		int [] dj = {13,24,30,17,28,18,19,23,22,20};// due dates
		int [] wj = {15,10,12,6,9,12,7,10,8,13};//weights
	
	
		int[][] h = new int [5][2];//tabu list
		for(int j = 0 ; j < 110 ; j++){// loop for 110 iterations
		System.out.println("iteration " + j + "----------------------------------");
		System.out.println("tabu list    ----------------------------------------");
		
		for(int i = 0 ; i < 5 ; i++){
			
			for (int k = 0 ; k<2 ; k++){
				System.out.print( h[i][k] + " ");
				
			}
			System.out.println("  ");
			
		}
			int [] iterationList= new int[9];//OFv list for 1 iteration
			int [] iterationList2= new int[9];
			
			for(int i = 0 ; i<9;i++){
				int f = a[i];// changing  the adjacent elements
				a[i]=a[i+1];
				a[i+1]=f;
				
				iterationList[i]= OFV(a,pj,dj,wj);//finding OFVs with function
				
				iterationList2[i]= OFV(a,pj,dj,wj);
				
				
				int g = a[i]; // making again the same sequence to use again
				a[i]=a[i+1];
				a[i+1]=g;
				
			
			}
		int sign = 0;
	
		int [] r = sort(iterationList2);	// sorting is a part since we need to determine if the swapping elements are int the tabu list or not
	
		for(int q = 0 ; q< r.length;q++){// recalculating if the swapping elements are in tabu list
			
			for(int i =0; i<iterationList.length ; i++){
				
				if ( r[q] == iterationList[i]){sign = i;}
	
				
				
			}
			
			
				int [][] t = new int [1][2];
			
					t[0][0] = a[sign];
					t[0][1] = a[sign+1];
			
			if(j == 0){// the first iteration, tabu list empty
					h[j][0] = a[sign];
					h[j][1] = a[sign+1];
					
					int f = a[sign];//changing the sequence
					a[sign]=a[sign+1];
					a[sign+1]=f;
					
					
					
					q=r.length-1;//finishing the loop since we have changed sequence so our swapping elements are not in the tabu list
					
	
			}
			if(j == 1){//second iteration
					if((t[0][0]==h[0][0] && t[0][1]== h[0][1])||(t[0][0]==h[0][1] && t[0][1]== h[0][0]) ){// controlling all elemnts for tabu list
						q++;//if the elements are int he tabu list make the cycle again
					}
					else{h[j][0] = a[sign];// otherwise make the changing
					h[j][1] = a[sign+1];
					
					int f = a[sign];
					a[sign]=a[sign+1];
					a[sign+1]=f;
					
					
					
					q=r.length-1;
					}
					
		
			}
			if(j == 2){//third iteration
				if((t[0][0]==h[0][0] && t[0][1]== h[0][1])||(t[0][0]==h[0][1] && t[0][1]== h[0][0])|| (t[0][0]==h[1][0] && t[0][1]== h[1][1])||(t[0][0]==h[1][1] && t[0][1]== h[1][0])){
					q++;
				}
				else{h[j][0] = a[sign];
				h[j][1] = a[sign+1];
				
				int f = a[sign];
				a[sign]=a[sign+1];
				a[sign+1]=f;
				
				
				
				q=r.length-1;
				}
		
			}
			if(j == 3){// fourth iteration
				if((t[0][0]==h[0][0] && t[0][1]== h[0][1])||(t[0][0]==h[0][1] && t[0][1]== h[0][0])|| (t[0][0]==h[1][0] && t[0][1]== h[1][1])||(t[0][0]==h[1][1] && t[0][1]== h[1][0])||(t[0][0]==h[2][0] && t[0][1]== h[2][1])||(t[0][0]==h[2][1] && t[0][1]== h[2][0])){
					q++;
				}
				else{h[j][0] = a[sign];
				h[j][1] = a[sign+1];
				
				int f = a[sign];
				a[sign]=a[sign+1];
				a[sign+1]=f;
				
				
				q=r.length-1;
				}
	
			}
			if(j == 4){// fifth iteration
				if((t[0][0]==h[0][0] && t[0][1]== h[0][1])||(t[0][0]==h[0][1] && t[0][1]== h[0][0])|| (t[0][0]==h[1][0] && t[0][1]== h[1][1])||(t[0][0]==h[1][1] && t[0][1]== h[1][0])||(t[0][0]==h[2][0] && t[0][1]== h[2][1])||(t[0][0]==h[2][1] && t[0][1]== h[2][0])||(t[0][0]==h[3][0] && t[0][1]== h[3][1])||(t[0][0]==h[3][1] && t[0][1]== h[3][0])){
					q++;
				}
				else{h[j][0] = a[sign];
				h[j][1] = a[sign+1];
				
				int f = a[sign];
				a[sign]=a[sign+1];
				a[sign+1]=f;
				
				
				
				q=r.length-1;
				}
		
			}
			
			if(j > 4){// for next steps 
				if((t[0][0]==h[0][0] && t[0][1]== h[0][1])||(t[0][0]==h[0][1] && t[0][1]== h[0][0])|| (t[0][0]==h[1][0] && t[0][1]== h[1][1])||(t[0][0]==h[1][1] && t[0][1]== h[1][0])||(t[0][0]==h[2][0] && t[0][1]== h[2][1])||(t[0][0]==h[2][1] && t[0][1]== h[2][0])||(t[0][0]==h[3][0] && t[0][1]== h[3][1])||(t[0][0]==h[3][1] && t[0][1]== h[3][0])||(t[0][0]==h[4][0] && t[0][1]== h[4][1])||(t[0][0]==h[4][1] && t[0][1]== h[4][0])){
					q++;
				}
				else{// re arranging the tabu list FIFO , first one should be gone
				
				h[0][0]=h[1][0];
				h[0][1]=h[1][1];
				
				h[1][0]=h[2][0];
				h[1][1]=h[2][1];
				
				h[2][0]=h[3][0];
				h[2][1]=h[3][1];
				
				h[3][0]=h[4][0];
				h[3][1]=h[4][1];
				
				h[4][0] = a[sign];
				h[4][1] = a[sign+1];
				
				int f = a[sign];
				a[sign]=a[sign+1];
				a[sign+1]=f;
				
			
				q=r.length-1;
				}
				
	
			
			}
			
			

		}
		
		for(int i = 0 ; i <a.length ; i++){// to see the results for each iteraiton
			
			System.out.print(a[i] + " ");
			
			
		}System.out.println(" " + "  OFV:   " + r[0]);
	}
		
	
	}
	
	public static int OFV(int[]a,int[]processingTime,int[]dueDates,int[]weights ){// OFV function
		
		int totalProsTime = 0;
		int ObjFunc = 0;
		for ( int i = 0 ; i < 10 ; i++){
			int c = a[i]-1;
			totalProsTime += processingTime[c];
			if(totalProsTime > dueDates[c]){
			ObjFunc += weights[c]*(-1*dueDates[c]+totalProsTime);}
		}
		return ObjFunc;
		
	}
	
	public static int [] sort(int arr[]) // sorting method , I used open source code for insertion sort algorithm
	{ 
		int n = arr.length; 
		for (int i=1; i<n; ++i) 
		{ 
			int key = arr[i]; 
			int j = i-1; 

			/* Move elements of arr[0..i-1], that are 
			greater than key, to one position ahead 
			of their current position */
			while (j>=0 && arr[j] > key) 
			{ 
				arr[j+1] = arr[j]; 
				j = j-1; 
			} 
			arr[j+1] = key; 
		} 
		return arr;
		}

	
}
