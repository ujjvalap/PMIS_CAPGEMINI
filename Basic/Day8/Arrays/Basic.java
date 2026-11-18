

class Basic {
    public static void main(String[] args) {

        // int[] arr;  // Declare the Array but not assing any Value 

        // int[] arr;
        // arr=new int[6];
        
        int[] arr={5, 34, 34, 64, 234,45 ,34};

        // System.out.println("Arr lenght: " + arr.length);   Normal type array length print 

      
        //  Print the All Index Element of the Array using the loop 

        // for(int i=0; i<arr.length; i++)
        // {
        //     System.out.print(arr[i]+ " ");    
        // }


    // for each  read only view of each value
    //   for(int x : arr)
    //   {
    //     System.out.print(x + " ");
    //   }
    


// Sum of the All Digit in the array 

//     int sum=0;
//     for(int i=0; i<arr.length; i++)
//     {
//         sum+=arr[i];
//     }
//     System.out.println(sum);

//     }
// }



// Find the Max Value of the Array 


int max=1;
for(int i=0; i<arr.length; i++)
{
    if(arr[i]>max) 
    {
        max=arr[i];
    }
    
}

System.out.println(max);

    }
}
