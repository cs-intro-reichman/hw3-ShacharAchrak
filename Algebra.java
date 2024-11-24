// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if(x1==0){
			return x2;
		}
		
		if(x2==0){
			return x1;
		}

		if(x2 > 0){
			for(int i=0; i<x2; i++){
				sum++;
			}
		}  else{
			if(x2 < 0){
		    	for(int i=0; i<x2; i++){
				sum--;
			}
		  }
	    } 
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int difference = x1;
			    if(x2==0){
			    return x1;

		    }

			if(x2 > 0){
		    	for(int i=0; i<x2; i++){
					difference--;
		     	}
		      }
		   else{
			if(x2 < 0){
		    	for(int i=0; i<x2; i++){
					difference++;
			}
		  }

		}
		return difference;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int product = 0;
		if(x1==0 || x2 ==0){
			return 0;
		}
		if (x1 > 0 && x2 > 0 || x1 < 0 && x2 < 0){
		    	for(int i=0; i < x2; i++){
					product = plus(product, x1);
			}
		  }
		if (x1 < 0 || x2 < 0){
			product = minus(product, x1);
		}
		return product;
	}
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int power = 1;
		if(x==0){
			return 0;
		
		}  else{
			  if(n==0){
			  return 1;
			  }
		    }
			      if(x>0){
		    	    for(int i=0; i<n; i++){
				        power = times(power, x);
			        }
			      }	
		          
			    	if(x<0 && mod(n,2)==0){
					power = times(power, x);
				    }
			          else{
				        if(x<0 && mod(n,2)==1){
				    	power = times(power, x);
						power = times(power, -1);
			        	}
		              }
		
		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int quotient = 0;
		int remainig =x1;
		if(x1 == 0 || x2 == 0){
			return 0;
		
		}else{
		    	while(remainig >= x2){
					remainig = minus(remainig, x2);
					quotient ++ ;
				}
		}
		
		return quotient;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int remainig = x1;
		if(x1 == 0 || x2 == 0){
			return 0;
		
		}else{
		    	while(remainig >= x2){
					remainig = minus(remainig, x2);
				}
				return remainig;
		}
		
	}
	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int result = 0;
		int increment = 1;
		    while (times(result, result) <= x) {
			    result = plus(result, increment);
			} 

			 return minus(result,1);
    }	  	  
}