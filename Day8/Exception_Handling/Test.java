//  class Test { 
//   public static  void  main(String[] args)
//   {
//      try {
//         int ans=10/10;
//         System.out.println(ans);
//         int[] arr={2,5, 6, 7};
//         System.out.println(arr[4]);

//      } catch (ArithmeticException e) {
//         System.out.println("You can not Divide the Zero ");
//         System.out.println(e.getMessage());
//      }
//      catch(ArrayIndexOutOfBoundsException e)
//      {
//         System.out.println("Array Index is Invalid !...");
//         System.out.println(e.getMessage());
//      }
//   }

// }




//finally Block 


 class Test { 
  public static  void  main(String[] args)
  {
     try {
        int ans=10/10;
        System.out.println(ans);
        int[] arr={2,5, 6, 7};
        System.out.println(arr[3]);

     } catch (ArithmeticException e) {
        System.out.println("You can not Divide the Zero ");
        System.out.println(e.getMessage());
     }
     catch(ArrayIndexOutOfBoundsException e)
     {
        System.out.println("Array Index is Invalid !...");
        System.out.println(e.getMessage());
     }
     finally{
        System.out.println("Program is Excuted");
     }
  }

}
