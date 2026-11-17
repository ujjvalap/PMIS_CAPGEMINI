// import  java.io.*;
// class File {

//     static  void Readfile() throws IOException{
//          FileReader file=new FileReader("Index.html");
//          System.out.println("File Opne");
//     }
    
//     public static void main(String[] args) throws IOException {
//       try {
//         Readfile();
//          System.out.println("File is Find");
           
//       } catch (FileNotFoundException e) {
        
//         System.out.println(e.getMessage());
//       }
        
//     }
// }


// Example 1


class File {
    public static void main(String[] args) {
        int Balance=44;
        int Widrow=2456;

        try {
            if(Widrow>Balance)
            {
                throw new IllegalAccessError(
                     "Insuficient Balnece"
                );
            }
            Balance-=Widrow;
            System.out.println("Widrow Done");
            System.out.println("After Widrow Remainig balance is : " + Balance);
        } catch (IllegalAccessError e) {
            System.out.println(e.getMessage());

        }
        finally{
                System.out.println("Progaram is Excuted ! ............");
        }
       
    }
}